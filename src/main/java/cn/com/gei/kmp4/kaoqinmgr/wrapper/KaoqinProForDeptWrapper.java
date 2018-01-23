package cn.com.gei.kmp4.kaoqinmgr.wrapper;

import java.io.Serializable;

/**
 * 部门员工考勤方案
 * @author zhouJW
 *
 */
public class KaoqinProForDeptWrapper implements Serializable {

	private static final long serialVersionUID = -7515646436447611175L;
	
	/**
	 * 员工id
	 */
	private String userId;
	
	/**
	 * 员工姓名
	 */
	private String personName;
	
	/**
	 * 考勤方案id
	 */
	private String kaoqinProjectId;
	
	/**
	 * 本月考勤方案名
	 */
	private String nowName;
	
	/**
	 * 上月考勤方案名
	 */
	private String preName;
	
	/**
	 * 下月考勤方案名
	 */
	private String nextName;
	
	public KaoqinProForDeptWrapper() {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getKaoqinProjectId() {
		return kaoqinProjectId;
	}

	public void setKaoqinProjectId(String kaoqinProjectId) {
		this.kaoqinProjectId = kaoqinProjectId;
	}

	public String getNowName() {
		return nowName;
	}

	public void setNowName(String nowName) {
		this.nowName = nowName;
	}

	public String getPreName() {
		return preName;
	}

	public void setPreName(String preName) {
		this.preName = preName;
	}

	public String getNextName() {
		return nextName;
	}

	public void setNextName(String nextName) {
		this.nextName = nextName;
	}

}
