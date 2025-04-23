package com.entity.model;

import com.entity.FangzhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房主
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangzhuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 房主姓名
     */
    private String fangzhuName;


    /**
     * 房主手机号
     */
    private String fangzhuPhone;


    /**
     * 房主身份证号
     */
    private String fangzhuIdNumber;


    /**
     * 房主头像
     */
    private String fangzhuPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 房主电子邮箱
     */
    private String fangzhuEmail;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：房主姓名
	 */
    public String getFangzhuName() {
        return fangzhuName;
    }


    /**
	 * 设置：房主姓名
	 */
    public void setFangzhuName(String fangzhuName) {
        this.fangzhuName = fangzhuName;
    }
    /**
	 * 获取：房主手机号
	 */
    public String getFangzhuPhone() {
        return fangzhuPhone;
    }


    /**
	 * 设置：房主手机号
	 */
    public void setFangzhuPhone(String fangzhuPhone) {
        this.fangzhuPhone = fangzhuPhone;
    }
    /**
	 * 获取：房主身份证号
	 */
    public String getFangzhuIdNumber() {
        return fangzhuIdNumber;
    }


    /**
	 * 设置：房主身份证号
	 */
    public void setFangzhuIdNumber(String fangzhuIdNumber) {
        this.fangzhuIdNumber = fangzhuIdNumber;
    }
    /**
	 * 获取：房主头像
	 */
    public String getFangzhuPhoto() {
        return fangzhuPhoto;
    }


    /**
	 * 设置：房主头像
	 */
    public void setFangzhuPhoto(String fangzhuPhoto) {
        this.fangzhuPhoto = fangzhuPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：房主电子邮箱
	 */
    public String getFangzhuEmail() {
        return fangzhuEmail;
    }


    /**
	 * 设置：房主电子邮箱
	 */
    public void setFangzhuEmail(String fangzhuEmail) {
        this.fangzhuEmail = fangzhuEmail;
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
