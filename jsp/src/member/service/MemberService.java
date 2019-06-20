package member.service;

import member.beans.MemberDao;
import member.beans.MemberException;

public class MemberService {
	
	private static MemberService instance;
	
	public static MemberService	getInstance() throws MemberException
	{
		if( instance == null )
		{
			instance = new MemberService();
		}
		return instance;
	}
	
	private MemberService()
	{
		
	}
	
	public int login( String id, String password ) throws MemberException
	{
		MemberDao mDao = MemberDao.getInstance();
		return mDao.login(id, password);
	
	}
	
	public String selectName(String id) throws MemberException
	{
		MemberDao mDao = MemberDao.getInstance();
		return mDao.selectName(id);
	}
}
