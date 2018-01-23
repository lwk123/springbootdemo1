package cn.com.gei.kmp4.kaoqinmgr.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NumberUtils {

	private static DecimalFormat df = new DecimalFormat("#.00");
	private final static SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final static SimpleDateFormat ymFormat = new SimpleDateFormat("yyyy-MM");
	private final static SimpleDateFormat hmFormat = new SimpleDateFormat("hh:mm");

	public static double formatDouble(Double v) {
		try {
			if (v == null)
				return 0;
			return Double.valueOf(df.format(v));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * yyyy-MM-dd
	 * 
	 * @param time
	 * @return
	 */
	public static String formateDate(Date time) {
		if (time == null)
			return "";

		return ymdFormat.format(time);
	}

	/**
	 * yyyy-MM
	 * 
	 * @param time
	 * @return
	 */
	public static String format(Date time) {
		if (time == null)
			return "";

		return ymFormat.format(time);
	}

	/**
	 * hh-mm
	 * 
	 * @param time
	 * @return
	 */
	public static String hmformat(Date time) {
		if (time == null)
			return "";

		return hmFormat.format(time);
	}

}
