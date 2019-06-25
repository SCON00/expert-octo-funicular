package mvc.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.model.BoardDao;
import mvc.board.model.BoardException;
import mvc.board.model.BoardRec;

public class CommandModify implements Command 
{
	private String next;

	public CommandModify( String _next ){
		next = _next;
	}

	public String execute( HttpServletRequest request , HttpServletResponse response  ) throws CommandException{
		try{
			BoardRec rec = new BoardRec();
			rec.setArticleId(Integer.parseInt(request.getParameter("articleId")));
			rec.setTitle(request.getParameter("title"));
			rec.setContent(request.getParameter("content"));
			rec.setPassword(request.getParameter("password"));
		    int result = BoardDao.getInstance().update(rec);	
		    request.setAttribute("result", result );

		}catch( BoardException ex ){
			throw new CommandException("CommandList.java < 목록보기시 > " + ex.toString() ); 
		}
		
		return next;
	}
}
