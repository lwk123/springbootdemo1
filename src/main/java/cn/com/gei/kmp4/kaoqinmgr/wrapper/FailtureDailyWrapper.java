package cn.com.gei.kmp4.kaoqinmgr.wrapper;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import cn.com.gei.kmp4.kaoqinmgr.utils.KaoQinConst;

/**
 * 漏打卡封装类
 * 
 * @author dxz
 *
 */
public class FailtureDailyWrapper implements Serializable {

	private static final long serialVersionUID = 7011257459882825050L;

	/*
	 * 考勤类型
	 */
	private String type = KaoQinConst.KAOQIN_FAILTURE;

	/*
	 * 漏打卡类型
	 */
	private String ldkType;

	/*
	 * 漏打卡时间
	 */
	private Date ldkTime;

	/*
	 * 审批结果
	 */
	private String result;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLdkType() {
		return ldkType;
	}

	public void setLdkType(String ldkType) {
		this.ldkType = ldkType;
	}

	public Date getLdkTime() {
		return ldkTime;
	}

	public void setLdkTime(Date ldkTime) {
		this.ldkTime = ldkTime;
	}

	public String getResult() {
		if (StringUtils.isNotBlank(result)) {
			if ("DRAFT".equals(result)) {
				return "起草";
			}
			if ("RUNNING".equals(result)) {
				return "审批中";
			}
		}
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
