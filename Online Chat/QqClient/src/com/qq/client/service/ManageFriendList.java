package com.qq.client.service;

import java.util.*;
import com.qq.client.view.*;

public class ManageFriendList {

		private static HashMap<String, QqFriendList> manageFriendList=new HashMap<>();
		
		public static void addQqFriendList(String userName, QqFriendList qqFriendList){
			manageFriendList.put(userName, qqFriendList);
		}
		
		public static QqFriendList getQqFriendList(String userName){
			return manageFriendList.get(userName);
		}
}
