package com.memo.user.bo;

import javax.websocket.ClientEndpointConfig.Builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memo.user.dao.UserRepository;
import com.memo.user.entity.UserEntity;

@Service
public class UserBO {
	
	@Autowired
	private UserRepository userRepository;
	
	// input: loginId
	// output: UserEntity(null or not null)
	public UserEntity getUserEntityByLoginid(String loginId) {
		return userRepository.findByLoginId(loginId);
	}
	
	// input: user 관련 파라미터들
	// output: UserEntity 중에 id pk만 추출
	public Integer addUser(String loginId, String password, String name, String email) {
		// save
		UserEntity userEntity = userRepository.save(
					UserEntity.builder()
					.loginId(loginId)
					.password(password)
					.name(name)
					.email(email)
					.build()
				);
		return userEntity == null ? null : userEntity.getId(); // pk(id)만 리턴
	}
	
	// input: loginId, password
	// output: UserEntity
	public UserEntity getUserEntityByLoginIdPassword(String loginId, String password) {
		return userRepository.findByLoginIdAndPassword(loginId, password);
		
	}
}
