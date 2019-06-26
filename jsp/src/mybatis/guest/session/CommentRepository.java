package mybatis.guest.session;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.guest.model.Comment;

public class CommentRepository 
{
	String namespace = "mapper.CommentMapper";
	
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
	
	// Connection 개념 -> SqlSession
	public List<Comment> selectComment(){
		// 마이바티즈가 관리하는 Connection 하나를 얻어오기
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			return sess.selectList(namespace + ".selectComment");
		} finally {
			sess.close(); // Connection 을 MyBatis 에게 반환
		}
	}

	// 조건검색
	public Comment selectCommentByPK(long commentNo) {
		
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			Map map = new HashMap();
			map.put("commentNo", commentNo);
			return sess.selectOne(namespace + ".selectComment", map);
		} finally {
			sess.close(); // Connection 을 MyBatis 에게 반환
		}
	}

	public void insertComment(Comment co) {
		
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			int result = sess.insert(namespace + ".insertComment", co);
			
			if(result > 0) { sess.commit(); } else { sess.rollback(); }
			
		} finally {
			sess.close(); // Connection 을 MyBatis 에게 반환
		}
	}

	public int deleteComment(long commentNo) {
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			int result = sess.delete(namespace + ".deleteComment", commentNo);
			
			if(result > 0) { sess.commit(); } else { sess.rollback(); }
			return result;
		} finally {
			sess.close(); // Connection 을 MyBatis 에게 반환
		}
	}

	public int updateComment(Comment co) {
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			int result = sess.update(namespace + ".updateComment", co);
			
			if(result > 0) { sess.commit(); } else { sess.rollback(); }
			return result;
		} finally {
			sess.close(); // Connection 을 MyBatis 에게 반환
		}
	}
}
