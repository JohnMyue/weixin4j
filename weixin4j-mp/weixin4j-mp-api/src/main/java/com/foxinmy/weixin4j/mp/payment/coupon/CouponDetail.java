package com.foxinmy.weixin4j.mp.payment.coupon;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.foxinmy.weixin4j.mp.payment.v3.ApiResult;
import com.foxinmy.weixin4j.mp.type.CouponStatus;
import com.foxinmy.weixin4j.mp.type.CouponStockType;
import com.foxinmy.weixin4j.mp.type.CouponType;
import com.foxinmy.weixin4j.util.DateUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 代金券详细
 * 
 * @className CouponDetail
 * @author jy
 * @date 2015年3月27日
 * @since JDK 1.7
 * @see
 */
public class CouponDetail extends ApiResult {

	private static final long serialVersionUID = -311265355895457070L;

	/**
	 * 代金券批次Id
	 */
	@XStreamAlias("coupon_stock_id")
	@JSONField(name = "coupon_stock_id")
	private String couponStockId;

	/**
	 * 批次类型；1-批量型，2-触发型
	 */
	@XStreamAlias("coupon_stock_type")
	@JSONField(name = "coupon_stock_type")
	private int couponStockType;

	/**
	 * 代金券id
	 */
	@XStreamAlias("coupon_id")
	@JSONField(name = "coupon_id")
	private String couponId;
	/**
	 * 代金券面值,单位是分
	 */
	@XStreamAlias("coupon_value")
	@JSONField(name = "coupon_value")
	private int couponValue;

	/**
	 * 代金券使用最低限额,单位是分
	 */
	@XStreamAlias("coupon_mininum")
	@JSONField(name = "coupon_mininum")
	private int couponMininum;
	/**
	 * 代金券名称
	 */
	@XStreamAlias("coupon_name")
	@JSONField(name = "coupon_name")
	private String couponName;
	/**
	 * 代金券状态：2-已激活，4-已锁定，8-已实扣
	 */
	@XStreamAlias("coupon_state")
	@JSONField(name = "coupon_state")
	private int couponStatus;
	/**
	 * 代金券类型：1-代金券无门槛，2-代金券有门槛互斥，3-代金券有门槛叠加，
	 */
	@XStreamAlias("coupon_type")
	@JSONField(name = "coupon_type")
	private int couponType;

	/**
	 * 代金券描述
	 */
	@XStreamAlias("coupon_desc")
	@JSONField(name = "coupon_desc")
	private String couponDesc;

	/**
	 * 代金券实际使用金额
	 */
	@XStreamAlias("coupon_use_value")
	@JSONField(name = "coupon_use_value")
	private int couponUseValue;

	/**
	 * 代金券剩余金额：部分使用情况下，可能会存在券剩余金额
	 */
	@XStreamAlias("coupon_remain_value")
	@JSONField(name = "coupon_remain_value")
	private int couponRemainValue;

	/**
	 * 生效开始时间:格式为yyyyMMddhhmmss，如2009年12月27日9点10分10秒表示为20091227091010。
	 */
	@XStreamAlias("begin_time")
	@JSONField(name = "begin_time")
	private String beginTime;

	/**
	 * 生效结束时间:格式为yyyyMMddhhmmss，如2009年12月27日9点10分10秒表示为20091227091010。
	 */
	@XStreamAlias("end_time")
	@JSONField(name = "end_time")
	private String endTime;

	/**
	 * 发放时间:格式为yyyyMMddhhmmss，如2009年12月27日9点10分10秒表示为20091227091010。
	 */
	@XStreamAlias("send_time")
	@JSONField(name = "send_time")
	private String sendTime;

	/**
	 * 使用时间:格式为yyyyMMddhhmmss，如2009年12月27日9点10分10秒表示为20091227091010。
	 */
	@XStreamAlias("use_time")
	@JSONField(name = "use_time")
	private String useTime;

	/**
	 * 使用单号:代金券使用后，关联的大单收单单号
	 */
	@XStreamAlias("trade_no")
	@JSONField(name = "trade_no")
	private String tradeNo;

	/**
	 * 消耗方商户id:代金券使用后，消耗方商户id
	 */
	@XStreamAlias("consumer_mch_id")
	@JSONField(name = "consumer_mch_id")
	private String consumerMchId;

	/**
	 * 消耗方商户名称:代金券使用后，消耗方商户名称
	 */
	@XStreamAlias("consumer_mch_name")
	@JSONField(name = "consumer_mch_name")
	private String consumerMchName;

	/**
	 * 消耗方商户appid:代金券使用后，消耗方商户appid
	 */
	@XStreamAlias("consumer_mch_appid")
	@JSONField(name = "consumer_mch_appid")
	private String consumerMchAppid;

	/**
	 * 发放来源:代金券发放来源
	 */
	@XStreamAlias("send_source")
	@JSONField(name = "send_source")
	private String sendSource;

	/**
	 * 是否允许部分使用:该代金券是否允许部分使用标识：1-表示支持部分使用
	 */
	@XStreamAlias("is_partial_use")
	@JSONField(name = "is_partial_use")
	private int isPartialUse;

	public String getCouponStockId() {
		return couponStockId;
	}

