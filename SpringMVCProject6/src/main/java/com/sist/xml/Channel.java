package com.sist.xml;

import java.util.*;

public class Channel {
	// <channel>안에 <item>이 여러개 ==> List로 만든다
	private List<Item> item=new ArrayList<Item>();

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}
	
}
