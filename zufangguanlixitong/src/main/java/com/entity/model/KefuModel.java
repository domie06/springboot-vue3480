package com.entity.model;

import com.entity.KefuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 客服
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KefuModel implements Serializable {
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
     * 客服姓名
     */
    private String kefuName;


    /**
     * 客服手机号
     */
    private String kefuPhone;


    /**
     * 客服身份证号
     */
    private String kefuIdNumber;


    /**
     * 客服头像
     */
    private String kefuPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 客服电子邮箱
     */
    private String kefuEmail;


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
	 * 获取：客服姓名
	 */
    public String getKefuName() {
        return kefuName;
    }


    /**
	 * 设置：客服姓名
	 */
    public void setKefuName(String kefuName) {
        this.kefuName = kefuName;
    }
    /**
	 * 获取：客服手机号
	 */
    public String getKefuPhone() {
        return kefuPhone;
    }


    /**
	 * 设置：客服手机号
	 */
    public void setKefuPhone(String kefuPhone) {
        this.kefuPhone = kefuPhone;
    }
    /**
	 * 获取：客服身份证号
	 */
    public String getKefuIdNumber() {
        return kefuIdNumber;
    }


    /**
	 * 设置：客服身份证号
	 */
    public void setKefuIdNumber(String kefuIdNumber) {
        this.kefuIdNumber = kefuIdNumber;
    }
    /**
	 * 获取：客服头像
	 */
    public String getKefuPhoto() {
        return kefuPhoto;
    }


    /**
	 * 设置：客服头像
	 */
    public void setKefuPhoto(String kefuPhoto) {
        this.kefuPhoto = kefuPhoto;
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
	 * 获取：客服电子邮箱
	 */
    public String getKefuEmail() {
        return kefuEmail;
    }


    /**
	 * 设置：客服电子邮箱
	 */
    public void setKefuEmail(String kefuEmail) {
        this.kefuEmail = kefuEmail;
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
