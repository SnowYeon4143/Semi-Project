package com.dev.order.vo;

public class OrderListVo 
{
	private String delivery_status;
	//private String ord_date;
	private String addr_name;
	private String pro_img;
	private String pro_name;
	private int quantity;
	private int unit_price;
	private int amt;
	
	//---------------------------------------
	
	public String getDelivery_status() 
	{
		return delivery_status;
	}
	
	public String getAddr_name() 
	{
		return addr_name;
	}
	
	public String getPro_img() 
	{
		return pro_img;
	}
	
	public String getPro_name() 
	{
		return pro_name;
	}
	
	public int getQuantity() 
	{
		return quantity;
	}
	
	public int getUnit_price() 
	{
		return unit_price;
	}
	
	public int getAmt() 
	{
		return amt;
	}
	
	//---------------------------------------
	
	public void setDelivery_status(String delivery_status) 
	{
		this.delivery_status = delivery_status;
	}
	
	public void setAddr_name(String addr_name) 
	{
		this.addr_name = addr_name;
	}
	
	public void setPro_img(String pro_img) 
	{
		this.pro_img = pro_img;
	}
	
	public void setPro_name(String pro_name) 
	{
		this.pro_name = pro_name;
	}
	
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	public void setUnit_price(int unit_price) 
	{
		this.unit_price = unit_price;
	}
	
	public void setAmt(int amt) 
	{
		this.amt = amt;
	}

	//---------------------------------------
	
	@Override
	public String toString() {
		return "OrderListVo [delivery_status=" + delivery_status + ", addr_name=" + addr_name + ", pro_img=" + pro_img
				+ ", pro_name=" + pro_name + ", quantity=" + quantity + ", unit_price=" + unit_price + ", amt=" + amt
				+ "]";
	}
	
	

	
}
