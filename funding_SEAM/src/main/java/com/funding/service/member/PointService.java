package com.funding.service.member;

import java.sql.SQLException;

import com.funding.dto.PointVO;

public interface PointService {

	public int getPointByMemNum(int mem_num)throws SQLException;
	public void usePoint(PointVO point)throws SQLException;
	
	public void savePoint(PointVO point)throws SQLException;
	public void deletePointByMemNum(int mem_num) throws SQLException;
}