	public int getCouponStockType() {
		return couponStockType;
	}

	@JSONField(deserialize = false, serialize = false)
	public CouponStockType getFormatCouponStockType() {
		for (CouponStockType couponStockType : CouponStockType.values()) {
			if (couponStockType.getVal() == this.couponStockType) {
				return couponStockType;
			}
		}
		return null;
	}

	public String getCouponId() {
		return couponId;
	}

	public int getCouponValue() {
		return couponValue;
	}

	/**
	 * <font color="red">调用接口获取单位为分,get方法转换为元方便使用</font>
	 * 
	 * @return 元单位
	 */
	@JSONField(deserialize = false, serialize = false)
	public double getFormatCouponValue() {
		return couponValue / 100d;
	}

	public int getCouponMininum() {
		return couponMininum;
	}

	/**
	 * <font color="red">调用接口获取单位为分,get方法转换为元方便使用</font>
	 * 
	 * @return 元单位
	 */
	@JSONField(deserialize = false, serialize = false)
	public double getFormatCouponMininum() {
		return couponMininum / 100d;
	}

	public String getCouponName() {
		return couponName;
	}

	public int getCouponStatus() {
		return couponStatus;
	}

	@JSONField(deserialize = false, serialize = false)
	public CouponStatus getFormatCouponStatus() {
		for (CouponStatus couponStatus : CouponStatus.values()) {
			if (couponStatus.getVal() == this.couponStatus) {
				return couponStatus;
			}
		}
		return null;
	}

	public int getCouponType() {
		return couponType;
	}

	@JSONField(deserialize = false, serialize = false)
	public CouponType getFormatCouponType() {
		for (CouponType couponType : CouponType.values()) {
			if (couponType.getVal() == this.couponType) {
				return couponType;
			}
		}
		return null;
	}

	public String getCouponDesc() {
		return couponDesc;
	}

	public int getCouponUseValue() {
		return couponUseValue;
	}

	/**
	 * <font color="red">调用接口获取单位为分,get方法转换为元方便使用</font>
	 * 
	 * @return 元单位
	 */
	@JSONField(deserialize = false, serialize = false)
	public double getFormatCouponUseValue() {
		return couponUseValue / 100d;
	}

	public int getCouponRemainValue() {
		return couponRemainValue;
	}

	/**
	 * <font color="red">调用接口获取单位为分,get方法转换为元方便使用</font>
	 * 
	 * @return 元单位
	 */
	@JSONField(deserialize = false, serialize = false)
	public double getFormatCouponRemainValue() {
		return couponRemainValue / 100d;
	}

	public String getBeginTime() {
		return beginTime;
	}

	@JSONField(deserialize = false, serialize = false)
	public Date getFormatBeginTime() {
		return DateUtil.parse2yyyyMMddHHmmss(beginTime);
	}

	public String getEndTime() {
		return endTime;
	}

	@JSONField(deserialize = false, serialize = false)
	public Date getFormatEndTime() {
		return DateUtil.parse2yyyyMMddHHmmss(endTime);
	}

	public String getSendTime() {
		return sendTime;
	}

	@JSONField(deserialize = false, serialize = false)
	public Date getFormatSendTime() {
		return DateUtil.parse2yyyyMMddHHmmss(sendTime);
	}

	public String getUseTime() {
		return useTime;
	}

	@JSONField(deserialize = false, serialize = false)
	public Date getFormatUseTime() {
		return StringUtils.isNotBlank(useTime) ? DateUtil
				.parse2yyyyMMddHHmmss(useTime) : null;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public String getConsumerMchId() {
		return consumerMchId;
	}

	public String getConsumerMchName() {
		return consumerMchName;
	}

	public String getConsumerMchAppid() {
		return consumerMchAppid;
	}

	public String getSendSource() {
		return sendSource;
	}

	public int getIsPartialUse() {
		return isPartialUse;
	}

	@JSONField(deserialize = false, serialize = false)
	public boolean getFormatIsPartialUse() {
		return isPartialUse == 1;
	}

	@Override
	public String toString() {
		return "CouponDetail [couponStockId=" + couponStockId
				+ ", couponStockType=" + getFormatCouponStockType()
				+ ", couponId=" + couponId + ", couponValue="
				+ getFormatCouponValue() + ", couponMininum="
				+ getFormatCouponMininum() + ", couponName=" + couponName
				+ ", couponStatus=" + getCouponStatus() + ", couponType="
				+ getFormatCouponType() + ", couponDesc=" + couponDesc
				+ ", couponUseValue=" + getFormatCouponUseValue()
				+ ", couponRemainValue=" + getFormatCouponRemainValue()
				+ ", beginTime=" + getFormatBeginTime() + ", endTime="
				+ getFormatEndTime() + ", sendTime=" + getFormatSendTime()
				+ ", useTime=" + getFormatUseTime() + ", tradeNo=" + tradeNo
				+ ", consumerMchId=" + consumerMchId + ", consumerMchName="
				+ consumerMchName + ", consumerMchAppid=" + consumerMchAppid
				+ ", sendSource=" + sendSource + ", isPartialUse="
				+ getFormatIsPartialUse() + ", " + super.toString()
				+ "]";
	}
}
