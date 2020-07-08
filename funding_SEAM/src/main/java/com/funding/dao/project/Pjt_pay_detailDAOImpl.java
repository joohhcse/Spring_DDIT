package com.funding.dao.project;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.funding.dto.Pjt_pay_detailVO;
import com.funding.dto.ProjectVO;
import com.funding.request.MypagePaylistRequest;
import com.funding.request.PaylistSearchCriteria;
import com.funding.request.ProjectPayRequest;
import com.funding.request.SearchCriteria;

public class Pjt_pay_detailDAOImpl implements Pjt_pay_detailDAO {
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int selectPjtPaySum(int pjt_num) throws SQLException {
		int sum=sqlSession.selectOne("Pjt_pay_detail-Mapper.selectPjtPaySum",pjt_num);
		return sum;
	}

	@Override
	public int selectBoardSeqNext() throws SQLException {
		int num=sqlSession.selectOne("Pjt_pay_detail-Mapper.selectPjsPaySeqNext");
		return num;
	}

	@Override
	public void insertPjtPay(Pjt_pay_detailVO pjt_pay_detail) throws SQLException {
		sqlSession.update("Pjt_pay_detail-Mapper.insertPjtPay",pjt_pay_detail);
		
	}

	@Override
	public List<ProjectPayRequest> selectPjtPayTableListByMemNum(SearchCriteria cri, int mem_num) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();
		
		//RowBounds : offset 만큼 건너뛰고 limit 만큼 가져온다
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		Map<String,Object> map = new HashMap<>();
		map.put("cri", cri);
		map.put("mem_num", mem_num);
		
		List<ProjectPayRequest> projectList = sqlSession.selectList("Pjt_pay_detail-Mapper.selectPjtPayTableListByMemNum",map,rowBounds);
		
		return projectList;
	}

	@Override
	public int selectPjtPayTableListByMemNumCount(SearchCriteria cri, int mem_num) throws SQLException {
		Map<String,Object> map = new HashMap<>();
		map.put("cri", cri);
		map.put("mem_num", mem_num);
		int count = sqlSession.selectOne("Pjt_pay_detail-Mapper.selectPjtPayTableListByMemNumCount",map);
		return count;
	}

	@Override
	public List<MypagePaylistRequest> selectPjtPayListByMemNum(SearchCriteria cri, int mem_num) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();
		
		//RowBounds : offset 만큼 건너뛰고 limit 만큼 가져온다
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		Map<String,Object> map = new HashMap<>();
		map.put("cri", cri);
		map.put("mem_num", mem_num);
		
		List<MypagePaylistRequest> payList = sqlSession.selectList("Pjt_pay_detail-Mapper.selectPjtPayListByMemNum",map,rowBounds);
		return payList;
	}
	
	@Override
	public int selectPjtPayListByMemNumCount(SearchCriteria cri, int mem_num) throws SQLException {
		Map<String,Object> map = new HashMap<>();
		map.put("cri", cri);
		map.put("mem_num", mem_num);
		int count = sqlSession.selectOne("Pjt_pay_detail-Mapper.selectPjtPayListByMemNumCount",map);
		return count;
	}
	
	@Override
	public List<MypagePaylistRequest> selectPjtPayListForRefundByMemNum(SearchCriteria cri, int mem_num)
			throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();
		
		//RowBounds : offset 만큼 건너뛰고 limit 만큼 가져온다
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		Map<String,Object> map = new HashMap<>();
		map.put("cri", cri);
		map.put("mem_num", mem_num);
		
		List<MypagePaylistRequest> payList = sqlSession.selectList("Pjt_pay_detail-Mapper.selectPjtPayListByMemNum",map,rowBounds);
		return payList;
	}

	@Override
	public int selectPjtPayListForRefundByMemNumCount(SearchCriteria cri, int mem_num) throws SQLException {
		return 0;
	}

	@Override
	public List<MypagePaylistRequest> selectPjtRefundListByMemNum(PaylistSearchCriteria cri, int mem_num) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();
		
		//RowBounds : offset 만큼 건너뛰고 limit 만큼 가져온다
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		Map<String,Object> map = new HashMap<>();
		map.put("cri", cri);
		map.put("mem_num", mem_num);
		
		List<MypagePaylistRequest> refundList = sqlSession.selectList("Pjt_pay_detail-Mapper.selectPjtRefundListByMemNum", map, rowBounds);
		return refundList;
	}

	@Override
	public int selectPjtRefundListByMemNumCount(PaylistSearchCriteria cri, int mem_num) throws SQLException {
		Map<String,Object> map = new HashMap<>();
		map.put("cri", cri);
		map.put("mem_num", mem_num);
		int count = sqlSession.selectOne("Pjt_pay_detail-Mapper.selectPjtRefundListByMemNumCount",map);
		return count;
	}

	@Override
	public List<MypagePaylistRequest> selectPjtAllPayListByMemNum(PaylistSearchCriteria cri, int mem_num) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();
		
		//RowBounds : offset 만큼 건너뛰고 limit 만큼 가져온다
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		Map<String,Object> map = new HashMap<>();
		map.put("cri", cri);
		map.put("mem_num", mem_num);
		
		List<MypagePaylistRequest> list = sqlSession.selectList("Pjt_pay_detail-Mapper.selectPjtAllPayListByMemNum",map,rowBounds);
		return list;
	}

	@Override
	public int selectPjtAllPayListByMemNumCount(PaylistSearchCriteria cri, int mem_num) throws SQLException {
		Map<String,Object> map = new HashMap<>();
		map.put("cri", cri);
		map.put("mem_num", mem_num);
		int count = sqlSession.selectOne("Pjt_pay_detail-Mapper.selectPjtAllPayListByMemNumCount",map);
		return count;
	}

	@Override
	public List<MypagePaylistRequest> selectSearchPjtAllPayListByMemNum(PaylistSearchCriteria cri, int mem_num)
			throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();
		
		//RowBounds : offset 만큼 건너뛰고 limit 만큼 가져온다
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		Map<String,Object> map = new HashMap<>();
		map.put("cri", cri);
		map.put("mem_num", mem_num);
		
		List<MypagePaylistRequest> list = sqlSession.selectList("Pjt_pay_detail-Mapper.selectSearchPjtAllPayListByMemNum",map,rowBounds);
		return list;
	}

	@Override
	public int selectSearchPjtAllPayListByMemNumCount(PaylistSearchCriteria cri, int mem_num) throws SQLException {
		Map<String,Object> map = new HashMap<>();
		map.put("cri", cri);
		map.put("mem_num", mem_num);
		int count = sqlSession.selectOne("Pjt_pay_detail-Mapper.selectSearchPjtAllPayListByMemNumCount",map);
		return count;
	}

	@Override
	public void updateAskRefundStateToOne(int pjt_pay_num) throws SQLException {
		sqlSession.update("Pjt_pay_detail-Mapper.updateAskRefundStateToOne", pjt_pay_num);
	}

}
