## 一、Spring Boot 注入接口 @Autowired interface 自动装配

**前言：@Service @Component @Configuration 注入方式相同**
接口只有唯一一个实现类的注入方式

先创建一个接口VideoService
```
public interface VideoService {

   String getVideoName();

}
```
创建一个接口的实现类VideoServiceImpl，使用@Service注解
```
@Service
public class VideoServiceImplA implements VideoService {

  @Override
  public String getVideoName() {
    return "三生三世十里桃花";
  }

}
```
在其他类中注入VideoService，此处以一个Controller类示例：

```
@RestController
public class HomeController {

  @Autowired
  //@Resource 跟上述注解的功能一致
  private VideoService videoService;

  @RequestMapping("/video")
  public String videoName(){
    return videoService.getVideoName();
  }

}
```


具体注入详情如下（需添加spring-boot-starter-actutor）：

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

```



新增一个VideoService的实现类VideoServiceImplB：
```
@Service
public class VideoServiceImplB implements VideoService{

  @Override
  public String getVideoName() {
    return "人民的名义";
  }

}
```


### 多个实现类情况

Spring给了明确提示说有2个Bean被找到，但是只需要一个。建议使用@Primary注解使其优先被选择，或者使用@Qualifier指定注入一个Bean。

先看第一种@Primary注解，在VideoServiceImplB上添加@Primary注解：
```
@Service
@Primary
public class VideoServiceImplB implements VideoService{

  @Override
  public String getVideoName() {
    return "人民的名义";
  }

}
```


@Primary注解VideoServiceImplB
HomeController中注入的也是videoServiceImplB：


**总结：使用@Primary注解的实现类会被优先注入**
再来看看@Qualifier注解，去掉VideoServiceImplB的@Primary注解，改写HomeController的代码：
```
@RestController
public class HomeController {

  @Autowired
  @Qualifier("videoServiceImplB")
  private VideoService videoService;

  @RequestMapping("/video")
  public String videoName(){
    return videoService.getVideoName();
  }

}
```

**总结：使用@Qualifier注入指定Bean的时候，若没有指明Bean的名称，则其默认名称是首字母小写的类名。**
那么如何指定Bean的名称呢？

此处的value值即为bean的名称，使用时将 @Service 改为 @Service("bean名称") 即可。注入时使用 @Qualifier("bean名称")
```
@Service("videoB")
public class VideoServiceImplB implements VideoService{

  @Override
  public String getVideoName() {
    return "人民的名义";
  }

}
```


```
@RestController
public class HomeController {

  @Autowired
  @Qualifier("videoB")
  private VideoService videoService;

  @RequestMapping("/video")
  public String videoName(){
    return videoService.getVideoName();
  }

}
```
指定Bean名称




## 二、使用Autowired

一般情况下，controller和service是有关联关系的，service和DAO层是有关联关系的，我们使用autowired注解，在controller中装配service，在service中装配reponsitory
```
package com.zj.annotation.service;

public interface TestService {
    void add();
}

```

```
package com.zj.annotation.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service 
public class TestServiceImpl implements TestService {

    @Override
    public void add() {
        System.out.println("service impl add.....");
    }

}
```
```
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    public void excute(){
        testService.add();
    }
}

```
**注意:** 使用autowired的前提是TestService的bean归IOC容器管理（使用注解或配置文件配置的方式配置了该bean）
如果没有创建testService这个bean，那么将抛异常
也可以使用required=false来声明可以不创建该bean：@Autowired(required=false)
autowired也可以用于方法

```
@Controller
public class TestController {

    private TestService testService;

    @Autowired
    private void getTestService(TestService testService) {
        this.testService = testService;
    }

    public void excute(){
        testService.add();
    }
}
```

这种写法和上面效果一样

### 细节注意

如果有多个类实现了TestService这个接口，那么autowired会自动装配哪个？

根据实现类的name，如其中一个实现类：@Service(“testService”)，那么就自动装配这个实现类，因为private TestService testService;
如果有多个实现类，但是没有指明name怎么办？

如果没有指明name，将会抛异常，但是我们可以使用@Qualifier注解来说明使用哪一个实现类

```
@Controller
public class TestController {

    @Autowired
    @Qualifier("testServiceImpl2")
    private TestService testService;

    public void excute(){
        testService.add();
    }
}
```

实现类为TestServiceImpl2，bean的name（id）默认为testServiceImpl2
@Qualifier也可以用于方法，或者方法的参数，如：

```
    private TestService testService;

    @Autowired
    @Qualifier("testServiceImpl2")
    private void getTestService(TestService testService) {
        this.testService = testService;
    }
```

或者

```
    private TestService testService;

    @Autowired
    private void getTestService(@Qualifier("testServiceImpl2")TestService testService) {
        this.testService = testService;
    }

```