package cn.com.gei.kmp4.kaoqinmgr.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 周考勤工时单（GEIKMP3_ManhaurForm）
 * 
 * @author dxz
 *
 */
public class ManhaurWeekForm implements Serializable {

	private static final long serialVersionUID = -7144523523522934057L;

	protected String unid;

	/**
	 * 员工ID（KMP3员工ID）
	 */
	protected String employeeId;

	/**
	 * 工时单名称
	 */
	protected String week;

	/**
	 * 所属年份
	 */
	protected int manhaurYear;

	/**
	 * 状态
	 */
	protected String status;

	/**
	 * 所属月份
	 */
	protected int manhaurMonth;

	/**
	 * 出勤工时（天）
	 */
	protected Double manhaurWorkTime;

	/**
	 * 出勤天数
	 */
	protected int manhaurWorkDay;

	/**
	 * 倒休工时（天）
	 */
	protected Double daoXiu;

	/**
	 * 迟到次数
	 */
	protected Double manhaurLateTime;

	/**
	 * 其他假工时
	 */
	protected Double otherHoliday;
	/**
	 * 加班工时
	 */
	protected Double manhaurExtraTime;

	/**
	 * 病假工时
	 */
	protected Double manhaurSickLeaveTime;

	/**
	 * 事假工时
	 */
	protected Double manhaurAffairLeaveTime;

	/**
	 * 说明
	 */
	protected String summary;

	/**
	 * 考勤开始日期
	 */
	protected Date beginDate;

	/**
	 * 考勤结束日期
	 */
	protected Date endDate;

	/**
	 * 旷工天数
	 */
	protected Double leaveTime;

	/**
	 * 有薪假天数
	 */
	protected Double leaveTimeWithSalary;

	/**
	 * 标准出勤天数
	 */
	protected Double standardWorkTime;

	/**
	 * 该周考勤记录所对应的创建信息表ID
	 */
	protected String weekRegisterId;

	/**
	 * 婚假工时
	 */
	protected Double manhaurMarryLeaveTime;

	/**
	 * 产假工时
	 */
	protected Double manhaurBirthLeaveTime;

	/**
	 * 丧假工时
	 */
	protected Double manhaurDeadLeaveTime;

	/**
	 * 创建时间
	 */
	protected Date createDate;

	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public int getManhaurYear() {
		return manhaurYear;
	}

	public void setManhaurYear(int manhaurYear) {
		this.manhaurYear = manhaurYear;
	}

	@JsonIgnore
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getManhaurMonth() {
		return manhaurMonth;
	}

	public void setManhaurMonth(int manhaurMonth) {
		this.manhaurMonth = manhaurMonth;
	}

	public Double getManhaurWorkTime() {
		if (manhaurWorkTime == null)
			return 0d;
		return manhaurWorkTime;
	}

	public void setManhaurWorkTime(Double manhaurWorkTime) {
		this.manhaurWorkTime = manhaurWorkTime;
	}

	public int getManhaurWorkDay() {
		return manhaurWorkDay;
	}

	public void setManhaurWorkDay(int manhaurWorkDay) {
		this.manhaurWorkDay = manhaurWorkDay;
	}

	public Double getDaoXiu() {
		if (daoXiu == null)
			return 0d;
		return daoXiu;
	}

	public void setDaoXiu(Double daoXiu) {
		this.daoXiu = daoXiu;
	}

	public Double getManhaurLateTime() {
		if (manhaurLateTime == null)
			return 0d;
		return manhaurLateTime;
	}

	public void setManhaurLateTime(Double manhaurLateTime) {
		this.manhaurLateTime = manhaurLateTime;
	}

	public Double getOtherHoliday() {
		if (otherHoliday == null)
			return 0d;
		return otherHoliday;
	}

	public void setOtherHoliday(Double otherHoliday) {
		this.otherHoliday = otherHoliday;
	}

	public Double getManhaurExtraTime() {
		if (manhaurExtraTime == null)
			return 0d;
		return manhaurExtraTime;
	}

	public void setManhaurExtraTime(Double manhaurExtraTime) {
		this.manhaurExtraTime = manhaurExtraTime;
	}

	public Double getManhaurSickLeaveTime() {
		if (manhaurSickLeaveTime == null)
			return 0d;
		return manhaurSickLeaveTime;
	}

	public void setManhaurSickLeaveTime(Double manhaurSickLeaveTime) {
		this.manhaurSickLeaveTime = manhaurSickLeaveTime;
	}

	public Double getManhaurAffairLeaveTime() {
		if (manhaurAffairLeaveTime == null)
			return 0d;
		return manhaurAffairLeaveTime;
	}

	public void setManhaurAffairLeaveTime(Double manhaurAffairLeaveTime) {
		this.manhaurAffairLeaveTime = manhaurAffairLeaveTime;
	}

	@JsonIgnore
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getLeaveTime() {
		if (leaveTime == null)
			return 0d;
		return leaveTime;
	}

	public void setLeaveTime(Double leaveTime) {
		this.leaveTime = leaveTime;
	}

	public Double getLeaveTimeWithSalary() {
		if (leaveTimeWithSalary == null)
			return 0d;
		return leaveTimeWithSalary;
	}

	public void setLeaveTimeWithSalary(Double leaveTimeWithSalary) {
		this.leaveTimeWithSalary = leaveTimeWithSalary;
	}

	public Double getStandardWorkTime() {
		if (standardWorkTime == null)
			return 0d;
		return standardWorkTime;
	}

	public void setStandardWorkTime(Double standardWorkTime) {
		this.standardWorkTime = standardWorkTime;
	}

	public String getWeekRegisterId() {
		return weekRegisterId;
	}

	public void setWeekRegisterId(String weekRegisterId) {
		this.weekRegisterId = weekRegisterId;
	}

	public Double getManhaurMarryLeaveTime() {
		if (manhaurMarryLeaveTime == null)
			return 0d;
		return manhaurMarryLeaveTime;
	}

	public void setManhaurMarryLeaveTime(Double manhaurMarryLeaveTime) {
		this.manhaurMarryLeaveTime = manhaurMarryLeaveTime;
	}

	public Double getManhaurBirthLeaveTime() {
		if (manhaurBirthLeaveTime == null)
			return 0d;
		return manhaurBirthLeaveTime;
	}

	public void setManhaurBirthLeaveTime(Double manhaurBirthLeaveTime) {
		this.manhaurBirthLeaveTime = manhaurBirthLeaveTime;
	}

	public Double getManhaurDeadLeaveTime() {
		if (manhaurDeadLeaveTime == null)
			return 0d;
		return manhaurDeadLeaveTime;
	}

	public void setManhaurDeadLeaveTime(Double manhaurDeadLeaveTime) {
		this.manhaurDeadLeaveTime = manhaurDeadLeaveTime;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
