package cn.com.gei.kmp4.kaoqinmgr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.gei.kmp4.kaoqinmgr.entity.Manhaur;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.ProjectManhaur;

public interface IManhaurDao {

	/**
	 * 根据ID获取工时分配详情
	 * 
	 * @param unid
	 * @return
	 */
	public Manhaur findMById(@Param("unid") String unid);

	/**
	 * 检索工时分配
	 * 
	 * @param employeeId
	 * @param timeStart
	 * @param timeEnd
	 * @param affairId
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<Manhaur> findMForSearch(@Param("employeeId") String employeeId, @Param("timeStart") String timeStart,
                                        @Param("timeEnd") String timeEnd, @Param("affairId") String affairId, @Param("offset") int offset,
                                        @Param("count") int count);

	/**
	 * 删除工时分配记录
	 * 
	 * @param employeeId
	 * @param timeStart
	 * @param timeEnd
	 */
	public void deleteManhaurByEmpAndTime(@Param("employeeId") String employeeId, @Param("timeStart") String timeStart,
                                          @Param("timeEnd") String timeEnd);

	/**
	 * 保存工时分配记录
	 * 
	 * @param manhaur
	 */
	public void saveProjectManhaur(Manhaur manhaur);

	/**
	 * 获取用户每月分配到项目上的工时
	 * 
	 * @param personId
	 * @param manhaurYear
	 * @return
	 */
	public List<ProjectManhaur> findAffairMByYear(@Param("personId") String personId,
                                                  @Param("manhaurYear") String manhaurYear);

}
