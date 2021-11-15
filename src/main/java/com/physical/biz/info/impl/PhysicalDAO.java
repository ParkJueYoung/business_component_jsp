package com.physical.biz.info.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.physical.biz.common.JDBCUtil;
import com.physical.biz.info.PhysicalVO;

@Repository("physicalDAO")
public class PhysicalDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private final String PHYSICAL_INSERT = "insert into physical(seq, height, weight, blood, gender) values((select nvl(max(seq), 0)+1 from physical),?,?,?,?)";
	private final String PHYSICAL_UPDATE = "update physical set height = ?, weight = ? where seq = ?";
	private final String PHYSICAL_DELETE = "delete physical where seq = ?";
	private final String PHYSICAL_GET = "select * from physical where seq = ?";
	private final String PHYSICAL_LIST = "select * from physical order by seq desc";

	// 신체정보 등록
	public void insertPhysical(PhysicalVO vo) {
		System.out.println("===> JDBC로 insertphysical() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PHYSICAL_INSERT);
			stmt.setString(1, vo.getHeight());
			stmt.setString(2, vo.getWeight());
			stmt.setString(3, vo.getBlood());
			stmt.setString(4, vo.getGender());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 신체 정보 변경
	public void updatePhysical(PhysicalVO vo) {
		System.out.println("===> JDBC로 updatePhysical() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PHYSICAL_UPDATE);
			stmt.setString(1, vo.getHeight());
			stmt.setString(2, vo.getWeight());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
			System.out.println("정상작동");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 신체 정보 삭제
	public void deletePhysical(PhysicalVO vo) {
		System.out.println("===> JDBC로 deletePhysical() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PHYSICAL_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 신체 정보 조회
	public PhysicalVO getPhysical(PhysicalVO vo) {
		System.out.println("===> JDBC로 getPhysical() 기능 처리");
		PhysicalVO physical = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PHYSICAL_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if (rs.next()) {
				physical = new PhysicalVO();
				physical.setSeq(rs.getInt("SEQ"));
				physical.setWeight(rs.getString("WEIGHT"));
				physical.setHeight(rs.getString("HEIGHT"));
				physical.setBlood(rs.getString("BLOOD"));
				physical.setGender(rs.getString("GENDER"));
				physical.setRegDate(rs.getDate("REGDATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return physical;
	}

	// 신체 정보 리스트
	public List<PhysicalVO> getPhysicalList(PhysicalVO vo) {
		System.out.println("===> getPhysicalList() 기능 처리");
		List<PhysicalVO> physicalList = new ArrayList<PhysicalVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(PHYSICAL_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				PhysicalVO physical = new PhysicalVO();
				physical.setSeq(rs.getInt("SEQ"));
				physical.setWeight(rs.getString("WEIGHT"));
				physical.setHeight(rs.getString("HEIGHT"));
				physical.setBlood(rs.getString("BLOOD"));
				physical.setGender(rs.getString("GENDER"));
				physical.setRegDate(rs.getDate("REGDATE"));
				physicalList.add(physical);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return physicalList;
	}
}
