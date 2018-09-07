package com.example.scheduledasync04;

import com.example.scheduledasync04.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduledAsync04ApplicationTests {

	private final Logger logger= LoggerFactory.getLogger(ScheduledAsync04ApplicationTests.class);

	@Autowired
	private Task task;

	//下面的代码中，我们在get方法中还定义了该线程执行的超时时间，通过执行这个测试我们可以观察到执行时间超过5秒的时候，这里会抛出超时异常，
	//该执行线程就能够因执行超时而释放回线程池，不至于一直阻塞而占用资源。

	@Test
	public void test() throws Exception {
		Future<String> futureResult = task.run();
		String result = futureResult.get(5 , TimeUnit.SECONDS);
		logger.info(result);
	}

}
