package cn.itcast.controller;

/**
 * @Author Lian Flower
 * @Date 2019/9/23 18:01
 * @Version 1.0
 */

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 账户的表现层
 */
@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	/**
	 * 查询所有
	 * @param model
	 * @return
	 */
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		System.out.println("表现层：查询所有账户");
		// 调用service的方法
		List<Account> accounts = accountService.findAll();
		// 将查询的结果存入到request域中
		model.addAttribute("accounts", accounts);
		return "list";
	}

	/**
	 * 保存
	 * @param account
	 * @return
	 */
	@RequestMapping("/save")
	public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("表现层：保存账户");
		accountService.saveAccount(account);
		// 重定向，再次查询所有账户
		response.sendRedirect(request.getContextPath() + "/account/findAll");
	}
}
