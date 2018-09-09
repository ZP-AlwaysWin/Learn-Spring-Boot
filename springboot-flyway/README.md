# Learn-Spring-Boot

## 数据访问
**Spring Boot中使用Flyway来管理数据库版本**

### Flyway存在的价值

在之前使用`JdbcTemplate`一文中，主要通过`spring`提供的`JdbcTemplate`实现对用户表的增删改查操作。在实现这个例子的时候，我们事先在`MySQL`中创建了用户表。创建表的过程我们在实际开发系统的时候会经常使用，但是一直有一个问题存在，由于一个系统的程序版本通过`git`得到了很好的版本控制，而数据库结构并没有，即使我们通过`Git`进行了语句的版本化，那么在各个环境的数据库中如何做好版本管理呢？下面我们就通过本文来学习一下在`Spring Boot`中如何使用`Flyway`来管理数据库的版本。

### Flyway简介
`Flyway`是一个简单开源数据库版本控制器（约定大于配置），主要提供`migrate`、`clean`、`info`、`validate`、`baseline`、`repair`等命令。它支持`SQL`（`PL/SQL`、`T-SQL`）方式和`Java`方式，支持命令行客户端等，还提供一系列的插件支持（`Maven`、`Gradle`、`SBT`、`ANT`等）。

**官方网站：**

https://flywaydb.org/

本文具体说说在`Spring Boot`应用中的应用，如何使用`Flyway`来创建数据库以及结构不一致的检查。

## 注意事项：

**使用Flyway自动建表的时候，第一次表要不存在或者为空**

