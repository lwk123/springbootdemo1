package cn.com.gei.kmp4.kaoqinmgr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.gei.kmp4.kaoqinmgr.entity.ManhaurFormLock;

public interface IManhaurFormLockDao {

	/**
	 * 获取指定年月的月考勤锁定信息
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public List<ManhaurFormLock> findMFLByTime(@Param("year") String year, @Param("month") String month);

}
