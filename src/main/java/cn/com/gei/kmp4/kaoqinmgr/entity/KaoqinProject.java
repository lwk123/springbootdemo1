package cn.com.gei.kmp4.kaoqinmgr.entity;

import java.io.Serializable;

/**
 * 考勤方案(geikmp3_kaoqinpriject)
 * @author zhouJW
 *
 */
public class KaoqinProject implements Serializable {

	private static final long serialVersionUID = 2996617906862572705L;

	protected String unid;
	
	/**
	 * 考勤方案名
	 */
	protected String name;
	
	/**
	 * 上班时间
	 */
	protected String onDuty;
	
	/**
	 * 下班时间
	 */
	protected String offDuty;
	
	/**
	 * 中午下班时间
	 */
	protected String noonBeginTime;
	
	/**
	 * 中午上班时间
	 */
	protected String noonEndTime;
	
	/**
	 * 加班开始时间
	 */
	protected String extraTimeBegin;
	
	public KaoqinProject() {
		
	}

	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOnDuty() {
		return onDuty;
	}

	public void setOnDuty(String onDuty) {
		this.onDuty = onDuty;
	}

	public String getOffDuty() {
		return offDuty;
	}

	public void setOffDuty(String offDuty) {
		this.offDuty = offDuty;
	}

	public String getNoonBeginTime() {
		return noonBeginTime;
	}

	public void setNoonBeginTime(String noonBeginTime) {
		this.noonBeginTime = noonBeginTime;
	}

	public String getNoonEndTime() {
		return noonEndTime;
	}

	public void setNoonEndTime(String noonEndTime) {
		this.noonEndTime = noonEndTime;
	}

	public String getExtraTimeBegin() {
		return extraTimeBegin;
	}

	public void setExtraTimeBegin(String extraTimeBegin) {
		this.extraTimeBegin = extraTimeBegin;
	}

}
