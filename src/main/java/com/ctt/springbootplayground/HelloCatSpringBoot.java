package com.ctt.springbootplayground;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCatSpringBoot {

	// 透過 @RequestMapping 指定從/會被對應到此hello()方法
	@RequestMapping("/hellocat")
	public String hellocat() {
		return "return hello cat";
	}

}
