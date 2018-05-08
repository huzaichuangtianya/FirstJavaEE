package com.ql.web1.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class IntercepterAll implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
System.out.println("IntercepterAll:afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("IntercepterAll:postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
//		String  url=request.getServletPath().toString();
//		HttpSession session = request.getSession();
//        Customer  customer = (Customer) session.getAttribute("customer");
//        //这里只是做了一个重定向
//        if (customer == null) {
//        	if(!url.equals("/customer/tologin") && !url.equals("/customer/login")){
//	            //被拦截，重定向到login界面
//	        	response.sendRedirect("/LbjyWeb/customer/tologin");
//	        	return false;
//        	}
//        }
//        else if(customer.getChildList() == null){
//	        	response.sendRedirect("/LbjyWeb/toRegbaby");
//	        	return false;
//        	}
		System.out.println("IntercepterAll:preHandle");
        return true;
	}
}
