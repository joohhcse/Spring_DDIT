package com.funding.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.funding.dto.NoticeVO;
import com.funding.request.SearchCriteria;

public class NoticeDAOImpl implements NoticeDAO{
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<NoticeVO> searchedNoticeList(SearchCriteria cri) throws SQLException {
		// 검색->조회 (검색조건 없으면 전체 리스트 출력)
		int offset=cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();
		RowBounds rowBounds= new RowBounds(offset,limit);
		
		List<NoticeVO> noticeList = sqlSession.selectList("notice-mapper.searchedNoticeList",cri,rowBounds);
		return noticeList;
	}

	@Override
	public int searchedNoticeListCount(SearchCriteria cri) throws SQLException {
		// 검색결과의 개수
		int count = sqlSession.selectOne("notice-mapper.searchedNoticeListCount",cri);
		return count;
	}
	
	@Override
	public List<NoticeVO> selectPointNoticeList(SearchCriteria cri) throws SQLException {
		List<NoticeVO> noticeList = sqlSession.selectList("notice-mapper.selectPointNoticeList",cri);
		return noticeList;
	}

	@Override
	public NoticeVO selectNoticeByNotice_num(int notice_num) throws SQLException {
		NoticeVO notice = sqlSession.selectOne("notice-mapper.selectNoticeByNotice_num",notice_num);
		return notice;
	}

	@Override
	public void insertNotice(NoticeVO notice) throws SQLException {
		sqlSession.update("notice-mapper.insertNotice",notice);
		
	}

	@Override
	public void updateNotice(NoticeVO notice) throws SQLException {
		sqlSession.update("notice-mapper.updateNotice",notice);
		
	}

	@Override
	public void deleteNotice(int notice_num) throws SQLException {
		sqlSession.update("notice-mapper.deleteNotice",notice_num);
		
	}

	@Override
	public void increaseViewCnt(int notice_num) throws SQLException {
		sqlSession.update("notice-mapper.increaseViewCnt",notice_num);
		
	}

	@Override
	public int selectNoticeSeqNext() throws SQLException {
		int seq_num = sqlSession.selectOne("notice-mapper.selectNoticeSeqNext");
		return seq_num;
	}

	@Override
	public List<NoticeVO> selectNoticeListAll() throws SQLException {
		List<NoticeVO> noticeList = sqlSession.selectList("notice-mapper.selectNoticeListAll");
		return noticeList;
	}

	@Override
	public void pointNoticeUpdate(NoticeVO notice) throws SQLException {
		sqlSession.update("notice-mapper.pointNoticeUpdate",notice);
		
	}

	@Override
	public NoticeVO next_notice_title(int notice_num) throws SQLException {
		
		NoticeVO next_title = sqlSession.selectOne("notice-mapper.next_notice_title", notice_num);   //
		
		return next_title;
	}

	@Override
	public NoticeVO prev_notice_title(int notice_num) throws SQLException {
		
		NoticeVO prev_title = sqlSession.selectOne("notice-mapper.prev_notice_title", notice_num);   
		
		return prev_title;
		
	}
	


}
