package com.memo.user.bo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.memo.user.entity.UserEntity;
@SpringBootTest
class UserBOTest {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserBO userBO;

	//@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void 회원조회() {
		UserEntity user = userBO.getUserEntityByLoginid("aaaa");
		logger.info("###### user: {}", user);
		assertNotNull(user);
	}
	
	@Transactional // 수행 후 데이터 rollback
	//@Test
	void 회원추가테스트() {
		userBO.addUser("junit22", "test22", "name22", "email22@test.com");
	}

}
