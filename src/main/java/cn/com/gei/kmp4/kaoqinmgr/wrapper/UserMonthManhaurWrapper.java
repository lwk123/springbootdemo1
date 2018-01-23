package cn.com.gei.kmp4.kaoqinmgr.wrapper;

import java.io.Serializable;

/**
 * 员工月考勤天数
 * 
 * @author dxz
 *
 */
public class UserMonthManhaurWrapper implements Serializable {

	private static final long serialVersionUID = -687841950856092441L;

	/*
	 * 部门ID
	 */
	private String deptId;

	/*
	 * 员工ID
	 */
	private String personId;

	/*
	 * 员工名称
	 */
	private String personName;

	/*
	 * 标准出勤天数
	 */
	private Double standardWorkTime;

	/*
	 * 实际出勤天数
	 */
	private Double manhaurWorkDay;

	/*
	 * 旷工工时
	 */
	private Double leaveTime;

	/*
	 * 出勤工时
	 */
	private Double manhaurWorkTime;

	/*
	 * 已分配工时
	 */
	private Double allocation;
	
	/**
	 * 倒休工时
	 */
	private Double daoXiu;
	
	/**
	 * 带薪假
	 */
	private Double salaryLeave;

	public Double getDaoXiu() {
		return daoXiu;
	}

	public void setDaoXiu(Double daoXiu) {
		this.daoXiu = daoXiu;
	}

	public Double getSalaryLeave() {
		return salaryLeave;
	}

	public void setSalaryLeave(Double salaryLeave) {
		this.salaryLeave = salaryLeave;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Double getStandardWorkTime() {
		return standardWorkTime;
	}

	public void setStandardWorkTime(Double standardWorkTime) {
		this.standardWorkTime = standardWorkTime;
	}

	public Double getManhaurWorkDay() {
		return manhaurWorkDay;
	}

	public void setManhaurWorkDay(Double manhaurWorkDay) {
		this.manhaurWorkDay = manhaurWorkDay;
	}

	public Double getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Double leaveTime) {
		this.leaveTime = leaveTime;
	}

	public Double getAllocation() {
		return allocation;
	}

	public void setAllocation(Double allocation) {
		this.allocation = allocation;
	}

	public Double getManhaurWorkTime() {
		return manhaurWorkTime;
	}

	public void setManhaurWorkTime(Double manhaurWorkTime) {
		this.manhaurWorkTime = manhaurWorkTime;
	}

}
