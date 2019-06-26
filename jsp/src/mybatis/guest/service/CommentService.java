package mybatis.guest.service;

import java.util.List;

import mybatis.guest.model.Comment;
import mybatis.guest.session.CommentRepository;

public class CommentService 
{
	private static CommentService instance;
	
	private CommentService() {}
	
	public static CommentService getInstance() {
		if ( instance == null ) instance = new CommentService();
		return instance;
	}
	
	CommentRepository repo = new CommentRepository();
	
	// 전체 검색
	public List<Comment> selectComment(){
		return repo.selectComment();
	}
	
	// 글번호로 검색
	public Comment selectCommentByPrimaryKey(long cId) {
		return repo.selectCommentByPK(cId);
	}
	
	// 입력
	public void insertComment(Comment co) {
		repo.insertComment(co);
	}
	
	// 삭제
	public int deleteComment(String cId) {
		return repo.deleteComment(Integer.parseInt(cId));
	}
	
	// 수정
	public int updateComment(Comment co) {
		return repo.updateComment(co);
	}
}
