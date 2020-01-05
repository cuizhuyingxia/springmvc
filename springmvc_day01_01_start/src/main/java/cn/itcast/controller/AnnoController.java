package cn.itcast.controller;

/**
 * @Author Lian Flower
 * @Date 2019/9/19 10:58
 * @Version 1.0
 */

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 常用的注解
 * 		@RequestParam
 * 			作用：用于将指定的请求参数赋给形参
 * 			属性：
 * 				name：		指定请求参数的名称
 * 				value：		和name属性的功能一样
 * 				required：	要求前端传回来的数据中，必须有name或value属性指定的请求参数，如果没有传，则会报错。默认为true
 *
 * 		@RequestBody
 * 			作用：用于接收请求体中的json数据
 *
 * 		@PathVariable
 * 			作用：用于获取请求url中的占位符
 * 				例如：http://localhost:8080/anno/testPathVariable/10
 * 						其中占位符就是10
 *
 * 		@RequestHeader
 * 			作用：获取请求头的值
 * 			属性：
 * 				value：指定请求头的名称
 *
 * 		@CookieValue
 * 			作用：获取cookie的值
 * 			属性：
 * 				value：指定cookie的名称
 *
 * 		@ModelAttribute
 * 			作用：该注解可以作用在方法上面，然后这个方法会在请求映射的方法执行之前执行
 * 			使用场景：例如，用户在提交表单时，只提交了用户名和年龄，而没有提交生日，
 * 						后台需要把这些数据封装到User对象中，User对象有三个属性：username，age，date
 * 							因为用户没有提交生日，所以我们在将数据封装到User对象时，date属性的值就为null
 * 								那如果我们不想让date属性的值为null怎么办？
 * 									我们可以在请求映射的方法执行之前，在@ModelAttribute注解修饰的方法中从数据库中查询该用户的生日，
 * 										然后将数据返回给请求映射的方法。
* 											该注解也可以作用的参数上，即当@ModelAttribute注解修饰的方法没有返回值时，而是把数据封装到了map集合中，
 * 												则我们可以在请求映射的方法上，使用@ModelAttribute注解获取map集合中的数据
 *
 * 		@SessionAttributes
 * 			作用：可以将数据存储到session域中，然后就可以在请求映射的方法之间共享数据
 *
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg2"})	// 将使用Model接口向request域中存入的数据msg2，再存入到session域中
public class AnnoController {

	/**
	 * 将指定的请求参数赋给形参
	 * @param username
	 * @return
	 */
	@RequestMapping("/testRequestParam")
	public String testRequestParam(@RequestParam(name = "name") String username) {
		System.out.println(username);
		return "success";
	}

	/**
	 * 获取请求体中的内容
	 * @param body
	 * @return
	 */
	@RequestMapping("/testRequestBody")
	public String testRequestBody(@RequestBody String body) {	// @RequestBody用于接收请求体中的json数据
		System.out.println(body);
		return "success";
	}

	/**
	 * 获取请求ulr中的占位符
	 * @param id
	 * @return
	 */
	@RequestMapping("/testPathVariable/{sid}")
	public String testPathVariable(@PathVariable(name = "sid") String id) {
		System.out.println(id);
		return "success";
	}

	/**
	 * 获取请求头的值
	 * @param header
	 * @return
	 */
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value = "User-Agent") String header) {
		System.out.println(header);
		return "success";
	}

	/**
	 * 获取cookie的值
	 * @param cookie
	 * @return
	 */
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookie) {
		System.out.println(cookie);
		return "success";
	}

	/**
	 * @ModelAttribute注解
	 * @param user
	 * @return
	 */
	/*@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user) {	// 这里的user，是从@ModelAttribute注解修饰的方法中返回的user
		System.out.println(user);
		return "success";
	}*/
	/**
	 * 在请求映射的方法封装数据前，执行一些其它操作（有返回值）
	 * @param uname
	 * @param age
	 * @return
	 */
	/*@ModelAttribute
	public User getBirthday(String uname, String age) {
		// 模拟从数据库中，查询用户的生日
		// ...
		// 模拟返回的数据
		User user = new User();
		user.setUname(uname);
		user.setAge(Integer.parseInt(age));
		user.setDate(new Date());
		return user;
	}*/


	/**
	 * @ModelAttribute注解
	 * @param user
	 * @return
	 */
	/*@RequestMapping("/testModelAttribute")
	public String testModelAttribute(@ModelAttribute("abc") User user) {	// 使用@ModelAttribute注解获取map集合中的数据
		System.out.println(user);
		return "success";
	}*/
	/**
	 * 在请求映射的方法封装数据前，执行一些其它操作（无返回值）
	 * @param
	 * @param
	 * @return
	 */
	/*@ModelAttribute
	public void getBirthday(String uname, String age, Map<String, User> map) {
		// 模拟从数据库中，查询用户的生日
		// ...
		// 模拟返回的数据
		User user = new User();
		user.setUname(uname);
		user.setAge(Integer.parseInt(age));
		user.setDate(new Date());
		map.put("abc", user);
	}*/

	/**
	 * 使用request对象向request域中存入数据
	 * @param request
	 * @return
	 */
	@RequestMapping("/testHttpServletRequest")
	public String testHttpServletRequest(HttpServletRequest request) {
		// 存储数据到request域
		request.setAttribute("msg1", "tutu");
		return "success";
	}

	/**
	 * 使用Model接口向request域中存入数据
	 * @param model
	 * @return
	 */
	@RequestMapping("/testModel")
	public String testModel(Model model) {	// Model是spring提供的用于操作request域的接口
		// 存储数据到request域
		model.addAttribute("msg2", "coco");
		return "success";
	}

	/**
	 * 使用Model接口的实现类ModelMap，从session域中的获取数据
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/testGetSession")
	public String testGetSession(ModelMap modelMap) {
		// 从session域中获取数据
		Object msg2 = modelMap.get("msg2");
		System.out.println(msg2);
		return "success";
	}

	/**
	 * 删除session域中的数据
	 * @return
	 */
	@RequestMapping("/testDelSession")
	public String testDelSession(SessionStatus sessionStatus) {
		// 删除session域中的数据
		sessionStatus.setComplete();
		return "success";
	}

}
