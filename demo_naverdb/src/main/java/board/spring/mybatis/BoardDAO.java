package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardDAO {

	public int insertBoard(BoardDTO dto);
	
	public List<BoardDTO> boardlist(int[] limit);

	public int selectTotal();

	public void updateViewCount(int seq);
	
	public BoardDTO selectOneBoard(int seq);

	public int deleteOneBoard(int seq);

	public int updateBoard(BoardDTO dto);

	public List<BoardDTO> boardAllSearchList(String word);

	public List<BoardDTO> boardSearchList(HashMap<String, String> map);
	
}