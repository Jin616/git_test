package board.spring.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberBoardController {
	
	@Autowired
	@Qualifier("memberServiceImpl")
	MemberService service;
	
	@GetMapping("/boardlogin")
	public String loginForm() {
		return "board/loginform";
	}
	
	@PostMapping("/boardlogin")
	String loginProcess(String memberid, String pw, HttpSession session) {
		MemberDTO dto = service.oneMember(memberid);
		if(dto != null) {
			if(dto.getPw().equals(pw)) { // 정상 로그인
				session.setAttribute("sessionid", memberid);
			} else { // 암호 다른 경우
				session.setAttribute("sessionid", "암호 다시 입력하세요");
			}
		} else { // 아이디조차 없는 경우
			session.setAttribute("sessionid", "회원가입부터 하세요.");
		}
		return "board/start";
	}
	
	@RequestMapping("/boardlogout")
	String logout(HttpSession session) {
		if(session.getAttribute("sessionid") != null)
			session.removeAttribute("sessionid");
		
		return "board/start";
	}
	
	@RequestMapping("/getWriter")
	@ResponseBody
	MemberDTO getWriter(String writer) {
		System.out.println("getWriter writer :" + writer);
		MemberDTO dto = service.oneMember(writer);
		System.out.println(dto);
		return dto;
	}
	
//	@RequestMapping("/getWriter/{writer}")
//	@ResponseBody
//	MemberDTO getWriter(@PathVariable("writer") String memberid) {
//		MemberDTO dto = service.oneMember(memberid);
//		System.out.println(dto);
//		return dto;
//	}
}
