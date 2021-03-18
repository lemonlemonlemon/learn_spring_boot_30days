package com.ctt.springbootplayground;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctt.springbootplayground.Service.UserService;

/*
 * 重點說明:
1.在Service的public class UserService上方加入@Service對這個類別宣告為Spring管理的一個Bean
2.在UserController下方下方使用@Autowired將UserService的實體Bean注入到UserController讓
UserController擁有UserService的功能

重新啟動我們的Spring Boot Application
在瀏覽器輸入
(http://localhost:8080)
 */

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String index(Map<String, Integer> model) {
		
	 	model.put("ID", userService.getUserId());
	 	
		return "index";
	}

}
