package com.dao;

import com.entity.FangzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangzhuView;

/**
 * 房主 Dao 接口
 *
 * @author 
 */
public interface FangzhuDao extends BaseMapper<FangzhuEntity> {

   List<FangzhuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
