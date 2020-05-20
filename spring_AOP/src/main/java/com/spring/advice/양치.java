package com.spring.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class 양치 {

	//이런 방법 좋지 않음 
	public void chikachikaProceed(ProceedingJoinPoint joinPoint) throws Throwable   {
		
		//외부에서 줄 필요없다
		//내부에서 모두 줌
		Object result = joinPoint.proceed();	//point cut
		System.out.println("양치하기");
		
		//내부적으로 proceed 지정
	}
	
	
	public void chikachika(JoinPoint joinPoint) throws Throwable   {
		
		System.out.println("양치하기");	// JOIN POINT를 줘야함 // 외부에서 줘야함
		
	}
}
