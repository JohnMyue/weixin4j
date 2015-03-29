package com.foxinmy.weixin4j.msg.event.menu;

import java.io.Serializable;

import com.foxinmy.weixin4j.type.EventType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 弹出地理位置选择器的事件推送
 * 
 * @className MenuLocationEventMessage
 * @author jy
 * @date 2014年9月30日
 * @since JDK 1.7
 * @see <a
 *      href="http://mp.weixin.qq.com/wiki/9/981d772286d10d153a3dc4286c1ee5b5.html#location_select.EF.BC.9A.E5.BC.B9.E5.87.BA.E5.9C.B0.E7.90.86.E4.BD.8D.E7.BD.AE.E9.80.89.E6.8B.A9.E5.99.A8.E7.9A.84.E4.BA.8B.E4.BB.B6.E6.8E.A8.E9.80.81">订阅号、服务号的弹出地理位置选择事件推送</a>
 * @see <a
 *      href="http://qydev.weixin.qq.com/wiki/index.php?title=%E6%8E%A5%E6%94%B6%E4%BA%8B%E4%BB%B6#.E5.BC.B9.E5.87.BA.E5.9C.B0.E7.90.86.E4.BD.8D.E7.BD.AE.E9.80.89.E6.8B.A9.E5.99.A8.E7.9A.84.E4.BA.8B.E4.BB.B6.E6.8E.A8.E9.80.81">企业号的弹出地理位置选择事件推送</a>
 */
public class MenuLocationEventMessage extends MenuEventMessage {

	private static final long serialVersionUID = 145223888272819563L;

	public MenuLocationEventMessage() {
		super(EventType.location_select);
	}

	/**
	 * 发送的位置消息
	 */
	@XStreamAlias("SendLocationInfo")
	private LocationInfo locationInfo;

	public LocationInfo getLocationInfo() {
		return locationInfo;
	}

	/**
	 * 地理位置信息
	 * @className LocationInfo
	 * @author jy
	 * @date 2015年3月29日
	 * @since JDK 1.7
	 * @see
	 */
	public static class LocationInfo implements Serializable {

		private static final long serialVersionUID = 4904181780216819965L;

		/**
		 * 地理位置维度
		 */
		@XStreamAlias("Location_X")
		private double x;
		/**
		 * 地理位置经度
		 */
		@XStreamAlias("Location_Y")
		private double y;
		/**
		 * 地图缩放大小
		 */
		@XStreamAlias("Scale")
		private double scale;
		/**
		 * 地理位置信息
		 */
		@XStreamAlias("Label")
		private String label;
		/**
		 * 朋友圈POI的名字，可能为空
		 */
		@XStreamAlias("Poiname")
		private String poiname;

		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}

		public double getScale() {
			return scale;
		}

		public String getLabel() {
			return label;
		}

		public String getPoiname() {
			return poiname;
		}

		@Override
		public String toString() {
			return "LocationInfo [x=" + x + ", y=" + y + ", scale=" + scale
					+ ", label=" + label + ", poiname=" + poiname + "]";
		}
	}

	@Override
	public String toString() {
		return "MenuLocationEventMessage [locationInfo=" + locationInfo + ", "
				+ super.toString() + "]";
	}
}
