package cn.com.gei.kmp4.kaoqinmgr.wrapper;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import cn.com.gei.kmp4.kaoqinmgr.utils.KaoQinConst;

/**
 * 外出单封装类
 * 
 * @author dxz
 *
 */
public class OutDailyWrapper implements Serializable {
	private static final long serialVersionUID = 9114376864218034538L;

	private String type = KaoQinConst.KAOQIN_EVECTION;

	/*
	 * 外出地点
	 */
	private String address;

	/*
	 * 开始时间
	 */
	private Date startTime;

	/*
	 * 结束时间
	 */
	private Date endTime;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
