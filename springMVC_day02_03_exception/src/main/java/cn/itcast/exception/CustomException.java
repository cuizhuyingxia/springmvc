package cn.itcast.exception;

/**
 * @Author Lian Flower
 * @Date 2019/9/23 15:08
 * @Version 1.0
 */

/**
 * 自定义异常类
 */
public class CustomException extends Exception {

	// 存储提示信息
	private String message;

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomException(String message) {
		this.message = message;
	}
}
