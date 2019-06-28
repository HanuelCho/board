package kh.spring.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.BoardDTO;
@Component
public class BoardDAO {
	@Autowired
	private HttpSession session;
	@Autowired
	private SqlSessionTemplate sst;
	
	public int insert(BoardDTO dto) {
		return sst.insert("board-mapper.insert",dto);
	}
	
	public List<BoardDTO> list() {
	
		return sst.selectList("board-mapper.boardList");
	}
	
	public BoardDTO contents(int seq) {
		return sst.selectOne("board-mapper.boardContents",seq);
	}
}
