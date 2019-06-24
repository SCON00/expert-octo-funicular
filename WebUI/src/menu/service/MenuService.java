package menu.service;

import java.util.ArrayList;



import menu.model.MenuDao;
import menu.model.MenuException;
import menu.model.MenuRec;
import menu.model.OrderRec;

public class MenuService {
	private static MenuService instance;
	public static MenuService getInstance()  throws MenuException{
		if( instance == null )
		{
			instance = new MenuService();
		}
		return instance;
	}
	
	private MenuService() {}
	
	public ArrayList<MenuRec> selectAll() throws MenuException{
		ArrayList<MenuRec> rec = MenuDao.getInstance().selectAll();
		
		return rec;
	}
	
	public int insertOrder(ArrayList<OrderRec> rec) throws MenuException{
		int result = MenuDao.getInstance().insertOrder(rec);
		return result;
	}
	public int insertOrder(int[]menuId, int[]menuCount) throws MenuException{
		
		MenuDao dao = MenuDao.getInstance();
		int sId = dao.getSalesNumber();
		int result = 0;
		for(int i=0; i<menuId.length; i++) {
			result += dao.insertOrder(menuId[i], menuCount[i], sId);
		}		
		return result;
	}
}
