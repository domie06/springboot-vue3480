package com.entity.view;

import com.entity.FangwuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 房屋
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fangwu")
public class FangwuView extends FangwuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 房屋类型的值
		*/
		private String fangwuValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



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

	public FangwuView() {

	}

	public FangwuView(FangwuEntity fangwuEntity) {
		try {
			BeanUtils.copyProperties(this, fangwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 房屋类型的值
			*/
			public String getFangwuValue() {
				return fangwuValue;
			}
			/**
			* 设置： 房屋类型的值
			*/
			public void setFangwuValue(String fangwuValue) {
				this.fangwuValue = fangwuValue;
			}
			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
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
