package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@Autowired
	@Qualifier("boardServiceImpl")
	BoardService service;
	
	@RequestMapping("/")
	String start() {
		return "board/start";
	}
	
	@GetMapping("/boardwrite")
	String writeBoardForm() {
		System.out.println("boardwrite - GET");
		return "board/boardwriteform";
	}
	
	@PostMapping("/boardwrite")
	String writeBoard(BoardDTO dto) {
		System.out.println("boardwrite - POST");
		service.registerBoard(dto);
		
		return "redirect:/boardlist";
	}
	
	@RequestMapping("/boardlist")
	ModelAndView showBoardList(
			@RequestParam(value="pagenum", required=false, defaultValue="1") int pagenum, 
			@RequestParam(value="pagecount", required=false, defaultValue="3")int pagecount) {
		ModelAndView mv = new ModelAndView();
		
		int[] limit = {(pagenum-1)*pagecount, pagecount}; 
		
		List<BoardDTO> list = service.boardList(limit);
		
		mv.addObject("boardlist", list);
		mv.addObject("totalcount", service.getTotalBoard());
		mv.addObject("pagecount", pagecount);
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping("/boarddetail")
	ModelAndView boarddetail(int seq) {
		//seq 번호에 해당하는 게시물 viewcount 1개 증가 sql(update)
		//seq 번호에 해당하는 게시물 1개 sql -MemberDTO-모델 저장
		//board/detail.jsp
		ModelAndView mv = new ModelAndView(); 
		
		mv.addObject("board", service.selectOneBoard(seq));
		mv.setViewName("board/detail");
		return mv;
	}
	
	@RequestMapping("/boarddelete")
	String boarddelete(int seq) {
		service.deleteBoard(seq);
		return "redirect:/boardlist";
	}
	
	@RequestMapping("/boardupdate")
	String boardupdate(BoardDTO dto) {
		service.updateBoard(dto);
		return "redirect:/boardlist";
	}
	
	@RequestMapping("/boardsearchlist")
	ModelAndView boardsearchlist(
			@RequestParam(value="pagenum", required=false, defaultValue="1") int pagenum, 
			@RequestParam(value="pagecount", required=false, defaultValue="3")int pagecount
			, String item, String word) {
		ModelAndView mv = new ModelAndView();
		
		HashMap<String, String> map = new HashMap<>();
		map.put("startSeq", String.valueOf(4));
		map.put("limitSeq", String.valueOf(pagecount));

		System.out.println("startSeq : " + map.get("startSeq") + ", limitSeq : " + map.get("limitSeq"));
		System.out.println("item : " + item + ", word : " + word);
		if(item.equals("모두")) {
			List<BoardDTO> list = service.boardAllSearchList(word);
			System.out.println(list);
			mv.addObject("list", list);
		} else {
			if(item.equals("제목")) {
				map.put("colname", "title");
			} else if(item.equals("이름")) {
				map.put("colname", "writer");
			} else if(item.equals("내용")) {
				map.put("colname", "comments");
			} else if(item.equals("모두")) {
				map.put("colname", "writer");
			}
			map.put("colvalue", word);
			List<BoardDTO> list = service.boardSearchList(map);
			System.out.println(list);
			mv.addObject("list", list);
		}		
		mv.setViewName("board/list");
		System.out.println(item + " : " + word);
		return mv;
	}
}