package com.funding.service.project;

import java.sql.SQLException;

import com.funding.dto.Interest_pjtVO;

public interface Interest_pjtService {
	
	public void interestPjt(Interest_pjtVO interest_pjt)throws SQLException;
	public void interestPjtCancle(Interest_pjtVO interest_pjt)throws SQLException;
	public void interestPjtCancleByIntPjtNum(Interest_pjtVO interest_pjt)throws SQLException;
	public Interest_pjtVO getInterestPjt(Interest_pjtVO interest_pjt)throws SQLException;

}
