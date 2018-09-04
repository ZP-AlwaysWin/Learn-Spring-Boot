package com.example.demo11;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.slf4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Demo11Application.class)
public class Demo11ApplicationTests {
	//private  final Logger logger = LoggerFactory.getLogger(getClass());
	private Logger logger = Logger.getLogger(getClass());

	@Test
	public void test() throws Exception {
		logger.info("输出info");
		logger.debug("输出debug");
		logger.error("输出error");
	}

}
