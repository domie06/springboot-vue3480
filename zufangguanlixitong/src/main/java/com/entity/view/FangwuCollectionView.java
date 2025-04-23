package com.entity.view;

import com.entity.FangwuCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 房屋收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fangwu_collection")
public class FangwuCollectionView extends FangwuCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String fangwuCollectionValue;



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

		//级联表 fangwu
			/**
			* 房屋 的 房主
			*/
			private Integer fangwuFangzhuId;
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
				* 房屋类型的值
				*/
				private String fangwuValue;
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
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer fangwuDelete;

	public FangwuCollectionView() {

	}

	public FangwuCollectionView(FangwuCollectionEntity fangwuCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, fangwuCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getFangwuCollectionValue() {
				return fangwuCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setFangwuCollectionValue(String fangwuCollectionValue) {
				this.fangwuCollectionValue = fangwuCollectionValue;
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





				//级联表的get和set fangwu

					/**
					* 获取：房屋 的 房主
					*/
					public Integer getFangwuFangzhuId() {
						return fangwuFangzhuId;
					}
					/**
					* 设置：房屋 的 房主
					*/
					public void setFangwuFangzhuId(Integer fangwuFangzhuId) {
						this.fangwuFangzhuId = fangwuFangzhuId;
					}


					/**
					* 获取： 房屋名称
					*/
					public String getFangwuName() {
						return fangwuName;
					}
					/**
					* 设置： 房屋名称
					*/
					public void setFangwuName(String fangwuName) {
						this.fangwuName = fangwuName;
					}

					/**
					* 获取： 房屋编号
					*/
					public String getFangwuUuidNumber() {
						return fangwuUuidNumber;
					}
					/**
					* 设置： 房屋编号
					*/
					public void setFangwuUuidNumber(String fangwuUuidNumber) {
						this.fangwuUuidNumber = fangwuUuidNumber;
					}

					/**
					* 获取： 房屋照片
					*/
					public String getFangwuPhoto() {
						return fangwuPhoto;
					}
					/**
					* 设置： 房屋照片
					*/
					public void setFangwuPhoto(String fangwuPhoto) {
						this.fangwuPhoto = fangwuPhoto;
					}

					/**
					* 获取： 房屋类型
					*/
					public Integer getFangwuTypes() {
						return fangwuTypes;
					}
					/**
					* 设置： 房屋类型
					*/
					public void setFangwuTypes(Integer fangwuTypes) {
						this.fangwuTypes = fangwuTypes;
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
					* 获取： 房屋位置
					*/
					public String getFangwuAddress() {
						return fangwuAddress;
					}
					/**
					* 设置： 房屋位置
					*/
					public void setFangwuAddress(String fangwuAddress) {
						this.fangwuAddress = fangwuAddress;
					}

					/**
					* 获取： 房屋面积
					*/
					public Double getFangwuMianji() {
						return fangwuMianji;
					}
					/**
					* 设置： 房屋面积
					*/
					public void setFangwuMianji(Double fangwuMianji) {
						this.fangwuMianji = fangwuMianji;
					}

					/**
					* 获取： 金额/平米
					*/
					public Double getFangwuPingmiJine() {
						return fangwuPingmiJine;
					}
					/**
					* 设置： 金额/平米
					*/
					public void setFangwuPingmiJine(Double fangwuPingmiJine) {
						this.fangwuPingmiJine = fangwuPingmiJine;
					}

					/**
					* 获取： 房屋原总价
					*/
					public Double getFangwuOldMoney() {
						return fangwuOldMoney;
					}
					/**
					* 设置： 房屋原总价
					*/
					public void setFangwuOldMoney(Double fangwuOldMoney) {
						this.fangwuOldMoney = fangwuOldMoney;
					}

					/**
					* 获取： 现总价
					*/
					public Double getFangwuNewMoney() {
						return fangwuNewMoney;
					}
					/**
					* 设置： 现总价
					*/
					public void setFangwuNewMoney(Double fangwuNewMoney) {
						this.fangwuNewMoney = fangwuNewMoney;
					}

					/**
					* 获取： 房屋热度
					*/
					public Integer getFangwuClicknum() {
						return fangwuClicknum;
					}
					/**
					* 设置： 房屋热度
					*/
					public void setFangwuClicknum(Integer fangwuClicknum) {
						this.fangwuClicknum = fangwuClicknum;
					}

					/**
					* 获取： 房屋详情
					*/
					public String getFangwuContent() {
						return fangwuContent;
					}
					/**
					* 设置： 房屋详情
					*/
					public void setFangwuContent(String fangwuContent) {
						this.fangwuContent = fangwuContent;
					}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
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

					/**
					* 获取： 逻辑删除
					*/
					public Integer getFangwuDelete() {
						return fangwuDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setFangwuDelete(Integer fangwuDelete) {
						this.fangwuDelete = fangwuDelete;
					}




























}
