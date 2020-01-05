package cn.itcast.dao;

/**
 * @Author Lian Flower
 * @Date 2019/9/23 17:57
 * @Version 1.0
 */

import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface AccountDao {

	/**
	 * 查询所有账户
	 * @return
	 */
	@Select("select * from account")
	List<Account> findAll();

	/**
	 * 保存账户
	 * @param account
	 */
	@Insert("insert into account(name, money) values(#{name}, #{money})")
	void saveAccount(Account account);
}
