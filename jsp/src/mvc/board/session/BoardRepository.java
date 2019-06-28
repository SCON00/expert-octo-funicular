package mvc.board.session;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mvc.board.model.BoardRec;

public class BoardRepository 
{
	String namespace = "mapper.BoardMapper";
	
	SqlSessionFactory getSqlSessionFactory() {
		InputStream inStream = null;
		
		try {
			inStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("config 파일 연결 실패: " + e.getMessage());
		}
		SqlSessionFactory sessFactory = new SqlSessionFactoryBuilder().build(inStream);
		return sessFactory;		
	}
	
	// 전체검색
	public List<BoardRec> selectArticle(){
		// 마이바티즈가 관리하는 Connection 하나를 얻어오기
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			return sess.selectList(namespace + ".selectArticle");
		} finally {
			sess.close(); // Connection 을 MyBatis 에게 반환
		}
	}
	// 전체검색
	public List<BoardRec> selectArticle(int startRow, int endRow){
		// 마이바티즈가 관리하는 Connection 하나를 얻어오기
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			Map map = new HashMap();
			map.put("startRow", startRow);
			map.put("endRow", endRow);
			return sess.selectList(namespace + ".selectArticleByPage", map);
		} finally {
			sess.close(); // Connection 을 MyBatis 에게 반환
		}
	}
	
	// 조건검색
	public BoardRec selectArticleByPK(int articleId) {
		
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			Map map = new HashMap();
			map.put("articleId", articleId);
			return sess.selectOne(namespace + ".selectArticle", map);
		} finally {
			sess.close(); // Connection 을 MyBatis 에게 반환
		}
	}

	// 글 입력
	public int insertArticle(BoardRec rec) {
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			int result = sess.insert(namespace + ".insertArticle", rec);
			int id = sess.selectOne(namespace + ".selectArticleId");	// 입력한 글의 고유번호 요청
			if(result > 0) {				
				sess.commit();
				return id;
			} else {
				sess.rollback();
				return 0;
			}
		} finally {
			sess.close(); // Connection 을 MyBatis 에게 반환
		}
	}

	// 그룹 번호 검색
	public int getGroupId() {
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			
			return sess.selectOne(namespace + ".selectGroupId");
		} finally {
			sess.close(); // Connection 을 MyBatis 에게 반환
		}
	}

	// 총 글 수 검색
	public int getTotalCount() {
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			
			return sess.selectOne(namespace + ".selectTotalCount");
		} finally {
			sess.close(); // Connection 을 MyBatis 에게 반환
		}
	}

	// 게시글 수정
	public int updateArticle(BoardRec rec) {
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			int result = sess.update(namespace + ".updateArticle", rec);
			if(result > 0) {				
				sess.commit();
				
			} else {
				sess.rollback();
				
			}
			return result;
		} finally {
			sess.close();
		}
	}

	// 조회수 증가
	public void increaseReadCount(int articleId) {
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			int result = sess.update(namespace + ".updateReadCount", articleId);
			if(result > 0) {				
				sess.commit();
				
			} else {
				sess.rollback();
				
			}
		} finally {
			sess.close();
		}
		
	}

	public String selectLastSequenceNumber(String maxSeqNum, String minSeqNum) {
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			Map map = new HashMap();
			map.put("maxSeqNum", maxSeqNum);
			map.put("minSeqNum", minSeqNum);
			return sess.selectOne(namespace + ".selectLastSeqNum", map);
		} finally {
			sess.close();
		}
	}

}
