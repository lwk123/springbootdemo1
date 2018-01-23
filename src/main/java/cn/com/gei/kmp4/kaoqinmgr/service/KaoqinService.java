package cn.com.gei.kmp4.kaoqinmgr.service;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.gei.kmp4.kaoqinmgr.dao.IAdjustLaborTimeRecordDao;
import cn.com.gei.kmp4.kaoqinmgr.dao.IKaoqinDailyDetailDao;
import cn.com.gei.kmp4.kaoqinmgr.dao.IKaoqinDailyInfoDao;
import cn.com.gei.kmp4.kaoqinmgr.dao.IKaoqinProjectDao;
import cn.com.gei.kmp4.kaoqinmgr.dao.IManhaurDao;
import cn.com.gei.kmp4.kaoqinmgr.dao.IManhaurFormLockDao;
import cn.com.gei.kmp4.kaoqinmgr.dao.IManhaurWeekFormDao;
import cn.com.gei.kmp4.kaoqinmgr.dao.ISubprojectManhaurDao;
import cn.com.gei.kmp4.kaoqinmgr.entity.AdjustLaborTimeRecord;
import cn.com.gei.kmp4.kaoqinmgr.entity.KaoqinDailyDetail;
import cn.com.gei.kmp4.kaoqinmgr.entity.KaoqinDailyInfo;
import cn.com.gei.kmp4.kaoqinmgr.entity.KaoqinProject;
import cn.com.gei.kmp4.kaoqinmgr.entity.Manhaur;
import cn.com.gei.kmp4.kaoqinmgr.entity.ManhaurFormLock;
import cn.com.gei.kmp4.kaoqinmgr.entity.ManhaurWeekForm;
import cn.com.gei.kmp4.kaoqinmgr.entity.SubprojectManhaur;
import cn.com.gei.kmp4.kaoqinmgr.utils.NumberUtils;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.KaoqinDailyInfoWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.KaoqinProForDeptWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.KaoqinProForPersonWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.ManhaurWeekFormWrapper;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.ProjectManhaur;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.UserMonthManhaurWrapper;

@Service("kaoqinService")
@Transactional(propagation = Propagation.REQUIRED)
public class KaoqinService implements IKaoqinService {
	@Autowired
	private IKaoqinDailyDetailDao kaoqinDailyDetailDao;

	@Autowired
	private IKaoqinDailyInfoDao kaoqinDailyInfoDao;

	@Autowired
	private IManhaurWeekFormDao manhaurWeekFormDao;

	@Autowired
	private IManhaurDao manhaurDao;

	@Autowired
	private ISubprojectManhaurDao subprojectManhaurDao;

	@Autowired
	private IManhaurFormLockDao manhaurFormLockDao;

	@Autowired
	private IAdjustLaborTimeRecordDao adjustLaborTimeRecordDao;

	@Autowired
	private IKaoqinProjectDao kaoqinProjectDao;

	@Override
	public KaoqinDailyDetail findDailyDetailById(String unid) {
		if (StringUtils.isBlank(unid))
			return null;
		return kaoqinDailyDetailDao.findById(unid);
	}

	@Override
	public KaoqinDailyDetail findDailyDetailByEmpIdAndDate(String employeeId, Date statDate) {
		if (StringUtils.isBlank(employeeId) || statDate == null)
			return null;

		List<KaoqinDailyDetail> kdds = kaoqinDailyDetailDao.findByEmployeeAndDate(employeeId,
				NumberUtils.formateDate(statDate));

		if (kdds != null && !kdds.isEmpty())
			return kdds.get(0);

		return null;
	}

	@Override
	public KaoqinDailyInfo findDailyInfoById(String unid) {
		if (StringUtils.isBlank(unid))
			return null;
		return kaoqinDailyInfoDao.findKDIById(unid);
	}

	@Override
	public KaoqinDailyInfo findDailyInfoByEmpAndDate(String employeeId, Date statDate) {
		if (StringUtils.isBlank(employeeId) || statDate == null)
			return null;
		List<KaoqinDailyInfo> kdis = kaoqinDailyInfoDao.findKDIByEmployeeAndDate(employeeId,
				NumberUtils.formateDate(statDate));
		if (kdis != null && !kdis.isEmpty())
			return kdis.get(0);
		return null;
	}

