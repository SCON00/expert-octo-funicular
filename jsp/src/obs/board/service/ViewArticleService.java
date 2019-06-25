package obs.board.service;

import java.util.List;

import obs.board.model.BoardDao;
import obs.board.model.BoardException;
import obs.board.model.BoardRec;

public class ViewArticleService {
	private static ViewArticleService instance;
	public static ViewArticleService getInstance()  throws BoardException{
		if( instance == null )
		{
			instance = new ViewArticleService();
		}
		return instance;
	}
	
	private ViewArticleService() {}
	
	public BoardRec getArticleById(String id) throws BoardException
	{
		int article_id = 0;
		if( id != null ) article_id = Integer.parseInt(id);
		BoardDao dao = BoardDao.getInstance();
		BoardRec rec = dao.selectById(article_id);		
		dao.increaseReadCount(article_id);
		return rec;
	}
		
}

