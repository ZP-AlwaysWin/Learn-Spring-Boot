# Learn-Spring-Boot
## 数据访问
Spring Boot中使用Spring-data-jps让数据访问更简单、更优雅

## 注意事项：

### 1. 如果在使用Hibernate的时候，用annotation的话，提示Entity过时；

**解决办法：**

import javax.persistence.Entity;
导入这个包，如果提示过期，你看看是不是jdk报出来的，jdk7是不包提示的

### 2. 如果启动的时候报如下错误；

**[异常信息]**

`Error performing load command : org.hibernate.InstantiationException: No default constructor for entity:  : entity.User`

**[原因]**

```
The no-argument constructor, which is also a JavaBean convention, is a requirement for all persistent classes. Hibernate needs to create objects for you, using Java Reflection. 
```

所有持久化类必须要求有不带参的构造方法（也是JavaBean的规范）。Hibernate需要使用Java反射为你创建对象。

                                                                                         ——来自官方文档《Hibernate Getting Started Guide》

**[解决方法]**

当实体类声明了其他带参构造方法时，需要显式声明不带参构造方法。
