package com.entity.view;

import com.entity.BaoxiuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 报修
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("baoxiu")
public class BaoxiuView extends BaoxiuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 报修物品类型的值
		*/
		private String baoxiuValue;
		/**
		* 故障类型的值
		*/
		private String guzhangValue;
		/**
		* 维修状态的值
		*/
		private String weixiuzhuangtaiValue;



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

		//级联表 weixiurenyuan
			/**
			* 维修人员姓名
			*/
			private String weixiurenyuanName;
			/**
			* 维修人员手机号
			*/
			private String weixiurenyuanPhone;
			/**
			* 维修人员身份证号
			*/
			private String weixiurenyuanIdNumber;
			/**
			* 维修人员头像
			*/
			private String weixiurenyuanPhoto;
			/**
			* 维修人员电子邮箱
			*/
			private String weixiurenyuanEmail;

	public BaoxiuView() {

	}

	public BaoxiuView(BaoxiuEntity baoxiuEntity) {
		try {
			BeanUtils.copyProperties(this, baoxiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 报修物品类型的值
			*/
			public String getBaoxiuValue() {
				return baoxiuValue;
			}
			/**
			* 设置： 报修物品类型的值
			*/
			public void setBaoxiuValue(String baoxiuValue) {
				this.baoxiuValue = baoxiuValue;
			}
			/**
			* 获取： 故障类型的值
			*/
			public String getGuzhangValue() {
				return guzhangValue;
			}
			/**
			* 设置： 故障类型的值
			*/
			public void setGuzhangValue(String guzhangValue) {
				this.guzhangValue = guzhangValue;
			}
			/**
			* 获取： 维修状态的值
			*/
			public String getWeixiuzhuangtaiValue() {
				return weixiuzhuangtaiValue;
			}
			/**
			* 设置： 维修状态的值
			*/
			public void setWeixiuzhuangtaiValue(String weixiuzhuangtaiValue) {
				this.weixiuzhuangtaiValue = weixiuzhuangtaiValue;
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




























				//级联表的get和set weixiurenyuan

					/**
					* 获取： 维修人员姓名
					*/
					public String getWeixiurenyuanName() {
						return weixiurenyuanName;
					}
					/**
					* 设置： 维修人员姓名
					*/
					public void setWeixiurenyuanName(String weixiurenyuanName) {
						this.weixiurenyuanName = weixiurenyuanName;
					}

					/**
					* 获取： 维修人员手机号
					*/
					public String getWeixiurenyuanPhone() {
						return weixiurenyuanPhone;
					}
					/**
					* 设置： 维修人员手机号
					*/
					public void setWeixiurenyuanPhone(String weixiurenyuanPhone) {
						this.weixiurenyuanPhone = weixiurenyuanPhone;
					}

					/**
					* 获取： 维修人员身份证号
					*/
					public String getWeixiurenyuanIdNumber() {
						return weixiurenyuanIdNumber;
					}
					/**
					* 设置： 维修人员身份证号
					*/
					public void setWeixiurenyuanIdNumber(String weixiurenyuanIdNumber) {
						this.weixiurenyuanIdNumber = weixiurenyuanIdNumber;
					}

					/**
					* 获取： 维修人员头像
					*/
					public String getWeixiurenyuanPhoto() {
						return weixiurenyuanPhoto;
					}
					/**
					* 设置： 维修人员头像
					*/
					public void setWeixiurenyuanPhoto(String weixiurenyuanPhoto) {
						this.weixiurenyuanPhoto = weixiurenyuanPhoto;
					}

					/**
					* 获取： 维修人员电子邮箱
					*/
					public String getWeixiurenyuanEmail() {
						return weixiurenyuanEmail;
					}
					/**
					* 设置： 维修人员电子邮箱
					*/
					public void setWeixiurenyuanEmail(String weixiurenyuanEmail) {
						this.weixiurenyuanEmail = weixiurenyuanEmail;
					}






}
