package com.physical.biz.info;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PhysicalServiceClient {

	public static void main(String[] args) {
		// 1. spring 컨테이너 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. spring 컨테이너로부터 PhysicalServiceImpl 객체를 Lookup
		PhysicalService physicalService = (PhysicalService) container.getBean("physicalService");
		
		// 3. 글 등록 테스트
		PhysicalVO vo = new PhysicalVO();
		vo.setWeight("170");
		vo.setHeight("65");
		vo.setBlood("A");
		vo.setGender("남");
		physicalService.insertPhysical(vo);
		
		// 4. 신체 정보 목록 검색 기능 테스트
		List<PhysicalVO> physicalList = physicalService.getPhysicalList(vo);
		for(PhysicalVO physical : physicalList) {
			System.out.println("---> " + physical.toString());
		}
		
		
		// 5.spring 컨테이너 종료
		container.close();
	}

}
