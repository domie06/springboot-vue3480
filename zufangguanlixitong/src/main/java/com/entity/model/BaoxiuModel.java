package com.entity.model;

import com.entity.BaoxiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 报修
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BaoxiuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 租客
     */
    private Integer zukeId;


    /**
     * 维修人员
     */
    private Integer weixiurenyuanId;


    /**
     * 报修编号
     */
    private String baoxiuUuidNumber;


    /**
     * 报修物品类型
     */
    private Integer baoxiuTypes;


    /**
     * 故障类型
     */
    private Integer guzhangTypes;


    /**
     * 报修位置
     */
    private String baoxiuAddress;


    /**
     * 上报时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 上报详情
     */
    private String forumContent;


    /**
     * 维修状态
     */
    private Integer weixiuzhuangtaiTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：租客
	 */
    public Integer getZukeId() {
        return zukeId;
    }


    /**
	 * 设置：租客
	 */
    public void setZukeId(Integer zukeId) {
        this.zukeId = zukeId;
    }
    /**
	 * 获取：维修人员
	 */
    public Integer getWeixiurenyuanId() {
        return weixiurenyuanId;
    }


    /**
	 * 设置：维修人员
	 */
    public void setWeixiurenyuanId(Integer weixiurenyuanId) {
        this.weixiurenyuanId = weixiurenyuanId;
    }
    /**
	 * 获取：报修编号
	 */
    public String getBaoxiuUuidNumber() {
        return baoxiuUuidNumber;
    }


    /**
	 * 设置：报修编号
	 */
    public void setBaoxiuUuidNumber(String baoxiuUuidNumber) {
        this.baoxiuUuidNumber = baoxiuUuidNumber;
    }
    /**
	 * 获取：报修物品类型
	 */
    public Integer getBaoxiuTypes() {
        return baoxiuTypes;
    }


    /**
	 * 设置：报修物品类型
	 */
    public void setBaoxiuTypes(Integer baoxiuTypes) {
        this.baoxiuTypes = baoxiuTypes;
    }
    /**
	 * 获取：故障类型
	 */
    public Integer getGuzhangTypes() {
        return guzhangTypes;
    }


    /**
	 * 设置：故障类型
	 */
    public void setGuzhangTypes(Integer guzhangTypes) {
        this.guzhangTypes = guzhangTypes;
    }
    /**
	 * 获取：报修位置
	 */
    public String getBaoxiuAddress() {
        return baoxiuAddress;
    }


    /**
	 * 设置：报修位置
	 */
    public void setBaoxiuAddress(String baoxiuAddress) {
        this.baoxiuAddress = baoxiuAddress;
    }
    /**
	 * 获取：上报时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：上报时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：上报详情
	 */
    public String getForumContent() {
        return forumContent;
    }


    /**
	 * 设置：上报详情
	 */
    public void setForumContent(String forumContent) {
        this.forumContent = forumContent;
    }
    /**
	 * 获取：维修状态
	 */
    public Integer getWeixiuzhuangtaiTypes() {
        return weixiuzhuangtaiTypes;
    }


    /**
	 * 设置：维修状态
	 */
    public void setWeixiuzhuangtaiTypes(Integer weixiuzhuangtaiTypes) {
        this.weixiuzhuangtaiTypes = weixiuzhuangtaiTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
