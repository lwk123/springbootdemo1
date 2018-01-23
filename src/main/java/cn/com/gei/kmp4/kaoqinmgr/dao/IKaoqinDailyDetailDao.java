package cn.com.gei.kmp4.kaoqinmgr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.gei.kmp4.kaoqinmgr.entity.KaoqinDailyDetail;

public interface IKaoqinDailyDetailDao {

	/**
	 * 根据ID获取日常考勤详细信息
	 * 
	 * @param unid
	 * @return
	 */
	public KaoqinDailyDetail findById(@Param("unid") String unid);

	/**
	 * 根据员工ID及时间获取考勤详细信息
	 * 
	 * @param employeeId
	 *            KMP3员工ID
	 * @param statDate
	 *            时间XXXX-XX-XX
	 * @return
	 */
	public List<KaoqinDailyDetail> findByEmployeeAndDate(@Param("employeeId") String employeeId,
                                                         @Param("statDate") String statDate);

}
