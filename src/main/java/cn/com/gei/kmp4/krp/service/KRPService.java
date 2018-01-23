package cn.com.gei.kmp4.krp.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.gei.kmp4.kaoqinmgr.service.IEvectionService;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.EvectionWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.FailtureDailyWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.LeaveDailyWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.OutDailyWrapper;
import cn.com.gei.kmp4.krp.dao.IKaoqinProcessDetailDao;

@Service("krpService")
@Transactional(propagation = Propagation.REQUIRED)
public class KRPService implements IKRPService {

	@Autowired
	private IKaoqinProcessDetailDao kaoqinProcessDetailDao;

	@Autowired
	private IEvectionService evectionService;

	@Override
	public List<FailtureDailyWrapper> findFailtureByUser(String empId, String searchStartTime, String searchEndTime) {
		List<FailtureDailyWrapper> fdws = kaoqinProcessDetailDao.findFailtureByUser(empId, searchStartTime,
				searchEndTime);
		return fdws;
	}

	@Override
	public List<LeaveDailyWrapper> findLeaveDailyByUser(String empId, String searchStartTime, String searchEndTime) {
		List<LeaveDailyWrapper> fdws = kaoqinProcessDetailDao.findLeaveDailyByUser(empId, searchStartTime,
				searchEndTime);
		return fdws;
	}

	@Override
	public List<OutDailyWrapper> findOutDailyByUser(String empId, String searchStartTime, String searchEndTime) {
		List<OutDailyWrapper> odws = kaoqinProcessDetailDao.findOutDailyByUser(empId, searchStartTime, searchEndTime);
		return odws;
	}

	@Override
	public List<EvectionWrapper> findEvectionByUser(String empId, String searchStartTime, String searchEndTime) {
		List<EvectionWrapper> ews = evectionService.findEvectionByUser(empId, searchStartTime, searchEndTime);
		if (ews != null && !ews.isEmpty()) {
			for (EvectionWrapper ew : ews) {
				ew.setResult(findEvectionProcessStatus(ew.getApplicantId(), ew.getCountIndex()));
			}
		}
		return ews;
	}

	@Override
	public String findEvectionProcessStatus(String evectionAppId, int countIndex) {
		if (StringUtils.isBlank(evectionAppId)) {
			return StringUtils.EMPTY;
		}
		List<String> status = kaoqinProcessDetailDao.findEvectionProcessStatus(evectionAppId, countIndex);
		if (status == null || !status.isEmpty()) {
			return status.get(0);
		}
		return StringUtils.EMPTY;
	}
}
