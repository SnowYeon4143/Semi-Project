package com.dev.order.vo;

public class CartVo 
{
	
	private int pro_no;
	private String pro_img;
	private String pro_name;
	private int unit_price;
	private int quantity;
	private int amt;
	
	
	//---------------------------------------
	
	public int getPro_no() 
	{
		return pro_no;
	}
	
	public String getPro_img() 
	{
		return pro_img;
	}
	
	public String getPro_name() 
	{
		return pro_name;
	}
	
	public int getUnit_price() 
	{
		return unit_price;
	}
	
	public int getQuantity() 
	{
		return quantity;
	}
	
	public int getAmt() 
	{
		return amt;
	}
	
	//---------------------------------------
	public void setPro_no(int pro_no) 
	{
		this.pro_no = pro_no;
	}

	public void setPro_img(String pro_img) 
	{
		this.pro_img = pro_img;
	}

	public void setPro_name(String pro_name) 
	{
		this.pro_name = pro_name;
	}

	public void setUnit_price(int unit_price) 
	{
		this.unit_price = unit_price;
	}
	
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	public void setAmt(int amt) 
	{
		this.amt = amt;
	}
	
	
	//---------------------------------------

	@Override
	public String toString() 
	{
		return "CartVo [" + "pro_no=" + pro_no + "pro_img=" + pro_img + ", pro_name=" + pro_name + ", unit_price=" + unit_price + ", quantity=" + quantity + ", amt=" + amt + "]";
	}
	
	
	
}
