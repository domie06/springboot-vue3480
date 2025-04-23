package com.entity.model;

import com.entity.TousuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 投诉
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TousuModel implements Serializable {
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
     * 租赁合同
     */
    private Integer zulinhetongId;


    /**
     * 投诉编号
     */
    private String tousuUuidNumber;


    /**
     * 投诉名称
     */
    private String tousuName;


    /**
     * 投诉类型
     */
    private Integer tousuTypes;


    /**
     * 投诉证据
     */
    private String tousuFile;


    /**
     * 投诉内容
     */
    private String tousuContent;


    /**
     * 投诉时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 回复内容
     */
    private String huifuContent;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date updateTime;


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
	 * 获取：租赁合同
	 */
    public Integer getZulinhetongId() {
        return zulinhetongId;
    }


    /**
	 * 设置：租赁合同
	 */
    public void setZulinhetongId(Integer zulinhetongId) {
        this.zulinhetongId = zulinhetongId;
    }
    /**
	 * 获取：投诉编号
	 */
    public String getTousuUuidNumber() {
        return tousuUuidNumber;
    }


    /**
	 * 设置：投诉编号
	 */
    public void setTousuUuidNumber(String tousuUuidNumber) {
        this.tousuUuidNumber = tousuUuidNumber;
    }
    /**
	 * 获取：投诉名称
	 */
    public String getTousuName() {
        return tousuName;
    }


    /**
	 * 设置：投诉名称
	 */
    public void setTousuName(String tousuName) {
        this.tousuName = tousuName;
    }
    /**
	 * 获取：投诉类型
	 */
    public Integer getTousuTypes() {
        return tousuTypes;
    }


    /**
	 * 设置：投诉类型
	 */
    public void setTousuTypes(Integer tousuTypes) {
        this.tousuTypes = tousuTypes;
    }
    /**
	 * 获取：投诉证据
	 */
    public String getTousuFile() {
        return tousuFile;
    }


    /**
	 * 设置：投诉证据
	 */
    public void setTousuFile(String tousuFile) {
        this.tousuFile = tousuFile;
    }
    /**
	 * 获取：投诉内容
	 */
    public String getTousuContent() {
        return tousuContent;
    }


    /**
	 * 设置：投诉内容
	 */
    public void setTousuContent(String tousuContent) {
        this.tousuContent = tousuContent;
    }
    /**
	 * 获取：投诉时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：投诉时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：回复内容
	 */
    public String getHuifuContent() {
        return huifuContent;
    }


    /**
	 * 设置：回复内容
	 */
    public void setHuifuContent(String huifuContent) {
        this.huifuContent = huifuContent;
    }
    /**
	 * 获取：回复时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 设置：回复时间
	 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
