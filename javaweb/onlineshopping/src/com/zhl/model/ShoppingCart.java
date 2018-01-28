package com.zhl.model;

import java.util.HashMap;

public class ShoppingCart {

	private HashMap<String, Book> shoppinglist;

	public HashMap<String, Book> getShoppinglist() {
		return shoppinglist;
	}

	public void setShoppinglist(HashMap<String, Book> shoppinglist) {
		this.shoppinglist = shoppinglist;
	}
	
}
