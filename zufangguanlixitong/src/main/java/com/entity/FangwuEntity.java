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
 * 房屋
 *
 * @author 
 * @email
 */
@TableName("fangwu")
public class FangwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangwuEntity() {

	}

	public FangwuEntity(T t) {
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
     * 房主
     */
    @TableField(value = "fangzhu_id")

    private Integer fangzhuId;


    /**
     * 房屋名称
     */
    @TableField(value = "fangwu_name")

    private String fangwuName;


    /**
     * 房屋编号
     */
    @TableField(value = "fangwu_uuid_number")

    private String fangwuUuidNumber;


    /**
     * 房屋照片
     */
    @TableField(value = "fangwu_photo")

    private String fangwuPhoto;


    /**
     * 房屋类型
     */
    @TableField(value = "fangwu_types")

    private Integer fangwuTypes;


    /**
     * 房屋位置
     */
    @TableField(value = "fangwu_address")

    private String fangwuAddress;


    /**
     * 房屋面积
     */
    @TableField(value = "fangwu_mianji")

    private Double fangwuMianji;


    /**
     * 金额/平米
     */
    @TableField(value = "fangwu_pingmi_jine")

    private Double fangwuPingmiJine;


    /**
     * 房屋原总价
     */
    @TableField(value = "fangwu_old_money")

    private Double fangwuOldMoney;


    /**
     * 现总价
     */
    @TableField(value = "fangwu_new_money")

    private Double fangwuNewMoney;


    /**
     * 房屋热度
     */
    @TableField(value = "fangwu_clicknum")

    private Integer fangwuClicknum;


    /**
     * 房屋详情
     */
    @TableField(value = "fangwu_content")

    private String fangwuContent;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "fangwu_delete")

    private Integer fangwuDelete;


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
	 * 设置：房主
	 */
    public Integer getFangzhuId() {
        return fangzhuId;
    }
    /**
	 * 获取：房主
	 */

    public void setFangzhuId(Integer fangzhuId) {
        this.fangzhuId = fangzhuId;
    }
    /**
	 * 设置：房屋名称
	 */
    public String getFangwuName() {
        return fangwuName;
    }
    /**
	 * 获取：房屋名称
	 */

    public void setFangwuName(String fangwuName) {
        this.fangwuName = fangwuName;
    }
    /**
	 * 设置：房屋编号
	 */
    public String getFangwuUuidNumber() {
        return fangwuUuidNumber;
    }
    /**
	 * 获取：房屋编号
	 */

    public void setFangwuUuidNumber(String fangwuUuidNumber) {
        this.fangwuUuidNumber = fangwuUuidNumber;
    }
    /**
	 * 设置：房屋照片
	 */
    public String getFangwuPhoto() {
        return fangwuPhoto;
    }
    /**
	 * 获取：房屋照片
	 */

    public void setFangwuPhoto(String fangwuPhoto) {
        this.fangwuPhoto = fangwuPhoto;
    }
    /**
	 * 设置：房屋类型
	 */
    public Integer getFangwuTypes() {
        return fangwuTypes;
    }
    /**
	 * 获取：房屋类型
	 */

    public void setFangwuTypes(Integer fangwuTypes) {
        this.fangwuTypes = fangwuTypes;
    }
    /**
	 * 设置：房屋位置
	 */
    public String getFangwuAddress() {
        return fangwuAddress;
    }
    /**
	 * 获取：房屋位置
	 */

    public void setFangwuAddress(String fangwuAddress) {
        this.fangwuAddress = fangwuAddress;
    }
    /**
	 * 设置：房屋面积
	 */
    public Double getFangwuMianji() {
        return fangwuMianji;
    }
    /**
	 * 获取：房屋面积
	 */

    public void setFangwuMianji(Double fangwuMianji) {
        this.fangwuMianji = fangwuMianji;
    }
    /**
	 * 设置：金额/平米
	 */
    public Double getFangwuPingmiJine() {
        return fangwuPingmiJine;
    }
    /**
	 * 获取：金额/平米
	 */

    public void setFangwuPingmiJine(Double fangwuPingmiJine) {
        this.fangwuPingmiJine = fangwuPingmiJine;
    }
    /**
	 * 设置：房屋原总价
	 */
    public Double getFangwuOldMoney() {
        return fangwuOldMoney;
    }
    /**
	 * 获取：房屋原总价
	 */

    public void setFangwuOldMoney(Double fangwuOldMoney) {
        this.fangwuOldMoney = fangwuOldMoney;
    }
    /**
	 * 设置：现总价
	 */
    public Double getFangwuNewMoney() {
        return fangwuNewMoney;
    }
    /**
	 * 获取：现总价
	 */

    public void setFangwuNewMoney(Double fangwuNewMoney) {
        this.fangwuNewMoney = fangwuNewMoney;
    }
    /**
	 * 设置：房屋热度
	 */
    public Integer getFangwuClicknum() {
        return fangwuClicknum;
    }
    /**
	 * 获取：房屋热度
	 */

    public void setFangwuClicknum(Integer fangwuClicknum) {
        this.fangwuClicknum = fangwuClicknum;
    }
    /**
	 * 设置：房屋详情
	 */
    public String getFangwuContent() {
        return fangwuContent;
    }
    /**
	 * 获取：房屋详情
	 */

    public void setFangwuContent(String fangwuContent) {
        this.fangwuContent = fangwuContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getFangwuDelete() {
        return fangwuDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setFangwuDelete(Integer fangwuDelete) {
        this.fangwuDelete = fangwuDelete;
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
        return "Fangwu{" +
            "id=" + id +
            ", fangzhuId=" + fangzhuId +
            ", fangwuName=" + fangwuName +
            ", fangwuUuidNumber=" + fangwuUuidNumber +
            ", fangwuPhoto=" + fangwuPhoto +
            ", fangwuTypes=" + fangwuTypes +
            ", fangwuAddress=" + fangwuAddress +
            ", fangwuMianji=" + fangwuMianji +
            ", fangwuPingmiJine=" + fangwuPingmiJine +
            ", fangwuOldMoney=" + fangwuOldMoney +
            ", fangwuNewMoney=" + fangwuNewMoney +
            ", fangwuClicknum=" + fangwuClicknum +
            ", fangwuContent=" + fangwuContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", fangwuDelete=" + fangwuDelete +
            ", createTime=" + createTime +
        "}";
    }
}
