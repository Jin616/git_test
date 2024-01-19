package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
	
	/*public*/void registerBoard(BoardDTO dto);
	/*public*/List<BoardDTO> boardList(int[] limit);
	/*public*/int getTotalBoard();
	/*public*/BoardDTO selectOneBoard(int seq);
	/*public*/int deleteBoard(int seq);
	/*public*/int updateBoard(BoardDTO dto);
	/*public*/List<BoardDTO> boardAllSearchList(String word);;
	/*public*/List<BoardDTO> boardSearchList(HashMap<String, String> map);
	
}
