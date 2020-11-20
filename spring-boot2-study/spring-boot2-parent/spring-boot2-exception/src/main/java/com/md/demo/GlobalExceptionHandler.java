package com.md.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理
 * 
 * @author Minbo
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	protected static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		logger.error("系统异常【全局异常】：" + e.getMessage(), e);
		return "error";
	}

	@ModelAttribute(name = "mydata1")
	public Map<String,Object> mydata1() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("age", 22);
		map.put("gender", "女");
		return map;
	}

	@ModelAttribute(name = "mydata2")
	public Map<String,Object> mydata2() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("age", 33);
		map.put("gender", "男");
		return map;
	}

	@InitBinder("a")
	public void a(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("a.");
	}

	@InitBinder("b")
	public void b(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("b.");
	}
}
