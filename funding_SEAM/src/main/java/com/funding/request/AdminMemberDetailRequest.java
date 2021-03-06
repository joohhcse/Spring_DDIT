package com.funding.request;

import java.util.Date;

public class AdminMemberDetailRequest {

	private int mem_num;  				//회원 번호
	private String mem_email; 			//회원 이메일
	private String mem_pw; 				//회원 비밀번호
	private String mem_name; 			//회원 이름
	private String mem_phone;			//회원 전화번호
	private String mem_profile_img;		//회원 프로필 경로
	private String mem_profile_ori; 	//회원 프로필 원본
	private Date mem_regdate;  			//회원 가입일자
	private Date mem_lastdate;			//회원 마지막 접속일자
	private int code_state_num;			//회원 상태 코드 번호
	private int code_num;				//회원코드 번호
	private String code_auth;			//회원코드권한
	private String code_state;			//회원 상태 코드
	
	private int count; //관리자 메인페이지에서 회원가입 그래프에서 사용할 용도
	
	private int pjt_pay_num;		//결제내역 번호
	private int pjt_pay_amount;		//결제금액
	private Date ptj_pay_date;		//결제일자
	private String pjt_pay_type;	//결제방식
	private int pjt_pay_usepoint;	//결제사용한포인트
	private int pjt_refund;			//환불 여부
	private int pjt_num;			//프로젝트 번호
	private String pjt_pay_phone;	//결제 휴대폰번호
	private Date pjt_pay_refund_date;//환불 날짜
	private Date pjt_pay_calc_date;	 //정산 날짜
	private int pjt_pay_calc_state;	//정산 여부
	
	private String pjt_title;		//제목
	private String pjt_contents;	//내용
	private int pjt_cash;			//프로젝트 목표 금액
	private String pjt_int_rate;	//투자이자율
	private Date pjt_startdate;		//시작일
	private Date pjt_enddate;		//종료일
	private Date pjt_calcdate;		//정산일
	private Date pjt_regdate;		//작성일
	private Date pjt_moddate;		//수정일
	private int pjt_view_cnt;		//조회수
	private int pjt_thumbsup;		//추천수
	private int pjt_enabled;		//활성화여부
	private String pjt_category;	//카테고리
	private int pjt_type_code;		//분류코드 (기부,대출)
	private int pjt_state_code;		//진행상태코드(미승인,승인)
	private String pjt_state_comment;//보류메시지
	
	private int pjtPaySum; //프로젝트 총 후원 금액
	
	private String pjt_state_code_val;//코드값(미승인,승인,보류)
	private String pjt_type_code_val; //코드값(기부,대출)
	
	private String comName; //사업장명
	private String comAddr1; //사업장주소
	
	private int pjt_atc_num; //첨부 번호
	private String pjt_atc_bankbook_path; //통장 파일 경오
	private String pjt_atc_bankbook_name; //통장 파일 이름
	private String pjt_atc_sum_path; //섬네일 파일 경로
	private String pjt_atc_sum_name; //섬네일 파일 이름
	private Date pjt_atc_regdate; //첨부 등록일자
	private Date pjt_atc_moddate; //첨부 수정일자
	
	public AdminMemberDetailRequest() {}

