package cn.com.gei.kmp4.kaoqinmgr.dao;

import java.util.List;

import cn.com.gei.kmp4.kaoqinmgr.entity.KaoqinProject;

public interface IKaoqinProjectDao {

	/**
	 * 获取所有考勤方案
	 * @param unid
	 * @return
	 */
	public List<KaoqinProject> findAllPro();
}
