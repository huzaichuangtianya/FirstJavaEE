package com.ql.web1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(name="kankan1")
public class MyServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("kankan");
//		HttpSession httpSession=req.getSession();
//		System.out.println("httpSession.getId():"+req.getSession().getId());
//		String str=(String)httpSession.getAttribute("qlId");
//		if(str==null) {
//			System.out.println("str:"+str);
//			httpSession.setAttribute("qlId", "jfskdfjsklfjlaaa");
//		}	else {
//			System.out.println("str:"+str);
//		}
//		
//		String strBackUrl = "http://" + req.getServerName() //服务器地址  
//        + ":"   
//        + req.getServerPort()           //端口号  
//        + req.getContextPath()      //项目名称  
//        + req.getServletPath();    //请求页面或其他地址  
////    + "?" + (req.getQueryString());
//		
//		System.out.println("strBackUrl:"+strBackUrl);
//		resp.encodeRedirectURL(strBackUrl);
//		resp.encodeRedirectUrl(strBackUrl);
		
		
		
		 response.setContentType("text/html;charset=UTF-8");
		          PrintWriter out = response.getWriter();
		         //创建Session
		          String qlid=(String)request.getSession().getAttribute("qlId");
			 		System.out.println("qlid:"+qlid);
			 		
			 		if(request.getSession().isNew()) {
			 			request.getSession().setAttribute("qlId", "aaaaadfsfsdfsd");
			 		}
		 		System.out.println("httpSession.getId():"+request.getSession().getId());
		 		
//		 		String str=(String)httpSession.getAttribute("qlId");
		         
		         out.write("本网站有如下书：<br/>");
		         
		 		String strBackUrl = "http://" + request.getServerName() //服务器地址  
		        + ":"   
		        + request.getServerPort()           //端口号  
		        + request.getContextPath()      //项目名称  
		        + request.getServletPath();    //请求页面或其他地址  
		         
		       String  enUrl = response.encodeURL(strBackUrl);//将超链接的url地址进行重写
		            out.println( "   <a href='"+enUrl+"'>购买</a><br/>");
		            

		
	}
}
