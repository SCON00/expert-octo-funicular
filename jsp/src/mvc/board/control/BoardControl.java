package mvc.board.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.command.Command;
import mvc.board.command.CommandContent;
import mvc.board.command.CommandDelete;
import mvc.board.command.CommandException;
import mvc.board.command.CommandInput;
import mvc.board.command.CommandList;
import mvc.board.command.CommandModify;
import mvc.board.command.CommandNull;
import mvc.board.command.CommandReply;

/**
 * Servlet implementation class GuestControl
 */
public class BoardControl extends HttpServlet {
	
	private HashMap commandMap;
	private String	jspDir = "/04_board_class/";
	private String  error = "error.jsp";
	

    public BoardControl() {
        super();       
		initCommand();
	}

	private void initCommand(){
		commandMap = new HashMap();

		commandMap.put("main-page",	new CommandNull("board.jsp") );
		// 리스트 출력
		commandMap.put("list-page",	new CommandList("BoardList.jsp") );
		// 게시글 보기		
		commandMap.put("article-page", new CommandContent("BoardView.jsp"));
		// 글쓰기
		commandMap.put("input-page", new CommandNull("BoardInputForm.jsp"));
		// 새 글 입력
		commandMap.put("input-do", new CommandInput("BoardSave.jsp"));
		// 답글 쓰기
		commandMap.put("reply-page", new CommandNull("BoardReplyForm.jsp"));
		// 답글 달기
		commandMap.put("reply-do", new CommandReply("BoardReply.jsp"));
		// 삭제버튼
		commandMap.put("delete-page", new CommandNull("BoardDeleteForm.jsp"));
		// 삭제요청
		commandMap.put("delete-do", new CommandDelete("BoardDelete.jsp"));
		// 게시글 수정
		commandMap.put("modify-page", new CommandContent("BoardModifyForm.jsp"));
		// 수정요청
		commandMap.put("modify-do", new CommandModify("BoardModify.jsp"));
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String nextPage = "";
		String cmdKey	= request.getParameter("cmd");
		if( cmdKey == null ){
			cmdKey = "main-page";
		}

		
		Command cmd = null;

		try{
			
			if( commandMap.containsKey( cmdKey ) ){
				cmd = (Command)commandMap.get( cmdKey);
			}else{
				throw new CommandException("지정할 명령어가 존재하지 않음");
			}

			nextPage = cmd.execute( request, response  );

		}catch( CommandException e ){
			request.setAttribute("javax.servlet.jsp.jspException", e );
			nextPage = error;
			System.out.println("오류 : " + e.getMessage() );
		}
		
		// forwarding
		RequestDispatcher reqDp = getServletContext().getRequestDispatcher( jspDir + nextPage );
		reqDp.forward( request, response );
		
	}

}
