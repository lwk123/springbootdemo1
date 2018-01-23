package cn.com.gei.kmp4.kaoqinmgr.service;

import java.util.Date;
import java.util.List;

import cn.com.gei.kmp4.kaoqinmgr.entity.KaoqinDailyDetail;
import cn.com.gei.kmp4.kaoqinmgr.entity.KaoqinDailyInfo;
import cn.com.gei.kmp4.kaoqinmgr.entity.KaoqinProject;
import cn.com.gei.kmp4.kaoqinmgr.entity.Manhaur;
import cn.com.gei.kmp4.kaoqinmgr.entity.ManhaurFormLock;
import cn.com.gei.kmp4.kaoqinmgr.entity.ManhaurWeekForm;
import cn.com.gei.kmp4.kaoqinmgr.entity.SubprojectManhaur;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.KaoqinDailyInfoWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.KaoqinProForDeptWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.KaoqinProForPersonWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.ManhaurWeekFormWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.ProjectManhaur;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.UserMonthManhaurWrapper;

public interface IKaoqinService {

	/**
	 * 根据ID获取日常考勤详细信息
	 * 
	 * @param unid
	 * @return
	 */
	public KaoqinDailyDetail findDailyDetailById(String unid);

	/**
	 * 根据员工ID及时间获取考勤详细信息
	 * 
	 * @param employeeId
	 *            KMP3员工ID
	 * @param statDate
	 * @return
	 */
	public KaoqinDailyDetail findDailyDetailByEmpIdAndDate(String employeeId, Date statDate);

	/**
	 * 根据ID获取日考勤信息
	 * 
	 * @param unid
	 * @return
	 */
	public KaoqinDailyInfo findDailyInfoById(String unid);

	/**
	 * 获取员工在某一天的日考勤信息
	 * 
	 * @param employeeId
	 *            员工ID，KMP3员工ID
	 * @param statDate
	 *            日期
	 * @return
	 */
	public KaoqinDailyInfo findDailyInfoByEmpAndDate(String employeeId, Date statDate);

	/**
	 * 提供日考勤检索
	 * 
	 * @param employeeId
	 *            员工ID，KMP3员工ID
	 * @param timeStart
	 *            检索开始时间
	 * @param timeEnd
	 *            检索结束时间
	 * @param status
	 *            状态（正常/异常）
	 * @param deptId
	 *            部门ID，KMP3部门ID
	 * @param offset
	 *            分页索引位置
	 * @param count
	 *            分页每页数量（offset>=0且count>0时分页有效）
	 * @return
	 */
	public List<KaoqinDailyInfoWrapper> findDailyInfoForSearch(String employeeId, Date timeStart, Date timeEnd,
                                                               String status, String deptId, String kaoqinStatus, int offset, int count);

	/**
	 * 根据ID获取周考勤信息
	 * 
	 * @param unid
	 * @return
	 */
	public ManhaurWeekForm findWeekFormById(String unid);

	/**
	 * 检索周考勤
	 * 
	 * @param employeeId
	 *            员工ID，KMP3员工ID
	 * @param timeStart
	 *            检索开始时间
	 * @param timeEnd
	 *            检索结束时间
	 * @param status
	 *            状态（Y:已分配，N：未分配，ALL：全部）
	 * @param offset
	 *            分页索引位置
	 * @param count
	 *            分页每页数量（offset>=0且count>0时分页有效）
	 * @return
	 */
	public List<ManhaurWeekFormWrapper> findWeekFormForSearch(String withManhaurDetail, String deptId,
                                                              String employeeId, Date timeStart, Date timeEnd, String status, int offset, int count);

	/**
	 * 根据ID获取工时分配详情
	 * 
	 * @param unid
	 * @return
	 */
	public Manhaur findManhaurById(String unid);

	/**
	 * 检索工时分配
	 * 
	 * @param employeeId
	 *            员工ID，KMP3员工ID
	 * @param timeStart
	 *            检索开始时间
	 * @param timeEnd
	 *            检索结束时间
	 * @param affairId
	 *            项目ID
	 * @param offset
	 *            分页索引位置
	 * @param count
	 *            分页每页数量（offset>=0且count>0时分页有效）
	 * @return
	 */
	public List<Manhaur> findManhaurForSearch(String employeeId, Date timeStart, Date timeEnd, String affairId,
                                              int offset, int count);

	/**
	 * 子项目工时分配查询
	 * 
	 * @param parentManhaurId
	 *            上级项目工时分配统计
	 * @param employeeId
	 *            KMP3员工ID
	 * @param timeStart
	 *            查询开始时间
	 * @param timeEnd
	 *            查询结束时间
	 * @param affairId
	 *            上级项目ID
	 * @return
	 */
	public List<SubprojectManhaur> findSubManhaurForSearch(String parentManhaurId, String employeeId, Date timeStart,
                                                           Date timeEnd, String affairId);

	/**
	 * 检索月考勤
	 * 
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
	public List<ManhaurWeekFormWrapper> findManhaurByMonth(int timeYear, Integer timeMonth, String deptId,
                                                           String employeeId);

	public void deleteManhaurByMF(ManhaurWeekForm manhaurForm);

	public void saveSubProjectManhaur(SubprojectManhaur subprojectManhaur);

	public void saveProjectManhaur(Manhaur manhaur);

	/**
	 * 获取指定年月的月考勤锁定信息
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public ManhaurFormLock findManhaurFormLockByTime(String year, String month);

	/**
	 * 获取用户每月分配到项目上的工时
	 * 
	 * @param personId
	 * @param manhaurYear
	 * @return
	 */
	public List<ProjectManhaur> findAffairManhaurByYear(String personId, String manhaurYear);

	/**
	 * 获取员工指定年月的考勤方案
	 * 
	 * @param userId
	 *            KMP3员工ID
	 * @param year
	 * @param month
	 * @param enable
	 * @return
	 */
	public KaoqinProForPersonWrapper findProByYearAndMonth(String userId, Integer year, Integer month, String enable);

	/**
	 * 获取部门员工的考勤方案
	 * 
	 * @param orgId
	 * @param year
	 * @param month
	 * @param enable
	 * @return
	 */
	public List<KaoqinProForDeptWrapper> finProByDept(String orgId, Integer year, Integer month);

	/**
	 * 查看所有考勤方案
	 * 
	 * @param unid
	 * @return
	 */
	public List<KaoqinProject> findAllPro();

	/**
	 * 更新考勤方案
	 * 
	 * @param userId
	 * @param year
	 * @param month
	 * @param kaoqinProjectId
	 */
	public void updatePro(String userId, Integer year, Integer month, String kaoqinProjectId);

	/**
	 * 获取员工出勤天数
	 * 
	 * @param deptId
	 *            部门ID
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @return
	 */
	public List<UserMonthManhaurWrapper> findUserMonthManhaurs(String deptId, String year, String month);

}
