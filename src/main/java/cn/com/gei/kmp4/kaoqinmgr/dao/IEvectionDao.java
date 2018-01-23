package cn.com.gei.kmp4.kaoqinmgr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.gei.kmp4.kaoqinmgr.wrapper.EvectionWrapper;

public interface IEvectionDao {

	/**
	 * 获取员工指定时间内的所有出差工时单
	 * 
	 * @param empId
	 * @param searchStartTime
	 * @param searchEndTime
	 * @return
	 */
	public List<EvectionWrapper> findEvectionByUser(@Param("empId") String empId,
                                                    @Param("searchStartTime") String searchStartTime, @Param("searchEndTime") String searchEndTime);

}
