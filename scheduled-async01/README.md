# Learn-Spring-Boot
## 定时与异步任务
Spring Boot中使用@Scheduled创建定时任务

**该实例介绍如何在Spring Boot中创建定时任务，实现每过5秒输出一下当前时间。**

- 在Spring Boot的主类中加入@EnableScheduling注解，启用定时任务的配置

## @Scheduled详解

在该入门例子中，使用了
<font color=#00ffff size=3>@Scheduled(fixedRate = 5000)</font>注解来定义每过5秒执行的任务，对于<font color=#00ffff size=3>@Scheduled</font>的使用可以总结如下几种方式：

- <font color=#00ffff size=3>@Scheduled(fixedRate = 5000)</font> ：上一次开始执行时间点之后5秒再执行
- <font color=#00ffff size=3>@Scheduled(fixedDelay = 5000) </font>：上一次执行完毕时间点之后5秒再执行
- <font color=#00ffff size=3>@Scheduled(initialDelay=1000, fixedRate=5000)</font> ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
- <font color=#00ffff size=3> @Scheduled(cron="*/5 * * * * *") </font> ：通过cron表达式定义规则
