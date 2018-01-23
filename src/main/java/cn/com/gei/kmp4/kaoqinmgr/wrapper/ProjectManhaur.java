package cn.com.gei.kmp4.kaoqinmgr.wrapper;

import java.io.Serializable;

import cn.com.gei.kmp4.kaoqinmgr.utils.NumberUtils;

/**
 * 项目分配工时
 * 
 * @author dxz
 *
 */
public class ProjectManhaur implements Serializable {

	private static final long serialVersionUID = -5016554553928875760L;

	/*
	 * 项目ID
	 */
	private String affairId;

	/*
	 * 项目名称
	 */
	private String affairName;

	/*
	 * 年
	 */
	private String year;

	/*
	 * 月
	 */
	private String month;

	/*
	 * 员工ID
	 */
	private String personId;

	/*
	 * 实际分配工时
	 */
	private double originalTimeConsume;

	public String getAffairId() {
		return affairId;
	}

	public void setAffairId(String affairId) {
		this.affairId = affairId;
	}

	public String getAffairName() {
		return affairName;
	}

	public void setAffairName(String affairName) {
		this.affairName = affairName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public double getOriginalTimeConsume() {
		return NumberUtils.formatDouble(originalTimeConsume);
	}

	public void setOriginalTimeConsume(double originalTimeConsume) {
		this.originalTimeConsume = originalTimeConsume;
	}

}
