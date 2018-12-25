package com.example.springbootdemo.modules.cmsadmin;

import com.example.springbootdemo.modules.cmsadmin.domain.primary.entity.UserPri;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsAdminApplicationTests {

	@Autowired
	private RedisTemplate<String,UserPri> redisTemplate;




	@Test
	public void contextLoads() {
	}



	@Test
	public void test() throws Exception {

		// 保存对象
		UserPri user = new UserPri("超人", 20);
		redisTemplate.opsForValue().set(user.getUserName(), user);

		user = new UserPri("蝙蝠侠", 30);
		redisTemplate.opsForValue().set(user.getUserName(), user);

		user = new UserPri("蜘蛛侠", 40);
		redisTemplate.opsForValue().set(user.getUserName(), user);

		Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
		Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
		Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

	}


}
