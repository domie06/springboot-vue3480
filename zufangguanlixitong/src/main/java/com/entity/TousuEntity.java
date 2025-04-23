package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 投诉
 *
 * @author 
 * @email
 */
@TableName("tousu")
public class TousuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TousuEntity() {

	}

	public TousuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 租客
     */
    @TableField(value = "zuke_id")

    private Integer zukeId;


    /**
     * 租赁合同
     */
    @TableField(value = "zulinhetong_id")

    private Integer zulinhetongId;


    /**
     * 投诉编号
     */
    @TableField(value = "tousu_uuid_number")

    private String tousuUuidNumber;


    /**
     * 投诉名称
     */
    @TableField(value = "tousu_name")

    private String tousuName;


    /**
     * 投诉类型
     */
    @TableField(value = "tousu_types")

    private Integer tousuTypes;


    /**
     * 投诉证据
     */
    @TableField(value = "tousu_file")

    private String tousuFile;


    /**
     * 投诉内容
     */
    @TableField(value = "tousu_content")

    private String tousuContent;


    /**
     * 投诉时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 回复内容
     */
    @TableField(value = "huifu_content")

    private String huifuContent;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "update_time",fill = FieldFill.UPDATE)

    private Date updateTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：租客
	 */
    public Integer getZukeId() {
        return zukeId;
    }
    /**
	 * 获取：租客
	 */

    public void setZukeId(Integer zukeId) {
        this.zukeId = zukeId;
    }
    /**
	 * 设置：租赁合同
	 */
    public Integer getZulinhetongId() {
        return zulinhetongId;
    }
    /**
	 * 获取：租赁合同
	 */

    public void setZulinhetongId(Integer zulinhetongId) {
        this.zulinhetongId = zulinhetongId;
    }
    /**
	 * 设置：投诉编号
	 */
    public String getTousuUuidNumber() {
        return tousuUuidNumber;
    }
    /**
	 * 获取：投诉编号
	 */

    public void setTousuUuidNumber(String tousuUuidNumber) {
        this.tousuUuidNumber = tousuUuidNumber;
    }
    /**
	 * 设置：投诉名称
	 */
    public String getTousuName() {
        return tousuName;
    }
    /**
	 * 获取：投诉名称
	 */

    public void setTousuName(String tousuName) {
        this.tousuName = tousuName;
    }
    /**
	 * 设置：投诉类型
	 */
    public Integer getTousuTypes() {
        return tousuTypes;
    }
    /**
	 * 获取：投诉类型
	 */

    public void setTousuTypes(Integer tousuTypes) {
        this.tousuTypes = tousuTypes;
    }
    /**
	 * 设置：投诉证据
	 */
    public String getTousuFile() {
        return tousuFile;
    }
    /**
	 * 获取：投诉证据
	 */

    public void setTousuFile(String tousuFile) {
        this.tousuFile = tousuFile;
    }
    /**
	 * 设置：投诉内容
	 */
    public String getTousuContent() {
        return tousuContent;
    }
    /**
	 * 获取：投诉内容
	 */

    public void setTousuContent(String tousuContent) {
        this.tousuContent = tousuContent;
    }
    /**
	 * 设置：投诉时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：投诉时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：回复内容
	 */
    public String getHuifuContent() {
        return huifuContent;
    }
    /**
	 * 获取：回复内容
	 */

    public void setHuifuContent(String huifuContent) {
        this.huifuContent = huifuContent;
    }
    /**
	 * 设置：回复时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
	 * 获取：回复时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Tousu{" +
            "id=" + id +
            ", zukeId=" + zukeId +
            ", zulinhetongId=" + zulinhetongId +
            ", tousuUuidNumber=" + tousuUuidNumber +
            ", tousuName=" + tousuName +
            ", tousuTypes=" + tousuTypes +
            ", tousuFile=" + tousuFile +
            ", tousuContent=" + tousuContent +
            ", insertTime=" + insertTime +
            ", huifuContent=" + huifuContent +
            ", updateTime=" + updateTime +
            ", createTime=" + createTime +
        "}";
    }
}
