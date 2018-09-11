package com.example.springbootmybatis;

import com.example.springbootmybatis.entity.User;
import com.example.springbootmybatis.entity.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    //创建单元测试
    //测试逻辑：插入一条name=AAA，age=20的记录，然后根据name=AAA查询，并判断age是否为20
    //测试结束回滚数据，保证测试单元每次运行的数据环境独立

    @Test
    @Rollback
    public void findByName() throws Exception {
        userMapper.insert("AAA", 20);
        User u = userMapper.findByName("AAA");
        Assert.assertEquals(20, u.getAge().intValue());
    }

}
