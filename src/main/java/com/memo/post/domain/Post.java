package com.memo.post.domain;

import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.ToString;

@ToString
@Data // getter, setter
public class Post {
	private int id;
	private int userId;
	private String subject;
	private String content;
	private String imagePath;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private ZonedDateTime createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private ZonedDateTime updatedAt;
}	
