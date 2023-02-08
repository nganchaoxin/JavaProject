package com.example.demo;

import com.example.demo.test.MathService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = "com.example.demo")
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	MathService mathService;
	@Test
	public void testAdd_UC001() {
		int actualResult = mathService.add(2,3);
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}

}
