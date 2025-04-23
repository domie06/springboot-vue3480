package com.entity.model;

import com.entity.FangwuOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 预约看房
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangwuOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String fangwuOrderUuidNumber;


    /**
     * 房屋
     */
    private Integer fangwuId;


    /**
     * 租客
     */
    private Integer zukeId;


    /**
     * 看房时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kanfangTime;


    /**
     * 预约申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 预约状态
     */
    private Integer fangwuOrderYesnoTypes;


    /**
     * 审核意见
     */
    private String fangwuOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fangwuOrderShenheTime;


    /**
     * 创建时间 show3
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
	 * 获取：订单号
	 */
    public String getFangwuOrderUuidNumber() {
        return fangwuOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setFangwuOrderUuidNumber(String fangwuOrderUuidNumber) {
        this.fangwuOrderUuidNumber = fangwuOrderUuidNumber;
    }
    /**
	 * 获取：房屋
	 */
    public Integer getFangwuId() {
        return fangwuId;
    }


    /**
	 * 设置：房屋
	 */
    public void setFangwuId(Integer fangwuId) {
        this.fangwuId = fangwuId;
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
	 * 获取：看房时间
	 */
    public Date getKanfangTime() {
        return kanfangTime;
    }


    /**
	 * 设置：看房时间
	 */
    public void setKanfangTime(Date kanfangTime) {
        this.kanfangTime = kanfangTime;
    }
    /**
	 * 获取：预约申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：预约申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：预约状态
	 */
    public Integer getFangwuOrderYesnoTypes() {
        return fangwuOrderYesnoTypes;
    }


    /**
	 * 设置：预约状态
	 */
    public void setFangwuOrderYesnoTypes(Integer fangwuOrderYesnoTypes) {
        this.fangwuOrderYesnoTypes = fangwuOrderYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getFangwuOrderYesnoText() {
        return fangwuOrderYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setFangwuOrderYesnoText(String fangwuOrderYesnoText) {
        this.fangwuOrderYesnoText = fangwuOrderYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getFangwuOrderShenheTime() {
        return fangwuOrderShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setFangwuOrderShenheTime(Date fangwuOrderShenheTime) {
        this.fangwuOrderShenheTime = fangwuOrderShenheTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
