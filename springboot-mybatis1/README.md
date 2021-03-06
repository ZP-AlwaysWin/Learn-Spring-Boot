# Learn-Spring-Boot

## 数据访问

**Spring Boot中使用MyBatis注解配置详解**


### 传参方式
**下面通过几种不同传参方式来实现前文中实现的插入操作。**

#### 使用@Param
在之前的整合示例中我们已经使用了这种最简单的传参方式，如下：

```
@Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
int insert(@Param("name") String name, @Param("age") Integer age);

```

这种方式很好理解，`@Param`中定义的`name`对应了SQL中的`#{name}`，`age`对应了SQL中的`#{age}`。

#### 使用Map
如下代码，通过`Map`对象来作为传递参数的容器：

```
@Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
int insertByMap(Map<String, Object> map);
```

对于`Insert`语句中需要的参数，我们只需要在`map`中填入同名的内容即可，具体如下面代码所示：
```
Map<String, Object> map = new HashMap<>();
map.put("name", "CCC");
map.put("age", 40);
userMapper.insertByMap(map);
```

#### 使用对象
除了`Map`对象，我们也可直接使用普通的`Java`对象来作为查询条件的传参，比如我们可以直接使用`User`对象:
```
@Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
int insertByUser(User user);
```

这样语句中的`#{name}`、`#{age}`就分别对应了User对象中的`name`和`age`属性。

### 增删改查
MyBatis针对不同的数据库操作分别提供了不同的注解来进行配置，在之前的示例中演示了`@Insert`，下面针对`User`表做一组最基本的增删改查作为示例：
```
public interface UserMapper {

    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);
}
```
在完成了一套增删改查后，不妨我们试试下面的单元测试来验证上面操作的正确性：

```
public class ApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	@Rollback
	public void testUserMapper() throws Exception {
		// insert一条数据，并select出来验证
		userMapper.insert("AAA", 20);
		User u = userMapper.findByName("AAA");
		Assert.assertEquals(20, u.getAge().intValue());
		// update一条数据，并select出来验证
		u.setAge(30);
		userMapper.update(u);
		u = userMapper.findByName("AAA");
		Assert.assertEquals(30, u.getAge().intValue());
		// 删除这条数据，并select验证
		userMapper.delete(u.getId());
		u = userMapper.findByName("AAA");
		Assert.assertEquals(null, u);
	}
}
```

### 返回结果的绑定
对于增、删、改操作相对变化较小。而对于“查”操作，我们往往需要进行多表关联，汇总计算等操作，那么对于查询的结果往往就不再是简单的实体对象了，往往需要返回一个与数据库实体不同的包装类，那么对于这类情况，就可以通过`@Results`和`@Result`注解来进行绑定，具体如下：

```
@Results({
    @Result(property = "name", column = "name"),
    @Result(property = "age", column = "age")
})
@Select("SELECT name, age FROM user")
List<User> findAll();
```
在上面代码中，`@Result`中的`property`属性对应`User`对象中的成员名，`column`对应`SELECT`出的字段名。在该配置中故意没有查出`id`属性，只对User对应中的`name`和`age`对象做了映射配置，这样可以通过下面的单元测试来验证查出的`id`为`null`，而其他属性不为`null`：

```
@Test
@Rollback
public void testUserMapper() throws Exception {
	List<User> userList = userMapper.findAll();
	for(User user : userList) {
		Assert.assertEquals(null, user.getId());
		Assert.assertNotEquals(null, user.getName());
	}
}
```
### 后记
本文主要介绍几种最为常用的方式，更多其他注解的使用可参见文档：

http://www.mybatis.org/mybatis-3/zh/java-api.html
