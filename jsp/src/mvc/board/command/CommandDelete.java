package mvc.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.model.BoardDao;
import mvc.board.model.BoardException;

public class CommandDelete implements Command {
	private String next;

	public CommandDelete( String _next ){
		next = _next;
	}
	
	public String execute(HttpServletRequest request, HttpServletResponse response  ) throws CommandException {

		try{
				
			int articleId = 0;
			String id = request.getParameter("article_id");
			if(id != null) articleId = Integer.parseInt(id);
			String password = request.getParameter("password");
			
			int resultCnt = BoardDao.getInstance().delete(articleId, password);
			
			request.setAttribute("result", resultCnt);
		}catch( BoardException ex ){
			throw new CommandException("CommandDelete.java < 삭제시 > " + ex.toString() ); 
		}
		
		return next;			
	}

}
