package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TestException;
import model.TestModel;

public class TestDao {
	private static TestDao instance;
	
	// DB 연결시  관한 변수 
	private static final String 	dbDriver	=	"org.mariadb.jdbc.Driver";
	private static final String		dbUrl		=	"jdbc:mariadb://127.0.0.1:3306/scon";
	private static final String		dbUser		=	"scon";
	private static final String		dbPass		=	"1234";
		
	private Connection con;	
	
	public static TestDao getInstance() throws TestException
	{
		if(instance == null) {
			instance = new TestDao();
		}
		return instance;
	}
	
	private TestDao() throws TestException {
		try{				
			/********************************************
				1. MariaDB 드라이버를 로딩
					( DBCP 연결하면 삭제할 부분 )
			*/
			Class.forName( dbDriver );	
		}catch( Exception ex ){
			throw new TestException("DB 연결시 오류  : " + ex.toString() );	
		}
	}
	
	public ArrayList<TestModel> selectAll() throws TestException
	{
		ArrayList<TestModel> result = new ArrayList<TestModel>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			String sql = "SELECT * FROM test";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				TestModel tm = new TestModel();
				tm.setTestId(rs.getInt("tid"));
				tm.setTestName(rs.getString("tname"));
				tm.setTestNum(rs.getInt("tnum"));
				tm.setTestCate(rs.getString("tcate"));
				tm.setTestDate(rs.getString("tdate"));
				result.add(tm);
			}
			return result;
		}catch( Exception ex ){
			throw new TestException("테이블 조회 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }				
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}		
	}
	
	public int insert(TestModel tm) throws TestException
	{
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			String sql = "INSERT INTO test " 
						+ "(tname, tnum, tcate)" 
						+ "VALUES (?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, tm.getTestName());
			ps.setInt(2, tm.getTestNum());
			ps.setString(3, tm.getTestCate());
			int result = ps.executeUpdate();
			
			return result;
		} catch(Exception ex) {
			throw new TestException("테이블 수정 오류 : " + ex.toString());
		} finally {
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
	}
}
