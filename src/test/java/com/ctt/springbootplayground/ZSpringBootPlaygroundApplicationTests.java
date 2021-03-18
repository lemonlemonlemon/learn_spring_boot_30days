package com.ctt.springbootplayground;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ctt.springbootplayground.model.MemberAccount;
import com.fasterxml.jackson.databind.ObjectMapper;


//1.RunWith : 要用org.springframework.test.context.junit4.SpringJUnit4ClassRunner的類來做為運行我們的類
//2.SpringBootTest(classes = ? ) : ?後為你的main class的主類名稱
//3.WebAppConfiguration : WebAppConfiguration如果你要使用Web的環境來做測試模擬這是要加上去的
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZSpringBootPlaygroundApplication.class)
@WebAppConfiguration
public class ZSpringBootPlaygroundApplicationTests {
	
	// for tutorial project. 
	/*
	@Autowired
	private MemberApiRepository memberApiRepository; //加入MemberRepository
	*/
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	MockMvc mvc; // 創建MockMvc類的物件
	
	@Before
	public void setup(){
		
//		Memberaccount memberaccount = new Memberaccount();
//		memberaccount.setId(1);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
	}

	@Test
	public void contextLoads() throws Exception {
		
		/*
		uri : 我設定一個字串去存取我要測試的REST入口方法,這邊以Get方法做測試

		perform(request):此方法為要做一個請求的建立,這是一個模擬請求的方式

		get(url) : 要去request(請求)的連結
		accept: 接受何種格式回傳 我用MediaType.APPLICATION_JSON 接受以JSON格式回傳
		andReturn方法 : 將結果轉換成MockMvc的型態

		status : 回傳狀態的變數

		MvcResult getResponse().getStatus() : 取回回傳狀態

		Assert(斷言測試)
		assertEquals("string",200(statusCode),status)
		第一個參數:當發生錯誤時要產生的提示文字
		第二個參數: 當返回值非第二個參數的數值時觸發
		第三個參數: 返回參數
		*/
		
		System.out.println("contextLoads, hello world");
		
		String uri = "/index.html";
		
		// .accept() ? why OK?
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)
										.accept(MediaType.APPLICATION_JSON)
										)
									.andReturn();

		int status = result.getResponse().getStatus();
		System.out.println(result.getResponse().getContentAsString());

		int expectedCode = 200;
		System.out.println(status);
		Assert.assertEquals("錯誤, 不是預期的" + expectedCode, expectedCode, status);

	}
	
	@Autowired
	ObjectMapper objectMapper;

	//MemberAccount memberaccount;
	
	/*
	
	@Test
	public void contextLoads2() throws Exception {
		
		System.out.println("contextLoads2, hello world");
		
		// setup, start ======
		memberaccount = new MemberAccount();
//		
		memberaccount.setCellphone("02135121");
		memberaccount.setEmail("qewq@qwe.asd.s");
		memberaccount.setPassword("qweqqq");
		// mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		// setup, end ======
		
		String uri = "/index.html";
		
		try{

			MvcResult result = mvc.perform(MockMvcRequestBuilders.post(uri)
						.content(objectMapper.writeValueAsString(memberaccount))
					.accept(MediaType.APPLICATION_JSON)).andReturn();

			int status = result.getResponse().getStatus();

			Assert.assertEquals("錯誤", 200, status);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	*/
	
	

}
