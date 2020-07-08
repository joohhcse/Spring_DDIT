package com.funding.request;

public class AdminMemberPageMaker {

	private int totalCount; // 전체 행의 개수
	private int startPage=1; // 시작 페이지 번호
	private int endPage=1; // 마지막 페이지 번호
	private int realEndPage; // 끝 페이지 번호
	private boolean prev; //이전페이지 버튼 유무
	private boolean next; //다음페이지 버튼 유무
	
	private int displayPageNum=10; //한 페이지에 보여줄 페이지번호 개수
	
	private AdminMemberSearchCriteria cri; //현재 페이지 정보
	
	
	//starPage,endPage, prev, next 설정. by totalCount
	private void calcData(){
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum)
					* displayPageNum);
		startPage = (endPage - displayPageNum) + 1;		
		
		realEndPage= (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		System.out.println("realEndPage......"+realEndPage);
		System.out.println("cri.getPerPageNum()......"+cri.getPerPageNum());
		System.out.println("totalCount......"+totalCount);
		System.out.println("Math.ceil(totalCount / (double) cri.getPerPageNum())......"+Math.ceil(totalCount / (double) cri.getPerPageNum()));
		
		if(startPage<0){
			startPage=1;
		}
		if (endPage > realEndPage) {		
			endPage = realEndPage;			
		}
		
		prev = startPage == 1 ? false : true;
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
		
	}
	   
	public String makeQuery(){
		return makeQuery(cri.getPage());
	}
	public String makeQuery(int page){	
		String query="?page="+page
				    +"&perPageNum="+cri.getPerPageNum()
				    +"&searchType="+cri.getSearchType()
				    +"&keyword="+cri.getKeyword()
				    +"code_state="+cri.getCode_state()
				    +"first_mem_regdate"+cri.getFirst_mem_regdate()
				    +"last_mem_regdate"+cri.getLast_mem_regdate();
		return query;
	}
	public static String makeQuery(AdminMemberSearchCriteria cri){	
		String query="?page="+cri.getPage()
				    +"&perPageNum="+cri.getPerPageNum()
				    +"&searchType="+cri.getSearchType()
				    +"&keyword="+cri.getKeyword()
				    +"code_state="+cri.getCode_state()
				    +"first_mem_regdate"+cri.getFirst_mem_regdate()
				    +"last_mem_regdate"+cri.getLast_mem_regdate();
		return query;
	}
	

	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getRealEndPage() {
		return realEndPage;
	}


	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public int getDisplayPageNum() {
		return displayPageNum;
	}
	
	public AdminMemberSearchCriteria getCri() {
		return cri;
		
	}
	
	public void setCri(AdminMemberSearchCriteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "AdminPageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", realEndPage=" + realEndPage + ", prev=" + prev + ", next=" + next + ", displayPageNum="
				+ displayPageNum + ", cri=" + cri + "]";
	}
	
}
