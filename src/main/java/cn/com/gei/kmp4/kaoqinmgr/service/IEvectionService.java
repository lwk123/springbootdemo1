package cn.com.gei.kmp4.kaoqinmgr.service;

import java.util.List;

import cn.com.gei.kmp4.kaoqinmgr.wrapper.EvectionWrapper;

public interface IEvectionService {

	/**
	 * 获取员工指定时间内的所有出差工时单
	 * 
	 * @param empId
	 * @param searchStartTime
	 * @param searchEndTime
	 * @return
	 */
	public List<EvectionWrapper> findEvectionByUser(String empId, String searchStartTime, String searchEndTime);

}
