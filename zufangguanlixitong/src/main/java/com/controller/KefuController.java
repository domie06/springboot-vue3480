
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
 * 客服
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kefu")
public class KefuController {
    private static final Logger logger = LoggerFactory.getLogger(KefuController.class);

    @Autowired
    private KefuService kefuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private ZukeService zukeService;
    @Autowired
    private FangzhuService fangzhuService;
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
        PageUtils page = kefuService.queryPage(params);

        //字典表数据转换
        List<KefuView> list =(List<KefuView>)page.getList();
        for(KefuView c:list){
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
        KefuEntity kefu = kefuService.selectById(id);
        if(kefu !=null){
            //entity转view
            KefuView view = new KefuView();
            BeanUtils.copyProperties( kefu , view );//把实体数据重构到view中

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
    public R save(@RequestBody KefuEntity kefu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kefu:{}",this.getClass().getName(),kefu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<KefuEntity> queryWrapper = new EntityWrapper<KefuEntity>()
            .eq("username", kefu.getUsername())
            .or()
            .eq("kefu_phone", kefu.getKefuPhone())
            .or()
            .eq("kefu_id_number", kefu.getKefuIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KefuEntity kefuEntity = kefuService.selectOne(queryWrapper);
        if(kefuEntity==null){
            kefu.setCreateTime(new Date());
            kefu.setPassword("123456");
            kefuService.insert(kefu);
            return R.ok();
        }else {
            return R.error(511,"账户或者客服手机号或者客服身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KefuEntity kefu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kefu:{}",this.getClass().getName(),kefu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<KefuEntity> queryWrapper = new EntityWrapper<KefuEntity>()
            .notIn("id",kefu.getId())
            .andNew()
            .eq("username", kefu.getUsername())
            .or()
            .eq("kefu_phone", kefu.getKefuPhone())
            .or()
            .eq("kefu_id_number", kefu.getKefuIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KefuEntity kefuEntity = kefuService.selectOne(queryWrapper);
        if("".equals(kefu.getKefuPhoto()) || "null".equals(kefu.getKefuPhoto())){
                kefu.setKefuPhoto(null);
        }
        if(kefuEntity==null){
            kefuService.updateById(kefu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者客服手机号或者客服身份证号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        kefuService.deleteBatchIds(Arrays.asList(ids));
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
            List<KefuEntity> kefuList = new ArrayList<>();//上传的东西
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
                            KefuEntity kefuEntity = new KefuEntity();
//                            kefuEntity.setUsername(data.get(0));                    //账户 要改的
//                            //kefuEntity.setPassword("123456");//密码
//                            kefuEntity.setKefuName(data.get(0));                    //客服姓名 要改的
//                            kefuEntity.setKefuPhone(data.get(0));                    //客服手机号 要改的
//                            kefuEntity.setKefuIdNumber(data.get(0));                    //客服身份证号 要改的
//                            kefuEntity.setKefuPhoto("");//详情和图片
//                            kefuEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            kefuEntity.setKefuEmail(data.get(0));                    //客服电子邮箱 要改的
//                            kefuEntity.setCreateTime(date);//时间
                            kefuList.add(kefuEntity);


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
                                //客服手机号
                                if(seachFields.containsKey("kefuPhone")){
                                    List<String> kefuPhone = seachFields.get("kefuPhone");
                                    kefuPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> kefuPhone = new ArrayList<>();
                                    kefuPhone.add(data.get(0));//要改的
                                    seachFields.put("kefuPhone",kefuPhone);
                                }
                                //客服身份证号
                                if(seachFields.containsKey("kefuIdNumber")){
                                    List<String> kefuIdNumber = seachFields.get("kefuIdNumber");
                                    kefuIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> kefuIdNumber = new ArrayList<>();
                                    kefuIdNumber.add(data.get(0));//要改的
                                    seachFields.put("kefuIdNumber",kefuIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<KefuEntity> kefuEntities_username = kefuService.selectList(new EntityWrapper<KefuEntity>().in("username", seachFields.get("username")));
                        if(kefuEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(KefuEntity s:kefuEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //客服手机号
                        List<KefuEntity> kefuEntities_kefuPhone = kefuService.selectList(new EntityWrapper<KefuEntity>().in("kefu_phone", seachFields.get("kefuPhone")));
                        if(kefuEntities_kefuPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(KefuEntity s:kefuEntities_kefuPhone){
                                repeatFields.add(s.getKefuPhone());
                            }
                            return R.error(511,"数据库的该表中的 [客服手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //客服身份证号
                        List<KefuEntity> kefuEntities_kefuIdNumber = kefuService.selectList(new EntityWrapper<KefuEntity>().in("kefu_id_number", seachFields.get("kefuIdNumber")));
                        if(kefuEntities_kefuIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(KefuEntity s:kefuEntities_kefuIdNumber){
                                repeatFields.add(s.getKefuIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [客服身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        kefuService.insertBatch(kefuList);
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
        KefuEntity kefu = kefuService.selectOne(new EntityWrapper<KefuEntity>().eq("username", username));
        if(kefu==null || !kefu.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(kefu.getId(),username, "kefu", "客服");
        R r = R.ok();
        r.put("token", token);
        r.put("role","客服");
        r.put("username",kefu.getKefuName());
        r.put("tableName","kefu");
        r.put("userId",kefu.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody KefuEntity kefu){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<KefuEntity> queryWrapper = new EntityWrapper<KefuEntity>()
            .eq("username", kefu.getUsername())
            .or()
            .eq("kefu_phone", kefu.getKefuPhone())
            .or()
            .eq("kefu_id_number", kefu.getKefuIdNumber())
            ;
        KefuEntity kefuEntity = kefuService.selectOne(queryWrapper);
        if(kefuEntity != null)
            return R.error("账户或者客服手机号或者客服身份证号已经被使用");
        kefu.setCreateTime(new Date());
        kefuService.insert(kefu);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        KefuEntity kefu = new KefuEntity();
        kefu.setPassword("123456");
        kefu.setId(id);
        kefuService.updateById(kefu);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        KefuEntity kefu = kefuService.selectOne(new EntityWrapper<KefuEntity>().eq("username", username));
        if(kefu!=null){
            kefu.setPassword("123456");
            boolean b = kefuService.updateById(kefu);
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
    public R getCurrKefu(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        KefuEntity kefu = kefuService.selectById(id);
        if(kefu !=null){
            //entity转view
            KefuView view = new KefuView();
            BeanUtils.copyProperties( kefu , view );//把实体数据重构到view中

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
        PageUtils page = kefuService.queryPage(params);

        //字典表数据转换
        List<KefuView> list =(List<KefuView>)page.getList();
        for(KefuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KefuEntity kefu = kefuService.selectById(id);
            if(kefu !=null){


                //entity转view
                KefuView view = new KefuView();
                BeanUtils.copyProperties( kefu , view );//把实体数据重构到view中

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
    public R add(@RequestBody KefuEntity kefu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,kefu:{}",this.getClass().getName(),kefu.toString());
        Wrapper<KefuEntity> queryWrapper = new EntityWrapper<KefuEntity>()
            .eq("username", kefu.getUsername())
            .or()
            .eq("kefu_phone", kefu.getKefuPhone())
            .or()
            .eq("kefu_id_number", kefu.getKefuIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KefuEntity kefuEntity = kefuService.selectOne(queryWrapper);
        if(kefuEntity==null){
            kefu.setCreateTime(new Date());
        kefu.setPassword("123456");
        kefuService.insert(kefu);
            return R.ok();
        }else {
            return R.error(511,"账户或者客服手机号或者客服身份证号已经被使用");
        }
    }


}
