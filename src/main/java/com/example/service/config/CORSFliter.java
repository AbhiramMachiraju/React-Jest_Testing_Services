package com.example.service.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.UrlPathHelper;



/*
 * @author :ABHIRAM MACHIRAJU
 * @Date   : July, 2021
 * @see : If any header added [For Security reason],Need to pass for internal API Calls also.....
 * 
 */

@Configuration
public class CORSFliter extends OncePerRequestFilter {


	@SuppressWarnings("unused")
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

			response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
			response.setHeader("Access-Control-Allow-Origin","*");
			// response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("X-XSS-Protection", "1; mode=block");
			response.setHeader("X-Frame-Options", "SAMEORIGIN");
			response.setHeader("Access-Control-Allow-Headers",
					"*");
			response.addHeader("Access-Control-Expose-Headers", "xsrf-token");
			if ("OPTIONS".equals(request.getMethod())) {
				response.setStatus(HttpServletResponse.SC_OK);
			} else {
				filterChain.doFilter(request, response);
			}

	}
}
