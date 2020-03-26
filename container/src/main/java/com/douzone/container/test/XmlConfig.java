package com.douzone.container.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User;
import com.douzone.container.user.User1;

public class XmlConfig {

	public static void main(String[] args) {
		// XML Auto-Configuration(Annotation Scanning)
		//		testBeanFactory01();
		
		// XML Bean Configuration(Implict Configuration)
		//		testBeanFactory02();

		// XML Auto Configuration(Annotation Scanning)
		//testApplicationContext01();
		
		// XML Bean Configuration(Implict Congiguration)
		testApplicationContext02();
	}
	
	public static void testApplicationContext01() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/user/applicationContext01.xml");

		User1 user1 = appContext.getBean(User1.class);
		System.out.println(user1.getName());

		//Bean의 id가 자동으로 설정됨
		user1 = (User1)appContext.getBean("user1");
		System.out.println(user1.getName());
		
		// 자원관리
		((ConfigurableApplicationContext)appContext).close();
	}

	//XML Bean Configuration(Implicit Configuration)
	public static void testApplicationContext02() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/user/applicationContext01.xml");

		//id로 bean 가져오기
		User user = (User)appContext.getBean("user");
		System.out.println(user);
		
		//name으로 bean 가져오기
		user = (User)appContext.getBean("usr");
		System.out.println(user);
		
		// 1. type으로 가져오기
		// 같은 타입의 객체가 2개 이상 있는 경우 type으로만 가져오면 에러!
		// type + id 또는 type + name
		user = (User)appContext.getBean("user2", User.class);
		System.out.println(user);
		
		// 2. 1개의 파라미터 생성자로 생성된 Bean 가져오기
		user = appContext.getBean("user2", User.class);
		System.out.println(user);

		// 2개 파라미터 생성자로 생성된 Bean 가져오기1 
		user = appContext.getBean("user3", User.class);
		System.out.println(user);

		// 2개 파라미터 생성자로 생성된 Bean 가져오기2 
		user = appContext.getBean("user4", User.class);
		System.out.println(user);

		// setter를 사용한 Bean 가져오기 
		user = appContext.getBean("user5", User.class);
		System.out.println(user);

		// setter를 사용한 Bean 가져오기 
		user = appContext.getBean("user7", User.class);
		System.out.println(user);
		
		
		//자원정리
		((ConfigurableApplicationContext)appContext).close();
	}

	
	// XML Auto Configuration(Annotation Scanning)
	public static void testBeanFactory01() {

		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext01.xml"));

		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());

		//Bean의 id가 자동으로 설정됨
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());
	}

	//XML Bean Configuration(Implicit Congiguration)
	public static void testBeanFactory02() {

		// XML Auto Configuration(Annotation Scanning)

		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext02.xml"));

		//XML Auto-Configuration(Annotation Scanning)
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());

		//Bean설정에선는 id가 자동으로 설정되지 않는다.
		//명시적으로 설정해야한다.
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());
	}
}
