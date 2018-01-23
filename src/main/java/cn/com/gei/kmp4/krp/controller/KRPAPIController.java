package cn.com.gei.kmp4.krp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.gei.kmp4.kaoqinmgr.entity.ManhaurWeekForm;
import cn.com.gei.kmp4.kaoqinmgr.service.IKaoqinService;
import cn.com.gei.kmp4.kaoqinmgr.utils.NumberUtils;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.CommonResult;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.ErrorResult;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.EvectionWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.FailtureDailyWrapper;
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
public class KRPAPIController {

	@Autowired
	private IKRPService krpService;

	@Autowired
	private IKaoqinService kaoqinService;

	/**
	 * 根据工时分配id获取日考勤信息
	 * 
	 * @param manhaurId
	 * @return
	 */
	@RequestMapping(value = "/kaoqin", method = RequestMethod.GET)
	public CommonResult getKMP4KaoqinData(@RequestParam("manhaurId") String manhaurId) {
		ManhaurWeekForm m = kaoqinService.findWeekFormById(manhaurId);
		if (m == null) {
			return new ErrorResult(manhaurId + "对应的实体不存在");
		}
		String beginTime = NumberUtils.formateDate(m.getBeginDate());
		String endTime = NumberUtils.formateDate(m.getEndDate());
		String beginTimeWithHM = beginTime + " 00:00:00";
		String endTimeWithHM = beginTime + " 23:59:59";
		List<Object> results = new ArrayList<Object>();

		List<FailtureDailyWrapper> fdws = krpService.findFailtureByUser(m.getEmployeeId(), beginTime, endTime);
		if (fdws != null && !fdws.isEmpty()) {
			results.addAll(fdws);
		}

		List<LeaveDailyWrapper> ldws = krpService.findLeaveDailyByUser(m.getEmployeeId(), beginTimeWithHM, endTimeWithHM);
		if (ldws != null && !ldws.isEmpty()) {
			results.addAll(ldws);
		}

		List<OutDailyWrapper> wdws = krpService.findOutDailyByUser(m.getEmployeeId(), beginTimeWithHM, endTimeWithHM);
		if (wdws != null && !wdws.isEmpty()) {
			results.addAll(wdws);
		}

		List<EvectionWrapper> ews = krpService.findEvectionByUser(m.getEmployeeId(), beginTimeWithHM, endTimeWithHM);
		if (ews != null && !ews.isEmpty()) {
			results.addAll(ews);
		}
		return new SuccessResult(results);
	}

}
