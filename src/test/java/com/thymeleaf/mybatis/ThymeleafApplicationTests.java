package com.thymeleaf.mybatis;

import com.thymeleaf.mybatis.pojo.UserBean;
import com.thymeleaf.mybatis.service.UserBeanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThymeleafApplicationTests {

    @Resource
    private UserBeanService userBeanService;

    @Test
    public void contextLoads() {

        //1.设置IP地址和端口
        Jedis jedis = new Jedis("localhost",6379);
        System.out.println("redis连接成功");

        //2.存储数据
        jedis.set("k1","测试1");
        jedis.set("k2","测试2");

        System.out.println(jedis.get("k1"));

        //3.释放资源
        jedis.close();

    }

    @Test
    public void testGetUser(){
        UserBean userBean =userBeanService.getUser("admin");
        System.out.println("对象输出》》" +userBean);

        //  没有使用缓存，第二仍然还是输出从数据库中查询
        UserBean userBean1 =userBeanService.getUser("user22");
        System.out.println("对象输出》》" +userBean1);
    }



}
