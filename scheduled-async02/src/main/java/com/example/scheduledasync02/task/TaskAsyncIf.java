package com.example.scheduledasync02.task;

import java.util.concurrent.Future;

public interface TaskAsyncIf {
    public Future doTaskOne() throws Exception;
    public Future doTaskTwo() throws Exception;
    public Future doTaskThree() throws Exception;
}
