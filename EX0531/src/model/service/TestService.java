package model.service;

import java.util.ArrayList;

import model.TestException;
import model.TestModel;
import model.dao.TestDao;

public class TestService {
	private static TestService instance;
	
	public static TestService getInstance() throws TestException
	{
		if( instance == null )
		{
			instance = new TestService();
		}
		return instance;
	}
	
	private TestService() {}
	
	public ArrayList<TestModel> getList() throws TestException
	{
		ArrayList<TestModel> result = TestDao.getInstance().selectAll();
		return result;
	}
	
	public int addMember(TestModel tm) throws TestException
	{
		int result = TestDao.getInstance().insert(tm);
		
		return result;
	}
}
