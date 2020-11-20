package com.md.demo.rest;

import com.md.demo.model.Author;
import com.md.demo.model.Book;
import com.md.demo.util.JsonResult;
import com.md.demo.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Minbo
 */
@RestController
public class InitRest {

	protected static Logger logger = LoggerFactory.getLogger(InitRest.class);

	/**
	 * http://localhost:9090/hello
	 * 
	 * @return
	 */
	@GetMapping("/hello")
	public String hello(Model model) {
		Map<String, Object> map = model.asMap();
		System.out.println(map);

		return "Hello greetings from spring-boot2-exception";
	}

	/**
	 * http://localhost:9090/exception
	 * 
	 * @return
	 */
	@GetMapping("/exception")
	public String exception() {
		int a = 10 / 0;
		return "exception，" + a;
	}

	@GetMapping("/error")
	public JsonResult error() {
		return new JsonResult(ResultCode.SUCCESS_FAIL, "error错误");
	}

	/**
	 * 无法区分同名属性，Author和Book的name属性取值相同
	 * @param author
	 * @param book
	 */
	@PostMapping("/bookA")
	public void addBook1(Author author, Book book) {
		System.out.println(author.toString());
		System.out.println(book.toString());
	}

	/**
	 * 可以分开给Author及Book的同名属性赋值
	 * 赋值需带上a.及b.：a.name=aaa a.age=10 b.name=bbb b.price=20
	 *
	 * @param author
	 * @param book
	 */
	@PostMapping("/bookB")
	public void addBook2(@ModelAttribute("a") Author author, @ModelAttribute("b") Book book) {
		System.out.println(author.toString());
		System.out.println(book.toString());
	}
}