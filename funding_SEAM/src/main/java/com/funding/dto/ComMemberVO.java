package com.funding.dto;

public class ComMemberVO {
	
	private int com_num;				//업체번호
	private String com_bsns_name;		//사업장명
	private String com_bsns_rep_name;	//대표자명
	private String com_bsns_number;		//사업자등록번호
	private String com_bsns_phone;		//대표전화번호
	private String com_bsns_reg_license;//사업자등록증
	private String com_bsns_cert;		//소상공인증명서
	private int mem_num;				//회원번호
	private String com_zipcode;			//우편번호
	private String com_addr1;			//주소1
	private String com_addr2;			//주소2
	
	private int com_state_code; //소상공인 가입 승인 여부 코드(JBR 0615 추가)
	private String com_state_comment; //소상공인 가입 미승인 메시지(JBR 0615 추가)
	
	public int getCom_num() {
		return com_num;
	}
	public void setCom_num(int com_num) {
		this.com_num = com_num;
	}
	public String getCom_bsns_name() {
		return com_bsns_name;
	}
	public void setCom_bsns_name(String com_bsns_name) {
		this.com_bsns_name = com_bsns_name;
	}
	public String getCom_bsns_rep_name() {
		return com_bsns_rep_name;
	}
	public void setCom_bsns_rep_name(String com_bsns_rep_name) {
		this.com_bsns_rep_name = com_bsns_rep_name;
	}
	public String getCom_bsns_number() {
		return com_bsns_number;
	}
	public void setCom_bsns_number(String com_bsns_number) {
		this.com_bsns_number = com_bsns_number;
	}
	public String getCom_bsns_phone() {
		return com_bsns_phone;
	}
	public void setCom_bsns_phone(String com_bsns_phone) {
		this.com_bsns_phone = com_bsns_phone;
	}
	public String getCom_bsns_reg_license() {
		return com_bsns_reg_license;
	}
	public void setCom_bsns_reg_license(String com_bsns_reg_license) {
		this.com_bsns_reg_license = com_bsns_reg_license;
	}
	public String getCom_bsns_cert() {
		return com_bsns_cert;
	}
	public void setCom_bsns_cert(String com_bsns_cert) {
		this.com_bsns_cert = com_bsns_cert;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getCom_zipcode() {
		return com_zipcode;
	}
	public void setCom_zipcode(String com_zipcode) {
		this.com_zipcode = com_zipcode;
	}
	public String getCom_addr1() {
		return com_addr1;
	}
	public void setCom_addr1(String com_addr1) {
		this.com_addr1 = com_addr1;
	}
	public String getCom_addr2() {
		return com_addr2;
	}
	public void setCom_addr2(String com_addr2) {
		this.com_addr2 = com_addr2;
	}
	
	public int getCom_state_code() {
		return com_state_code;
	}
	public void setCom_state_code(int com_state_code) {
		this.com_state_code = com_state_code;
	}
	public String getCom_state_comment() {
		return com_state_comment;
	}
	public void setCom_state_comment(String com_state_comment) {
		this.com_state_comment = com_state_comment;
	}
	
	public ComMemberVO() {	}
	public ComMemberVO(int com_num, String com_bsns_name, String com_bsns_rep_name, String com_bsns_number,
			String com_bsns_phone, String com_bsns_reg_license, String com_bsns_cert, int mem_num, String com_zipcode,
			String com_addr1, String com_addr2, int com_state_code, String com_state_comment) {
		super();
		this.com_num = com_num;
		this.com_bsns_name = com_bsns_name;
		this.com_bsns_rep_name = com_bsns_rep_name;
		this.com_bsns_number = com_bsns_number;
		this.com_bsns_phone = com_bsns_phone;
		this.com_bsns_reg_license = com_bsns_reg_license;
		this.com_bsns_cert = com_bsns_cert;
		this.mem_num = mem_num;
		this.com_zipcode = com_zipcode;
		this.com_addr1 = com_addr1;
		this.com_addr2 = com_addr2;
		this.com_state_code = com_state_code;
		this.com_state_comment = com_state_comment;
	}

	@Override
	public String toString() {
		return "ComMemberVO [com_num=" + com_num + ", com_bsns_name=" + com_bsns_name + ", com_bsns_rep_name="
				+ com_bsns_rep_name + ", com_bsns_number=" + com_bsns_number + ", com_bsns_phone=" + com_bsns_phone
				+ ", com_bsns_reg_license=" + com_bsns_reg_license + ", com_bsns_cert=" + com_bsns_cert + ", mem_num="
				+ mem_num + ", com_zipcode=" + com_zipcode + ", com_addr1=" + com_addr1 + ", com_addr2=" + com_addr2
				+ ", com_state_code=" + com_state_code + ", com_state_comment=" + com_state_comment + "]";
	}

}
