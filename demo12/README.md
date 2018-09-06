# Learn-Spring-Boot

## 日志管理
Spring boot中使用AOP统一处理Web请求日志

## 注意事项：

**在最新版的springboot里面无法测试成功：**

```
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.4.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
</parent>
```

在高版本测试不通过的问题是，导入日志的包估计已经废弃了：

`import org.apache.log4j.Logger;`

**低版本的springboot里面可以测试成功该demo11**

```
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.3.2.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
</parent>
```



## 优化：AOP切面的优先级

由于通过AOP实现，程序得到了很好的解耦，但是也会带来一些问题，比如：我们可能会对Web层做多个切面，校验用户，校验头信息等等，这个时候经常会碰到切面的处理顺序问题。

所以，我们需要定义每个切面的优先级，我们需要`@Order(i)`注解来标识切面的优先级。**i的值越小，优先级越高**。假设我们还有一个切面是`CheckNameAspect`用来校验name必须为moons，我们为其设置`@Order(10)`，而上文中`WebLogAspect`设置为`@Order(5)`，所以`WebLogAspect`有更高的优先级，这个时候执行顺序是这样的：

在`@Before`中优先执行`@Order(5)`的内容，再执行`@Order(10)`的内容
在`@After`和`@AfterReturning`中优先执行`@Order(10)`的内容，再执行`@Order(5)`的内容
所以我们可以这样子总结：

- 在切入点前的操作，按order的值由小到大执行
- 在切入点后的操作，按order的值由大到小执行