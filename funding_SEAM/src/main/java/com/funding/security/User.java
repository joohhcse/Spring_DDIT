package com.funding.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.funding.dto.MemberVO;

public class User implements UserDetails {
	private MemberVO member;

	public User() {}
	public User(MemberVO member) {
		this.member = member;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return member.getMem_pw();
	}

	@Override
	public String getUsername() {
		return member.getMem_email();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		boolean res = true;
		
		if(member.getCode_state_num() != 1)
			res = false;
		
		return res;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		if(member.getCode_num() == 9)	//ROLE_COM_HOLD
			return false;
		
		return true;
	}
	
	public MemberVO getMemberVO() {
		return this.member;
	}
}
