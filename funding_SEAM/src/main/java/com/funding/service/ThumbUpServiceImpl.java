package com.funding.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dao.ThumbUpDAO;
import com.funding.dto.Thumb_upVO;

public class ThumbUpServiceImpl implements ThumbUpService {

	@Autowired
	private ThumbUpDAO thumbUpDAO;
	public void setThumbUpDAO(ThumbUpDAO thumbUpDAO) {
		this.thumbUpDAO = thumbUpDAO;
	}
	
	private ProjectProposeService proposeService;
	
	public void setProposeService(ProjectProposeService proposeService) {
		this.proposeService = proposeService;
	}
	
	@Override
	public Thumb_upVO selectThumbUpForPJTPRP(Thumb_upVO thumbUp) throws SQLException {
		Thumb_upVO selectedThumbUp = thumbUpDAO.selectThumbUpForPJTPRP(thumbUp);
		return selectedThumbUp;
	}

	@Override
	public Thumb_upVO selectThumbUpForPJTPRP_CMTS(Thumb_upVO thumbUp) throws SQLException {
		Thumb_upVO selectedThumbUp = thumbUpDAO.selectThumbUpForPJTPRP_CMTS(thumbUp);
		return selectedThumbUp;
	}

	@Override
	public Thumb_upVO selectThumbUpForFreeBoard(Thumb_upVO thumbUp) throws SQLException {
		Thumb_upVO selectedThumbUp = thumbUpDAO.selectThumbUpForFreeBoard(thumbUp);
		return selectedThumbUp;
	}

	@Override
	public Thumb_upVO selectThumbUpForFreeBoard_CMTS(Thumb_upVO thumbUp) throws SQLException {
		Thumb_upVO selectedThumbUp = thumbUpDAO.selectThumbUpForFreeBoard_CMTS(thumbUp);
		return selectedThumbUp;
	}

	@Override
	public void registThumbUpForPJTPRP(Thumb_upVO thumbUp) throws SQLException {
		int pjtprp_num = thumbUp.getPjtprp_num();
		proposeService.proposeLikePlusCnt(pjtprp_num);
		thumbUpDAO.registThumbUpForPJTPRP(thumbUp);
	}

	@Override
	public void registThumbUpForPJTPRP_CMTS(Thumb_upVO thumbUp) throws SQLException {
		thumbUpDAO.registThumbUpForPJTPRP_CMTS(thumbUp);
	}

	@Override
	public void registThumbUpForFreeBoard(Thumb_upVO thumbUp) throws SQLException {
		thumbUpDAO.registThumbUpForFreeBoard(thumbUp);
	}

	@Override
	public void registThumbUpForFreeBoard_CMTS(Thumb_upVO thumbUp) throws SQLException {
		thumbUpDAO.registThumbUpForFreeBoard_CMTS(thumbUp);
	}

	@Override
	public void removeThumbUp(int thumbup_num) throws SQLException {
		thumbUpDAO.removeThumbUp(thumbup_num);
	}

}
