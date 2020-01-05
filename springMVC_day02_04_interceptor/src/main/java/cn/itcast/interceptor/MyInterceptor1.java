package cn.itcast.interceptor;

/**
 * @Author Lian Flower
 * @Date 2019/9/23 16:55
 * @Version 1.0
 */

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyInterceptor1 implements HandlerInterceptor {

	/**
	 * 预处理方法，在Controller方法执行之前执行
	 * @param request
	 * @param response
	 * @param handler
	 * @return true：放行，执行下一个拦截器，如果没有拦截器了，则执行Controller方法		false：不放行，可以直接转发到其它页面
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("MyInterceptor1执行了...预处理方法");
		// 如果不想放行的话，可以转发到其它页面，返回false即可
		//request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
		return true;
	}

	/**
	 * 后处理方法，在Controller方法执行后，跳转到响应页面之前，执行
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("MyInterceptor1执行了...后处理方法");
		// 也可以在这里，设置转发页面
		//request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
	}

	/**
	 * 最后执行的方法，在Controller方法执行完并跳转到响应页面后，执行该方法
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// 该方法一般用于释放资源
		System.out.println("MyInterceptor1执行了...最后执行的方法");
	}
}
