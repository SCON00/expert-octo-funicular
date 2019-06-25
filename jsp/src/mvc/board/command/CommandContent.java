package mvc.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.model.BoardDao;
import mvc.board.model.BoardRec;
import mvc.board.model.BoardException;

public class CommandContent implements Command{
	
	private String next;

	public CommandContent( String _next ){
		next = _next;
	}

	public String execute( HttpServletRequest request , HttpServletResponse response  ) throws CommandException{
		try{
			int id = Integer.parseInt(request.getParameter("article_id"));
		    BoardRec rec = BoardDao.getInstance().selectById(id);	
		    request.setAttribute("param", rec );

		}catch( BoardException ex ){
			throw new CommandException("CommandList.java < 목록보기시 > " + ex.toString() ); 
		}
		
		return next;
	}
}
