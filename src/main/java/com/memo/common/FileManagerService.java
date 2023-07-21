package com.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component // 일반적인 spring bean
public class FileManagerService {
	
	
	// 실제 업로드가 된 이미지가 저장될 경로(서버)
	public static final String FILE_UPLOAD_PATH = "C:\\Users\\ASUS\\Desktop\\HSM\\6_spring_project\\memo\\workspace\\images/";
	
	// input: MultipartFile(이미지 파일), loginId
	// output: web image path(String)
	public String saveFile(String loginId, MultipartFile file) {
		// 파일 디렉토리(폴더)  예) aaaa_1678123929/sun.png (1678123929: 현재시간(밀리단위))
		String directoryName = loginId + "_" + System.currentTimeMillis() + "/"; // aaaa_1678123929/
		String filePath = FILE_UPLOAD_PATH + directoryName; // C:\\Users\\ASUS\\Desktop\\HSM\\6_spring_project\\memo\\workspace\\images/aaaa_1678123929/
		
		// 폴더 생성
		File directory = new File(filePath); 
		if (directory.mkdir() == false) {
			// 폴더 만드는데 실패 시 이미지 경로 null로 리턴
			return null;
		}
		
		// 파일 업로드: byte 단위 업로드
		try {
			byte[] bytes = file.getBytes();
			// *** 한글 이름 이미지는 올릴 수 없으므로 나중에 영문자로 바꿔서 올리기
			Path path = Paths.get(filePath + file.getOriginalFilename()); // 디렉토리 경로 + 사용자가 올린 파일명
			Files.write(path, bytes); // 파일 업로드
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; // 이미지 업로드 실패 시 null 리턴
		}
		
		//  파일 업로드가 성공했으면 웹 이미지 url path를 리턴한다.
		//  /images/aaaa_151231231/sun.jpg
		return "/images/" + directoryName + file.getOriginalFilename();
	}
}
