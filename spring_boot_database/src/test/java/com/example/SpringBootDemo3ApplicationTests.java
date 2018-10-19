package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.controller.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo3ApplicationTests {

	@Test
	public void contextLoads() {
		HelloWorldController hc = new HelloWorldController();
		String str = hc.index();
		str =str;
	}

}
