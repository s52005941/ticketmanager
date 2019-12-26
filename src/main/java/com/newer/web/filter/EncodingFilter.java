package com.newer.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

	private String encoder;  // 字符集名称

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoder);
		response.setContentType("text/html;charset="+encoder);
//		System.out.println(encoder+"转码完成");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoder = filterConfig.getInitParameter("encoder");
	}
	
}
