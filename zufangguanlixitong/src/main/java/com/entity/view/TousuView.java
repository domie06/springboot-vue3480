package com.entity.view;

import com.entity.TousuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 投诉
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("tousu")
public class TousuView extends TousuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 投诉类型的值
		*/
		private String tousuValue;



		//级联表 zuke
			/**
			* 租客姓名
			*/
			private String zukeName;
			/**
			* 租客手机号
			*/
			private String zukePhone;
			/**
			* 租客身份证号
			*/
			private String zukeIdNumber;
			/**
			* 租客头像
			*/
			private String zukePhoto;
			/**
			* 电子邮箱
			*/
			private String zukeEmail;

		//级联表 zulinhetong
			/**
			* 租赁合同 的 房主
			*/
			private Integer zulinhetongFangzhuId;
			/**
			* 租赁合同 的 租客
			*/
			private Integer zulinhetongZukeId;
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
				* 租赁合同类型的值
				*/
				private String zulinhetongValue;
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
				* 是否同意的值
				*/
				private String zulinhetongYesnoValue;

	public TousuView() {

	}

	public TousuView(TousuEntity tousuEntity) {
		try {
			BeanUtils.copyProperties(this, tousuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 投诉类型的值
			*/
			public String getTousuValue() {
				return tousuValue;
			}
			/**
			* 设置： 投诉类型的值
			*/
			public void setTousuValue(String tousuValue) {
				this.tousuValue = tousuValue;
			}







				//级联表的get和set zuke

					/**
					* 获取： 租客姓名
					*/
					public String getZukeName() {
						return zukeName;
					}
					/**
					* 设置： 租客姓名
					*/
					public void setZukeName(String zukeName) {
						this.zukeName = zukeName;
					}

					/**
					* 获取： 租客手机号
					*/
					public String getZukePhone() {
						return zukePhone;
					}
					/**
					* 设置： 租客手机号
					*/
					public void setZukePhone(String zukePhone) {
						this.zukePhone = zukePhone;
					}

					/**
					* 获取： 租客身份证号
					*/
					public String getZukeIdNumber() {
						return zukeIdNumber;
					}
					/**
					* 设置： 租客身份证号
					*/
					public void setZukeIdNumber(String zukeIdNumber) {
						this.zukeIdNumber = zukeIdNumber;
					}

					/**
					* 获取： 租客头像
					*/
					public String getZukePhoto() {
						return zukePhoto;
					}
					/**
					* 设置： 租客头像
					*/
					public void setZukePhoto(String zukePhoto) {
						this.zukePhoto = zukePhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getZukeEmail() {
						return zukeEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setZukeEmail(String zukeEmail) {
						this.zukeEmail = zukeEmail;
					}































				//级联表的get和set zulinhetong

					/**
					* 获取：租赁合同 的 房主
					*/
					public Integer getZulinhetongFangzhuId() {
						return zulinhetongFangzhuId;
					}
					/**
					* 设置：租赁合同 的 房主
					*/
					public void setZulinhetongFangzhuId(Integer zulinhetongFangzhuId) {
						this.zulinhetongFangzhuId = zulinhetongFangzhuId;
					}


					/**
					* 获取：租赁合同 的 租客
					*/
					public Integer getZulinhetongZukeId() {
						return zulinhetongZukeId;
					}
					/**
					* 设置：租赁合同 的 租客
					*/
					public void setZulinhetongZukeId(Integer zulinhetongZukeId) {
						this.zulinhetongZukeId = zulinhetongZukeId;
					}


					/**
					* 获取： 租赁合同编号
					*/
					public String getZulinhetongUuidNumber() {
						return zulinhetongUuidNumber;
					}
					/**
					* 设置： 租赁合同编号
					*/
					public void setZulinhetongUuidNumber(String zulinhetongUuidNumber) {
						this.zulinhetongUuidNumber = zulinhetongUuidNumber;
					}

					/**
					* 获取： 租赁合同名称
					*/
					public String getZulinhetongName() {
						return zulinhetongName;
					}
					/**
					* 设置： 租赁合同名称
					*/
					public void setZulinhetongName(String zulinhetongName) {
						this.zulinhetongName = zulinhetongName;
					}

					/**
					* 获取： 租赁合同文件
					*/
					public String getZulinhetongFile() {
						return zulinhetongFile;
					}
					/**
					* 设置： 租赁合同文件
					*/
					public void setZulinhetongFile(String zulinhetongFile) {
						this.zulinhetongFile = zulinhetongFile;
					}

					/**
					* 获取： 租赁合同类型
					*/
					public Integer getZulinhetongTypes() {
						return zulinhetongTypes;
					}
					/**
					* 设置： 租赁合同类型
					*/
					public void setZulinhetongTypes(Integer zulinhetongTypes) {
						this.zulinhetongTypes = zulinhetongTypes;
					}


						/**
						* 获取： 租赁合同类型的值
						*/
						public String getZulinhetongValue() {
							return zulinhetongValue;
						}
						/**
						* 设置： 租赁合同类型的值
						*/
						public void setZulinhetongValue(String zulinhetongValue) {
							this.zulinhetongValue = zulinhetongValue;
						}

					/**
					* 获取： 租赁日期
					*/
					public Date getZulinriqiTime() {
						return zulinriqiTime;
					}
					/**
					* 设置： 租赁日期
					*/
					public void setZulinriqiTime(Date zulinriqiTime) {
						this.zulinriqiTime = zulinriqiTime;
					}

					/**
					* 获取： 租赁月
					*/
					public Integer getZulinhetongYue() {
						return zulinhetongYue;
					}
					/**
					* 设置： 租赁月
					*/
					public void setZulinhetongYue(Integer zulinhetongYue) {
						this.zulinhetongYue = zulinhetongYue;
					}

					/**
					* 获取： 押金
					*/
					public Double getZulinhetongYajinJine() {
						return zulinhetongYajinJine;
					}
					/**
					* 设置： 押金
					*/
					public void setZulinhetongYajinJine(Double zulinhetongYajinJine) {
						this.zulinhetongYajinJine = zulinhetongYajinJine;
					}

					/**
					* 获取： 每月金额
					*/
					public Double getZulinhetongJine() {
						return zulinhetongJine;
					}
					/**
					* 设置： 每月金额
					*/
					public void setZulinhetongJine(Double zulinhetongJine) {
						this.zulinhetongJine = zulinhetongJine;
					}

					/**
					* 获取： 合同备注
					*/
					public String getZulinhetongContent() {
						return zulinhetongContent;
					}
					/**
					* 设置： 合同备注
					*/
					public void setZulinhetongContent(String zulinhetongContent) {
						this.zulinhetongContent = zulinhetongContent;
					}

					/**
					* 获取： 是否同意
					*/
					public Integer getZulinhetongYesnoTypes() {
						return zulinhetongYesnoTypes;
					}
					/**
					* 设置： 是否同意
					*/
					public void setZulinhetongYesnoTypes(Integer zulinhetongYesnoTypes) {
						this.zulinhetongYesnoTypes = zulinhetongYesnoTypes;
					}


						/**
						* 获取： 是否同意的值
						*/
						public String getZulinhetongYesnoValue() {
							return zulinhetongYesnoValue;
						}
						/**
						* 设置： 是否同意的值
						*/
						public void setZulinhetongYesnoValue(String zulinhetongYesnoValue) {
							this.zulinhetongYesnoValue = zulinhetongYesnoValue;
						}



}
