package mvc.board.service;

import java.util.List;

import mvc.board.model.BoardRec;
import mvc.board.session.BoardRepository;

public class BoardService {

	private static BoardService instance;
	
	private BoardService() {}
	
	public static BoardService getInstance() {
		if( instance == null) instance = new BoardService();
		return instance;
	}
	
	BoardRepository repo = new BoardRepository();
	
	// 전체 검색
	public List<BoardRec> selectArticle(){
		return repo.selectArticle();
	}
	
	// 글번호로 검색
	public BoardRec selectArticleByPrimaryKey(int cId) {
		return repo.selectArticleByPK(cId);
	}
	/*
	 * // 입력 public void insertComment(Comment co) { repo.insertComment(co); }
	 * 
	 * // 삭제 public int deleteComment(String cId) { return
	 * repo.deleteComment(Integer.parseInt(cId)); }
	 * 
	 * // 수정 public int updateComment(Comment co) { return repo.updateComment(co); }
	 */
}
