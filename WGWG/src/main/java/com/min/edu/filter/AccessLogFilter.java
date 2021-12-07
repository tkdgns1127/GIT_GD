package com.min.edu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AccessLogFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		// 접속 정보 log
		String remote = StringUtils.defaultString(req.getRemoteAddr(), "-");
		String uri = StringUtils.defaultString(req.getRequestURI(), "-") ;
		String queryString = StringUtils.defaultString(req.getQueryString(), "");
		
		// Header 정보 log
		String refer = StringUtils.defaultString(req.getHeader("Referer"), "-");
		String agent = StringUtils.defaultString(req.getHeader("User-Agent"), "-");
		
		// System.out.printf("%s?%s : %s : %s : %s", uri, queryString, remote, refer, agent);
		String log = String.format("%s?%s : %s : %s : %s", uri, queryString, remote, refer, agent);
		
		logger.info(log);
		
		// 흐름제어 코드
		// req.getRequestDispatcher("/WEB-INF/views/abcd.jsp").forward(request, response);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		logger.info("============= AccessLogFilter Init =============");
	}
	
	public void destroy() {
		logger.info("============= AccessLogFilter Destroy =============");

	}
}
