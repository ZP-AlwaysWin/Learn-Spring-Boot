package com.example.scheduledasync04.task;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

@Slf4j
@Component
public class Task {

    public static Random random = new Random();
    private  final Logger logger = LoggerFactory.getLogger(Task.class);

    @Async("taskExecutor")
    public Future<String> run() throws Exception {
        long sleep = random.nextInt(10000);
        logger.info("开始任务，需耗时：" + sleep + "毫秒");
        Thread.sleep(sleep);
        logger.info("完成任务");
        return new AsyncResult<>("test");
    }

}