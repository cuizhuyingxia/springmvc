package cn.itcast.exception;

/**
 * @Author Lian Flower
 * @Date 2019/9/23 15:12
 * @Version 1.0
 */

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理器
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	/**
	 * 处理器处理异常业务逻辑
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param o
	 * @param e	捕获到的异常
	 * @return
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
		// 获取自定义异常类对象
		CustomException customException = null;
		// 如果异常处理器捕获到的异常为CustomException
		if (e instanceof CustomException) {
			// 则将捕获到的异常强转为CustomException
			customException = (CustomException)e;
		} else {
			// 否则，创建CustomException对象，并给出提示信息
			customException = new CustomException("系统正在维护");
		}
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 将异常提示信息存储到request域中
		modelAndView.addObject("errorMsg", customException.getMessage());
		// 设置响应的页面
		modelAndView.setViewName("error");
		return modelAndView;
	}
}
