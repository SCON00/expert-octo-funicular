package menu.model;

public class MenuRec {
	
	String menuId;
	String menuName;
	int menuPrice;
	int menuCount;
	String menuImg;
		
	public MenuRec(String menuId, String menuName, int menuPrice, int menuCount, String menuImg) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuCount = menuCount;
		this.menuImg = menuImg;
	}
	
	public MenuRec() {
		// TODO Auto-generated constructor stub
	}

	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public int getMenuCount() {
		return menuCount;
	}
	public void setMenuCount(int menuCount) {
		this.menuCount = menuCount;
	}
	public String getMenuImg() {
		return menuImg;
	}
	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}
	
	
}
