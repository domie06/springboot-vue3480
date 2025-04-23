package com.entity.vo;

import com.entity.TousuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 投诉
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tousu")
public class TousuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
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

    @TableField(value = "update_time")
    private Date updateTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
