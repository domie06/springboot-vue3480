
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
 * 租赁合同
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zulinhetong")
public class ZulinhetongController {
    private static final Logger logger = LoggerFactory.getLogger(ZulinhetongController.class);

    @Autowired
    private ZulinhetongService zulinhetongService;


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
        PageUtils page = zulinhetongService.queryPage(params);

        //字典表数据转换
        List<ZulinhetongView> list =(List<ZulinhetongView>)page.getList();
        for(ZulinhetongView c:list){
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
        ZulinhetongEntity zulinhetong = zulinhetongService.selectById(id);
        if(zulinhetong !=null){
            //entity转view
            ZulinhetongView view = new ZulinhetongView();
            BeanUtils.copyProperties( zulinhetong , view );//把实体数据重构到view中

                //级联表
                ZukeEntity zuke = zukeService.selectById(zulinhetong.getZukeId());
                if(zuke != null){
                    BeanUtils.copyProperties( zuke , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZukeId(zuke.getId());
                }
                //级联表
                FangzhuEntity fangzhu = fangzhuService.selectById(zulinhetong.getFangzhuId());
                if(fangzhu != null){
                    BeanUtils.copyProperties( fangzhu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangzhuId(fangzhu.getId());
                }
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
    public R save(@RequestBody ZulinhetongEntity zulinhetong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zulinhetong:{}",this.getClass().getName(),zulinhetong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("房主".equals(role))
            zulinhetong.setFangzhuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("租客".equals(role))
            zulinhetong.setZukeId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ZulinhetongEntity> queryWrapper = new EntityWrapper<ZulinhetongEntity>()
            .eq("fangzhu_id", zulinhetong.getFangzhuId())
            .eq("zuke_id", zulinhetong.getZukeId())
            .eq("zulinhetong_uuid_number", zulinhetong.getZulinhetongUuidNumber())
            .eq("zulinhetong_name", zulinhetong.getZulinhetongName())
            .eq("zulinhetong_types", zulinhetong.getZulinhetongTypes())
            .eq("zulinhetong_yue", zulinhetong.getZulinhetongYue())
            .eq("zulinhetong_yesno_types", zulinhetong.getZulinhetongYesnoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZulinhetongEntity zulinhetongEntity = zulinhetongService.selectOne(queryWrapper);
        if(zulinhetongEntity==null){
            zulinhetong.setZulinhetongYesnoTypes(1);
            zulinhetong.setInsertTime(new Date());
            zulinhetong.setCreateTime(new Date());
            zulinhetongService.insert(zulinhetong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZulinhetongEntity zulinhetong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zulinhetong:{}",this.getClass().getName(),zulinhetong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("房主".equals(role))
//            zulinhetong.setFangzhuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("租客".equals(role))
//            zulinhetong.setZukeId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ZulinhetongEntity> queryWrapper = new EntityWrapper<ZulinhetongEntity>()
            .notIn("id",zulinhetong.getId())
            .andNew()
            .eq("fangzhu_id", zulinhetong.getFangzhuId())
            .eq("zuke_id", zulinhetong.getZukeId())
            .eq("zulinhetong_uuid_number", zulinhetong.getZulinhetongUuidNumber())
            .eq("zulinhetong_name", zulinhetong.getZulinhetongName())
            .eq("zulinhetong_types", zulinhetong.getZulinhetongTypes())
            .eq("zulinriqi_time", zulinhetong.getZulinriqiTime())
            .eq("zulinhetong_yue", zulinhetong.getZulinhetongYue())
            .eq("zulinhetong_yesno_types", zulinhetong.getZulinhetongYesnoTypes())
            .eq("insert_time", zulinhetong.getInsertTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZulinhetongEntity zulinhetongEntity = zulinhetongService.selectOne(queryWrapper);
        if("".equals(zulinhetong.getZulinhetongFile()) || "null".equals(zulinhetong.getZulinhetongFile())){
                zulinhetong.setZulinhetongFile(null);
        }
        if(zulinhetongEntity==null){
            zulinhetongService.updateById(zulinhetong);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ZulinhetongEntity zulinhetongEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,zulinhetongEntity:{}",this.getClass().getName(),zulinhetongEntity.toString());

//        if(zulinhetongEntity.getZulinhetongYesnoTypes() == 2){//通过
//            zulinhetongEntity.setZulinhetongTypes();
//        }else if(zulinhetongEntity.getZulinhetongYesnoTypes() == 3){//拒绝
//            zulinhetongEntity.setZulinhetongTypes();
//        }
        zulinhetongService.updateById(zulinhetongEntity);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zulinhetongService.deleteBatchIds(Arrays.asList(ids));
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
            List<ZulinhetongEntity> zulinhetongList = new ArrayList<>();//上传的东西
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
                            ZulinhetongEntity zulinhetongEntity = new ZulinhetongEntity();
//                            zulinhetongEntity.setFangzhuId(Integer.valueOf(data.get(0)));   //房主 要改的
//                            zulinhetongEntity.setZukeId(Integer.valueOf(data.get(0)));   //租客 要改的
//                            zulinhetongEntity.setZulinhetongUuidNumber(data.get(0));                    //租赁合同编号 要改的
//                            zulinhetongEntity.setZulinhetongName(data.get(0));                    //租赁合同名称 要改的
//                            zulinhetongEntity.setZulinhetongFile(data.get(0));                    //租赁合同文件 要改的
//                            zulinhetongEntity.setZulinhetongTypes(Integer.valueOf(data.get(0)));   //租赁合同类型 要改的
//                            zulinhetongEntity.setZulinriqiTime(sdf.parse(data.get(0)));          //租赁日期 要改的
//                            zulinhetongEntity.setZulinhetongYue(Integer.valueOf(data.get(0)));   //租赁月 要改的
//                            zulinhetongEntity.setZulinhetongYajinJine(data.get(0));                    //押金 要改的
//                            zulinhetongEntity.setZulinhetongJine(data.get(0));                    //每月金额 要改的
//                            zulinhetongEntity.setZulinhetongContent("");//详情和图片
//                            zulinhetongEntity.setZulinhetongYesnoTypes(Integer.valueOf(data.get(0)));   //是否同意 要改的
//                            zulinhetongEntity.setInsertTime(date);//时间
//                            zulinhetongEntity.setCreateTime(date);//时间
                            zulinhetongList.add(zulinhetongEntity);


                            //把要查询是否重复的字段放入map中
                                //租赁合同编号
                                if(seachFields.containsKey("zulinhetongUuidNumber")){
                                    List<String> zulinhetongUuidNumber = seachFields.get("zulinhetongUuidNumber");
                                    zulinhetongUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zulinhetongUuidNumber = new ArrayList<>();
                                    zulinhetongUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zulinhetongUuidNumber",zulinhetongUuidNumber);
                                }
                        }

                        //查询是否重复
                         //租赁合同编号
                        List<ZulinhetongEntity> zulinhetongEntities_zulinhetongUuidNumber = zulinhetongService.selectList(new EntityWrapper<ZulinhetongEntity>().in("zulinhetong_uuid_number", seachFields.get("zulinhetongUuidNumber")));
                        if(zulinhetongEntities_zulinhetongUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZulinhetongEntity s:zulinhetongEntities_zulinhetongUuidNumber){
                                repeatFields.add(s.getZulinhetongUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [租赁合同编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zulinhetongService.insertBatch(zulinhetongList);
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
        PageUtils page = zulinhetongService.queryPage(params);

        //字典表数据转换
        List<ZulinhetongView> list =(List<ZulinhetongView>)page.getList();
        for(ZulinhetongView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZulinhetongEntity zulinhetong = zulinhetongService.selectById(id);
            if(zulinhetong !=null){


                //entity转view
                ZulinhetongView view = new ZulinhetongView();
                BeanUtils.copyProperties( zulinhetong , view );//把实体数据重构到view中

                //级联表
                    ZukeEntity zuke = zukeService.selectById(zulinhetong.getZukeId());
                if(zuke != null){
                    BeanUtils.copyProperties( zuke , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZukeId(zuke.getId());
                }
                //级联表
                    FangzhuEntity fangzhu = fangzhuService.selectById(zulinhetong.getFangzhuId());
                if(fangzhu != null){
                    BeanUtils.copyProperties( fangzhu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangzhuId(fangzhu.getId());
                }
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
    public R add(@RequestBody ZulinhetongEntity zulinhetong, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zulinhetong:{}",this.getClass().getName(),zulinhetong.toString());
        Wrapper<ZulinhetongEntity> queryWrapper = new EntityWrapper<ZulinhetongEntity>()
            .eq("fangzhu_id", zulinhetong.getFangzhuId())
            .eq("zuke_id", zulinhetong.getZukeId())
            .eq("zulinhetong_uuid_number", zulinhetong.getZulinhetongUuidNumber())
            .eq("zulinhetong_name", zulinhetong.getZulinhetongName())
            .eq("zulinhetong_types", zulinhetong.getZulinhetongTypes())
            .eq("zulinhetong_yue", zulinhetong.getZulinhetongYue())
            .eq("zulinhetong_yesno_types", zulinhetong.getZulinhetongYesnoTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZulinhetongEntity zulinhetongEntity = zulinhetongService.selectOne(queryWrapper);
        if(zulinhetongEntity==null){
            zulinhetong.setZulinhetongYesnoTypes(1);
            zulinhetong.setInsertTime(new Date());
            zulinhetong.setCreateTime(new Date());
        zulinhetongService.insert(zulinhetong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
