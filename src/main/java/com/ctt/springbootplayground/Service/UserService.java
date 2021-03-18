package com.ctt.springbootplayground.Service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	public Integer getUserId() {
		
		int userId = 5;
		System.out.println("進入了UserService的getUserId方法, " + userId);
		
		return userId;
	}

}
