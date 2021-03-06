package com.funding.dao.admin;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.funding.dto.ProjectVO;
import com.funding.dto.Project_state_codeVO;
import com.funding.dto.Project_type_codeVO;
import com.funding.request.AdminDetailPageMaker;
import com.funding.request.AdminMemberDetailRequest;
import com.funding.request.AdminProjectRequest;
import com.funding.request.AdminProjectSearchCriteria;

public class AdminProjectManageDAOImpl implements AdminProjectManageDAO {

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<ProjectVO> selectFinishProjectList() throws SQLException {
		List<ProjectVO> finishProjectList = sqlSession.selectList("Admin-Mapper.selectFinishProjectList");
		return finishProjectList;
	}
	
	@Override
	public List<Project_type_codeVO> selectPjtTypeCode() throws SQLException {
		List<Project_type_codeVO> pjtTypeCodeList = sqlSession.selectList("Admin-Mapper.selectPjtTypeCode");
		return pjtTypeCodeList;
	}

	@Override
	public List<Project_state_codeVO> selectPjtStateCode() throws SQLException {
		List<Project_state_codeVO> pjtStateCodeList = sqlSession.selectList("Admin-Mapper.selectPjtStateCode");
		return pjtStateCodeList;
	}

	@Override
	public List<AdminProjectRequest> selectSearchProjectList(AdminProjectSearchCriteria cri) throws SQLException {
		int offset=cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();
		RowBounds rowBounds= new RowBounds(offset,limit);
		List<AdminProjectRequest> projectList = sqlSession.selectList("Admin-Mapper.selectSearchProjectList", cri, rowBounds);
		return projectList;
	}
	
	@Override
	public List<AdminProjectRequest> selectSearchProjectListForDownload(AdminProjectSearchCriteria cri) throws SQLException {
		List<AdminProjectRequest> projectListForDownload = sqlSession.selectList("Admin-Mapper.selectSearchProjectList", cri);
		return projectListForDownload;
	}

	@Override
	public int selectSearchProjectListTotalCount(AdminProjectSearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("Admin-Mapper.selectSearchProjectListTotalCount", cri);
		return count;
	}

	@Override
	public int selectStateToStandByTotalCount() throws SQLException {
		int count = sqlSession.selectOne("Admin-Mapper.selectStateToStandByTotalCount");
		return count;
	}

	@Override
	public int selectCalcToStandByTotalCount() throws SQLException {
		int count = sqlSession.selectOne("Admin-Mapper.selectCalcToStandByTotalCount");
		return count;
	}

	@Override
	public AdminProjectRequest selectProjectByPjtNum(int pjt_num) throws SQLException {
		AdminProjectRequest project = sqlSession.selectOne("Admin-Mapper.selectProjectByPjtNum", pjt_num);
		return project;
	}

	@Override
	public List<AdminMemberDetailRequest> selectProjectPayByPjtNum(AdminDetailPageMaker pageMaker, int pjt_num) throws SQLException {
		int offset=pageMaker.getPageStartRowNum();
		int limit=pageMaker.getPerPageNum();
		RowBounds rowBounds= new RowBounds(offset,limit);
		List<AdminMemberDetailRequest> listOfParticipationInProject = sqlSession.selectList("Admin-Mapper.selectProjectPayByPjtNum", pjt_num, rowBounds);
		return listOfParticipationInProject;
	}

	@Override
	public List<AdminMemberDetailRequest> selectProjectPayByPjtNumForDownload(int pjt_num) throws SQLException {
		List<AdminMemberDetailRequest> listOfParticipationInProjectForDownload = sqlSession.selectList("Admin-Mapper.selectProjectPayByPjtNum", pjt_num);
		return listOfParticipationInProjectForDownload;
	}

	@Override
	public int selectProjectPayByPjtNumTotalCount(int pjt_num) throws SQLException {
		int count = sqlSession.selectOne("Admin-Mapper.selectProjectPayByPjtNumTotalCount", pjt_num);
		return count;
	}

	@Override
	public List<AdminProjectRequest> selectCalcToStandByList() throws SQLException {
		List<AdminProjectRequest> calcToStandByList = sqlSession.selectList("Admin-Mapper.selectCalcToStandByList");
		return calcToStandByList;
	}

	@Override
	public List<ProjectVO> selectProjectListInProgress() throws SQLException {
		List<ProjectVO> projectInProgressList = sqlSession.selectList("Admin-Mapper.selectProjectListInProgress");
		return projectInProgressList;
	}

	@Override
	public List<AdminProjectRequest> selectStandByToCalcList() throws SQLException {
		List<AdminProjectRequest> standByToCalcList = sqlSession.selectList("Admin-Mapper.selectStandByToCalcList");
		return standByToCalcList;
	}
	
	@Override
	public void modifyProjectState(ProjectVO project) throws SQLException {
		sqlSession.update("Admin-Mapper.modifyProjectState", project);
	}

	@Override
	public void modifyProjectCalcDate(int pjt_num) throws SQLException {
		sqlSession.update("Admin-Mapper.modifyProjectCalcDate", pjt_num);
	}

	@Override
	public void modifyProjectRepayDate(int pjt_num) throws SQLException {
		sqlSession.update("Admin-Mapper.modifyProjectRepayDate", pjt_num);
	}
	
	@Override
	public void modifyProjectCalculateCode(ProjectVO project) throws SQLException {
		sqlSession.update("Admin-Mapper.modifyProjectCalculateCode", project);
	}
	
	@Override
	public void modifyProjectThumbsUp(ProjectVO project) throws SQLException {
		sqlSession.update("Admin-Mapper.modifyProjectThumbsUp", project);
	}

	@Override
	public void modifyProjectEnabled(ProjectVO project) throws SQLException {
		sqlSession.update("Admin-Mapper.modifyProjectEnabled", project);
	}

	@Override
	public void updateRepayment(int pjt_pay_num) throws SQLException {
		sqlSession.update("Admin-Mapper.updateRepayment", pjt_pay_num);
	}

}
