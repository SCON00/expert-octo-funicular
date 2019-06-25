package obs.board.service;

import java.util.List;

import obs.board.model.BoardDao;
import obs.board.model.BoardException;
import obs.board.model.BoardRec;

public class ListArticleService {
	private static ListArticleService instance;
	
	private int totalRecCount;		// 전체 레코드 수	
	private int pageTotalCount;		// 전체 페이지 수
	private int countPerPage = 5;	// 한페이지당 레코드 수
	
	public static ListArticleService getInstance()  throws BoardException{
		if( instance == null )
		{
			instance = new ListArticleService();
		}
		return instance;
	}
	
	private ListArticleService() {}
	
	public List <BoardRec> getArticleList() throws BoardException
	{
		// 
		 List <BoardRec> mList = BoardDao.getInstance().selectList();			
		return mList;
	}
		
	public List <BoardRec> getArticleList(String pNum) throws BoardException
	{
		int pageNum = (pNum != null)? Integer.parseInt(pNum) : 1;
		// 페이지 번호에 따른 시작 레코드 번호(startRow)와 마지막 번호(endRow) 추출
		/*
		 * 전체레코드 수 20
		 * 1 페이지 : 1 ~ 5 
		 * 2 페이지 : 6 ~ 10
		 * 3 페이지 : 11 ~ 15
		 * 4 페이지 : 16 ~ 20
		 */
		int startRow = countPerPage * (pageNum - 1) + 1;
		int endRow = pageNum * countPerPage;
		
		List <BoardRec> mList = BoardDao.getInstance().selectList(startRow,endRow);			
		return mList;
	}
	
	public int getTotalPage() throws BoardException{
		// 전체 레코드 수를 얻어옴
		totalRecCount = BoardDao.getInstance().getTotalCount();
				
		// 전체 페이지 수를 구함
		pageTotalCount = totalRecCount / countPerPage + ((totalRecCount % countPerPage == 0)? 0 : 1);
		return pageTotalCount;
	}
}
