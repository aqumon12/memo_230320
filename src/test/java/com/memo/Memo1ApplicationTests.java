package com.memo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ObjectUtils;

@SpringBootTest
class Memo1ApplicationTests {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void 비어있는지테스트() {
		String a = null;   // ""
		if (ObjectUtils.isEmpty(a)) {
			logger.info("######## is empty.");
		}
		
		List<Integer> list = List.of(1, 2, 3, 4);
		List<Integer> list1 = List.of(); // null
		if (ObjectUtils.isEmpty(list1)) {
			logger.info("######## list is empty.");
		}
	}
}
