package com.chris;

import javax.swing.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LogTest {
	private final Logger logger=LoggerFactory.getLogger(LogTest.class);
	
	@Test
	public void test() {
		logger.debug("debug ...");
		logger.info("info ...");
		logger.error("error ...");
	}
}
