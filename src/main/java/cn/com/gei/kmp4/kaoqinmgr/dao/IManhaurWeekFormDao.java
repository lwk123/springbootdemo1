package cn.com.gei.kmp4.kaoqinmgr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.gei.kmp4.kaoqinmgr.entity.ManhaurWeekForm;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.ManhaurWeekFormWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.UserMonthManhaurWrapper;

public interface IManhaurWeekFormDao {

	/**
	 * 根据ID获取周考勤信息
	 * 
	 * @param unid
	 * @return
	 */
	public ManhaurWeekForm findMWFById(@Param("unid") String unid);

	/**
	 * 检索周考勤
	 * 
	 * @param widthManhaurDetail
	 *            是否检索工时分配详情
	 * @param deptId
	 *            KMP3部门ID
	 * @param employeeId
	 *            KMP3员工ID
	 * @param timeStart
	 *            检索开始时间
	 * @param timeEnd
	 *            检索结束时间
	 * @param status
	 *            状态（Y：已分配工时，N：未分配工时）
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<ManhaurWeekFormWrapper> findMWFForSearch(@Param("withManhaurDetail") String withManhaurDetail,
                                                         @Param("deptId") String deptId, @Param("employeeId") String employeeId,
                                                         @Param("timeStart") String timeStart, @Param("timeEnd") String timeEnd, @Param("status") String status,
                                                         @Param("offset") int offset, @Param("count") int count);

	/**
	 * 检索月考勤
	 * 
	 * @param timeStart
	 *            检索开始时间
	 * @param timeEnd
	 *            检索结束时间
	 * @param timeYear
	 *            年
	 * @param timeMonth
	 *            月
	 * @param deptId
	 *            所属部门ID
	 * @param employeeId
	 *            所属员工ID
	 * @return
	 */
	public List<ManhaurWeekFormWrapper> findMonthManhaur(@Param("timeStart") String timeStart,
                                                         @Param("timeEnd") String timeEnd, @Param("timeYear") int timeYear, @Param("timeMonth") Integer timeMonth,
                                                         @Param("deptId") String deptId, @Param("employeeId") String employeeId);

	/**
	 * 获取员工出勤天数
	 * 
	 * @param timeStart
	 *            月开始时间
	 * @param timeEnd
	 *            月结束时间
	 * @param deptId
	 *            部门ID
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @return
	 */
	public List<UserMonthManhaurWrapper> findUserMonthManhaurs(@Param("timeStart") String timeStart,
                                                               @Param("timeEnd") String timeEnd, @Param("deptId") String deptId, @Param("year") String year,
                                                               @Param("month") String month);

}
