package mvc.board.service;

import java.text.DecimalFormat;
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
	// 입력 
	public BoardRec insertArticle(BoardRec rec) { 
		
		int groupId = repo.getGroupId();	// 그룹번호 검색
		rec.setGroupId(groupId);
		
		// 순서번호(sequence_no) 지정
		DecimalFormat dformat = new DecimalFormat("0000000000");
		rec.setSequenceNo( dformat.format(groupId) + "999999");
		// groupId = 1 이라면 00000000001999999
		// groupId = 1234 이라면 00000001234999999
		// DB에 insert
		rec.setArticleId(repo.insertArticle(rec));
		return rec;
	}

	/*
	 * // 삭제 public int deleteComment(String cId) { return
	 * repo.deleteComment(Integer.parseInt(cId)); }
	 * 
	 * // 수정 public int updateComment(Comment co) { return repo.updateComment(co); }
	 */
}
