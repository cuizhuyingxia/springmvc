package cn.itcast.controller;

import cn.itcast.exception.CustomException;
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

	@RequestMapping("/testException")
	public String testException() throws CustomException {
		System.out.println("testException执行了...");
		try {
			// 模拟异常
			int i = 3 / 0;
		} catch (Exception e) {
			// 在控制台打印异常信息
			e.printStackTrace();
			// 抛出自定义异常类的提示信息
			throw new CustomException("查询所用用户时出现错误...");
		}
		return "success";
	}
}
