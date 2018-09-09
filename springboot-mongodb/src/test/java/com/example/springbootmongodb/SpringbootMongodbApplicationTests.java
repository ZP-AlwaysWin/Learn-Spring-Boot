package com.example.springbootmongodb;

import com.example.springbootmongodb.entity.User;
import com.example.springbootmongodb.entity.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMongodbApplicationTests{


    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void test() throws Exception {

        // 创建三个User，并验证User总数
        userRepository.save(new User(1L, "moons", 30));
        userRepository.save(new User(2L, "java", 40));
        userRepository.save(new User(3L, "python", 50));
        Assert.assertEquals(3, userRepository.findAll().size());

        // 删除一个User，再验证User总数
        //User u = userRepository.findOne(1L);
        //Springboot 改版之后将findOne 更名为 findById
        //但是findById并不仅仅是将findOne改名，它返回的对象变成了Optional
        //如果想让findById和findOne有同样的功能，可以用下面这个函数
        //User u = userRepository.findById(1L).orElse(null);
        User u = userRepository.findById(1L).orElse(null);
        userRepository.delete(u);
        Assert.assertEquals(2, userRepository.findAll().size());

        // 删除一个User，再验证User总数
        u = userRepository.findByUsername("java");
        userRepository.delete(u);
        Assert.assertEquals(1, userRepository.findAll().size());

    }
}
