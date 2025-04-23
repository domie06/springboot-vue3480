package com.entity.view;

import com.entity.ZulinhetongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 租赁合同
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zulinhetong")
public class ZulinhetongView extends ZulinhetongEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 租赁合同类型的值
		*/
		private String zulinhetongValue;
		/**
		* 是否同意的值
		*/
		private String zulinhetongYesnoValue;



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

		//级联表 fangzhu
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
			* 房主电子邮箱
			*/
			private String fangzhuEmail;

	public ZulinhetongView() {

	}

	public ZulinhetongView(ZulinhetongEntity zulinhetongEntity) {
		try {
			BeanUtils.copyProperties(this, zulinhetongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

















				//级联表的get和set fangzhu

					/**
					* 获取： 房主姓名
					*/
					public String getFangzhuName() {
						return fangzhuName;
					}
					/**
					* 设置： 房主姓名
					*/
					public void setFangzhuName(String fangzhuName) {
						this.fangzhuName = fangzhuName;
					}

					/**
					* 获取： 房主手机号
					*/
					public String getFangzhuPhone() {
						return fangzhuPhone;
					}
					/**
					* 设置： 房主手机号
					*/
					public void setFangzhuPhone(String fangzhuPhone) {
						this.fangzhuPhone = fangzhuPhone;
					}

					/**
					* 获取： 房主身份证号
					*/
					public String getFangzhuIdNumber() {
						return fangzhuIdNumber;
					}
					/**
					* 设置： 房主身份证号
					*/
					public void setFangzhuIdNumber(String fangzhuIdNumber) {
						this.fangzhuIdNumber = fangzhuIdNumber;
					}

					/**
					* 获取： 房主头像
					*/
					public String getFangzhuPhoto() {
						return fangzhuPhoto;
					}
					/**
					* 设置： 房主头像
					*/
					public void setFangzhuPhoto(String fangzhuPhoto) {
						this.fangzhuPhoto = fangzhuPhoto;
					}

					/**
					* 获取： 房主电子邮箱
					*/
					public String getFangzhuEmail() {
						return fangzhuEmail;
					}
					/**
					* 设置： 房主电子邮箱
					*/
					public void setFangzhuEmail(String fangzhuEmail) {
						this.fangzhuEmail = fangzhuEmail;
					}
















}
