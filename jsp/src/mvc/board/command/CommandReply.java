package mvc.board.command;

import java.text.DecimalFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.model.BoardDao;
import mvc.board.model.BoardException;
import mvc.board.model.BoardRec;
import mvc.board.service.BoardService;

public class CommandReply implements Command
{
	private String next;

	public CommandReply ( String _next ){
		next = _next;
	}

	public String execute( HttpServletRequest request , HttpServletResponse response  ) throws CommandException{
		try{
			BoardRec rec = new BoardRec();
			rec.setTitle(request.getParameter("title"));
			rec.setWriterName(request.getParameter("writerName"));
			rec.setContent(request.getParameter("content"));
			rec.setPassword(request.getParameter("password"));
		    
		    int parentId = 0;
		    String pId = request.getParameter("parent_id");
		    
			if( pId != null ) parentId = Integer.parseInt(pId);
			
			BoardService bs = BoardService.getInstance();
			// 부모게시글의 레코드를 얻어옴
			BoardRec parent = bs.selectArticleByPrimaryKey(parentId);
			
			// 부모게시글을 체크
			checkParent(parent, parentId);
			
			// 답변글에 순서번호 구하기
			String maxSeqNum = parent.getSequenceNo();
			String minSeqNum = getSearchMinSeqNum( parent );
			
			String lastChildSeq = bs.selectLastSequenceNumber( maxSeqNum, minSeqNum );
			
			String sequenceNumber = getSequenceNumber( parent,lastChildSeq);
			
			
			rec.setGroupId(parent.getGroupId()); // 부모의 그룹번호와 동일하게 지정
			rec.setSequenceNo(sequenceNumber);	 // 위에서 구한 답변글의 순서번호 지정
			rec.setPostingDate( (new Date()).toString());	 // 등록일
			
			rec = bs.insertArticle(rec);
			
			request.setAttribute("result", rec);
		}catch( BoardException ex ){
			throw new CommandException("CommandList.java < 목록보기시 > " + ex.toString() ); 
		}
		
		return next;
	}
	/*
	 * 부모글이 존재하는지 부모글이 마지막 3단계인지 확인하는 함수
	 */
	private void checkParent( BoardRec parent, int pId ) throws BoardException
	{
		
		if( parent == null ) throw new BoardException("부모글이 존재하지 않음 : " + pId );
		
		int parentLevel = parent.getLevel();
		if( parentLevel == 3 ) throw new BoardException("3단계 마지막 레벨 글에는 답변을 달 수 없습니다.");
	
	}
	
	
	private String getSearchMinSeqNum( BoardRec parent )
	{
		String parentSeqNum = parent.getSequenceNo();
		DecimalFormat dFormat = new DecimalFormat("0000000000000000");
		long parentSeqLongValue = Long.parseLong(parentSeqNum);
		long searchMinLongValue = 0;
		
		switch( parent.getLevel())
		{
		case 0 : searchMinLongValue = parentSeqLongValue / 1000000L * 1000000L; break;
		case 1 : searchMinLongValue = parentSeqLongValue / 10000L * 10000L; break;
		case 2 : searchMinLongValue = parentSeqLongValue / 100L * 100L; break;
		}
		return dFormat.format(searchMinLongValue);
	}
	
	
	private String getSequenceNumber( BoardRec parent, String lastChildSeq ) throws BoardException
	{
		long parentSeqLong	= Long.parseLong( parent.getSequenceNo());
		int  parentLevel	= parent.getLevel();
		
		long decUnit = 0;
		if		( parentLevel == 0 ){	decUnit = 10000L;	}
		else if	( parentLevel == 1 ){	decUnit = 100L;		}
		else if ( parentLevel == 2 ){	decUnit = 1L;		}
		
		String sequenceNumber = null;
		
		DecimalFormat dFormat = new DecimalFormat("0000000000000000");
		if( lastChildSeq == null ){			// 답변글이 없다면
			sequenceNumber = dFormat.format(parentSeqLong-decUnit);
		} else {							// 답변글이 있다면, 마지막 답변글인지 확인
			String orderOfLastChildSeq = null;
			if( parentLevel == 0 ){
				orderOfLastChildSeq = lastChildSeq.substring(10,12);
				sequenceNumber = lastChildSeq.substring(0, 12) + "9999";
			}else if( parentLevel == 1 ){
				orderOfLastChildSeq = lastChildSeq.substring(12,14);
				sequenceNumber = lastChildSeq.substring(0, 14) + "99";				
			}else if( parentLevel == 2 ){
				orderOfLastChildSeq = lastChildSeq.substring(14,16);
				sequenceNumber = lastChildSeq;			
			}
			
			if( orderOfLastChildSeq.equals("00")){
				throw new BoardException("마지막 자식 글이 이미 존재합니다.");
			}
			
			long seq = Long.parseLong(sequenceNumber) - decUnit;
			sequenceNumber = dFormat.format(seq);
			
			return sequenceNumber; 
		}
		return sequenceNumber;
		
	}
}
