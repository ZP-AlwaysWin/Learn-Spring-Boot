## Spring Boot自动化配置的利弊及解决之道

### Spring Boot中的双刃剑：自动化配置
`Spring Boot`的自动化配置会给我们带来的超便利的新开发方式。但是，在一些情况下`Spring Boot`的自动化配置也会给我们惹来不少的麻烦，比如这些场景：

项目依赖复杂的情况下，由于依赖方的依赖组织不够严格，可能引入了一些实际我们不需要的依赖，从而导致我们的项目满足一些特定的自动化配置。
传统`Spring`项目转换为`Spring Boot`项目的过程中，由于不同的组织方式问题，引发自动化配置加载的错误，比如：通过`xml`手工组织的多数据源配置等。
上面这些原因都会导致不必要的自动化配置加载而导致应用无法启动或触发`/health`的健康检查不通过等问题。比如，我们在改造传统`Spring`项目到`Spring Boot`项目中碰到的一些错误：

```
九月 12, 2018 6:23:47 下午 org.apache.catalina.loader.WebappClassLoaderBase clearReferencesThreads
警告: The web application [ROOT] appears to have started a thread named [Abandoned connection cleanup thread] but has failed to stop it. This is very likely to create a memory leak. Stack trace of thread:
 java.lang.Object.wait(Native Method)
 java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
 com.mysql.jdbc.AbandonedConnectionCleanupThread.run(AbandonedConnectionCleanupThread.java:43)
2018-09-12 18:23:47,230 INFO  [main] org.springframework.boot.autoconfigure.logging.AutoConfigurationReportLoggingInitializer - 

Error starting ApplicationContext. To display the auto-configuration report re-run your application with 'debug' enabled.
2018-09-12 18:23:47,237 ERROR [main] org.springframework.boot.diagnostics.LoggingFailureAnalysisReporter - 

***************************
APPLICATION FAILED TO START
***************************

Description:

Cannot determine embedded database driver class for database type NONE

Action:

If you want an embedded database please put a supported one on the classpath. If you have database settings to be loaded from a particular profile you may need to active it (no profiles are currently active).
```

从报错信息中，我们就可以分析出错误原因是触发了数据源的自动化配置，然而当前项目其实并不需要数据源。查其根源是依赖方提供的API依赖中引用了一些多余的依赖触发了该自动化配置的加载。

**如何解决:**
为了解决上面所述的问题，我们可以用两种方法来解决：

#### 一、通过外部依赖的修改来解决：通过与依赖方沟通，在对方提供的`API`依赖中去掉不必要的依赖
#### 二、通过禁用指定的自动化配置来避免加载不必要的自动化配置，下面列举了禁用的方法：
- 使用了`@EnableAutoConfiguration`的时候

`@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})`

- 使用了`@SpringBootApplication`的时候

`@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})`

- 使用了`@SpringCloudApplication`的时候

```
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringCloudApplication
```

- 通过配置文件来设置

`spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration`
