package cn.com.gei.kmp4.kaoqinmgr.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.com.gei.kmp4.kaoqinmgr.entity.ManhaurWeekForm;
import cn.com.gei.kmp4.kaoqinmgr.service.IKaoqinService;
import cn.com.gei.kmp4.kaoqinmgr.utils.NumberUtils;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.CommonResult;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.ErrorResult;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.EvectionWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.FailtureDailyWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.KaoqinDailyInfoWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.LeaveDailyWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.OutDailyWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.SuccessResult;
import cn.com.gei.kmp4.krp.service.IKRPService;

/**
 * 移动端接口
 * 
 * @author dxz
 *
 */
@RestController
@RequestMapping("/manhaur/api")
public class MobileAPIController {

	@Autowired
	private IKaoqinService kaoqinService;

	@Autowired
	private IKRPService krpService;

	/**
	 * 根据工时分配id获取日考勤信息
	 * 
	 * @param manhaurId
	 * @return
	 */
	@RequestMapping(value = "/dailyinfo", method = RequestMethod.GET)
	public CommonResult getManhaurDailyInfo(@RequestParam(required = true) String manhaurId,
			@RequestParam(required = false) String status) {
		ManhaurWeekForm m = kaoqinService.findWeekFormById(manhaurId);
		if (m == null) {
			return new ErrorResult(manhaurId + "对应的实体不存在");
		}
		if (StringUtils.isBlank(status)) {
			status = "N";
		}
		Date beginDate = m.getBeginDate();
		Date endDate = m.getEndDate();
		List<KaoqinDailyInfoWrapper> results = kaoqinService.findDailyInfoForSearch(m.getEmployeeId(), beginDate,
				endDate, status, StringUtils.EMPTY, StringUtils.EMPTY, 0, 0);
		JSONObject resultObject = new JSONObject();
		if (results != null && !results.isEmpty()) {
			JSONArray array = new JSONArray(results.size());
			for (KaoqinDailyInfoWrapper kdw : results) {
				JSONObject obj = new JSONObject();
				obj.put("date", kdw.getStatDate());
				obj.put("workStartTime", kdw.getBeginTime());
				obj.put("workEndTime", kdw.getEndTime());
				obj.put("absenteeism", kdw.getAbsentTime());
				array.add(obj);
			}
			resultObject.put("dailyInfos", array);
		}

		String beginTime = NumberUtils.formateDate(m.getBeginDate());
		String endTime = NumberUtils.formateDate(m.getEndDate());
		String beginTimeWithHM = beginTime + " 00:00:00";
		String endTimeWithHM = beginTime + " 23:59:59";
		List<Object> kaoqinResults = new ArrayList<Object>();
		List<FailtureDailyWrapper> fdws = krpService.findFailtureByUser(m.getEmployeeId(), beginTime, endTime);
		if (fdws != null && !fdws.isEmpty()) {
			kaoqinResults.addAll(fdws);
		}

		List<LeaveDailyWrapper> ldws = krpService.findLeaveDailyByUser(m.getEmployeeId(), beginTimeWithHM,
				endTimeWithHM);
		if (ldws != null && !ldws.isEmpty()) {
			kaoqinResults.addAll(ldws);
		}

		List<OutDailyWrapper> wdws = krpService.findOutDailyByUser(m.getEmployeeId(), beginTimeWithHM, endTimeWithHM);
		if (wdws != null && !wdws.isEmpty()) {
			kaoqinResults.addAll(wdws);
		}

		List<EvectionWrapper> ews = krpService.findEvectionByUser(m.getEmployeeId(), beginTimeWithHM, endTimeWithHM);
		if (ews != null && !ews.isEmpty()) {
			kaoqinResults.addAll(ews);
		}
		resultObject.put("kaoqinInfos", kaoqinResults);
		return new SuccessResult(resultObject);
	}

}
