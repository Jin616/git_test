package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//("boardServiceImpl")
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO dao;
	
	@Override
	public void registerBoard(BoardDTO dto) {
		int result = dao.insertBoard(dto);
		System.out.println(result);
	}

	@Override
	public List<BoardDTO> boardList(int[] limit) {
		return dao.boardlist(limit);
	}

	@Override
	public int getTotalBoard() {
		return dao.selectTotal();
	}

	@Override
	public BoardDTO selectOneBoard(int seq) {
		dao.updateViewCount(seq);
		return dao.selectOneBoard(seq);
	}

	@Override
	public int deleteBoard(int seq) {
		return dao.deleteOneBoard(seq);
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		return dao.updateBoard(dto);
	}

	@Override
	public List<BoardDTO> boardAllSearchList(String word) {
		System.out.println("boardAllSearchList word : " + word);
		return dao.boardAllSearchList(word);
	}

	@Override
	public List<BoardDTO> boardSearchList(HashMap<String, String> map) {
		return dao.boardSearchList(map);
	}
	
}
