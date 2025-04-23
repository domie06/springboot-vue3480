
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 房主
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fangzhu")
public class FangzhuController {
    private static final Logger logger = LoggerFactory.getLogger(FangzhuController.class);

    @Autowired
    private FangzhuService fangzhuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private ZukeService zukeService;
    @Autowired
    private KefuService kefuService;
    @Autowired
    private WeixiurenyuanService weixiurenyuanService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("租客".equals(role))
            params.put("zukeId",request.getSession().getAttribute("userId"));
        else if("房主".equals(role))
            params.put("fangzhuId",request.getSession().getAttribute("userId"));
        else if("客服".equals(role))
            params.put("kefuId",request.getSession().getAttribute("userId"));
        else if("维修人员".equals(role))
            params.put("weixiurenyuanId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = fangzhuService.queryPage(params);

        //字典表数据转换
        List<FangzhuView> list =(List<FangzhuView>)page.getList();
        for(FangzhuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangzhuEntity fangzhu = fangzhuService.selectById(id);
        if(fangzhu !=null){
            //entity转view
            FangzhuView view = new FangzhuView();
            BeanUtils.copyProperties( fangzhu , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FangzhuEntity fangzhu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangzhu:{}",this.getClass().getName(),fangzhu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<FangzhuEntity> queryWrapper = new EntityWrapper<FangzhuEntity>()
            .eq("username", fangzhu.getUsername())
            .or()
            .eq("fangzhu_phone", fangzhu.getFangzhuPhone())
            .or()
            .eq("fangzhu_id_number", fangzhu.getFangzhuIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangzhuEntity fangzhuEntity = fangzhuService.selectOne(queryWrapper);
        if(fangzhuEntity==null){
            fangzhu.setCreateTime(new Date());
            fangzhu.setPassword("123456");
            fangzhuService.insert(fangzhu);
            return R.ok();
        }else {
            return R.error(511,"账户或者房主手机号或者房主身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangzhuEntity fangzhu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fangzhu:{}",this.getClass().getName(),fangzhu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<FangzhuEntity> queryWrapper = new EntityWrapper<FangzhuEntity>()
            .notIn("id",fangzhu.getId())
            .andNew()
            .eq("username", fangzhu.getUsername())
            .or()
            .eq("fangzhu_phone", fangzhu.getFangzhuPhone())
            .or()
            .eq("fangzhu_id_number", fangzhu.getFangzhuIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangzhuEntity fangzhuEntity = fangzhuService.selectOne(queryWrapper);
        if("".equals(fangzhu.getFangzhuPhoto()) || "null".equals(fangzhu.getFangzhuPhoto())){
                fangzhu.setFangzhuPhoto(null);
        }
        if(fangzhuEntity==null){
            fangzhuService.updateById(fangzhu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者房主手机号或者房主身份证号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        fangzhuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<FangzhuEntity> fangzhuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FangzhuEntity fangzhuEntity = new FangzhuEntity();
//                            fangzhuEntity.setUsername(data.get(0));                    //账户 要改的
//                            //fangzhuEntity.setPassword("123456");//密码
//                            fangzhuEntity.setFangzhuName(data.get(0));                    //房主姓名 要改的
//                            fangzhuEntity.setFangzhuPhone(data.get(0));                    //房主手机号 要改的
//                            fangzhuEntity.setFangzhuIdNumber(data.get(0));                    //房主身份证号 要改的
//                            fangzhuEntity.setFangzhuPhoto("");//详情和图片
//                            fangzhuEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            fangzhuEntity.setFangzhuEmail(data.get(0));                    //房主电子邮箱 要改的
//                            fangzhuEntity.setCreateTime(date);//时间
                            fangzhuList.add(fangzhuEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //房主手机号
                                if(seachFields.containsKey("fangzhuPhone")){
                                    List<String> fangzhuPhone = seachFields.get("fangzhuPhone");
                                    fangzhuPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> fangzhuPhone = new ArrayList<>();
                                    fangzhuPhone.add(data.get(0));//要改的
                                    seachFields.put("fangzhuPhone",fangzhuPhone);
                                }
                                //房主身份证号
                                if(seachFields.containsKey("fangzhuIdNumber")){
                                    List<String> fangzhuIdNumber = seachFields.get("fangzhuIdNumber");
                                    fangzhuIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> fangzhuIdNumber = new ArrayList<>();
                                    fangzhuIdNumber.add(data.get(0));//要改的
                                    seachFields.put("fangzhuIdNumber",fangzhuIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<FangzhuEntity> fangzhuEntities_username = fangzhuService.selectList(new EntityWrapper<FangzhuEntity>().in("username", seachFields.get("username")));
                        if(fangzhuEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FangzhuEntity s:fangzhuEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //房主手机号
                        List<FangzhuEntity> fangzhuEntities_fangzhuPhone = fangzhuService.selectList(new EntityWrapper<FangzhuEntity>().in("fangzhu_phone", seachFields.get("fangzhuPhone")));
                        if(fangzhuEntities_fangzhuPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FangzhuEntity s:fangzhuEntities_fangzhuPhone){
                                repeatFields.add(s.getFangzhuPhone());
                            }
                            return R.error(511,"数据库的该表中的 [房主手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //房主身份证号
                        List<FangzhuEntity> fangzhuEntities_fangzhuIdNumber = fangzhuService.selectList(new EntityWrapper<FangzhuEntity>().in("fangzhu_id_number", seachFields.get("fangzhuIdNumber")));
                        if(fangzhuEntities_fangzhuIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FangzhuEntity s:fangzhuEntities_fangzhuIdNumber){
                                repeatFields.add(s.getFangzhuIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [房主身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        fangzhuService.insertBatch(fangzhuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        FangzhuEntity fangzhu = fangzhuService.selectOne(new EntityWrapper<FangzhuEntity>().eq("username", username));
        if(fangzhu==null || !fangzhu.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(fangzhu.getId(),username, "fangzhu", "房主");
        R r = R.ok();
        r.put("token", token);
        r.put("role","房主");
        r.put("username",fangzhu.getFangzhuName());
        r.put("tableName","fangzhu");
        r.put("userId",fangzhu.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody FangzhuEntity fangzhu){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<FangzhuEntity> queryWrapper = new EntityWrapper<FangzhuEntity>()
            .eq("username", fangzhu.getUsername())
            .or()
            .eq("fangzhu_phone", fangzhu.getFangzhuPhone())
            .or()
            .eq("fangzhu_id_number", fangzhu.getFangzhuIdNumber())
            ;
        FangzhuEntity fangzhuEntity = fangzhuService.selectOne(queryWrapper);
        if(fangzhuEntity != null)
            return R.error("账户或者房主手机号或者房主身份证号已经被使用");
        fangzhu.setCreateTime(new Date());
        fangzhuService.insert(fangzhu);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        FangzhuEntity fangzhu = new FangzhuEntity();
        fangzhu.setPassword("123456");
        fangzhu.setId(id);
        fangzhuService.updateById(fangzhu);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        FangzhuEntity fangzhu = fangzhuService.selectOne(new EntityWrapper<FangzhuEntity>().eq("username", username));
        if(fangzhu!=null){
            fangzhu.setPassword("123456");
            boolean b = fangzhuService.updateById(fangzhu);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrFangzhu(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        FangzhuEntity fangzhu = fangzhuService.selectById(id);
        if(fangzhu !=null){
            //entity转view
            FangzhuView view = new FangzhuView();
            BeanUtils.copyProperties( fangzhu , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = fangzhuService.queryPage(params);

        //字典表数据转换
        List<FangzhuView> list =(List<FangzhuView>)page.getList();
        for(FangzhuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangzhuEntity fangzhu = fangzhuService.selectById(id);
            if(fangzhu !=null){


                //entity转view
                FangzhuView view = new FangzhuView();
                BeanUtils.copyProperties( fangzhu , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody FangzhuEntity fangzhu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangzhu:{}",this.getClass().getName(),fangzhu.toString());
        Wrapper<FangzhuEntity> queryWrapper = new EntityWrapper<FangzhuEntity>()
            .eq("username", fangzhu.getUsername())
            .or()
            .eq("fangzhu_phone", fangzhu.getFangzhuPhone())
            .or()
            .eq("fangzhu_id_number", fangzhu.getFangzhuIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangzhuEntity fangzhuEntity = fangzhuService.selectOne(queryWrapper);
        if(fangzhuEntity==null){
            fangzhu.setCreateTime(new Date());
        fangzhu.setPassword("123456");
        fangzhuService.insert(fangzhu);
            return R.ok();
        }else {
            return R.error(511,"账户或者房主手机号或者房主身份证号已经被使用");
        }
    }


}
