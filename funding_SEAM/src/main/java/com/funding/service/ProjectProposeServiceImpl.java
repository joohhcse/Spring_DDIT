package com.funding.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.funding.dao.ProjectProposeDAO;
import com.funding.dao.ProposeCmtDAO;
import com.funding.dto.Project_ProposeVO;
import com.funding.dto.Thumb_upVO;
import com.funding.request.PageMaker;
import com.funding.request.SearchCriteria;

public class ProjectProposeServiceImpl implements ProjectProposeService{

	private ProjectProposeDAO proposeDAO;
	
	private ProposeCmtDAO cmtDAO;
	
	public void setCmtDAO(ProposeCmtDAO cmtDAO) {
		this.cmtDAO = cmtDAO;
	}
	
	public void setProposeDAO(ProjectProposeDAO proposeDAO) {
		this.proposeDAO = proposeDAO;
	}
	
	@Override
	public Map<String, Object> getProposeList(SearchCriteria cri) throws SQLException {
		List<Project_ProposeVO> list = proposeDAO.proposeList(cri);
		Map<String,Object> dataMap = new HashMap<String, Object>();
		
		int totalCount = proposeDAO.proposeListCount(cri);
		for(Project_ProposeVO propose : list) {
			int cmt_count = cmtDAO.selectCmtCount(propose.getPjtprp_num());
			propose.setCmt_count(cmt_count);
		}
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("propose", list);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}

	@Override
	public int nextSeq() throws SQLException {
		int seq = proposeDAO.selectProposeSeqNext();
		return seq;
	}

	@Override
	public int selectMemberNum(String mem_name) throws SQLException {
		int num = proposeDAO.selectMemberNum(mem_name);
		return num;
	}

	@Override
	public void insertPropose(Project_ProposeVO propose) throws SQLException {
		proposeDAO.insertPropose(propose);
		
	}

	@Override
	public Project_ProposeVO selectProposeBy_num(int pjtprp_num) throws SQLException {
		proposeDAO.increaseViewCnt(pjtprp_num);
		Project_ProposeVO propose=proposeDAO.selectProposeBy_num(pjtprp_num);
		return propose;
	}

	@Override
	public void updatePropose(Project_ProposeVO propose) throws SQLException {
		proposeDAO.updatePropose(propose);
		
	}

	@Override
	public void deletePropose(int pjtprp_num) throws SQLException {
		proposeDAO.deletePropose(pjtprp_num);
		
	}

	@Override
	public void disabledPropose(int pjtprp_num) throws SQLException {
		proposeDAO.disabledPropose(pjtprp_num);
		
	}

	@Override
	public void enabledPropose(int pjtprp_num) throws SQLException {
		proposeDAO.enabledPropose(pjtprp_num);
		
	}

	@Override
	public int selectEnabled(int pjtprp_num) throws SQLException {
		int num = proposeDAO.selectEnabled(pjtprp_num);
		return num;
	}

	@Override
	public void listDisabledPropose(int pjtprp_num) throws SQLException {
		proposeDAO.listDisabledPropose(pjtprp_num);
		
	}

	@Override
	public Project_ProposeVO selectProposeBynum(int pjtprp_num) throws SQLException {
		Project_ProposeVO propose=proposeDAO.selectProposeBy_num(pjtprp_num);
		return propose;
	}

	@Override
	public List<Thumb_upVO> selectLikeClick(int mem_num) throws SQLException {
		List<Thumb_upVO> likeList = proposeDAO.selectLikeClick(mem_num);
		return likeList;
	}

	@Override
	public void proposeLikePlusCnt(int pjtprp_num) throws SQLException {
		proposeDAO.proposeLikePlusCnt(pjtprp_num);
		
	}

	@Override
	public void proposeLikeMinusCnt(int pjtprp_num) throws SQLException {
		proposeDAO.proposeLikeMinusCnt(pjtprp_num);
	}

	@Override
	public Project_ProposeVO checkTodayRegist(int mem_num) throws SQLException {
		Project_ProposeVO propose = proposeDAO.checkTodayRegist(mem_num);
		return propose;
	}

	@Override
	public List<Project_ProposeVO> selectLikeDesc() throws SQLException {
		List<Project_ProposeVO> list = proposeDAO.selectLikeDesc();
		for(Project_ProposeVO propose : list) {
			int cmt_count = cmtDAO.selectCmtCount(propose.getPjtprp_num());
			propose.setCmt_count(cmt_count);
		}
		return list;
	}

	@Override
	public void successPropose(int pjtprp_num) throws SQLException {
		proposeDAO.successPropose(pjtprp_num);
		
	}

	@Override
	public Project_ProposeVO proposeByNum(int pjtprp_num) throws SQLException {
		Project_ProposeVO propose = proposeDAO.proposeByNum(pjtprp_num);
		return propose;
	}

	

	
}
