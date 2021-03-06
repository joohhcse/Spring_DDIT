package com.funding.dao;

import java.sql.SQLException;
import java.util.List;

import com.funding.dto.QnAVO;
import com.funding.request.SearchCriteria;

public interface QnADAO {

	// 전체 글 리스트
	List<QnAVO> selectQnAList(SearchCriteria cri) throws SQLException;
	
	int selectSearchQnAListTotalCount(SearchCriteria cri)throws SQLException;
	
	//관리자 외 사용자 리스트 조회(disabled된 글 제외한 모든 데이터)
	List<QnAVO> selectQnAListExptDisabled(SearchCriteria cri)throws SQLException;
	
	int selectSearchQnAListTotalCountExptDisabled(SearchCriteria cri)throws SQLException;

	// 글번호로 글의 상세조회
	QnAVO selectQnAByqna_Num(int qna_num) throws SQLException;

	// 질문 등록 비밀글
	void registQnA(QnAVO qna) throws SQLException;
	
	// 질문 등록 일반글
	void registQnAnone(QnAVO qna) throws SQLException;
	
	// 답변 등록
	void registCmts(QnAVO qna) throws SQLException;

	// 질문 수정
	void modifyQnA(QnAVO qna) throws SQLException;
	
	//답글 수정
	void modifyCmts(QnAVO qna) throws SQLException;
	
	// 질문 삭제
	void removeQnA(int qna_num) throws SQLException;
	
	void removeCmts(int qna_cmts_num)throws SQLException;

	// 조회수 증가
	void increaseQnAViewCnt(int qna_num) throws SQLException;

	// 시퀀스넘버 가져오기
	int selectQnASeqNext() throws SQLException;
	
	//답글 리스트
	List<QnAVO> selectQnACmtsList(int qna_num)throws SQLException;
	
	QnAVO countQnACmts(int qna_cmts_num)throws SQLException;
	
	// 게시글 활성
	void checkQnAEnabled(int qna_num)throws SQLException;
	// 게시글 비활성
	void checkQnADisabled(int qna_num)throws SQLException;
	
	
	
	

		
}
