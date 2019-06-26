package mvc.board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.model.BoardDao;
import mvc.board.model.BoardException;
import mvc.board.model.BoardRec;
import mvc.board.service.BoardService;

public class CommandList implements Command 
{
	private String next;

	private int totalRecCount;		// 전체 레코드 수	
	private int pageTotalCount;		// 전체 페이지 수
	private int countPerPage = 5;	// 한페이지당 레코드 수
	
	public CommandList( String _next ){
		next = _next;
	}

	public String execute( HttpServletRequest request , HttpServletResponse response  ) throws CommandException{
		try{
		    
		    String pNum = request.getParameter("page");
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
			
			List <BoardRec> mList = BoardService.getInstance().selectArticle();			
			//List <BoardRec> mList = BoardDao.getInstance().selectList(startRow,endRow);			
			request.setAttribute("param", mList );
			request.setAttribute("pageCount", getTotalPage());
			
		}catch( BoardException ex ){
			throw new CommandException("CommandList.java < 목록보기시 > " + ex.toString() ); 
		}
		
		return next;
	}
	
	public int getTotalPage() throws BoardException{
		// 전체 레코드 수를 얻어옴
		totalRecCount = BoardDao.getInstance().getTotalCount();
				
		// 전체 페이지 수를 구함
		pageTotalCount = totalRecCount / countPerPage + ((totalRecCount % countPerPage == 0)? 0 : 1);
		return pageTotalCount;
	}
}
