package com.my.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.my.core.util.FileUtil;

@Controller
@RequestMapping("/file")
public class FileUploadAction {
	
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(String fileName,MultipartFile file){
		try {
			FileUtil.uploadFile(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
}
