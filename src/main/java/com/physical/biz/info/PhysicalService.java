package com.physical.biz.info;

import java.util.List;

public interface PhysicalService {

	// 신체 정보 등록
	void insertPhysical(PhysicalVO vo);
	
	// 신체 정보 수정
	void updatePhysical(PhysicalVO vo);

	// 신체 정보 삭제
	void deletePhysical(PhysicalVO vo);
	
	// 신체 정보 조회
	PhysicalVO getPhysical(PhysicalVO vo);
	
	// 신체 정보 리스트 조회
	List<PhysicalVO> getPhysicalList(PhysicalVO vo);
}
