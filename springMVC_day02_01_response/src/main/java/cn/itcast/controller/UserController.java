package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Lian Flower
 * @Date 2019/9/21 17:03
 * @Version 1.0
 */
@Component
@RequestMapping("/user")
public class UserController {

	/**
	 * 返回值类型为字符串
	 * @param model
	 * @return
	 */
	@RequestMapping("/testString")
	public String testString(Model model) {
		System.out.println("testString执行了");
		// 模拟从数据库中查询用户信息
		User user = new User();
		user.setUsername("coco");
		user.setPassword("123");
		user.setAge(18);
		// 将用户信息存储到request域中
		model.addAttribute("user", user);
		return "success";
	}

	/**
	 * 返回值类型为void
	 * @param request
	 * @param response
	 */
	@RequestMapping("/testVoid")
	public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("testVoid方法执行了");
		// 请求转发到响应页面
		//request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
		// 重定向到响应页面
		// 使用重定向，需要加上项目路径，而且不能访问WEB-INF下的资源，只能访问webapp目录下的资源
		//response.sendRedirect(request.getContextPath() + "/success2.jsp");
		// 直接响应数据
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("哈喽");
	}

	/**
	 * 返回值类型为ModelAndView
	 * @param model
	 * @return
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView(Model model) {
		System.out.println("testModelAndView执行了");
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 模拟从数据库中查询用户信息
		User user = new User();
		user.setUsername("tutu");
		user.setPassword("2667");
		user.setAge(18);
		// 使用ModelAndView对象将用户信息存储到request域中
		modelAndView.addObject("user", user);
		// 设置响应的页面
		// springMVC会使用视图解析器解析设置的响应页面，然后跳转到响应页面上
		modelAndView.setViewName("success");
		return modelAndView;
	}

	/**
	 * 使用关键字转发到响应页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/testForward")
	public String testForward(Model model) {
		System.out.println("testForward执行了");
		// 转发到响应页面
		return "forward:/WEB-INF/pages/success.jsp";
	}

	/**
	 * 使用关键字重定向到响应页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/testRedirect")
	public String testRedirect(Model model) {
		System.out.println("testForward执行了");
		// 重定向到响应页面（这里就不需用加项目名称了，因为springMVC底层已经帮我们加上了项目名称）
		return "redirect:/success2.jsp";
	}

	/**
	 * 获取ajax请求的数据
	 * @param body
	 */
	/*@RequestMapping("/testAjax")
	public void testAjax(@RequestBody String body) {	//@RequestBody获取请求体中的json数据
		System.out.println("testAjax方法执行了");
		System.out.println(body);
	}*/

	/**
	 * 将json数据响应给ajax请求
	 * @param user
	 */
	@RequestMapping("/testAjax")
	// @ResponseBody用于将响应的数据转换为json字符串（底层是由jackson自动转换的），返回给前台		// @RequestBody用于获取请求体中的json数据，
	public @ResponseBody User testAjax(@RequestBody User user) {							// 并获取的json数据封装到User对象中（底层是由jackson自动封装的）
		System.out.println("testAjax方法执行了");
		System.out.println(user);
		// 对数据做一些修改
		user.setUsername("tutu");
		user.setPassword("456");
		// 然后返回
		return user;
	}
}
