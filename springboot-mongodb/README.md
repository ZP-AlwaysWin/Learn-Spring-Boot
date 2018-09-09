# Learn-Spring-Boot

## 数据访问

**Spring Boot中使用MongoDB数据库**

## 注意事项

一、`Springboot`改版之后将`findOne`更名为`findById`;但是`findById`并不仅仅是将`findOne`改名，它返回的对象变成了`Optional`。如果想让`findById`和`findOne`有同样的功能，可以用下面这个函数：

**老版本写法：**

`User u = userRepository.findOne(1L);`

**新版本写法:**

`User u = userRepository.findById(1L).orElse(null);`



        
二、 在`import org.springframework.data.repository.CrudRepository;`中`findById`这个方法被占用且返回值是`Optional`。

   
```$xslt
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.springframework.data.repository;

import java.util.Optional;

@NoRepositoryBean
public interface CrudRepository<T, ID> extends Repository<T, ID> {
    <S extends T> S save(S var1);

    <S extends T> Iterable<S> saveAll(Iterable<S> var1);

    Optional<T> findById(ID var1);

    boolean existsById(ID var1);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<ID> var1);

    long count();

    void deleteById(ID var1);

    void delete(T var1);

    void deleteAll(Iterable<? extends T> var1);

    void deleteAll();
}


```

所以如果还想要使用ID查看整个User对象，那么可以把该方法名改变一下

```$xslt
package com.example.springbootmongodb.entity;


import org.springframework.data.mongodb.repository.MongoRepository;

//import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);

    User findByid(Long id);

}


```

然后调用findByid这个方法
```$xslt

User u = userRepository.findByid(1L);
userRepository.delete(u);

```