	public AdminMemberDetailRequest(int mem_num, String mem_email, String mem_pw, String mem_name, String mem_phone,
			String mem_profile_img, String mem_profile_ori, Date mem_regdate, Date mem_lastdate, int code_state_num,
			int code_num, String code_auth, String code_state, int count, int pjt_pay_num, int pjt_pay_amount,
			Date ptj_pay_date, String pjt_pay_type, int pjt_pay_usepoint, int pjt_refund, int pjt_num,
			String pjt_pay_phone, Date pjt_pay_refund_date, Date pjt_pay_calc_date, int pjt_pay_calc_state,
			String pjt_title, String pjt_contents, int pjt_cash, String pjt_int_rate, Date pjt_startdate,
			Date pjt_enddate, Date pjt_calcdate, Date pjt_regdate, Date pjt_moddate, int pjt_view_cnt, int pjt_thumbsup,
			int pjt_enabled, String pjt_category, int pjt_type_code, int pjt_state_code, String pjt_state_comment,
			int pjtPaySum, String pjt_state_code_val, String pjt_type_code_val, String comName, String comAddr1,
			int pjt_atc_num, String pjt_atc_bankbook_path, String pjt_atc_bankbook_name, String pjt_atc_sum_path,
			String pjt_atc_sum_name, Date pjt_atc_regdate, Date pjt_atc_moddate) {
		super();
		this.mem_num = mem_num;
		this.mem_email = mem_email;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_phone = mem_phone;
		this.mem_profile_img = mem_profile_img;
		this.mem_profile_ori = mem_profile_ori;
		this.mem_regdate = mem_regdate;
		this.mem_lastdate = mem_lastdate;
		this.code_state_num = code_state_num;
		this.code_num = code_num;
		this.code_auth = code_auth;
		this.code_state = code_state;
		this.count = count;
		this.pjt_pay_num = pjt_pay_num;
		this.pjt_pay_amount = pjt_pay_amount;
		this.ptj_pay_date = ptj_pay_date;
		this.pjt_pay_type = pjt_pay_type;
		this.pjt_pay_usepoint = pjt_pay_usepoint;
		this.pjt_refund = pjt_refund;
		this.pjt_num = pjt_num;
		this.pjt_pay_phone = pjt_pay_phone;
		this.pjt_pay_refund_date = pjt_pay_refund_date;
		this.pjt_pay_calc_date = pjt_pay_calc_date;
		this.pjt_pay_calc_state = pjt_pay_calc_state;
		this.pjt_title = pjt_title;
		this.pjt_contents = pjt_contents;
		this.pjt_cash = pjt_cash;
		this.pjt_int_rate = pjt_int_rate;
		this.pjt_startdate = pjt_startdate;
		this.pjt_enddate = pjt_enddate;
		this.pjt_calcdate = pjt_calcdate;
		this.pjt_regdate = pjt_regdate;
		this.pjt_moddate = pjt_moddate;
		this.pjt_view_cnt = pjt_view_cnt;
		this.pjt_thumbsup = pjt_thumbsup;
		this.pjt_enabled = pjt_enabled;
		this.pjt_category = pjt_category;
		this.pjt_type_code = pjt_type_code;
		this.pjt_state_code = pjt_state_code;
		this.pjt_state_comment = pjt_state_comment;
		this.pjtPaySum = pjtPaySum;
		this.pjt_state_code_val = pjt_state_code_val;
		this.pjt_type_code_val = pjt_type_code_val;
		this.comName = comName;
		this.comAddr1 = comAddr1;
		this.pjt_atc_num = pjt_atc_num;
		this.pjt_atc_bankbook_path = pjt_atc_bankbook_path;
		this.pjt_atc_bankbook_name = pjt_atc_bankbook_name;
		this.pjt_atc_sum_path = pjt_atc_sum_path;
		this.pjt_atc_sum_name = pjt_atc_sum_name;
		this.pjt_atc_regdate = pjt_atc_regdate;
		this.pjt_atc_moddate = pjt_atc_moddate;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_profile_img() {
		return mem_profile_img;
	}

	public void setMem_profile_img(String mem_profile_img) {
		this.mem_profile_img = mem_profile_img;
	}

	public String getMem_profile_ori() {
		return mem_profile_ori;
	}

	public void setMem_profile_ori(String mem_profile_ori) {
		this.mem_profile_ori = mem_profile_ori;
	}

	public Date getMem_regdate() {
		return mem_regdate;
	}

	public void setMem_regdate(Date mem_regdate) {
		this.mem_regdate = mem_regdate;
	}

	public Date getMem_lastdate() {
		return mem_lastdate;
	}

	public void setMem_lastdate(Date mem_lastdate) {
		this.mem_lastdate = mem_lastdate;
	}

	public int getCode_state_num() {
		return code_state_num;
	}

	public void setCode_state_num(int code_state_num) {
		this.code_state_num = code_state_num;
	}

	public int getCode_num() {
		return code_num;
	}

	public void setCode_num(int code_num) {
		this.code_num = code_num;
	}

	public String getCode_auth() {
		return code_auth;
	}

	public void setCode_auth(String code_auth) {
		this.code_auth = code_auth;
	}

	public String getCode_state() {
		return code_state;
	}

	public void setCode_state(String code_state) {
		this.code_state = code_state;
	}

	public int getPjt_pay_num() {
		return pjt_pay_num;
	}

	public void setPjt_pay_num(int pjt_pay_num) {
		this.pjt_pay_num = pjt_pay_num;
	}

	public int getPjt_pay_amount() {
		return pjt_pay_amount;
	}

	public void setPjt_pay_amount(int pjt_pay_amount) {
		this.pjt_pay_amount = pjt_pay_amount;
	}

	public Date getPtj_pay_date() {
		return ptj_pay_date;
	}

	public void setPtj_pay_date(Date ptj_pay_date) {
		this.ptj_pay_date = ptj_pay_date;
	}

	public String getPjt_pay_type() {
		return pjt_pay_type;
	}

	public void setPjt_pay_type(String pjt_pay_type) {
		this.pjt_pay_type = pjt_pay_type;
	}

	public int getPjt_pay_usepoint() {
		return pjt_pay_usepoint;
	}

	public void setPjt_pay_usepoint(int pjt_pay_usepoint) {
		this.pjt_pay_usepoint = pjt_pay_usepoint;
	}

	public int getPjt_refund() {
		return pjt_refund;
	}

	public void setPjt_refund(int pjt_refund) {
		this.pjt_refund = pjt_refund;
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public int getPjt_num() {
		return pjt_num;
	}

	public void setPjt_num(int pjt_num) {
		this.pjt_num = pjt_num;
	}

	public String getPjt_pay_phone() {
		return pjt_pay_phone;
	}

	public void setPjt_pay_phone(String pjt_pay_phone) {
		this.pjt_pay_phone = pjt_pay_phone;
	}

	public Date getPjt_pay_refund_date() {
		return pjt_pay_refund_date;
	}

	public void setPjt_pay_refund_date(Date pjt_pay_refund_date) {
		this.pjt_pay_refund_date = pjt_pay_refund_date;
	}

	public Date getPjt_pay_calc_date() {
		return pjt_pay_calc_date;
	}

	public void setPjt_pay_calc_date(Date pjt_pay_calc_date) {
		this.pjt_pay_calc_date = pjt_pay_calc_date;
	}

	public int getPjt_pay_calc_state() {
		return pjt_pay_calc_state;
	}

	public void setPjt_pay_calc_state(int pjt_pay_calc_state) {
		this.pjt_pay_calc_state = pjt_pay_calc_state;
	}

	public String getPjt_title() {
		return pjt_title;
	}

	public void setPjt_title(String pjt_title) {
		this.pjt_title = pjt_title;
	}

	public String getPjt_contents() {
		return pjt_contents;
	}

	public void setPjt_contents(String pjt_contents) {
		this.pjt_contents = pjt_contents;
	}

	public int getPjt_cash() {
		return pjt_cash;
	}

	public void setPjt_cash(int pjt_cash) {
		this.pjt_cash = pjt_cash;
	}

	public String getPjt_int_rate() {
		return pjt_int_rate;
	}

	public void setPjt_int_rate(String pjt_int_rate) {
		this.pjt_int_rate = pjt_int_rate;
	}

	public Date getPjt_startdate() {
		return pjt_startdate;
	}

	public void setPjt_startdate(Date pjt_startdate) {
		this.pjt_startdate = pjt_startdate;
	}

	public Date getPjt_enddate() {
		return pjt_enddate;
	}

	public void setPjt_enddate(Date pjt_enddate) {
		this.pjt_enddate = pjt_enddate;
	}

	public Date getPjt_calcdate() {
		return pjt_calcdate;
	}

	public void setPjt_calcdate(Date pjt_calcdate) {
		this.pjt_calcdate = pjt_calcdate;
	}

	public Date getPjt_regdate() {
		return pjt_regdate;
	}

	public void setPjt_regdate(Date pjt_regdate) {
		this.pjt_regdate = pjt_regdate;
	}

	public Date getPjt_moddate() {
		return pjt_moddate;
	}

	public void setPjt_moddate(Date pjt_moddate) {
		this.pjt_moddate = pjt_moddate;
	}

	public int getPjt_view_cnt() {
		return pjt_view_cnt;
	}

	public void setPjt_view_cnt(int pjt_view_cnt) {
		this.pjt_view_cnt = pjt_view_cnt;
	}

	public int getPjt_thumbsup() {
		return pjt_thumbsup;
	}

	public void setPjt_thumbsup(int pjt_thumbsup) {
		this.pjt_thumbsup = pjt_thumbsup;
	}

	public int getPjt_enabled() {
		return pjt_enabled;
	}

	public void setPjt_enabled(int pjt_enabled) {
		this.pjt_enabled = pjt_enabled;
	}

	public String getPjt_category() {
		return pjt_category;
	}

	public void setPjt_category(String pjt_category) {
		this.pjt_category = pjt_category;
	}

	public int getPjt_type_code() {
		return pjt_type_code;
	}

	public void setPjt_type_code(int pjt_type_code) {
		this.pjt_type_code = pjt_type_code;
	}

	public int getPjt_state_code() {
		return pjt_state_code;
	}

	public void setPjt_state_code(int pjt_state_code) {
		this.pjt_state_code = pjt_state_code;
	}

	public String getPjt_state_comment() {
		return pjt_state_comment;
	}

	public void setPjt_state_comment(String pjt_state_comment) {
		this.pjt_state_comment = pjt_state_comment;
	}
	
	public int getPjtPaySum() {
		return pjtPaySum;
	}

	public void setPjtPaySum(int pjtPaySum) {
		this.pjtPaySum = pjtPaySum;
	}

	public String getPjt_state_code_val() {
		return pjt_state_code_val;
	}

	public void setPjt_state_code_val(String pjt_state_code_val) {
		this.pjt_state_code_val = pjt_state_code_val;
	}

	public String getPjt_type_code_val() {
		return pjt_type_code_val;
	}

	public void setPjt_type_code_val(String pjt_type_code_val) {
		this.pjt_type_code_val = pjt_type_code_val;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getComAddr1() {
		return comAddr1;
	}

	public void setComAddr1(String comAddr1) {
		this.comAddr1 = comAddr1;
	}

	public int getPjt_atc_num() {
		return pjt_atc_num;
	}

	public void setPjt_atc_num(int pjt_atc_num) {
		this.pjt_atc_num = pjt_atc_num;
	}

	public String getPjt_atc_bankbook_path() {
		return pjt_atc_bankbook_path;
	}

	public void setPjt_atc_bankbook_path(String pjt_atc_bankbook_path) {
		this.pjt_atc_bankbook_path = pjt_atc_bankbook_path;
	}

	public String getPjt_atc_bankbook_name() {
		return pjt_atc_bankbook_name;
	}

	public void setPjt_atc_bankbook_name(String pjt_atc_bankbook_name) {
		this.pjt_atc_bankbook_name = pjt_atc_bankbook_name;
	}

	public String getPjt_atc_sum_path() {
		return pjt_atc_sum_path;
	}

	public void setPjt_atc_sum_path(String pjt_atc_sum_path) {
		this.pjt_atc_sum_path = pjt_atc_sum_path;
	}

	public String getPjt_atc_sum_name() {
		return pjt_atc_sum_name;
	}

	public void setPjt_atc_sum_name(String pjt_atc_sum_name) {
		this.pjt_atc_sum_name = pjt_atc_sum_name;
	}

	public Date getPjt_atc_regdate() {
		return pjt_atc_regdate;
	}

	public void setPjt_atc_regdate(Date pjt_atc_regdate) {
		this.pjt_atc_regdate = pjt_atc_regdate;
	}

	public Date getPjt_atc_moddate() {
		return pjt_atc_moddate;
	}

	public void setPjt_atc_moddate(Date pjt_atc_moddate) {
		this.pjt_atc_moddate = pjt_atc_moddate;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AdminMemberDetailRequest [mem_num=" + mem_num + ", mem_email=" + mem_email + ", mem_pw=" + mem_pw
				+ ", mem_name=" + mem_name + ", mem_phone=" + mem_phone + ", mem_profile_img=" + mem_profile_img
				+ ", mem_profile_ori=" + mem_profile_ori + ", mem_regdate=" + mem_regdate + ", mem_lastdate="
				+ mem_lastdate + ", code_state_num=" + code_state_num + ", code_num=" + code_num + ", code_auth="
				+ code_auth + ", code_state=" + code_state + ", count=" + count + ", pjt_pay_num=" + pjt_pay_num
				+ ", pjt_pay_amount=" + pjt_pay_amount + ", ptj_pay_date=" + ptj_pay_date + ", pjt_pay_type="
				+ pjt_pay_type + ", pjt_pay_usepoint=" + pjt_pay_usepoint + ", pjt_refund=" + pjt_refund + ", pjt_num="
				+ pjt_num + ", pjt_pay_phone=" + pjt_pay_phone + ", pjt_pay_refund_date=" + pjt_pay_refund_date
				+ ", pjt_pay_calc_date=" + pjt_pay_calc_date + ", pjt_pay_calc_state=" + pjt_pay_calc_state
				+ ", pjt_title=" + pjt_title + ", pjt_contents=" + pjt_contents + ", pjt_cash=" + pjt_cash
				+ ", pjt_int_rate=" + pjt_int_rate + ", pjt_startdate=" + pjt_startdate + ", pjt_enddate=" + pjt_enddate
				+ ", pjt_calcdate=" + pjt_calcdate + ", pjt_regdate=" + pjt_regdate + ", pjt_moddate=" + pjt_moddate
				+ ", pjt_view_cnt=" + pjt_view_cnt + ", pjt_thumbsup=" + pjt_thumbsup + ", pjt_enabled=" + pjt_enabled
				+ ", pjt_category=" + pjt_category + ", pjt_type_code=" + pjt_type_code + ", pjt_state_code="
				+ pjt_state_code + ", pjt_state_comment=" + pjt_state_comment + ", pjtPaySum=" + pjtPaySum
				+ ", pjt_state_code_val=" + pjt_state_code_val + ", pjt_type_code_val=" + pjt_type_code_val
				+ ", comName=" + comName + ", comAddr1=" + comAddr1 + ", pjt_atc_num=" + pjt_atc_num
				+ ", pjt_atc_bankbook_path=" + pjt_atc_bankbook_path + ", pjt_atc_bankbook_name="
				+ pjt_atc_bankbook_name + ", pjt_atc_sum_path=" + pjt_atc_sum_path + ", pjt_atc_sum_name="
				+ pjt_atc_sum_name + ", pjt_atc_regdate=" + pjt_atc_regdate + ", pjt_atc_moddate=" + pjt_atc_moddate
				+ "]";
	}
	
}
