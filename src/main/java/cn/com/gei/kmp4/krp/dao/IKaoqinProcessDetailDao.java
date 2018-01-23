package cn.com.gei.kmp4.krp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.gei.kmp4.kaoqinmgr.wrapper.FailtureDailyWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.LeaveDailyWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.OutDailyWrapper;

/**
 * 考勤单接口
 * 
 * @author dxz
 *
 */
public interface IKaoqinProcessDetailDao {

	/**
	 * 获取员工指定时间内的漏打卡单
	 * 
	 * @param empId
	 * @param searchStartTime
	 * @param searchEndTime
	 * @return
	 */
	public List<FailtureDailyWrapper> findFailtureByUser(@Param("empId") String empId,
                                                         @Param("searchStartTime") String searchStartTime, @Param("searchEndTime") String searchEndTime);

	/**
	 * 获取员工指定时间内的请假单
	 * 
	 * @param empId
	 * @param searchStartTime
	 * @param searchEndTime
	 * @return
	 */
	public List<LeaveDailyWrapper> findLeaveDailyByUser(@Param("empId") String empId,
                                                        @Param("searchStartTime") String searchStartTime, @Param("searchEndTime") String searchEndTime);

	/**
	 * 获取员工指定时间内的外出工时单
	 * 
	 * @param empId
	 * @param searchStartTime
	 * @param searchEndTime
	 * @return
	 */
	public List<OutDailyWrapper> findOutDailyByUser(@Param("empId") String empId,
                                                    @Param("searchStartTime") String searchStartTime, @Param("searchEndTime") String searchEndTime);

	/**
	 * 获取请假单的流程审批状态
	 * 
	 * @param evectionAppId
	 * @param countIndex
	 * @return
	 */
	public List<String> findEvectionProcessStatus(@Param("evectionAppId") String evectionAppId,
                                                  @Param("countIndex") int countIndex);

}
