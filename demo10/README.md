# Learn-Spring-Boot

## 日志管理
Spring boot中使用log4j记录日志

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

**低版本的springboot里面可以测试成功该demo9**

```
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.3.2.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
</parent>
```

