package guest.service;

import guest.model.Message;
import guest.model.MessageDao;
import guest.model.MessageException;

import java.util.List;

public class ListMessageService {

	//-------------------------------------------------------------------
	private int totalRecCount;		// 전체 레코드 수	
	private int pageTotalCount;		// 전체 페이지 수
	private int countPerPage = 3;	// 한페이지당 레코드 수
	
	private static ListMessageService instance;
	
	public static ListMessageService	getInstance() throws MessageException
	{
		if( instance == null )
		{
			instance = new ListMessageService();
		}
		return instance;
	}
	
	private ListMessageService()
	{
		
	}
	
	public List <Message> getMessageList() throws MessageException
	{
		// 전체 레코드를 검색해 온다면
		List <Message> mList = MessageDao.getInstance().selectList();			
		return mList;
	}
	public List <Message> getMessageList(String pNum) throws MessageException
	{
		int pageNum = (pNum != null)? Integer.parseInt(pNum) : 1;
		// 페이지 번호에 따른 시작 레코드 번호(startRow)와 마지막 번호(endRow) 추출
		/*
		 * 전체레코드 수 10
		 * 1 페이지 : 1 ~ 3 
		 * 2 페이지 : 4 ~ 6
		 * 3 페이지 : 7 ~ 9
		 * 4 페이지 : 10
		 */
		int startRow = countPerPage * (pageNum - 1) + 1;
		int endRow = pageNum * countPerPage;
		List <Message> mList = MessageDao.getInstance().selectList(startRow,endRow);			
		return mList;
	}
	
	public int getTotalPage() throws MessageException{
		// 전체 레코드 수를 얻어옴
		totalRecCount = MessageDao.getInstance().getTotalCount();
				
		// 전체 페이지 수를 구함
		pageTotalCount = totalRecCount / countPerPage + ((totalRecCount % countPerPage == 0)? 0 : 1);
		return pageTotalCount;
	}
}
