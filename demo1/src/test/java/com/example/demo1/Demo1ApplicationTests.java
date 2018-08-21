package com.example.demo1;

import com.example.demo1.controller.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {
	//使用MockServletContext来构建一个空的WebApplicationContext，
	//这样我们创建的HelloController就可以在@Before函数中创建并传递到MockMvcBuilders.standaloneSetup（）函数中。
	//注意引入下面内容，让status、content、equalTo函数可用

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
//				.andExpect(content().string(equalTo("http://blog.didispace.com")));
	}

}




