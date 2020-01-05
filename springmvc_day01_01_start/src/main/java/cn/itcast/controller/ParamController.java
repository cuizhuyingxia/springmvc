package cn.itcast.controller;

/**
 * @Author Lian Flower
 * @Date 2019/9/17 20:42
 * @Version 1.0
 */

import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 请求参数绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {

	/**
	 * 请求参数绑定入门
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/testParam")
	public String testParam(String username, String password) {
		System.out.println("参数绑定成功");
		System.out.println(username);
		System.out.println(password);
		return "success";
	}

	/**
	 * 请求参数绑定实体类型
	 * @param account
	 * @return
	 */
	@RequestMapping("/saveAccount")
	public String testSaveSAccount(Account account) {
		System.out.println("参数绑定成功");
		System.out.println(account);
		return "success";
	}

	/**
	 * 请求参数绑定List集合和map集合
	 * @param account
	 * @return
	 */
	@RequestMapping("/saveAccount2")
	public String testSaveAccount2(Account account) {
		System.out.println("参数绑定成功");
		System.out.println(account);
		return "success";
	}

	/**
	 * 自定义类型转换器
	 * @param user
	 * @return
	 */
	@RequestMapping("/saveUser")
	public String testSaveUser(User user) {
		System.out.println("参数绑定成功");
		System.out.println(user);
		return "success";
	}

	/**
	 * 获取Servlet原生的API
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("servlet")
	public String testServlet(HttpServletRequest request, HttpServletResponse response) {
		// 获取request对象
		System.out.println(request);
		// 获取session对象
		HttpSession session = request.getSession();
		System.out.println(session);
		// 获取servletContext域对象
		ServletContext servletContext = session.getServletContext();
		System.out.println(servletContext);
		// 获取response对象
		System.out.println(response);
		return "success";
	}
}
