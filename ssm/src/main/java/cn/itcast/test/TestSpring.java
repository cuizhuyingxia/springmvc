package cn.itcast.test;

import cn.itcast.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Lian Flower
 * @Date 2019/9/23 18:13
 * @Version 1.0
 */
public class TestSpring {

	@Test
	public void test1() {
		// 加载spring配置文件，创建Ioc容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取对象
		AccountService accountService = ac.getBean("accountService", AccountService.class);
		// 调用方法
		accountService.findAll();
	}
}
