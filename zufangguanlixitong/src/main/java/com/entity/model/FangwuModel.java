package com.entity.model;

import com.entity.FangwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房屋
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangwuModel implements Serializable {
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
     * 房屋名称
     */
    private String fangwuName;


    /**
     * 房屋编号
     */
    private String fangwuUuidNumber;


    /**
     * 房屋照片
     */
    private String fangwuPhoto;


    /**
     * 房屋类型
     */
    private Integer fangwuTypes;


    /**
     * 房屋位置
     */
    private String fangwuAddress;


    /**
     * 房屋面积
     */
    private Double fangwuMianji;


    /**
     * 金额/平米
     */
    private Double fangwuPingmiJine;


    /**
     * 房屋原总价
     */
    private Double fangwuOldMoney;


    /**
     * 现总价
     */
    private Double fangwuNewMoney;


    /**
     * 房屋热度
     */
    private Integer fangwuClicknum;


    /**
     * 房屋详情
     */
    private String fangwuContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer fangwuDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：房屋名称
	 */
    public String getFangwuName() {
        return fangwuName;
    }


    /**
	 * 设置：房屋名称
	 */
    public void setFangwuName(String fangwuName) {
        this.fangwuName = fangwuName;
    }
    /**
	 * 获取：房屋编号
	 */
    public String getFangwuUuidNumber() {
        return fangwuUuidNumber;
    }


    /**
	 * 设置：房屋编号
	 */
    public void setFangwuUuidNumber(String fangwuUuidNumber) {
        this.fangwuUuidNumber = fangwuUuidNumber;
    }
    /**
	 * 获取：房屋照片
	 */
    public String getFangwuPhoto() {
        return fangwuPhoto;
    }


    /**
	 * 设置：房屋照片
	 */
    public void setFangwuPhoto(String fangwuPhoto) {
        this.fangwuPhoto = fangwuPhoto;
    }
    /**
	 * 获取：房屋类型
	 */
    public Integer getFangwuTypes() {
        return fangwuTypes;
    }


    /**
	 * 设置：房屋类型
	 */
    public void setFangwuTypes(Integer fangwuTypes) {
        this.fangwuTypes = fangwuTypes;
    }
    /**
	 * 获取：房屋位置
	 */
    public String getFangwuAddress() {
        return fangwuAddress;
    }


    /**
	 * 设置：房屋位置
	 */
    public void setFangwuAddress(String fangwuAddress) {
        this.fangwuAddress = fangwuAddress;
    }
    /**
	 * 获取：房屋面积
	 */
    public Double getFangwuMianji() {
        return fangwuMianji;
    }


    /**
	 * 设置：房屋面积
	 */
    public void setFangwuMianji(Double fangwuMianji) {
        this.fangwuMianji = fangwuMianji;
    }
    /**
	 * 获取：金额/平米
	 */
    public Double getFangwuPingmiJine() {
        return fangwuPingmiJine;
    }


    /**
	 * 设置：金额/平米
	 */
    public void setFangwuPingmiJine(Double fangwuPingmiJine) {
        this.fangwuPingmiJine = fangwuPingmiJine;
    }
    /**
	 * 获取：房屋原总价
	 */
    public Double getFangwuOldMoney() {
        return fangwuOldMoney;
    }


    /**
	 * 设置：房屋原总价
	 */
    public void setFangwuOldMoney(Double fangwuOldMoney) {
        this.fangwuOldMoney = fangwuOldMoney;
    }
    /**
	 * 获取：现总价
	 */
    public Double getFangwuNewMoney() {
        return fangwuNewMoney;
    }


    /**
	 * 设置：现总价
	 */
    public void setFangwuNewMoney(Double fangwuNewMoney) {
        this.fangwuNewMoney = fangwuNewMoney;
    }
    /**
	 * 获取：房屋热度
	 */
    public Integer getFangwuClicknum() {
        return fangwuClicknum;
    }


    /**
	 * 设置：房屋热度
	 */
    public void setFangwuClicknum(Integer fangwuClicknum) {
        this.fangwuClicknum = fangwuClicknum;
    }
    /**
	 * 获取：房屋详情
	 */
    public String getFangwuContent() {
        return fangwuContent;
    }


    /**
	 * 设置：房屋详情
	 */
    public void setFangwuContent(String fangwuContent) {
        this.fangwuContent = fangwuContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFangwuDelete() {
        return fangwuDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setFangwuDelete(Integer fangwuDelete) {
        this.fangwuDelete = fangwuDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
