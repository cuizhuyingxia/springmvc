package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author Lian Flower
 * @Date 2019/9/23 20:13
 * @Version 1.0
 */
public class testMybatis {

	@Test
	public void testFindAll() throws IOException {
		// 1. 获取mybatis主配置文件的字节输入流
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 2. 根据字节输入流构建SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3. 根据SqlSessionFactory生产一个SqlSession
		SqlSession sqlSession = factory.openSession();
		// 4. 使用SqlSession创建Dao的代理对象
		AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
		// 5. 使用代理对象执行方法
		List<Account> accounts = accountDao.findAll();
		for (Account account : accounts) {
			System.out.println(account);
		}
		// 6. 释放资源
		sqlSession.close();
		inputStream.close();
	}

	@Test
	public void testSaveAccount() throws IOException {
		// 1. 获取mybatis主配置文件的字节输入流
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 2. 根据字节输入流构建SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3. 根据SqlSessionFactory生产一个SqlSession
		SqlSession sqlSession = factory.openSession();
		// 4. 使用SqlSession创建Dao的代理对象
		AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
		// 5. 使用代理对象执行方法
		Account account = new Account();
		account.setName("tutu");
		account.setMoney(2000D);
		accountDao.saveAccount(account);
		// 提交事务
		sqlSession.commit();
		// 6. 释放资源
		sqlSession.close();
		inputStream.close();
	}
}
