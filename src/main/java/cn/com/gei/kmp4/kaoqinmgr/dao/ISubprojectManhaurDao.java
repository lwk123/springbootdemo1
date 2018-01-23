package cn.com.gei.kmp4.kaoqinmgr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.gei.kmp4.kaoqinmgr.entity.SubprojectManhaur;

public interface ISubprojectManhaurDao {

	/**
	 * 子项目工时分配
	 * 
	 * @param parentManhaurId
	 * @param employeeId
	 * @param timeStart
	 * @param timeEnd
	 * @param affairId
	 * @return
	 */
	public List<SubprojectManhaur> findSubMForSearch(@Param("parentManhaurId") String parentManhaurId,
                                                     @Param("employeeId") String employeeId, @Param("timeStart") String timeStart,
                                                     @Param("timeEnd") String timeEnd, @Param("affairId") String affairId);
	
	/**
	 * 删除子项目工时分配记录
	 * 
	 * @param employeeId
	 * @param timeStart
	 * @param timeEnd
	 */
	public void deleteSubManhaurByEmpAndTime(
            @Param("employeeId") String employeeId,
            @Param("timeStart") String timeStart,
            @Param("timeEnd") String timeEnd);

	/**
	 * 保存子项目工时分配记录
	 * 
	 * @param subprojectManhaur
	 */
	public void saveSubProjectManhaur(SubprojectManhaur subprojectManhaur);

}
