package com.dao;

import com.entity.KefuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KefuView;

/**
 * 客服 Dao 接口
 *
 * @author 
 */
public interface KefuDao extends BaseMapper<KefuEntity> {

   List<KefuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
