package cn.itcast.service.impl;

/**
 * @Author Lian Flower
 * @Date 2019/9/23 18:00
 * @Version 1.0
 */

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层接口实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

	// 注入AccountDao接口的代理对象
	@Autowired
	private AccountDao accountDao;

	@Override
	public List<Account> findAll() {
		System.out.println("业务层：查询所有账户");
		return accountDao.findAll();
	}

	@Override
	public void saveAccount(Account account) {
		System.out.println("业务层：保存账户");
		accountDao.saveAccount(account);
	}
}
