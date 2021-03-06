package com.funding.service.admin;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.funding.dto.ProjectVO;
import com.funding.request.AdminDetailPageMaker;
import com.funding.request.AdminProjectSearchCriteria;

public interface AdminProjectManageService {

	//문자 알림용(종료된 프로젝트 리스트)
	List<ProjectVO> getFinishProjectList() throws SQLException;
	
	//프로젝트 리스트 조회 + 검색
	Map<String, Object> getSearchProjectList(AdminProjectSearchCriteria cri) throws SQLException;

	//프로젝트 상세보기
	Map<String, Object> getProject(AdminDetailPageMaker pageMaker, int pjt_num) throws SQLException;

	//프로젝트 승인/보류 하기
	void modifyProjectState(ProjectVO project) throws SQLException;

	//프로젝트 정산 완료 처리 하기
	void modifyProjectCalcDate(int pjt_num) throws SQLException;
	
	//프로젝트 대출 상환 완료 처리 하기
	void modifyProjectRepayDate(int pjt_num) throws SQLException;
	
	//프로젝트 정산/상환 여부 코드 변경 하기
	void modifyProjectCalculateCode(ProjectVO project) throws SQLException;
	
	//프로젝트 추천하기
	void modifyProjectThumbsUp(ProjectVO project) throws SQLException;
	
	//프로젝트 활성화 여부
	void modifyProjectEnabled(ProjectVO project) throws SQLException;
	
	//프로젝트 상세 페이지 내에 있는 결제 내역 대출 상환 완료 처리
	void updateRepayment(int pjt_pay_num) throws SQLException;

}
