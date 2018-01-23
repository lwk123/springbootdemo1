package cn.com.gei.kmp4.kaoqinmgr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.gei.kmp4.kaoqinmgr.dao.IEvectionDao;
import cn.com.gei.kmp4.kaoqinmgr.wrapper.EvectionWrapper;

@Service("evectionService")
@Transactional(propagation = Propagation.REQUIRED)
public class EvectionService implements IEvectionService {

	@Autowired
	private IEvectionDao evectionDao;

	@Override
	public List<EvectionWrapper> findEvectionByUser(String empId, String searchStartTime, String searchEndTime) {
		return evectionDao.findEvectionByUser(empId, searchStartTime, searchEndTime);
	}

}
