package cn.com.gei.kmp4.kaoqinmgr.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 周考勤登记信息
 * 
 * @author dxz
 *
 */
public class KaoqinWeekRegister implements Serializable {

	private static final long serialVersionUID = -892875526836044224L;

	private String unid;

	/**
	 * 创建人ID（KMP3员工ID）
	 */
	private String createPersonId;

	/**
	 * 创建人姓名
	 */
	private String registerName;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 开始时间
	 */
	private Date beginTime;

	/**
	 * 结束时间
	 */
	private Date endTime;

	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
	}

	public String getCreatePersonId() {
		return createPersonId;
	}

	public void setCreatePersonId(String createPersonId) {
		this.createPersonId = createPersonId;
	}

	public String getRegisterName() {
		return registerName;
	}

	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
