package cn.com.gei.kmp4.kaoqinmgr.wrapper;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import cn.com.gei.kmp4.kaoqinmgr.utils.KaoQinConst;

/**
 * 出差工时单封装类
 * 
 * @author dxz
 */
public class EvectionWrapper implements Serializable {

	private static final long serialVersionUID = -5657403407188999363L;

	private String type = KaoQinConst.KAOQIN_EVECTION;

	/*
	 * 出差申请单ID（geikmp3_evectionapplicant）
	 */
	private String applicantId;

	/*
	 * 出差单名称
	 */
	private String title;

	/*
	 * 出差地点
	 */
	private String address;

	/*
	 * 出差开始时间
	 */
	private Date startTime;

	/*
	 * 出差结束时间
	 */
	private Date endTime;

	/*
	 * 审批结果
	 */
	private String result;

	/*
	 * 序号
	 */
	private int countIndex;

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

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCountIndex() {
		return countIndex;
	}

	public void setCountIndex(int countIndex) {
		this.countIndex = countIndex;
	}

}
