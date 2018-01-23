package cn.com.gei.kmp4.kaoqinmgr.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 工时分配（KA_Manhaur）
 * 
 * @author dxz
 *
 */
public class Manhaur implements Serializable {
	private static final long serialVersionUID = 2881104832781205097L;

	private String unid;

	/**
	 * 项目ID
	 */
	private String affairId;

	/**
	 * 开始日期
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
	 * 总结
	 */
	private String summary;

	/**
	 * 所用工时
	 */
	private Double timeConsume;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 当量工时
	 */
	private Double equivManhaur;

	/**
	 * 当量工时系数
	 */
	private Double equivManhaurXishu;

	/**
	 * 实际项目工时
	 */
	private Double originalTimeConsume;

	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getEquivManhaur() {
		if (equivManhaur == null)
			return 0d;
		return equivManhaur;
	}

	public void setEquivManhaur(Double equivManhaur) {
		this.equivManhaur = equivManhaur;
	}

	public Double getEquivManhaurXishu() {
		if (equivManhaurXishu == null)
			return 0d;
		return equivManhaurXishu;
	}

	public void setEquivManhaurXishu(Double equivManhaurXishu) {
		this.equivManhaurXishu = equivManhaurXishu;
	}

	public Double getOriginalTimeConsume() {
		if (originalTimeConsume == null)
			return 0d;
		return originalTimeConsume;
	}

	public void setOriginalTimeConsume(Double originalTimeConsume) {
		this.originalTimeConsume = originalTimeConsume;
	}

}
