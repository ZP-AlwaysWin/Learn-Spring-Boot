# Learn-Spring-Boot
## 其他功能
**Spring Boot快速开发利器：Spring Boot CLI**

**Spring Boot CLI（Command Line Interface）是一个命令行工具，您可以用它来快速构建Spring原型应用。通过Spring Boot CLI，我们可以通过编写Groovy脚本来快速的构建出Spring Boot应用，并通过命令行的方式将其运行起来。**


## 安装Spring Boot CLI

关于Spring Boot CLI的安装方式有很多，这里根据目前主要主流的开发平台，具体介绍一下Windows和Mac下的安装方式：

### 通用安装

先介绍一个所有平台都可以使用的安装方法。

- 第一步：下载Spring Boot CLI的工具包：
    压缩包已经上传到该项目路径的GitHub：spring-boot-cli-2.0.1.RELEASE-bin.zip
- 第二步：解压下载内容，可以看到bin目录下已经有适用于windows和linux平台的两个可执行文件了，我们已经可以直接使用它；为了更方便的使用Spring Boot CLI的命令，我们可以将上面bin目录中对应的可执行文件加入到当前系统的环境变量即可。


### 验证安装

不论使用哪种方法安装，在安装好之后，我们可以通过下面的命令来验证一下当前的安装结果：
```
$ spring --version
Spring CLI v2.0.0.RELEASE
```

### 运行Groovy脚本

在完成了Spring Boot CLI的安装之后，我们来试试使用它来快速的构建一个Spring Boot应用，方法很简单，只需要如下操作：

- 第一步：新建一个Groovy脚本，hello.groovy，内容如下：

```
@RestController
class ThisWillActuallyRun {

    @RequestMapping("/")
    String home() {
        "Hello World!"
    }
    
}

```

- 第二步：使用spring命令运行该Groovy脚本，具体如下：

```
$ spring run hello.groovy
Resolving dependencies......

```

从日志中我们可以看到我们通过Groovy脚本定义的一个简单web应用就构建成功了，可以通过访问localhost:8080来验证一下上面应用提供的接口：

```
$ curl localhost:8080
Hello World!

```