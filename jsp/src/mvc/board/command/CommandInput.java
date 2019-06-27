package mvc.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.model.BoardRec;
import mvc.board.service.BoardService;

public class CommandInput implements Command {
	private String next;

	public CommandInput( String _next ){
		next = _next;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response  ) throws CommandException {
		
			BoardRec rec = new BoardRec();
			rec.setWriterName(request.getParameter("writerName"));
			rec.setTitle(request.getParameter("title"));
			rec.setContent( request.getParameter("content"));
			rec.setPassword(request.getParameter("password"));
			
			BoardRec result = BoardService.getInstance().insertArticle(rec);
		    
			request.setAttribute("param", result);
		
		return next;
	}

}
