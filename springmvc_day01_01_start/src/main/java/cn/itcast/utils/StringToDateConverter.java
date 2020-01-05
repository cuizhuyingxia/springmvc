package cn.itcast.utils;

/**
 * @Author Lian Flower
 * @Date 2019/9/18 17:20
 * @Version 1.0
 */

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器
 * 		将字符串转换为日期
 *
 * 		因为springMVC提供的转换器，只能将2019/9/18这种格式的字符串转换为日期，
 * 			对于2019-9-18这种格式，则无法转换为日期
 * 				所以，我们可以自定义类型转换器，将2019-9-18这种格式，转换为日期
 */
public class StringToDateConverter implements Converter<String, Date> {

	/**
	 *
	 * @param source	传入的字符串
	 * @return
	 */
	@Override
	public Date convert(String source) {
		// 判断传入的参数是否为空
		if (source == null) {
			throw new RuntimeException("请您传入数据（参数）");
		}
		// 定义转换器，将字符串转换为日期
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// 转换为日期
			return df.parse(source);
		} catch (Exception e) {
			throw new RuntimeException("数据类型转换异常");
		}

		/*
		注意：如果需要将用户传入的数据转换为日期时，spring默认是可以将yy/MM/dd这种格式的字符串转换为日期，不能将yyyy-MM-dd这种格式的字符串转换为日期；
				而如果我们自定义了转换器，即使得springMVC可以将yyyy-MM-dd这种格式的字符串转换为日期，
					那么springMVC将无法再把yyyy/MM/dd这种格式的字符串转换为日期
						就是说我们自定义的转换器，会覆盖掉springMVC中对应的转换器规则
		 */
	}
}
