package menu.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuDao {
	// Single Pattern 
		private static MenuDao instance;
		
		// DB 연결시  관한 변수 
		private static final String 	dbDriver	=	"oracle.jdbc.driver.OracleDriver";
		private static final String		dbUrl		=	"jdbc:oracle:thin:@192.168.0.116:1521:orcl";
		private static final String		dbUser		=	"team5";
		private static final String		dbPass		=	"1004";
		
		
		private Connection	 		con;	
		
		//--------------------------------------------
		//#####	 객체 생성하는 메소드 
		public static MenuDao	getInstance() throws MenuException
		{
			if( instance == null )
			{
				instance = new MenuDao();
			}
			return instance;
		}
		
		private MenuDao() throws MenuException
		{		
			try{				
				/********************************************
					1. 오라클 드라이버를 로딩
						( DBCP 연결하면 삭제할 부분 )
				*/
				Class.forName( dbDriver );	
			}catch( Exception ex ){
				throw new MenuException("DB 연결시 오류  : " + ex.toString() );	
			}
			
		}
		
		// 메뉴 아이템 정보 불러오는 메소드
		public ArrayList<MenuRec> selectAll() throws MenuException
		{
			ArrayList<MenuRec> result = new ArrayList<MenuRec>();
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
				String sql = "SELECT * FROM goods";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					MenuRec m = new MenuRec();
					m.setMenuId(rs.getString("GID"));
					m.setMenuName(rs.getString("GNAME"));
					m.setMenuPrice(rs.getInt("PRICE"));
					m.setMenuCount(rs.getInt("GCNT"));
					m.setMenuImg(rs.getString("IMG"));
					result.add(m);
				}
				return result;
			}catch( Exception ex ){
				throw new MenuException("메뉴판 ) 테이블 조회 오류  : " + ex.toString() );	
			} finally{
				if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }				
				if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
				if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
			}
			
		}
		
		// 주문 입력하는 메소드
		public int insertOrder(ArrayList<OrderRec> rec) throws MenuException
		{
			return -1;
		}
		
		// 주문 입력하는 메소드
		public int insertOrder(int menuId, int menuCount, int sId) throws MenuException
		{			
			Connection con = null;
			PreparedStatement ps = null;			
			
			try {
				con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
				String sql = "INSERT INTO sales (sid, snum, gid, scnt, sdate) "
						+ "VALUES (SEQ_SALES_SID.nextval, ?, ?, ?, sysdate)";
				ps = con.prepareStatement(sql);
				ps.setString(1, String.valueOf(sId));
				ps.setString(2, String.valueOf(menuId));
				ps.setInt(3, menuCount);
				
				int result = ps.executeUpdate();
				return result;
			}catch( Exception ex ){
				throw new MenuException("메뉴판 ) 테이블 조회 오류  : " + ex.toString() );	
			} finally{
						
				if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
				if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
			}			
		}

		public int getSalesNumber() throws MenuException
		{		
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
				String sql = "SELECT seq_sales_snum.nextval AS snum FROM dual";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				int result = 0;
				if(rs.next()) {
					result = rs.getInt("snum");
				}
				return result;
			}catch( Exception ex ){
				throw new MenuException("메뉴판 ) 테이블 조회 오류  : " + ex.toString() );	
			} finally{
				if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }				
				if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
				if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
			}
		}
		
}
