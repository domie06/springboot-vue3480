package com.entity.model;

import com.entity.ZulinhetongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 租赁合同
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZulinhetongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 房主
     */
    private Integer fangzhuId;


    /**
     * 租客
     */
    private Integer zukeId;


    /**
     * 租赁合同编号
     */
    private String zulinhetongUuidNumber;


    /**
     * 租赁合同名称
     */
    private String zulinhetongName;


    /**
     * 租赁合同文件
     */
    private String zulinhetongFile;


    /**
     * 租赁合同类型
     */
    private Integer zulinhetongTypes;


    /**
     * 租赁日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zulinriqiTime;


    /**
     * 租赁月
     */
    private Integer zulinhetongYue;


    /**
     * 押金
     */
    private Double zulinhetongYajinJine;


    /**
     * 每月金额
     */
    private Double zulinhetongJine;


    /**
     * 合同备注
     */
    private String zulinhetongContent;


    /**
     * 是否同意
     */
    private Integer zulinhetongYesnoTypes;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：房主
	 */
    public Integer getFangzhuId() {
        return fangzhuId;
    }


    /**
	 * 设置：房主
	 */
    public void setFangzhuId(Integer fangzhuId) {
        this.fangzhuId = fangzhuId;
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
	 * 获取：租赁合同编号
	 */
    public String getZulinhetongUuidNumber() {
        return zulinhetongUuidNumber;
    }


    /**
	 * 设置：租赁合同编号
	 */
    public void setZulinhetongUuidNumber(String zulinhetongUuidNumber) {
        this.zulinhetongUuidNumber = zulinhetongUuidNumber;
    }
    /**
	 * 获取：租赁合同名称
	 */
    public String getZulinhetongName() {
        return zulinhetongName;
    }


    /**
	 * 设置：租赁合同名称
	 */
    public void setZulinhetongName(String zulinhetongName) {
        this.zulinhetongName = zulinhetongName;
    }
    /**
	 * 获取：租赁合同文件
	 */
    public String getZulinhetongFile() {
        return zulinhetongFile;
    }


    /**
	 * 设置：租赁合同文件
	 */
    public void setZulinhetongFile(String zulinhetongFile) {
        this.zulinhetongFile = zulinhetongFile;
    }
    /**
	 * 获取：租赁合同类型
	 */
    public Integer getZulinhetongTypes() {
        return zulinhetongTypes;
    }


    /**
	 * 设置：租赁合同类型
	 */
    public void setZulinhetongTypes(Integer zulinhetongTypes) {
        this.zulinhetongTypes = zulinhetongTypes;
    }
    /**
	 * 获取：租赁日期
	 */
    public Date getZulinriqiTime() {
        return zulinriqiTime;
    }


    /**
	 * 设置：租赁日期
	 */
    public void setZulinriqiTime(Date zulinriqiTime) {
        this.zulinriqiTime = zulinriqiTime;
    }
    /**
	 * 获取：租赁月
	 */
    public Integer getZulinhetongYue() {
        return zulinhetongYue;
    }


    /**
	 * 设置：租赁月
	 */
    public void setZulinhetongYue(Integer zulinhetongYue) {
        this.zulinhetongYue = zulinhetongYue;
    }
    /**
	 * 获取：押金
	 */
    public Double getZulinhetongYajinJine() {
        return zulinhetongYajinJine;
    }


    /**
	 * 设置：押金
	 */
    public void setZulinhetongYajinJine(Double zulinhetongYajinJine) {
        this.zulinhetongYajinJine = zulinhetongYajinJine;
    }
    /**
	 * 获取：每月金额
	 */
    public Double getZulinhetongJine() {
        return zulinhetongJine;
    }


    /**
	 * 设置：每月金额
	 */
    public void setZulinhetongJine(Double zulinhetongJine) {
        this.zulinhetongJine = zulinhetongJine;
    }
    /**
	 * 获取：合同备注
	 */
    public String getZulinhetongContent() {
        return zulinhetongContent;
    }


    /**
	 * 设置：合同备注
	 */
    public void setZulinhetongContent(String zulinhetongContent) {
        this.zulinhetongContent = zulinhetongContent;
    }
    /**
	 * 获取：是否同意
	 */
    public Integer getZulinhetongYesnoTypes() {
        return zulinhetongYesnoTypes;
    }


    /**
	 * 设置：是否同意
	 */
    public void setZulinhetongYesnoTypes(Integer zulinhetongYesnoTypes) {
        this.zulinhetongYesnoTypes = zulinhetongYesnoTypes;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：记录时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
