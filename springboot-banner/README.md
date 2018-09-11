# Learn-Spring-Boot
## 其他功能
**Spring Boot自定义Banner**

本文将介绍一下这个轻松愉快的自定义`banner`功能。实现的方式非常简单，我们只需要在`Spring Boot`工程的`/src/main/resources`目录下创建一个`banner.txt`文件，然后将`ASCII`字符画复制进去，就能替换默认的`banner`了。比如上图中的输出，就采用了下面的`banner.txt`内容：


### 生成工具

如果让我们手工的来编辑控制台输出的这些字符画，显然是一件非常困难的差事。所以，我们可以借助下面这些工具，轻松地根据文字或图片来生成用于`Banner`输出的字符画。

http://patorjk.com/software/taag
http://www.network-science.de/ascii/
http://www.degraeve.com/img2txt.php

字符画中还可以使用一些属性设置：

- ${AnsiColor.BRIGHT_RED}：设置控制台中输出内容的颜色
- ${application.version}：用来获取MANIFEST.MF文件中的版本号
- ${application.formatted-version}：格式化后的${application.version}版本信息
- ${spring-boot.version}：Spring Boot的版本号
- ${spring-boot.formatted-version}：格式化后的${spring-boot.version}版本信息

### 关闭Banner的写法

```
SpringApplication sb=new SpringApplication(SpringbootBannerApplication.class);
sb.setBannerMode(Banner.Mode.OFF);
sb.run(args);
```