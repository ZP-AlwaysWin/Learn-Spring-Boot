# Learn-Spring-Boot

## 事务管理

**Spring Boot中的事务管理**

## 注意事项
表类型是`MyISAM`，是非事务安全的，所以无法实现事物回滚。 

只有表的类型是`Innodb`，才可以进行对事物的回滚。

`SpringBoot`升级到2.0+版本后，依然是使用`jpa`、`Hibernate`来操作`mysql`，发现`Hibernate`默认创建的表是`myisam`引擎，而不是`innodb`。添加下面的配置即可修改为`innodb`

```
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
#不加这句则默认为myisam引擎
```

## 事务详解

本文中例子我们使用了默认的事务配置，可以满足一些基本的事务需求，但是当我们项目较大较复杂时（比如，有多个数据源等），这时候需要在声明事务时，指定不同的事务管理器。对于不同数据源的事务管理配置可以见[《Spring Boot多数据源配置与使用》](https://github.com/ZP-AlwaysWin/Learn-Spring-Boot/tree/master/demo8)中的设置。在声明事务时，只需要通过`value`属性指定配置的事务管理器名即可，例如：`@Transactional(value="transactionManagerPrimary")。`

除了指定不同的事务管理器之后，还能对事务进行隔离级别和传播行为的控制，下面分别详细解释：

### 隔离级别

隔离级别是指若干个并发的事务之间的隔离程度，与我们开发时候主要相关的场景包括：脏读取、重复读、幻读。

我们可以看`org.springframework.transaction.annotation.Isolation`枚举类中定义了五个表示隔离级别的值：

```
public enum Isolation {
    DEFAULT(-1),
    READ_UNCOMMITTED(1),
    READ_COMMITTED(2),
    REPEATABLE_READ(4),
    SERIALIZABLE(8);
}
```

`DEFAULT`：这是默认值，表示使用底层数据库的默认隔离级别。对大部分数据库而言，通常这值就是：`READ_COMMITTED`。

`READ_UNCOMMITTED`：该隔离级别表示一个事务可以读取另一个事务修改但还没有提交的数据。该级别不能防止脏读和不可重复读，因此很少使用该隔离级别。

`READ_COMMITTED`：该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止脏读，这也是大多数情况下的推荐值。

`REPEATABLE_READ`：该隔离级别表示一个事务在整个过程中可以多次重复执行某个查询，并且每次返回的记录都相同。即使在多次查询之间有新增的数据满足该查询，这些新增的记录也会被忽略。该级别可以防止脏读和不可重复读。

`SERIALIZABLE`：所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，该级别可以防止脏读、不可重复读以及幻读。但是这将严重影响程序的性能。通常情况下也不会用到该级别。

#### 指定方法：通过使用`isolation`属性设置，例如：

`@Transactional(isolation = Isolation.DEFAULT)`

### 传播行为

所谓事务的传播行为是指，如果在开始当前事务之前，一个事务上下文已经存在，此时有若干选项可以指定一个事务性方法的执行行为。

我们可以看`org.springframework.transaction.annotation.Propagation`枚举类中定义了6个表示传播行为的枚举值：

```
public enum Propagation {
    REQUIRED(0),
    SUPPORTS(1),
    MANDATORY(2),
    REQUIRES_NEW(3),
    NOT_SUPPORTED(4),
    NEVER(5),
    NESTED(6);
}

```

`REQUIRED`：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。

`SUPPORTS`：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。

`MANDATORY`：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。

`REQUIRES_NEW`：创建一个新的事务，如果当前存在事务，则把当前事务挂起。

`NOT_SUPPORTED`：以非事务方式运行，如果当前存在事务，则把当前事务挂起。

`NEVER`：以非事务方式运行，如果当前存在事务，则抛出异常。

`NESTED`：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于`REQUIRED`。

#### 指定方法：通过使用`propagation`属性设置，例如：

`@Transactional(propagation = Propagation.REQUIRED)`