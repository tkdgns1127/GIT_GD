package com.min.edu.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * AOP에서 사용할 Advice의 대상이 되는 메소드를 선언한다
 * before / after / after-returning / after-throwing / around
 */
public class DaoLogExecute {
	
	public void before(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget() + "");
		logger.debug("AOP log 시작");
		Object[] obj = j.getArgs();
		if(obj != null) {
			logger.debug("method : " + j.getSignature().getName());
			for (int i = 0; i < obj.length; i++) {
				logger.debug(i + "번째 : " + obj[i]);
			}
			logger.debug("method : " + j.getSignature().getName());

		}
	}
	
	public void error(JoinPoint j, Exception exception) {
		Logger logger = LoggerFactory.getLogger(j.getTarget() + "");
		logger.debug("에러 \t {}", j.getArgs());
		logger.debug("에러 \t {}", exception.getMessage());
	}
	
}
