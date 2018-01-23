package cn.com.gei.kmp4.kaoqinmgr.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 日考勤信息（GEIKMP3_KaoqinDailyInfo）
 * 
 * @author dxz
 *
 */
public class KaoqinDailyInfo implements Serializable {

	private static final long serialVersionUID = 2873612420044052857L;

	/**
	 * id
	 */
	protected String unid;

	/**
	 * 统计时间
	 */
	protected Date statDate;

	/**
	 * 员工ID（KMP3员工ID）
	 */
	protected String employeeId;

	/**
	 * 员工类型（专职/兼职）
	 */
	protected String employeeType;

	/**
	 * 工时
	 */
	protected Double workTime;

	/**
	 * 请假工时
	 */
	protected Double leaveTime;

	/**
	 * 倒休工时
	 */
	protected Double awardTime;

	/**
	 * 加班工时
	 */
	protected Double extraTime;

	/**
	 * 旷工工时
	 */
	protected Double absentTime;

	/**
	 * 其他假工时
	 */
	protected Double otherLeaveTime;

	/**
	 * 事假
	 */
	protected Double affairLeaveTime;

	/**
	 * 病假
	 */
	protected Double sickLeaveTime;

	/**
	 * 婚假
	 */
	protected Double marryLeaveTime;

	/**
	 * 产假
	 */
	protected Double birthLeaveTime;

	/**
	 * 丧假
	 */
	protected Double deadLeaveTime;

	/**
	 * 是否迟到
	 */
	protected String isLate;

	/**
	 * 是否早退
	 */
	protected String isLeaveEarly;

	/**
	 * 是否忽略
	 */
	protected String isIgnore;

	/**
	 * 有薪假
	 */
	protected Double salaryLeave;

	/**
	 * 状态
	 */
	protected String status;

	/**
	 * 开始时间
	 */
	protected Date beginTime;

	/**
	 * 结束时间
	 */
	protected Date endTime;

	/**
	 * 部门ID（KMP3部门ID）
	 */
	protected String departmentId;

	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
	}

	public Date getStatDate() {
		return statDate;
	}

	public void setStatDate(Date statDate) {
		this.statDate = statDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public Double getWorkTime() {
		if (workTime == null)
			return 0d;
		return workTime;
	}

	public void setWorkTime(Double workTime) {
		this.workTime = workTime;
	}

	public Double getLeaveTime() {
		if (leaveTime == null)
			return 0d;
		return leaveTime;
	}

	public void setLeaveTime(Double leaveTime) {
		this.leaveTime = leaveTime;
	}

	public Double getAwardTime() {
		if (awardTime == null)
			return 0d;
		return awardTime;
	}

	public void setAwardTime(Double awardTime) {
		this.awardTime = awardTime;
	}

	public Double getExtraTime() {
		if (extraTime == null)
			return 0d;
		return extraTime;
	}

	public void setExtraTime(Double extraTime) {
		this.extraTime = extraTime;
	}

	public Double getAbsentTime() {
		if (absentTime == null)
			return 0d;
		return absentTime;
	}

	public void setAbsentTime(Double absentTime) {
		this.absentTime = absentTime;
	}

	public Double getOtherLeaveTime() {
		if (otherLeaveTime == null)
			return 0d;
		return otherLeaveTime;
	}

	public void setOtherLeaveTime(Double otherLeaveTime) {
		this.otherLeaveTime = otherLeaveTime;
	}

	public Double getAffairLeaveTime() {
		if (affairLeaveTime == null)
			return 0d;
		return affairLeaveTime;
	}

	public void setAffairLeaveTime(Double affairLeaveTime) {
		this.affairLeaveTime = affairLeaveTime;
	}

	public Double getSickLeaveTime() {
		if (sickLeaveTime == null)
			return 0d;
		return sickLeaveTime;
	}

	public void setSickLeaveTime(Double sickLeaveTime) {
		this.sickLeaveTime = sickLeaveTime;
	}

	public Double getMarryLeaveTime() {
		if (marryLeaveTime == null)
			return 0d;
		return marryLeaveTime;
	}

	public void setMarryLeaveTime(Double marryLeaveTime) {
		this.marryLeaveTime = marryLeaveTime;
	}

	public Double getBirthLeaveTime() {
		if (birthLeaveTime == null)
			return 0d;
		return birthLeaveTime;
	}

	public void setBirthLeaveTime(Double birthLeaveTime) {
		this.birthLeaveTime = birthLeaveTime;
	}

	public Double getDeadLeaveTime() {
		if (deadLeaveTime == null)
			return 0d;
		return deadLeaveTime;
	}

	public void setDeadLeaveTime(Double deadLeaveTime) {
		this.deadLeaveTime = deadLeaveTime;
	}

	public String getIsLate() {
		return isLate;
	}

	public void setIsLate(String isLate) {
		this.isLate = isLate;
	}

	public String getIsLeaveEarly() {
		return isLeaveEarly;
	}

	public void setIsLeaveEarly(String isLeaveEarly) {
		this.isLeaveEarly = isLeaveEarly;
	}

	public String getIsIgnore() {
		return isIgnore;
	}

	public void setIsIgnore(String isIgnore) {
		this.isIgnore = isIgnore;
	}

	public Double getSalaryLeave() {
		if (salaryLeave == null)
			return 0d;
		return salaryLeave;
	}

	public void setSalaryLeave(Double salaryLeave) {
		this.salaryLeave = salaryLeave;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

}
