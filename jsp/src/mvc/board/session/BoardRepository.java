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
	
	public List<BoardRec> selectArticle(){
		// 마이바티즈가 관리하는 Connection 하나를 얻어오기
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			return sess.selectList(namespace + ".selectArticle");
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

}
