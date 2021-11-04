package com.physical.biz.info.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.physical.biz.info.PhysicalVO;

@Repository
public class PhysicalDAOSpring{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String PHYSICAL_INSERT = "insert into physical(seq, weight, height, blood, gender) values((select nvl(max(seq), 0)+1 from physical),?,?,?,?)";
	private final String PHYSICAL_UPDATE = "update into physical set weight = ? height = ?";
	private final String PHYSICAL_DELETE = "delete physical where seq = ?";
	private final String PHYSICAL_GET = "select * from physical where seq = ?";
	private final String PHYSICAL_LIST = "select * from physical order by seq desc";
	
	// 신체정보 등록
	public void insertPhysical(PhysicalVO vo) {
		System.out.println("===> JDBC로 insertPhysical() 기능 처리");
		jdbcTemplate.update(PHYSICAL_INSERT, vo.getWeight(), vo.getHeight(), vo.getBlood(), vo.getGender());
	}
	
	public void updatePhysical(PhysicalVO vo) {
		System.out.println("===> JDBD로 updatePhysical() 기능 처리");
		jdbcTemplate.update(PHYSICAL_UPDATE, vo.getWeight(), vo.getHeight());
	}
	
	public void deletePhysical(PhysicalVO vo) {
		System.out.println("===> JDBC로 deletePhysical() 기능 처리");
		jdbcTemplate.update(PHYSICAL_DELETE, vo.getSeq());
	}
	
	public PhysicalVO getPhysical(PhysicalVO vo) {
		System.out.println("===> JDBC로 getPhysical() 기능 처리");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(PHYSICAL_GET, args, new PhysicalRowMapper());
	}
	
	public List<PhysicalVO> getPhysicalList(PhysicalVO vo){
		System.out.println("===> JDBC로 getPhysicalList() 기능 처리");
		return jdbcTemplate.query(PHYSICAL_LIST, new PhysicalRowMapper());
	}

	class PhysicalRowMapper implements RowMapper<PhysicalVO>{
		public PhysicalVO mapRow(ResultSet rs, int rowNum) throws SQLException{
			PhysicalVO physical = new PhysicalVO();
			physical.setSeq(rs.getInt("SEQ"));
			physical.setWeight(rs.getString("WEIGHT"));
			physical.setHeight(rs.getString("HEIGHT"));
			physical.setBlood(rs.getString("BLOOD"));
			physical.setGender(rs.getString("GENDER"));
			physical.setRegDate(rs.getDate("REGDATE"));
			
			return physical;
		}
	}
}