	@Override
	public List<KaoqinDailyInfoWrapper> findDailyInfoForSearch(String employeeId, Date timeStart, Date timeEnd,
			String status, String deptId, String kaoqinStatus, int offset, int count) {
		if ("Y".equals(status)) {
			status = "正常";
		} else if ("N".equals(status)) {
			status = "异常";
		} else {
			status = "";
		}
		return kaoqinDailyInfoDao.findKDIForSearch(employeeId, NumberUtils.formateDate(timeStart),
				NumberUtils.formateDate(timeEnd), status, deptId, kaoqinStatus, offset, count);
	}

	@Override
	public ManhaurWeekForm findWeekFormById(String unid) {
		if (StringUtils.isBlank(unid))
			return null;
		return manhaurWeekFormDao.findMWFById(unid);
	}

	@Override
	public List<ManhaurWeekFormWrapper> findWeekFormForSearch(String withManhaurDetail, String deptId,
			String employeeId, Date timeStart, Date timeEnd, String status, int offset, int count) {
		if (StringUtils.isBlank(withManhaurDetail)) {
			withManhaurDetail = "Y";
		}
		return manhaurWeekFormDao.findMWFForSearch(withManhaurDetail, deptId, employeeId,
				NumberUtils.formateDate(timeStart), NumberUtils.formateDate(timeEnd), status, offset, count);
	}

	@Override
	public Manhaur findManhaurById(String unid) {
		if (StringUtils.isBlank(unid))
			return null;
		return manhaurDao.findMById(unid);
	}

	@Override
	public List<Manhaur> findManhaurForSearch(String employeeId, Date timeStart, Date timeEnd, String affairId,
			int offset, int count) {
		return manhaurDao.findMForSearch(employeeId, NumberUtils.formateDate(timeStart),
				NumberUtils.formateDate(timeEnd), affairId, offset, count);
	}

	@Override
	public List<SubprojectManhaur> findSubManhaurForSearch(String parentManhaurId, String employeeId, Date timeStart,
			Date timeEnd, String affairId) {

		return subprojectManhaurDao.findSubMForSearch(parentManhaurId, employeeId, NumberUtils.formateDate(timeStart),
				NumberUtils.formateDate(timeEnd), affairId);
	}

	@Override
	public List<ManhaurWeekFormWrapper> findManhaurByMonth(int timeYear, Integer timeMonth, String deptId,
			String employeeId) {
		if (timeMonth != null && timeMonth > 0) {
			Calendar time = Calendar.getInstance();
			time.set(Calendar.YEAR, timeYear);
			time.set(Calendar.MONTH, timeMonth - 1);
			String endTime = NumberUtils.format(time.getTime()) + "-25";
			time.add(Calendar.MONTH, -1);
			String startTime = NumberUtils.format(time.getTime()) + "-26";
			return manhaurWeekFormDao.findMonthManhaur(startTime, endTime, timeYear, timeMonth, deptId, employeeId);
		} else {
			return manhaurWeekFormDao.findMonthManhaur(null, null, timeYear, null, deptId, employeeId);
		}
	}

	@Override
	public void deleteManhaurByMF(ManhaurWeekForm manhaurForm) {
		if (manhaurForm == null) {
			return;
		}
		Date beginDate = manhaurForm.getBeginDate();
		Date endDate = manhaurForm.getEndDate();
		if (beginDate != null && endDate != null && manhaurForm.getEmployeeId() != null) {
			String timeStart = NumberUtils.formateDate(beginDate);
			String timeEnd = NumberUtils.formateDate(endDate);
			// 获取已保存数据
			manhaurDao.deleteManhaurByEmpAndTime(manhaurForm.getEmployeeId(), timeStart, timeEnd);
			subprojectManhaurDao.deleteSubManhaurByEmpAndTime(manhaurForm.getEmployeeId(), timeStart, timeEnd);
		}

	}

