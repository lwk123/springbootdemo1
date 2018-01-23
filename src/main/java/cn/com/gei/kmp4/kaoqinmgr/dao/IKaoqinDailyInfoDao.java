package cn.com.gei.kmp4.kaoqinmgr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.gei.kmp4.kaoqinmgr.entity.KaoqinDailyInfo;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.KaoqinDailyInfoWrapper;

/**
 * 日考勤信息
 * 
 * @author dxz
 *
 */
public interface IKaoqinDailyInfoDao {

	/**
	 * 根据ID获取日考勤信息
	 * 
	 * @param unid
	 * @return
	 */
	public KaoqinDailyInfo findKDIById(@Param("unid") String unid);

	/**
	 * 获取员工在某一天的日考勤信息
	 * 
	 * @param employeeId
	 * @param statDate
	 * @return
	 */
	public List<KaoqinDailyInfo> findKDIByEmployeeAndDate(@Param("employeeId") String employeeId,
                                                          @Param("statDate") String statDate);

	/**
	 * 提供日考勤检索
	 * 
	 * @param employeeId
	 * @param timeStart
	 * @param timeEnd
	 * @param status
	 * @param deptId
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<KaoqinDailyInfoWrapper> findKDIForSearch(@Param("employeeId") String employeeId,
                                                         @Param("timeStart") String timeStart, @Param("timeEnd") String timeEnd, @Param("status") String status,
                                                         @Param("deptId") String deptId, @Param("kaoqinStatus") String kaoqinStatus, @Param("offset") int offset, @Param("count") int count);

}
