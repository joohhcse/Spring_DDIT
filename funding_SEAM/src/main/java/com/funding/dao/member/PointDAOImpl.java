package com.funding.dao.member;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.funding.dto.PointVO;

public class PointDAOImpl implements PointDAO {
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int getPoint(int mem_num) throws SQLException {
		int point = sqlSession.selectOne("Point-Mapper.getPoint",mem_num);
		return point;
	}

	@Override
	public void usePoint(PointVO point) throws SQLException {
		sqlSession.update("Point-Mapper.usePoint",point);
	}

	@Override
	public void savePoint(PointVO point) throws SQLException {
		sqlSession.update("Point-Mapper.savePoint",point);
	}

	@Override
	public void deletePoint(int mem_num) throws SQLException {
		sqlSession.update("Point-Mapper.deletePoint", mem_num);
	}

}
