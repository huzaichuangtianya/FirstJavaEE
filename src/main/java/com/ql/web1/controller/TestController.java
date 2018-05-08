package com.ql.web1.controller;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.ql.web1.entity.User;
import com.ql.web1.redis.RedisGeneratorDao;
import com.ql.web1.service.users.UserService;
import com.ql.web1.util.MemcacheUtil;

import redis.clients.jedis.Jedis;

@Controller
@Scope("prototype")
@RequestMapping(value = "/user")
public class TestController {
	
	@Resource
	private UserService userService;
	

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test1(HttpServletResponse httpServletResponse,HttpServletRequest httpServletRequest) {
		System.out.println("httpSession.getId():"+httpServletRequest.getSession().getId());
		System.out.println("httpSession.getAttribute():"+httpServletRequest.getSession().getAttribute("qlId"));
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public void test2(HttpServletResponse httpServletResponse) {
		
		System.out.println(MemcacheUtil.set("aa", "bb", new Date(1000 * 60)));
		Object obj = MemcacheUtil.get("aa");  
		System.out.println("***************************");  
		System.out.println(obj.toString());  
	}
	
	
	 private final static String HOST = "127.0.0.1";
	    private final static int PORT = 6379;
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String test3(HttpServletResponse httpServletResponse) {
		 
		  Jedis jedis = new Jedis(HOST, PORT);
	        jedis.set("account", "itdragon");
	        System.out.println("set , get 操作 : " + jedis.get("account"));
	return "test";
	}
	
	@Autowired
	StringRedisTemplate redisTemplate;
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public String test4(HttpServletResponse httpServletResponse) {
		redisTemplate.opsForValue().set("kankan1", "kankan1Value");
	
		System.out.println("redisTemplate.opsForValue():"+redisTemplate.opsForValue().get("kankan1"));
		
//		RedisConnectionFactory redisConnectionFactory=new JedisConnectionFactory();
//		redisConnectionFactory.s
//		redisTemplate=new StringRedisTemplate();
		
		
	return "test";
	}
	
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String test5(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		HttpSession httpSession=httpServletRequest.getSession();
		
		System.out.println("httpSession.getId():"+httpServletRequest.getSession().getId());
		System.out.println("httpSession.getAttribute():"+httpServletRequest.getSession().getAttribute("qlId"));
		
		String qlId=(String)httpServletRequest.getSession().getAttribute("qlId");
		
		if(qlId==null) {
			httpSession.setAttribute("qlId", "jfskdfjsklfjlaaa");
			String strBackUrl = "http://" + httpServletRequest.getServerName() //服务器地址  
	        + ":"   
	        + httpServletRequest.getServerPort()           //端口号  
	        + httpServletRequest.getContextPath()      //项目名称  
	        + httpServletRequest.getServletPath()   ;   //请求页面或其他地址  
//	    + "?" + (httpServletRequest.getQueryString());
			
			System.out.println("strBackUrl:"+strBackUrl);
			
			String enstrBackUrl=httpServletResponse.encodeRedirectURL(strBackUrl);
			try {
				httpServletResponse.sendRedirect(enstrBackUrl);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return "test";
	}
	
	
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public @ResponseBody String hello(HttpServletResponse httpServletResponse) {
		return "hello world!";
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.GET)
	public String save(WebRequest webRequest) {
////		System.out.println("save:"+webRequest.getParameter("id"));
////		System.out.println("save:"+webRequest.getParameter("name"));
//		
////		userService.saveUser(new User(Integer.valueOf(webRequest.getParameter("id")),webRequest.getParameter("name")));
//			return "";
		
		ModelAndView modelAndView=new ModelAndView();
//		modelAndView.setViewName("index2");
//		modelAndView.addObject(new User(10,"zhangsan10"));
//		return modelAndView;
		return "test";
	}
	
	@RequestMapping(value = "/query")
	@ResponseBody
	public User query(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		System.out.println("query:"+httpServletRequest.getParameter("id"));
		
		User user=userService.getUser(Integer.valueOf(httpServletRequest.getParameter("id")));
		
	
		
//		httpSession.getId();
		
		return user;
	}
	
	@RequestMapping(value = "/update")
	public @ResponseBody String update(HttpServletRequest httpServletRequest) {
		System.out.println("update:"+httpServletRequest.getParameter("id"));
		System.out.println("update:"+httpServletRequest.getParameter("name"));
		userService.updateUser(new User(Integer.valueOf(httpServletRequest.getParameter("id")),httpServletRequest.getParameter("name")));
		return "update success!";
	}
	
	@RequestMapping(value = "/delete")
	public @ResponseBody String delete(HttpServletRequest httpServletRequest) {
		System.out.println("update:"+httpServletRequest.getParameter("id"));
		userService.deleteUser(Integer.valueOf(httpServletRequest.getParameter("id")));
		return "delete success!";
	}
	
	
	

}
