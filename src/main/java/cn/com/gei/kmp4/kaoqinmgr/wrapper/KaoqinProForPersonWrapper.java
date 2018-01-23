package cn.com.gei.kmp4.kaoqinmgr.wrapper;

import java.io.Serializable;

/**
 * 个人考勤方案封装类
 * @author zhouJW
 *
 */
public class KaoqinProForPersonWrapper implements Serializable {

	private static final long serialVersionUID = 536429841473808929L;

	/**
	 * 考勤方案id
	 */
	private String kaoqinProjectId;
	
	/**
	 * 考勤方案名
	 */
	private String name;
	
	/**
	 * 员工考勤方案生效年
	 */
	private Integer year;
	
	/**
	 * 员工考勤方案生效月
	 */
	private Integer month;
	
	public KaoqinProForPersonWrapper() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getKaoqinProjectId() {
		return kaoqinProjectId;
	}

	public void setKaoqinProjectId(String kaoqinProjectId) {
		this.kaoqinProjectId = kaoqinProjectId;
	}
}
