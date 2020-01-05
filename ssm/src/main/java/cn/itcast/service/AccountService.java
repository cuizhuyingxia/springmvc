package cn.itcast.service;

/**
 * @Author Lian Flower
 * @Date 2019/9/23 17:59
 * @Version 1.0
 */

import cn.itcast.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface AccountService {

	/**
	 * 查询所有账户
	 * @return
	 */
	List<Account> findAll();

	/**
	 * 保存账户
	 * @param account
	 */
	void saveAccount(Account account);
}
