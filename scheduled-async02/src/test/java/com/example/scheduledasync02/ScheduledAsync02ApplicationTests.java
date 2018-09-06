package com.example.scheduledasync02;

import com.example.scheduledasync02.task.Task;
import com.example.scheduledasync02.task.TaskAsyncIf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduledAsync02ApplicationTests {

	@Autowired
	private Task task;

	@Autowired
	private TaskAsyncIf taskasync;

//	@Test
//	public void test() throws Exception {
//		taskasync.doTaskOne();
//		taskasync.doTaskTwo();
//		taskasync.doTaskThree();
//	}

	@Test
	public void test() throws Exception {

		long start = System.currentTimeMillis();

		Future<String> task1 = taskasync.doTaskOne();
		Future<String> task2 = taskasync.doTaskTwo();
		Future<String> task3 = taskasync.doTaskThree();

		while(true) {
			if(task1.isDone() && task2.isDone() && task3.isDone()) {
				// 三个任务都调用完成，退出循环等待
				break;
			}
			Thread.sleep(1000);
		}

		long end = System.currentTimeMillis();

		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

	}

}
