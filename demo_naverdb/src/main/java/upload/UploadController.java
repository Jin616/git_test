package upload;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	@GetMapping("/fileupload")
	String uploadform() {
		return "upload/uploadform";
	}
	
	@PostMapping("/fileupload")
	ModelAndView uploadresult(UploadDTO dto) throws IOException {
		// 요청파라미터명 = dto 변수명 자동 전달 주입
		String savePath = "c:/fullstack/upload/";
		String filename1 = null, filename2 = null;
		
		// 클라이언트 파일 전송한다 - http stream - 파일형태로 서버 전송받는다
		MultipartFile file1 = dto.getFile1();
		if(!file1.isEmpty()) {
			String filename = file1.getOriginalFilename();
			
			filename1 = filename.substring(0, filename.lastIndexOf(".")) + "(" + UUID.randomUUID().toString() + ")" + filename.substring(filename.lastIndexOf("."));
			File savefile1 = new File(savePath + filename1);
			file1.transferTo(savefile1);
		}
		
		MultipartFile file2 = dto.getFile2();
		if(!file2.isEmpty()) {
			String filename = file2.getOriginalFilename();
			
			filename2 = filename.substring(0, filename.lastIndexOf(".")) + "(" + UUID.randomUUID().toString() + ")" + filename.substring(filename.lastIndexOf("."));
			File savefile2 = new File(savePath + filename2);
			file2.transferTo(savefile2);
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("saveresult1", savePath + filename1 + " 저장했습니다.");
		mv.addObject("saveresult2", savePath + filename2 + " 저장했습니다.");
		mv.setViewName("upload/uploadresult");
		return mv;
	}
}
