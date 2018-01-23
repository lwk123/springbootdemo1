package cn.com.gei.kmp4.kaoqinmgr.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 日考勤详细信息（GEIKMP3_KaoqinDailyDetail）
 * 
 * @author dxz
 *
 */
public class KaoqinDailyDetail implements Serializable {

	private static final long serialVersionUID = 2021720584245241663L;

	protected String unid;

	/**
	 * 所属日考勤ID
	 */
	protected String kaoqinDaily;

	/**
	 * 员工ID（KMP3员工ID）
	 */
	protected String employeeId;

	/**
	 * 统计时间
	 */
	protected Date statDate;

	/**
	 * 开始时间
	 */
	protected Date beginTime;

	/**
	 * 结束时间
	 */
	protected Date endTime;

	/**
	 * 检查人
	 */
	protected String checkPerson;

	/**
	 * 检查日期
	 */
	protected Date checkDate;

	/**
	 * 缺勤工时
	 */
	protected Double absentManhaur;

	/**
	 * 是否检查
	 */
	protected String isCheck;

	/**
	 * 出差项目名称
	 */
	protected String evectionProjectName;

	/**
	 * 工作内容
	 */
	protected String workContent;

	/**
	 * 出差地点
	 */
	protected String evectionAddress;

	/**
	 * 状态
	 */
	protected String status;

	/**
	 * 出差单ID
	 */
	protected String evectionRecordId;

	/**
	 * 出勤/休假
	 */
	protected String onOrOffDuty;

	/**
	 * 上班时间
	 */
	protected Date onDutyDate;

	/**
	 * 下班时间
	 */
	protected Date offDutyDate;

	/**
	 * 是否忽略
	 */
	protected String isIngore;

	/**
	 * 忽略工时
	 */
	protected Double ingoreManhaur;

	/**
	 * 休假类型
	 */
	protected String leaveType;

	/**
	 * 休假工时
	 */
	protected Double leaveManhaur;

	/**
	 * 有薪假
	 */
	protected Double leaveSalaryTime;

	/**
	 * 申请人ID
	 */
	protected String applicantId;

	/**
	 * 外出项目名称
	 */
	protected String outerProjectName;

	/**
	 * 外出工时
	 */
	protected Double outerManhaur;

	/**
	 * 类型
	 */
	protected String type;

	/**
	 * 远程打卡IP
	 */
	protected String regIp;

	/**
	 * 所属长假期请求
	 */
	protected String belongedLongLeaveRequest;

	/**
	 * 中午打卡开始时间
	 */
	protected Date midBeginTime;

	/**
	 * 中午打卡结束时间
	 */
	protected Date midEndTime;

	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
	}

	public String getKaoqinDaily() {
		return kaoqinDaily;
	}

	public void setKaoqinDaily(String kaoqinDaily) {
		this.kaoqinDaily = kaoqinDaily;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Date getStatDate() {
		return statDate;
	}

	public void setStatDate(Date statDate) {
		this.statDate = statDate;
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

	public String getCheckPerson() {
		return checkPerson;
	}

	public void setCheckPerson(String checkPerson) {
		this.checkPerson = checkPerson;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Double getAbsentManhaur() {
		if (absentManhaur == null)
			return 0d;
		return absentManhaur;
	}

	public void setAbsentManhaur(Double absentManhaur) {
		this.absentManhaur = absentManhaur;
	}

	public String getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	public String getEvectionProjectName() {
		return evectionProjectName;
	}

	public void setEvectionProjectName(String evectionProjectName) {
		this.evectionProjectName = evectionProjectName;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public String getEvectionAddress() {
		return evectionAddress;
	}

	public void setEvectionAddress(String evectionAddress) {
		this.evectionAddress = evectionAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEvectionRecordId() {
		return evectionRecordId;
	}

	public void setEvectionRecordId(String evectionRecordId) {
		this.evectionRecordId = evectionRecordId;
	}

	public String getOnOrOffDuty() {
		return onOrOffDuty;
	}

	public void setOnOrOffDuty(String onOrOffDuty) {
		this.onOrOffDuty = onOrOffDuty;
	}

	public Date getOnDutyDate() {
		return onDutyDate;
	}

	public void setOnDutyDate(Date onDutyDate) {
		this.onDutyDate = onDutyDate;
	}

	public Date getOffDutyDate() {
		return offDutyDate;
	}

	public void setOffDutyDate(Date offDutyDate) {
		this.offDutyDate = offDutyDate;
	}

	public String getIsIngore() {
		return isIngore;
	}

	public void setIsIngore(String isIngore) {
		this.isIngore = isIngore;
	}

	public Double getIngoreManhaur() {
		if (ingoreManhaur == null)
			return 0d;
		return ingoreManhaur;
	}

	public void setIngoreManhaur(Double ingoreManhaur) {
		this.ingoreManhaur = ingoreManhaur;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public Double getLeaveManhaur() {
		if (leaveManhaur == null)
			return 0d;
		return leaveManhaur;
	}

	public void setLeaveManhaur(Double leaveManhaur) {
		this.leaveManhaur = leaveManhaur;
	}

	public Double getLeaveSalaryTime() {
		if (leaveSalaryTime == null)
			return 0d;
		return leaveSalaryTime;
	}

	public void setLeaveSalaryTime(Double leaveSalaryTime) {
		this.leaveSalaryTime = leaveSalaryTime;
	}

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public String getOuterProjectName() {
		return outerProjectName;
	}

	public void setOuterProjectName(String outerProjectName) {
		this.outerProjectName = outerProjectName;
	}

	public Double getOuterManhaur() {
		if (outerManhaur == null)
			return 0d;
		return outerManhaur;
	}

	public void setOuterManhaur(Double outerManhaur) {
		this.outerManhaur = outerManhaur;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegIp() {
		return regIp;
	}

	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}

	public String getBelongedLongLeaveRequest() {
		return belongedLongLeaveRequest;
	}

	public void setBelongedLongLeaveRequest(String belongedLongLeaveRequest) {
		this.belongedLongLeaveRequest = belongedLongLeaveRequest;
	}

	public Date getMidBeginTime() {
		return midBeginTime;
	}

	public void setMidBeginTime(Date midBeginTime) {
		this.midBeginTime = midBeginTime;
	}

	public Date getMidEndTime() {
		return midEndTime;
	}

	public void setMidEndTime(Date midEndTime) {
		this.midEndTime = midEndTime;
	}

}
