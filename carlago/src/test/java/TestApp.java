import com.ago.Application;
import com.ago.model.member.Member;
import com.ago.service.member.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisPool;

/**
 * author ago
 * date 2016/10/21 0021 下午 16:54
 */
@RunWith(SpringRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class TestApp {

    private static Logger logger = LoggerFactory.getLogger(TestApp.class);

    @Autowired
    JedisPool jedisPool;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    MemberService memberService;

    @Test
    public void testRedis(){
        /*redisTemplate.opsForValue().set("ago","df1111111111111");
        Jedis jedis = jedisPool.getResource();
        jedis.setex("geek", 1000, "cattle");
        System.out.println(redisTemplate.opsForValue().get("ago"));*/
        Member admin = memberService.findByUsername("flyshy");
        System.out.println(admin);
    }
/*
    @Test
    public static void main(String[] args) {
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }*/


}
