package member.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {

	
	// DB 연결시  관한 변수 

	private static final String 	dbDriver	=	"oracle.jdbc.driver.OracleDriver";
	private static final String		dbUrl		=	"jdbc:oracle:thin:@192.168.0.116:1521:orcl";
	private static final String		dbUser		=	"team5";
	private static final String		dbPass		=	"1004";

		
	private static MemberDao memberDao;
	
	public static MemberDao getInstance() throws MemberException
	{
		if( memberDao == null )
		{
			memberDao =  new MemberDao();
		}
		return memberDao;
	}
	

	private MemberDao() throws MemberException
	{
			
		try{			
			/********************************************
				1. 드라이버를 로딩							
			*/
			Class.forName(dbDriver);
		}catch( Exception ex ){
			throw new MemberException("DB 연결시 오류  : " + ex.toString() );	
		}
	}
	
	/*******************************************
	 * * 회원관리테이블 MEMBERTEST 에  회원정보를 입력하는 함수
	 * @param rec
	 * @throws MemberException
	 */
	public void insertMember( Member rec ) throws MemberException
	{
		
		try {
			 // 0. 연결 객체 얻어오기			
			Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			 // 1. sql 문장 만들기 ( insert문 )
			String sql = "INSERT INTO membertest (id, password, name, tel, addr) "
					+ "VALUES (?,?,?,?,?)";
			 // 2. sql 전송 객체 만들기
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, rec.getId());
			ps.setString(2, rec.getPassword());
			ps.setString(3, rec.getName());
			ps.setString(4, rec.getTel());
			ps.setString(5, rec.getAddr());
			 // 3. sql 전송
			ps.executeUpdate();
			 // 4. 객체 닫기
			ps.close();
			con.close(); 
		} catch ( Exception ex ){
			throw new MemberException("멤버 입력시 오류  : " + ex.toString() );			
		}
	}
	
	/**********************************************************
	 * * 회원관리테이블 MEMBERTEST에서 기존의 id값과 중복되는지 확인하는 함수
	 */
	public boolean isDuplicatedId( String id ) throws MemberException
	{
		boolean flag = false;
		
		try{
			Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			String sql = "SELECT id FROM membertest "
					+ "WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) flag = true;
			
			rs.close();
			ps.close();
			con.close();
		}catch( Exception ex ){
			throw new MemberException("중복아이디 검사시 오류  : " + ex.toString() );			
		}
			
		return flag;
	}
	
	/*****
	 *  로그인 처리용 함수
	 */
	
	public int login(String id, String password) throws MemberException
	{
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			String sql = "SELECT * FROM membertest "
					+ "WHERE id = ? AND password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) result = 1;
			rs.close();
			ps.close();
			con.close();
			return result;
		}catch( Exception ex ){
			throw new MemberException("로그인 실행 오류  : " + ex.toString() );			
		}
	}
	
	/*****
	 *  멤버 이름 불러오기
	 */
	
	public String selectName(String id) throws MemberException
	{
		String name = "";
		try {
			Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			String sql = "SELECT name FROM membertest "
					+ "WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) name = rs.getString("name");
			
			rs.close();
			ps.close();
			con.close();
			return name;
		}catch( Exception ex ){
			throw new MemberException("이름 검색 오류  : " + ex.toString() );			
		}
		
	}
}
