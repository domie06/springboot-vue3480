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
 * 报修
 *
 * @author 
 * @email
 */
@TableName("baoxiu")
public class BaoxiuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BaoxiuEntity() {

	}

	public BaoxiuEntity(T t) {
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
     * 维修人员
     */
    @TableField(value = "weixiurenyuan_id")

    private Integer weixiurenyuanId;


    /**
     * 报修编号
     */
    @TableField(value = "baoxiu_uuid_number")

    private String baoxiuUuidNumber;


    /**
     * 报修物品类型
     */
    @TableField(value = "baoxiu_types")

    private Integer baoxiuTypes;


    /**
     * 故障类型
     */
    @TableField(value = "guzhang_types")

    private Integer guzhangTypes;


    /**
     * 报修位置
     */
    @TableField(value = "baoxiu_address")

    private String baoxiuAddress;


    /**
     * 上报时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 上报详情
     */
    @TableField(value = "forum_content")

    private String forumContent;


    /**
     * 维修状态
     */
    @TableField(value = "weixiuzhuangtai_types")

    private Integer weixiuzhuangtaiTypes;


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
	 * 设置：维修人员
	 */
    public Integer getWeixiurenyuanId() {
        return weixiurenyuanId;
    }
    /**
	 * 获取：维修人员
	 */

    public void setWeixiurenyuanId(Integer weixiurenyuanId) {
        this.weixiurenyuanId = weixiurenyuanId;
    }
    /**
	 * 设置：报修编号
	 */
    public String getBaoxiuUuidNumber() {
        return baoxiuUuidNumber;
    }
    /**
	 * 获取：报修编号
	 */

    public void setBaoxiuUuidNumber(String baoxiuUuidNumber) {
        this.baoxiuUuidNumber = baoxiuUuidNumber;
    }
    /**
	 * 设置：报修物品类型
	 */
    public Integer getBaoxiuTypes() {
        return baoxiuTypes;
    }
    /**
	 * 获取：报修物品类型
	 */

    public void setBaoxiuTypes(Integer baoxiuTypes) {
        this.baoxiuTypes = baoxiuTypes;
    }
    /**
	 * 设置：故障类型
	 */
    public Integer getGuzhangTypes() {
        return guzhangTypes;
    }
    /**
	 * 获取：故障类型
	 */

    public void setGuzhangTypes(Integer guzhangTypes) {
        this.guzhangTypes = guzhangTypes;
    }
    /**
	 * 设置：报修位置
	 */
    public String getBaoxiuAddress() {
        return baoxiuAddress;
    }
    /**
	 * 获取：报修位置
	 */

    public void setBaoxiuAddress(String baoxiuAddress) {
        this.baoxiuAddress = baoxiuAddress;
    }
    /**
	 * 设置：上报时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：上报时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：上报详情
	 */
    public String getForumContent() {
        return forumContent;
    }
    /**
	 * 获取：上报详情
	 */

    public void setForumContent(String forumContent) {
        this.forumContent = forumContent;
    }
    /**
	 * 设置：维修状态
	 */
    public Integer getWeixiuzhuangtaiTypes() {
        return weixiuzhuangtaiTypes;
    }
    /**
	 * 获取：维修状态
	 */

    public void setWeixiuzhuangtaiTypes(Integer weixiuzhuangtaiTypes) {
        this.weixiuzhuangtaiTypes = weixiuzhuangtaiTypes;
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
        return "Baoxiu{" +
            "id=" + id +
            ", zukeId=" + zukeId +
            ", weixiurenyuanId=" + weixiurenyuanId +
            ", baoxiuUuidNumber=" + baoxiuUuidNumber +
            ", baoxiuTypes=" + baoxiuTypes +
            ", guzhangTypes=" + guzhangTypes +
            ", baoxiuAddress=" + baoxiuAddress +
            ", insertTime=" + insertTime +
            ", forumContent=" + forumContent +
            ", weixiuzhuangtaiTypes=" + weixiuzhuangtaiTypes +
            ", createTime=" + createTime +
        "}";
    }
}
