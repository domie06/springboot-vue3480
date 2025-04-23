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
 * 房主
 *
 * @author 
 * @email
 */
@TableName("fangzhu")
public class FangzhuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangzhuEntity() {

	}

	public FangzhuEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 房主姓名
     */
    @TableField(value = "fangzhu_name")

    private String fangzhuName;


    /**
     * 房主手机号
     */
    @TableField(value = "fangzhu_phone")

    private String fangzhuPhone;


    /**
     * 房主身份证号
     */
    @TableField(value = "fangzhu_id_number")

    private String fangzhuIdNumber;


    /**
     * 房主头像
     */
    @TableField(value = "fangzhu_photo")

    private String fangzhuPhoto;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 房主电子邮箱
     */
    @TableField(value = "fangzhu_email")

    private String fangzhuEmail;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：房主姓名
	 */
    public String getFangzhuName() {
        return fangzhuName;
    }
    /**
	 * 获取：房主姓名
	 */

    public void setFangzhuName(String fangzhuName) {
        this.fangzhuName = fangzhuName;
    }
    /**
	 * 设置：房主手机号
	 */
    public String getFangzhuPhone() {
        return fangzhuPhone;
    }
    /**
	 * 获取：房主手机号
	 */

    public void setFangzhuPhone(String fangzhuPhone) {
        this.fangzhuPhone = fangzhuPhone;
    }
    /**
	 * 设置：房主身份证号
	 */
    public String getFangzhuIdNumber() {
        return fangzhuIdNumber;
    }
    /**
	 * 获取：房主身份证号
	 */

    public void setFangzhuIdNumber(String fangzhuIdNumber) {
        this.fangzhuIdNumber = fangzhuIdNumber;
    }
    /**
	 * 设置：房主头像
	 */
    public String getFangzhuPhoto() {
        return fangzhuPhoto;
    }
    /**
	 * 获取：房主头像
	 */

    public void setFangzhuPhoto(String fangzhuPhoto) {
        this.fangzhuPhoto = fangzhuPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：房主电子邮箱
	 */
    public String getFangzhuEmail() {
        return fangzhuEmail;
    }
    /**
	 * 获取：房主电子邮箱
	 */

    public void setFangzhuEmail(String fangzhuEmail) {
        this.fangzhuEmail = fangzhuEmail;
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
        return "Fangzhu{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", fangzhuName=" + fangzhuName +
            ", fangzhuPhone=" + fangzhuPhone +
            ", fangzhuIdNumber=" + fangzhuIdNumber +
            ", fangzhuPhoto=" + fangzhuPhoto +
            ", sexTypes=" + sexTypes +
            ", fangzhuEmail=" + fangzhuEmail +
            ", createTime=" + createTime +
        "}";
    }
}
