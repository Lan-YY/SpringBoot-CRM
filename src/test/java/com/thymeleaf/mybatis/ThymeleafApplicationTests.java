package com.thymeleaf.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThymeleafApplicationTests {

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

}
