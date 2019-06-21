package menu.model;

public class OrderRec {
	int salesId;
	int orderId;
	int menuId;
	int menuCount;
	String orderDate;
	
	public OrderRec(int salesId, int orderId, int menuId, int menuCount, String orderDate) {
		super();
		this.salesId = salesId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.menuCount = menuCount;
		this.orderDate = orderDate;
	}
	public int getSalesId() {
		return salesId;
	}
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getMenuCount() {
		return menuCount;
	}
	public void setMenuCount(int menuCount) {
		this.menuCount = menuCount;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
