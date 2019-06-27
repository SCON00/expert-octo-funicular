package mvc.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.model.BoardException;
import mvc.board.model.BoardRec;
import mvc.board.service.BoardService;

public class CommandContent implements Command{
	
	private String next;

	public CommandContent( String _next ){
		next = _next;
	}

	public String execute( HttpServletRequest request , HttpServletResponse response  ) throws CommandException{
		
			int id = Integer.parseInt(request.getParameter("article_id"));
//		    BoardRec rec = BoardDao.getInstance().selectById(id);	
		    BoardRec rec = BoardService.getInstance().selectArticleByPrimaryKey(id);	
		    request.setAttribute("param", rec );		
		
		return next;
	}
}
