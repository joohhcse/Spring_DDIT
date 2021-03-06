package com.funding.security;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.funding.dao.MemberDAO;
import com.funding.dto.MemberVO;
import com.funding.util.Encryption;

public class CustomAuthentication implements AuthenticationProvider {

	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		Encryption enc;
		String encode = "";
		
		String login_id = (String) auth.getPrincipal();		//로그인 시도한 ID가져옴
		String login_pw = (String) auth.getCredentials();	//로그인 시도한 PW가져옴
		
		try {
			enc = new Encryption();
			encode = enc.aesEncode(login_pw);
			System.out.println("encode >");
			System.out.println(encode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MemberVO member = null;
		try {
			member = memberDAO.selectMemberById(login_id);
			
			if(member == null)
				throw new InternalAuthenticationServiceException("미가입회원");
			
		} catch (SQLException e) {
			throw new BadCredentialsException("비밀번호오류");
		}
		
//		if(member != null && login_pw.equals(member.getMem_pw())) {
		if(member != null && encode.equals(member.getMem_pw())) {
			User loginUser = new User(member);
			
			if(!loginUser.isEnabled())
			{
//				throw new DisabledException("사용불가한 사용자입니다.");
				throw new DisabledException("승인대기중");
			}
			else
			{
				List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
				
 				// 사용자에게 권한 부여
 				if(loginUser.isAccountNonLocked()) 
 				{
 					//roles.add(new SimpleGrantedAuthority(member.getAuthority()));
 					int code_num = member.getCode_num();
 					
 					switch(code_num) {
	 					case 0:
	 						roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	 						break;
	 					case 1:
	 						roles.add(new SimpleGrantedAuthority("ROLE_USER"));
	 						break;
	 					case 2:
	 						roles.add(new SimpleGrantedAuthority("ROLE_COM"));
	 						break;
	 					case 9:
	 						roles.add(new SimpleGrantedAuthority("ROLE_COM_HOLD"));
	 						break;
	 					default :
	 						roles.add(new SimpleGrantedAuthority("ROLE_USER"));
	 						break;
 					}
 				}
 				else 
 				{
 					roles.add(new SimpleGrantedAuthority("ROLE_USER"));
 				}
				
				// 스프링 시큐리티 내부 클래스로 인증 토큰 생성한다.
 				UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(member.getMem_email(), member.getMem_pw(), roles);
 				//전달할 내용을 설정한 후 
	            result.setDetails(loginUser);
	            
	            return result;
			}
		}
		else {
			// 실패시 예외처리
 			throw new BadCredentialsException("비밀번호오류");
		}
	}

	@Override
	public boolean supports(Class<?> arg) {		//타입 비교하려고 만든 supports 메서드
		 //UsernamePasswordAuthenticationToken 리턴할 때 파라미터와 같은 레퍼런스인지 비교를하고 리턴을 한다.
		 //default-target-url 로 전송된다. 
		return arg.equals(UsernamePasswordAuthenticationToken.class);
	}

}
