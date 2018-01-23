package cn.com.gei.kmp4.kaoqinmgr.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.gei.kmp4.kaoqinmgr.entity.AdjustLaborTimeRecord;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.KaoqinProForDeptWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.KaoqinProForPersonWrapper;

public interface IAdjustLaborTimeRecordDao {

	/**
	 * 获取员工指定年月及之前的考勤方案
	 * @param userId KMP3员工ID
	 * @param year
	 * @param month
	 * @param enable
	 * @return
	 */
	public List<KaoqinProForPersonWrapper> findProByYearAndMonth(@Param("userId") String userId, @Param("year") Integer year, @Param("month") Integer month, @Param("enable") String enable);
	
	/**
	 * 获取部门所有元的考勤方案
	 * @param orgId 部门ID
	 * @return
	 */
	public List<KaoqinProForDeptWrapper> findProByDept(Map<String, Object> map);
	
	/**
	 * 保存考勤方案
	 * @param adjustLaborTimeRecord
	 */
	public void savePro(AdjustLaborTimeRecord adjustLaborTimeRecord);
	
	/**
	 * 修改考勤方案
	 * @param adjustLaborTimeRecord
	 */
	public void modifPro(AdjustLaborTimeRecord adjustLaborTimeRecord);
	
	/**
	 * 获取员工指定年月的考勤方案记录
	 * @param userId
	 * @param year
	 * @param month
	 * @return
	 */
	public List<AdjustLaborTimeRecord> findPersonPro(@Param("userId") String userId, @Param("year") Integer year, @Param("month") Integer month);
}
