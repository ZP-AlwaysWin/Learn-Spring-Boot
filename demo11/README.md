# Learn-Spring-Boot

## 日志管理
Spring boot中对log4j进行多环境不同日志级别的控制

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

**对于不同环境的使用人员也不需要改变代码或打包文件，只需要通过执行命令中参加参数即可，比如我想采用生产环境的级别，那么我可以这样运行应用：**


`java -jar xxx.jar --spring.profiles.active=prod`
