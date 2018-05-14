package com.itheima.domain;

public class Books {
private int id;
private String name;
private int price;
private int pnum;
private String category;
public Books(int id, String name, int price, int pnum, String category) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.pnum = pnum;
	this.category = category;
}
public Books() {
	super();
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getPnum() {
	return pnum;
}
public void setPnum(int pnum) {
	this.pnum = pnum;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
}
