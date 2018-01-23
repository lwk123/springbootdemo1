package cn.com.gei.kmp4.kaoqinmgr.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 子项目工时（KA_SubprojectManhaur）
 * 
 * @author dxz
 *
 */
public class SubprojectManhaur implements Serializable {

	private static final long serialVersionUID = -1915928976443899613L;

	private String unid;

	/**
	 * 上级工时ID
	 */
	private String parentManhaurId;

	/**
	 * 子项目ID
	 */
	private String subprojectId;

	/**
	 * 项目ID
	 */
	private String affairId;

	/**
	 * 开始时间
	 */
	private Date beginDate;

	/**
	 * 结束时间
	 */
	private Date endDate;

	/**
	 * 员工ID
	 */
	private String personId;

	/**
	 * 备注
	 */
	private String summary;

	/**
	 * 工时
	 */
	private Double timeConsume;

	/**
	 * 实际工时
	 */
	private Double originalTimeConsume;

	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
	}

	public String getParentManhaurId() {
		return parentManhaurId;
	}

	public void setParentManhaurId(String parentManhaurId) {
		this.parentManhaurId = parentManhaurId;
	}

	public String getSubprojectId() {
		return subprojectId;
	}

	public void setSubprojectId(String subprojectId) {
		this.subprojectId = subprojectId;
	}

	public String getAffairId() {
		return affairId;
	}

	public void setAffairId(String affairId) {
		this.affairId = affairId;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Double getTimeConsume() {
		if (timeConsume == null)
			return 0d;
		return timeConsume;
	}

	public void setTimeConsume(Double timeConsume) {
		this.timeConsume = timeConsume;
	}

	public Double getOriginalTimeConsume() {
		return originalTimeConsume;
	}

	public void setOriginalTimeConsume(Double originalTimeConsume) {
		this.originalTimeConsume = originalTimeConsume;
	}

}
