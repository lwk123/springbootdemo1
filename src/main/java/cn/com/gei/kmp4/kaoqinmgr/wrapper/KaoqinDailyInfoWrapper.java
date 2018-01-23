package cn.com.gei.kmp4.kaoqinmgr.wrapper;

import org.apache.commons.lang.StringUtils;

import cn.com.gei.kmp4.kaoqinmgr.entity.KaoqinDailyInfo;

/**
 * 日考勤记录封装类
 * 
 * @author dxz
 *
 */
public class KaoqinDailyInfoWrapper extends KaoqinDailyInfo {

	private static final long serialVersionUID = -4660483392880977115L;

	/**
	 * 员工姓名
	 */
	private String employeeName;

	private String kaoqinStatus;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getKaoqinStatus() {
		if (StringUtils.isBlank(kaoqinStatus)) {
			return "";
		}
		String[] statusArray = kaoqinStatus.split(",");
		StringBuilder str = new StringBuilder();
		for (String status : statusArray) {
			if("Evection".equals(status)){
				str.append("出差").append(",");
			}else if("AwardLeave".equals(status)){
				str.append("倒休").append(",");
			}else if("SalaryLeave".equals(status)){
				str.append("带薪假").append(",");
			}else if("Outer".equals(status)){
				str.append("外出").append(",");
			}else if("Leave".equals(status)){
				str.append("请假").append(",");
			}
		}
		if (str.length() > 0) {
			str.deleteCharAt(str.length() - 1);
		}
		return str.toString();
	}

	public void setKaoqinStatus(String kaoqinStatus) {
		this.kaoqinStatus = kaoqinStatus;
	}

}
