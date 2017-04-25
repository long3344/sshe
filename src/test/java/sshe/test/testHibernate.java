package sshe.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sy.model.User;
import sy.service.UserService;

public class testHibernate {
	
	@Test
	public void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[] {"classpath:spring.xml","classpath:spring-hibernate.xml"});
		UserService userService=(UserService) ac.getBean("userService");
		User t=new User();
		t.setId(1);
		t.setPassword("123456");
		t.setUsername("tesst");
		t.setCreatedTime(new Date());
		t.setUpdatedTime(new Date());
//		userService.save(t);
	}
	
	
}
