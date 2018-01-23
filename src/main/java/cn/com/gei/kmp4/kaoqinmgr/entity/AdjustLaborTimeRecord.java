package cn.com.gei.kmp4.kaoqinmgr.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工考勤方案(geikmp3_adjustlabortimerecord)
 * @author zhouJW
 *
 */
public class AdjustLaborTimeRecord implements Serializable {

	private static final long serialVersionUID = 5713434354028947028L;

	protected String unid;
	
	/**
	 * 员工id
	 */
	protected String userId;
	
	/**
	 * 考勤方案id
	 */
	protected String kaoqinProjectId;
	
	/**
	 * 是否有效
	 */
	protected String enable;
	
	/**
	 * 创建时间
	 */
	protected Date createdTime;
	
	/**
	 * 有效年
	 */
	protected Integer year;
	
	/**
	 * 有效月
	 */
	protected Integer month;
	
	public AdjustLaborTimeRecord() {
		
	}

	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getKaoqinProjectId() {
		return kaoqinProjectId;
	}

	public void setKaoqinProjectId(String kaoqinProjectId) {
		this.kaoqinProjectId = kaoqinProjectId;
	}

	public String isEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}
}
