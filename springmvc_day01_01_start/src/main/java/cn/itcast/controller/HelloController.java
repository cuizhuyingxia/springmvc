package cn.itcast.controller;

/**
 * @Author Lian Flower
 * @Date 2019/9/17 11:43
 * @Version 1.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制器类
 *
 * 		@RequestMapping
 * 			作用：用于建立请求url和请求映射的方法之间的关系
 * 			属性：
 * 				path：		用于指定请求的url
 * 				value：		和path属性的作用一样
 * 				method：		用于限定请求的方式
 * 				params：		用于限定请求的参数，
 * 								例如：params = {"username=heihei"}
 * 									即要求请求url中必须有请求参数username，且参数值为heihei
 * 				headers：	用于限定请求消息头
 * 								例如：headers = {"Accept"}
 * 									即要求请求消息头中必须包含请求头Accept
 *
 *
 */
@Controller
@RequestMapping("/user")
public class HelloController {

	// 配置请求映射，当请求路径为/hello时，就会执行该方法
	@RequestMapping("/hello")
	public String satHello() {
		System.out.println("Hello SpringMVC");
		/*
		springmvc有个默认的规则，当请求映射的方法返回一个字符串时，
			springmvc的视图解析器，就会把这个字符串看作是JSP页面的名称，
				然后会到指定的目录下，查找这个字符串对应的JSP页面
					最后会转发到这个JSP页面上
						可以在springmvc.xml中配置视图解析器
		 */
		return "success";
	}

	@RequestMapping(value = "/world", method = RequestMethod.GET, params = {"username=heihei"}, headers = {"Accept"})
	public String sayWorld() {
		System.out.println("World");
		return "success";
	}
}
