# Learn-Spring-Boot

## 数据访问
Spring pring Boot中多数据源配置(一)：JdbcTemplate版本

## 注意事项：

### 1. spring boot 版本 2.0.1.RELEASE spring.datasource.boot.url 变成 spring.datasource.boot.jdbc-url

### 2. @Bean与@Qualifier合用的功能
使用@Qualifier注解并且设置内容，是为了防止注入时冲突问题,功能和上述函数的@Bean一样,类似一个别名，但是@Qualifier不能单独存在，
否则下面引用@Qualifier别名会报没有对应Bean的错误。
@Primary
@Primary配置了数据源为主数据源，当没有配置自动切换的package时默认使用该数据源进行数据处理操作。