package cn.itcast.domain;

import java.io.Serializable;

/**
 * @Author Lian Flower
 * @Date 2019/9/21 17:09
 * @Version 1.0
 */
public class User implements Serializable {

	private String username;
	private String Password;
	private Integer age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", Password='" + Password + '\'' +
				", age=" + age +
				'}';
	}
}
