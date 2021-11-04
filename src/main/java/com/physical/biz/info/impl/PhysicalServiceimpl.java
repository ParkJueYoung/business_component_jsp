package com.physical.biz.info.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.physical.biz.common.Log4jAdvice;
import com.physical.biz.common.LogAdvice;
import com.physical.biz.info.PhysicalService;
import com.physical.biz.info.PhysicalVO;

@Service("physicalService")
public class PhysicalServiceimpl implements PhysicalService{
	@Autowired
	private PhysicalDAO physicalDAO;
//	private LogAdvice log;
//	private Log4jAdvice log;
	
	
	@Override
	public void insertPhysical(PhysicalVO vo) {
		physicalDAO.insertPhysical(vo);
	}

	@Override
	public void updatePhysical(PhysicalVO vo) {
		physicalDAO.updatePhysical(vo);
		
	}

	@Override
	public void deletePhysical(PhysicalVO vo) {
		physicalDAO.deletePhysical(vo);
		
	}

	@Override
	public PhysicalVO getPhysical(PhysicalVO vo) {
		return physicalDAO.getPhysical(vo);
	}

	@Override
	public List<PhysicalVO> getPhysicalList(PhysicalVO vo) {
		return physicalDAO.getPhysicalList(vo);
	}
}
