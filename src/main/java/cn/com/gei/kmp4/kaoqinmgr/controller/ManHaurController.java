package cn.com.gei.kmp4.kaoqinmgr.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.com.gei.kmp4.kaoqinmgr.entity.KaoqinDailyDetail;
import cn.com.gei.kmp4.kaoqinmgr.entity.KaoqinProject;
import cn.com.gei.kmp4.kaoqinmgr.entity.Manhaur;
import cn.com.gei.kmp4.kaoqinmgr.entity.ManhaurFormLock;
import cn.com.gei.kmp4.kaoqinmgr.entity.ManhaurWeekForm;
import cn.com.gei.kmp4.kaoqinmgr.entity.SubprojectManhaur;
import cn.com.gei.kmp4.kaoqinmgr.service.IKaoqinService;
import cn.com.gei.kmp4.kaoqinmgr.utils.IdUtils;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.CommonResult;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.ErrorResult;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.KaoqinDailyInfoWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.KaoqinProForDeptWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.KaoqinProForPersonWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.ManhaurWeekFormWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.ProjectManhaur;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.SuccessResult;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.UserMonthManhaurWrapper;

@RestController
@RequestMapping("/manhaur")
public class ManHaurController {
	Log logger = LogFactory.getLog(getClass());

	@Autowired
	private IKaoqinService kaoqinService;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		System.out.println("====in====");
		return "success";
	}

	/**
	 * 日考勤信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/dailyinfo", method = RequestMethod.GET)
	public CommonResult dailyinfo(@RequestParam(required = false) String deptId,@RequestParam(required = false) String kaoqinStatus,
			@RequestParam(required = false) String employeeId, @RequestParam(required = false) String status,
			@RequestParam(required = false) Long startTime, @RequestParam(required = false) Long endTime,
			@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit) {
		try {
			Date startDate = null;
			if (startTime != null) {
				startDate = new Date(startTime);
			}
			Date endDate = null;
			if (endTime != null) {
				endDate = new Date(endTime);
			}
			System.out.println("dailyinfo.....");
			List<KaoqinDailyInfoWrapper> results = kaoqinService.findDailyInfoForSearch(employeeId, startDate, endDate,
					status, deptId,kaoqinStatus, offset == null ? 0 : offset, limit == null ? 0 : limit);
			return new SuccessResult(results);
		} catch (Exception e) {
			logger.error("获取工时记录时出现错误(/manhaur/dailyinfo)", e);
		}
		return new ErrorResult("获取工时记录时出现错误");
	}

	/**
	 * 日考勤详细信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/dailydetail", method = RequestMethod.GET)
	public CommonResult dailydetail(@RequestParam String employeeId, @RequestParam("dayTime") long dayTime) {
		try {
			KaoqinDailyDetail kdd = kaoqinService.findDailyDetailByEmpIdAndDate(employeeId, new Date(dayTime));
			if (kdd != null) {
				return new SuccessResult(kdd);
			} else {
				return new ErrorResult("您要查找的考勤明细不存在，查找条件：" + employeeId + " " + dayTime);
			}
		} catch (Exception e) {
			logger.error("获取工时记录时出现错误(/manhaur/dailydetail)", e);
		}
		return new ErrorResult("获取工时记录时出现错误");
	}

	/**
	 * 周考勤检索
	 * 
	 * @return
	 */
	@RequestMapping(value = "/weekforperson", method = RequestMethod.GET)
	public CommonResult weekforsearch(@RequestParam("timeStart") long timeStart, @RequestParam("timeEnd") long timeEnd,
			@RequestParam(required = false) String employeeId, @RequestParam(required = false) String status,
			@RequestParam(required = false) String manhaurDetail, @RequestParam(required = false) String deptId,
			@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer count) {
		try {
			List<ManhaurWeekFormWrapper> mwfws = kaoqinService.findWeekFormForSearch(manhaurDetail, deptId, employeeId,
					new Date(timeStart), new Date(timeEnd), status, offset == null ? 0 : offset,
					count == null ? 0 : count);
			if (mwfws != null) {
				return new SuccessResult(mwfws);
			}
		} catch (Exception e) {
			logger.error("获取工时记录时出现错误(/manhaur/weekforperson)", e);
		}
		return new ErrorResult("获取工时记录时出现错误");
	}

	/**
	 * 周考勤检索
	 * 
	 * @return
	 */
	@RequestMapping(value = "/month", method = RequestMethod.GET)
	public CommonResult weekforsearch(@RequestParam("year") int year, @RequestParam(required = false) Integer month,
			@RequestParam(required = false) String employeeId, @RequestParam(required = false) String deptId) {
		try {
			List<ManhaurWeekFormWrapper> mwfws = kaoqinService.findManhaurByMonth(year, month, deptId, employeeId);
			if (mwfws != null) {
				return new SuccessResult(mwfws);
			}
		} catch (Exception e) {
			logger.error("获取工时记录时出现错误(/manhaur/weekforperson)", e);
		}
		return new ErrorResult("获取工时记录时出现错误");
	}

	/**
	 * 员工工时分配明细
	 * 
	 * @return
	 */
	@RequestMapping(value = "/allocation/person", method = RequestMethod.GET)
	public CommonResult allocationForPerson(@RequestParam String employeeId, @RequestParam("timeStart") long timeStart,
			@RequestParam("timeEnd") long timeEnd) {
		try {
			List<Manhaur> manhaurs = kaoqinService.findManhaurForSearch(employeeId, new Date(timeStart),
					new Date(timeEnd), null, 0, 0);
			if (manhaurs == null || manhaurs.isEmpty())
				return new SuccessResult(Collections.emptyList());

			JSONArray results = new JSONArray();
			for (Manhaur manhaur : manhaurs) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("affairId", manhaur.getAffairId());
				jsonObject.put("manhaur", manhaur.getOriginalTimeConsume());
				jsonObject.put("startTime", manhaur.getBeginDate());
				jsonObject.put("endTime", manhaur.getEndDate());
				List<SubprojectManhaur> subManhaurs = kaoqinService.findSubManhaurForSearch(manhaur.getUnid(), null,
						null, null, null);
				if (subManhaurs != null && !subManhaurs.isEmpty()) {
					JSONArray subManhaurResults = new JSONArray(subManhaurs.size());
					for (SubprojectManhaur subManhaur : subManhaurs) {
						JSONObject sub = new JSONObject();
						sub.put("affairId", subManhaur.getSubprojectId());
						sub.put("manhaur", subManhaur.getOriginalTimeConsume());
						subManhaurResults.add(sub);
					}
					jsonObject.put("subManhuars", subManhaurResults);
				}
				results.add(jsonObject);
			}
			return new SuccessResult(results);
		} catch (Exception e) {
			logger.error("获取工时记录时出现错误(/manhaur/allocation/person)", e);
		}
		return new ErrorResult("获取工时记录时出现错误");
	}

	@RequestMapping(value = "/lockinfo", method = RequestMethod.GET)
	public CommonResult getLockInfo(@RequestParam String year, @RequestParam String month) {
		try {
			ManhaurFormLock mfl = kaoqinService.findManhaurFormLockByTime(year, month);
			if (mfl == null) {
				return new ErrorResult(year + "年" + month + "月，没有找到工时锁定信息");
			} else {
				return new SuccessResult(mfl);
			}
		} catch (Exception e) {
			logger.error("获取工时锁定信息错误", e);
		}
		return new ErrorResult("系统错误，请联系管理员！");
	}

	/**
	 * 工时分配
	 * 
	 * @param manhaurId
	 * @param empXS
	 * @param employeeId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/allocation/{manhaurId}", method = RequestMethod.POST)
	public Object allocationManhaur(@PathVariable String manhaurId, @RequestParam double empXS,
			@RequestParam String employeeId, HttpServletRequest request) {
		JSONArray manhaurs = readJson2JSON(request);
		if (manhaurs == null || manhaurs.size() == 0) {
			return new ErrorResult("工时分配记录空");
		}

		ManhaurWeekForm manhaurForm = kaoqinService.findWeekFormById(manhaurId);
		if (manhaurForm == null) {
			logger.error("获取工时记录时出现错误(/allocation/{manhaurId})");
			return new ErrorResult("获取工时记录时出现错误");
		}
		kaoqinService.deleteManhaurByMF(manhaurForm); 
		// 浮点数比较的最小精度。
		float Delta = 0.001f;
		for (int i = 0; i < manhaurs.size(); i++) {
			JSONObject p = manhaurs.getJSONObject(i);
			String affairId = p.getString("affairId");
			double manhaurValue = 0;
			JSONArray subProjectManhaurs = p.getJSONArray("subManhaurs");
			String parentManhaurId = IdUtils.getUUID();
			if (subProjectManhaurs == null || subProjectManhaurs.isEmpty()) {
				manhaurValue = p.getDoubleValue("manhaur");
			} else {
				for (int j = 0; j < subProjectManhaurs.size(); j++) {
					JSONObject subManhaur = subProjectManhaurs.getJSONObject(j);
					String subAffairId = subManhaur.getString("affairId");
					double subManhaurValue = subManhaur.getDoubleValue("manhaur");
					if (subManhaurValue < Delta) {
						continue;
					}
					SubprojectManhaur subprojectManhaur = new SubprojectManhaur();
					subprojectManhaur.setUnid(IdUtils.getUUID());
					subprojectManhaur.setAffairId(affairId);
					subprojectManhaur.setBeginDate(manhaurForm.getBeginDate());
					subprojectManhaur.setEndDate(manhaurForm.getEndDate());
					subprojectManhaur.setParentManhaurId(parentManhaurId);
					subprojectManhaur.setPersonId(employeeId);
					subprojectManhaur.setSubprojectId(subAffairId);
					subprojectManhaur.setTimeConsume(subManhaurValue * empXS);
					subprojectManhaur.setOriginalTimeConsume(subManhaurValue);
					kaoqinService.saveSubProjectManhaur(subprojectManhaur);
					manhaurValue += subManhaurValue;
				}
			}
			Manhaur manhaur = new Manhaur();
			manhaur.setAffairId(affairId);
			manhaur.setBeginDate(manhaurForm.getBeginDate());
			manhaur.setEndDate(manhaurForm.getEndDate());
			manhaur.setPersonId(employeeId);
			manhaur.setTimeConsume(manhaurValue * empXS);
			manhaur.setOriginalTimeConsume(manhaurValue);
			manhaur.setUnid(parentManhaurId);
			manhaur.setEquivManhaur(manhaurValue * empXS);
			manhaur.setEquivManhaurXishu(empXS);
			kaoqinService.saveProjectManhaur(manhaur);
		}
		return new SuccessResult("工时分配成功");
	}

	/**
	 * 获取用户每月在项目中分配的工时明细
	 * 
	 * @param personId
	 * @param year
	 * @return
	 */
	@RequestMapping(value = "/affair/time", method = RequestMethod.GET)
	public CommonResult affairTime(@RequestParam String personId, @RequestParam String year) {
		try {
			List<ProjectManhaur> pms = kaoqinService.findAffairManhaurByYear(personId, year);
			return new SuccessResult(pms);
		} catch (Exception e) {
			logger.error("获取工时锁定信息错误", e);
		}
		return new ErrorResult("系统错误，请联系管理员！");
	}

	/**
	 * 获取用户每月考勤天数
	 * 
	 * @param personId
	 * @param year
	 * @return
	 */
	@RequestMapping(value = "/user/workday", method = RequestMethod.GET)
	public CommonResult getUserWorkDay(@RequestParam(required = false) String deptId, @RequestParam String year,
			@RequestParam String month) {
		try {
			List<UserMonthManhaurWrapper> pms = kaoqinService.findUserMonthManhaurs(deptId, year, month);
			return new SuccessResult(pms);
		} catch (Exception e) {
			logger.error("获取员工考勤天数信息错误", e);
		}
		return new ErrorResult("系统错误，请联系管理员！");
	}

	/**
	 * 读取request中的inputstream,并转化为JSONObject
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public JSONArray readJson2JSON(HttpServletRequest request) {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
			StringBuffer sb = new StringBuffer();
			String temp;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			br.close();

			return JSONArray.parseArray(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JSONArray(0);
	}

	/**
	 * 获取员工指定过年月的考勤方案信息
	 * @Param employeeId kmp3员工id
	 * @param year
	 * @param month
	 */
	@RequestMapping(value="/project/person/{employeeId}", method = RequestMethod.GET)
	public CommonResult kaoqinProForPerson(@PathVariable String employeeId, @RequestParam Integer year, @RequestParam Integer month, @RequestParam(value="enable", required = false) String enable) {
		try {
			KaoqinProForPersonWrapper kaoqinProForPersonWrapper = kaoqinService.findProByYearAndMonth(employeeId, year, month, enable);
			return new SuccessResult(kaoqinProForPersonWrapper);
		} catch (Exception e) {
			logger.error("获取员工考勤方案信息错误", e);
		}
		return new ErrorResult("系统错误，请联系管理员！");
	}
	
	/**
	 * 获取部门员工指定过年月的考勤方案信息
	 * @Param employeeId kmp3员工id
	 * @param year
	 * @param month
	 */
	@RequestMapping(value="/project/dept", method = RequestMethod.GET)
	public CommonResult kaoqinProForDept(@RequestParam String orgId, @RequestParam Integer year, @RequestParam Integer month) {
		try {
			List<KaoqinProForDeptWrapper> kaoqinProForDeptWrappers = kaoqinService.finProByDept(orgId, year, month);
			return new SuccessResult(kaoqinProForDeptWrappers);
		} catch (Exception e) {
			logger.error("获取部门员工考勤方案信息错误", e);
		}
		return new ErrorResult("系统错误，请联系管理员！");
	}
	
	/**
	 * 更新员工的考勤该方案信息
	 * @param employeeId
	 * @param year
	 * @param month
	 * @param kaoqinProjectId
	 * @return
	 */
	@RequestMapping(value="/project/update/{employeeId}", method = RequestMethod.GET)
	public CommonResult updatePro(@PathVariable String employeeId, @RequestParam Integer year, @RequestParam Integer month, @RequestParam String kaoqinProjectId) {
		try {
			kaoqinService.updatePro(employeeId, year, month, kaoqinProjectId);
			return new SuccessResult("考勤方案信息更新成功");
		} catch (Exception e) {
			logger.error("更新部门员工考勤方案信息错误", e);
		}
		return new ErrorResult("系统错误，请联系管理员！");
	}
	
	/**
	 * 获取所有考勤方案的详细信息
	 * @return
	 */
	@RequestMapping(value="/project", method = RequestMethod.GET)
	public CommonResult kaoqinPro() {
		try {
			List<KaoqinProject> kaoqinProjects = kaoqinService.findAllPro();
			return new SuccessResult(kaoqinProjects);
		} catch (Exception e) {
			logger.error("获取所有考勤方案信息错误", e);
		}
		return new ErrorResult("系统错误，请联系管理员！");
	}
}
