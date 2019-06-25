package mvc.board.command;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.model.BoardDao;
import mvc.board.model.BoardRec;
import mvc.board.model.BoardException;

public class CommandInput implements Command {
	private String next;

	public CommandInput( String _next ){
		next = _next;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response  ) throws CommandException {
		try{

			BoardRec rec = new BoardRec();
			rec.setWriterName(request.getParameter("writerName"));
			rec.setTitle(request.getParameter("title"));
			rec.setContent( request.getParameter("content"));
			rec.setPassword(request.getParameter("password"));
			BoardDao dao = BoardDao.getInstance();
			
			//---------
			// 그룹번호(group_id) 지정
			int groupId = dao.getGroupId();
			rec.setGroupId(groupId);
			
			// 순서번호(sequence_no) 지정
			DecimalFormat dformat = new DecimalFormat("0000000000");
			rec.setSequenceNo( dformat.format(groupId) + "999999");
			// groupId = 1 이라면 00000000001999999
			// groupId = 1234 이라면 00000001234999999
			// DB에 insert
			rec.setArticleId(dao.insert(rec));
		    
			request.setAttribute("param", rec);
		}catch( BoardException ex ){
			throw new CommandException("CommandInput.java < 입력시 > " + ex.toString() ); 
		}
		return next;
	}

}