	@Override
	public void saveSubProjectManhaur(SubprojectManhaur subprojectManhaur) {
		subprojectManhaurDao.saveSubProjectManhaur(subprojectManhaur);
	}

	@Override
	public void saveProjectManhaur(Manhaur manhaur) {
		manhaurDao.saveProjectManhaur(manhaur);
	}

	@Override
	public ManhaurFormLock findManhaurFormLockByTime(String year, String month) {
		if (StringUtils.isBlank(year) || StringUtils.isBlank(month)) {
			return null;
		}
		List<ManhaurFormLock> mfls = manhaurFormLockDao.findMFLByTime(year, month);
		if (mfls != null && !mfls.isEmpty()) {
			return mfls.get(0);
		}
		return null;
	}

	@Override
	public List<ProjectManhaur> findAffairManhaurByYear(String personId, String manhaurYear) {
		if (StringUtils.isBlank(personId) || StringUtils.isBlank(manhaurYear))
			return Collections.emptyList();
		return manhaurDao.findAffairMByYear(personId, manhaurYear);
	}

	@Override
	public KaoqinProForPersonWrapper findProByYearAndMonth(String userId, Integer year, Integer month, String enable) {
		List<KaoqinProForPersonWrapper> list = adjustLaborTimeRecordDao.findProByYearAndMonth(userId, year, month,
				enable);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<KaoqinProForDeptWrapper> finProByDept(String orgId, Integer year, Integer month) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nowYear", year);
		map.put("nowMonth", month);
		map.put("preYear", year);
		map.put("preMonth", month - 1);
		map.put("nextYear", year);
		map.put("nextMonth", month + 1);
		if (month == 1) {
			map.put("preYear", year - 1);
			map.put("preMonth", 12);
		}
		if (month == 12) {
			map.put("nextYear", year + 1);
			map.put("nextMonth", 1);
		}
		map.put("orgId", orgId);
		return adjustLaborTimeRecordDao.findProByDept(map);
	}

	@Override
	public List<KaoqinProject> findAllPro() {
		return kaoqinProjectDao.findAllPro();
	}

	@Override
	public void updatePro(String userId, Integer year, Integer month, String kaoqinProjectId) {
		List<AdjustLaborTimeRecord> adjustLaborTimeRecords = adjustLaborTimeRecordDao.findPersonPro(userId, year,
				month);
		if (adjustLaborTimeRecords == null || adjustLaborTimeRecords.isEmpty())
			return;
		AdjustLaborTimeRecord adjustLaborTimeRecord = adjustLaborTimeRecords.get(0);
		if (adjustLaborTimeRecord != null) {
			adjustLaborTimeRecord.setKaoqinProjectId(kaoqinProjectId);
			adjustLaborTimeRecordDao.modifPro(adjustLaborTimeRecord);
		} else {
			adjustLaborTimeRecord = new AdjustLaborTimeRecord();
			adjustLaborTimeRecord.setUnid(UUID.randomUUID().toString());
			adjustLaborTimeRecord.setUserId(userId);
			adjustLaborTimeRecord.setYear(year);
			adjustLaborTimeRecord.setMonth(month);
			adjustLaborTimeRecord.setKaoqinProjectId(kaoqinProjectId);
			adjustLaborTimeRecord.setCreatedTime(new Date());
			adjustLaborTimeRecord.setEnable("是");
			adjustLaborTimeRecordDao.savePro(adjustLaborTimeRecord);
		}
	}

	@Override
	public List<UserMonthManhaurWrapper> findUserMonthManhaurs(String deptId, String year, String month) {
		if (StringUtils.isBlank(year) || StringUtils.isBlank(month))
			return Collections.emptyList();
		Calendar time = Calendar.getInstance();
		time.set(Calendar.YEAR, Integer.parseInt(year));
		time.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		String endTime = NumberUtils.format(time.getTime()) + "-25";
		time.add(Calendar.MONTH, -1);
		String startTime = NumberUtils.format(time.getTime()) + "-26";
		return manhaurWeekFormDao.findUserMonthManhaurs(startTime, endTime, deptId, year, month);
	}
}
