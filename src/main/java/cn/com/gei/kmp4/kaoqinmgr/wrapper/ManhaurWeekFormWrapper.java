package cn.com.gei.kmp4.kaoqinmgr.wrapper;

import cn.com.gei.kmp4.kaoqinmgr.entity.ManhaurWeekForm;

/**
 * 周考勤封装类
 * 
 * @author dxz
 *
 */
public class ManhaurWeekFormWrapper extends ManhaurWeekForm {

	private static final long serialVersionUID = 5124331785262791580L;

	/*
	 * 员工姓名
	 */
	private String employeeName;

	/*
	 * 未分配工时
	 */
	private Double allocation;

	/*
	 * 工时分配明细
	 */
	private String allocationDetail;

	/*
	 * 部门名称
	 */
	private String deptName;

	/*
	 * 任职类型
	 */
	private String personType;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Double getAllocation() {
		if (allocation == null)
			return 0d;
		return allocation;
	}

	public void setAllocation(Double allocation) {
		this.allocation = allocation;
	}

	public String getAllocationDetail() {
		return allocationDetail;
	}

	public void setAllocationDetail(String allocationDetail) {
		this.allocationDetail = allocationDetail;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

}
