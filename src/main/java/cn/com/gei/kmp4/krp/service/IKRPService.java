package cn.com.gei.kmp4.krp.service;

import java.util.List;

import cn.com.gei.kmp4.kaoqinmgr.wrapper.EvectionWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.FailtureDailyWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.LeaveDailyWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.OutDailyWrapper;

public interface IKRPService {

	/**
	 * 获取员工指定时间内的漏打卡单
	 * 
	 * @param empId
	 * @param searchStartTime
	 * @param searchEndTime
	 * @return
	 */
	public List<FailtureDailyWrapper> findFailtureByUser(String empId, String searchStartTime, String searchEndTime);

	/**
	 * 获取员工指定时间内的请假单
	 * 
	 * @param empId
	 * @param searchStartTime
	 * @param searchEndTime
	 * @return
	 */
	public List<LeaveDailyWrapper> findLeaveDailyByUser(String empId, String searchStartTime, String searchEndTime);

	/**
	 * 获取员工指定时间内的外出工时单
	 * 
	 * @param empId
	 * @param searchStartTime
	 * @param searchEndTime
	 * @return
	 */
	public List<OutDailyWrapper> findOutDailyByUser(String empId, String searchStartTime, String searchEndTime);

	/**
	 * 获取员工指定时间内的所有出差工时单
	 * 
	 * @param empId
	 * @param searchStartTime
	 * @param searchEndTime
	 * @return
	 */
	public List<EvectionWrapper> findEvectionByUser(String empId, String searchStartTime, String searchEndTime);

	/**
	 * 获取请假单的流程审批状态
	 * 
	 * @param evectionAppId
	 * @param countIndex
	 * @return
	 */
	public String findEvectionProcessStatus(String evectionAppId, int countIndex);
}
