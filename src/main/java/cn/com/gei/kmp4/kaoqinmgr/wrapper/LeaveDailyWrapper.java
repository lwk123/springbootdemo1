package cn.com.gei.kmp4.kaoqinmgr.wrapper;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import cn.com.gei.kmp4.kaoqinmgr.utils.KaoQinConst;

public class LeaveDailyWrapper implements Serializable {

	private static final long serialVersionUID = 2989089338892330325L;

	private String id;

	private String type = KaoQinConst.KAOQIN_LEAVE;

	private String reasonType;

	private Date startTime;

	private Date endTime;

	private String result;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReasonType() {
		return reasonType;
	}

	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
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
