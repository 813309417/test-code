package com.xuxincheng.boot;


import com.xuxincheng.controller.HelloController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {
	@Autowired
	HelloController helloController;
	@Test
	public void contextLoads() {
		String count = helloController.getcount();
		System.out.println("总学生数"+count);
	}
	@Test
	public void testAddStudent() {
		String name = "我要测试"+Math.random()*10;
		String sex = "1";
		String phone = "15980666611";
		String isOk = helloController.addStudent(name,sex,phone);
		//验证是否成功  为false 系统会提示错误感叹号
		Assert.assertEquals("1",isOk);
		//System.out.println("是否成功"+isOk);
	}
}
