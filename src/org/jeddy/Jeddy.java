package org.jeddy;

import org.jeddy.core.JeddyObject;
import org.jeddy.core.JeddyObjectConverter;

public class Jeddy {

	
	
	public static void main(String[] args) {
		
		JeddyObject user1 = new JeddyObject("user1");
		user1.addNode("name", "John");
		user1.addNode("age", "31");
		user1.addNode("city", "Buea");
		
		JeddyObject user2 = new JeddyObject("user2");
		user2.addNode("name", "Simeon");
		user2.addNode("age", "40");
		user2.addNode("city", "Limbe");
		
		JeddyObject user = new JeddyObject("users");
		user.addNode("users", user1);
		user.addNode("users", user2);
		
		JeddyObject names = new JeddyObject();
		names.addNode("names", "john");
		names.addNode("names", "Edward");
		names.addNode("names", "Jude");
		
		JeddyObjectConverter cv = new JeddyObjectConverter();
		
		System.out.println(cv.toJson(names));
		
	}
}
