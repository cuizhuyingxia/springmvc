package cn.itcast.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Lian Flower
 * @Date 2019/9/23 14:54
 * @Version 1.0
 */
@Component
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/testInterceptor")
	public String testException() {
		System.out.println("testInterceptor执行了...Controller方法");
		return "success";
	}
}
