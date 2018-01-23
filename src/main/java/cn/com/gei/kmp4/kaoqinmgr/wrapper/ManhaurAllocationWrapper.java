package cn.com.gei.kmp4.kaoqinmgr.wrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目工时分配明细
 * 
 * @author dxz
 *
 */
public class ManhaurAllocationWrapper {

	/**
	 * 项目ID
	 */
	private String affairId;

	/**
	 * 工时
	 */
	private Double manhaur;

	/**
	 * 子项目工时分配
	 */
	private List<ManhaurAllocationWrapper> subProjectManhaur;

	public ManhaurAllocationWrapper(String affairId, Double manhaur) {
		super();
		this.affairId = affairId;
		this.manhaur = manhaur;
	}

	public String getAffairId() {
		return affairId;
	}

	public void setAffairId(String affairId) {
		this.affairId = affairId;
	}

	public Double getManhaur() {
		return manhaur;
	}

	public void setManhaur(Double manhaur) {
		this.manhaur = manhaur;
	}

	public List<ManhaurAllocationWrapper> getSubProjectManhaur() {
		if (subProjectManhaur == null)
			return new ArrayList<ManhaurAllocationWrapper>();
		return subProjectManhaur;
	}

	public void setSubProjectManhaur(List<ManhaurAllocationWrapper> subProjectManhaur) {
		this.subProjectManhaur = subProjectManhaur;
	}

}
