package com.funding.service.freeboard;

import java.sql.SQLException;
import java.util.List;

import com.funding.dto.FreeBoardCmtsVO;
import com.funding.dto.FreeBoardVO;

public interface FreeBoardCmtsService {
	
	//댓글 리스트 조회
	List<FreeBoardCmtsVO> getFreeBoardCmtsList(int free_num) throws SQLException;
	
	//댓글 조회
	FreeBoardCmtsVO selectFreeBoardCmts(int free_cmts_num)	throws SQLException;
	
	//등록
	void regist(FreeBoardCmtsVO freeBoardCmts) throws SQLException;
		
	//수정
	void modify(FreeBoardCmtsVO freeBoardCmts) throws SQLException;
	
	//댓글 권한 수정
	void modifyEnabled(FreeBoardCmtsVO freeBoardCmts) throws SQLException;
	
	//삭제
	void remove(int free_cmts_num) throws SQLException;
	
	//좋아요 개수 변경
	void modifyFreeCmtsLike(int free_cmts_num, String str) throws SQLException;
	
}
