package com.example.demo10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.apache.log4j.Logger;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Demo10Application.class)
public class Demo10ApplicationTests {

	private Logger logger = Logger.getLogger(getClass());
	//private final Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void test() throws Exception {
		logger.info("输出info");
		logger.debug("输出debug");
		logger.error("输出error");
	}

}
