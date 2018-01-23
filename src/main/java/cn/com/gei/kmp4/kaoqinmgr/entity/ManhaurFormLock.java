package cn.com.gei.kmp4.kaoqinmgr.entity;

import java.io.Serializable;

/**
 * 锁定工时记录
 * 
 * @author dxz
 *
 */
public class ManhaurFormLock implements Serializable {

	private static final long serialVersionUID = 8418851060754460233L;

	private String unid;

	/**
	 * 年
	 */
	private int manhaurYear;

	/**
	 * 月
	 */
	private int manhaurMonth;

	/**
	 * 是否锁定
	 */
	private String flag;

	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
	}

	public int getManhaurYear() {
		return manhaurYear;
	}

	public void setManhaurYear(int manhaurYear) {
		this.manhaurYear = manhaurYear;
	}

	public int getManhaurMonth() {
		return manhaurMonth;
	}

	public void setManhaurMonth(int manhaurMonth) {
		this.manhaurMonth = manhaurMonth;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
