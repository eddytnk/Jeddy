package org.jeddy;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jeddy.core.JeddyObject;

public class Jeddy {

	
	public static JeddyObject getJeddyObject(Object object) {
		return Jeddy.getJeddyObject(object, new String[]{});
	}
	
	public static JeddyObject getJeddyObject(Object object,String[] notRef) {
		JeddyObject jEddyObj = new JeddyObject("data");
		Field[] fields = object.getClass().getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			try {
				String key = fields[i].getName();
				Object value = fields[i].get(object);
				Class<?> dataType = fields[i].getType();
				
				List<String> propExcept = Arrays.asList(notRef);
				// Check property exception list
				if (propExcept.contains(key)) {
					continue;
				}
				
				if (dataType.isArray()) {
					int length = Array.getLength(value);
					for (int j = 0; j < length; j++) {
						Object element = Array.get(value, j);
						jEddyObj.addNode(key, element.toString());
					}
				}else {
						String canName = dataType.getCanonicalName();
						if(canName.equals("java.util.List") ||
								canName.equals("java.util.ArrayList") || 
								canName.equals("java.util.LinkedList")  ||
								canName.equals("java.util.Stack") ) {
								
							List<Object> listValue = (List<Object>)value;
							for(Object element: listValue) {
								jEddyObj.addNode(key, element.toString());
							}
					}else {
						jEddyObj.addNode(key,value.toString());
					}
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return jEddyObj;
	}
	
	
	public static void main(String[] args) {
		
		//JeddyObject obj = Jeddy.getJeddyObject(new User(),new String[] {"USstates","age"});
		JeddyObject obj = Jeddy.getJeddyObject(new User(),new String[] {});
		System.out.println(obj.toXml());
		
		
		/*JeddyObject user1 = new JeddyObject("user1");
		user1.addNode("name", "John");
		user1.addNode("age", "31");
		user1.addNode("city", "Buea");
		
		JeddyObject user2 = new JeddyObject("user2");
		user2.addNode("name", "Simeon");
		user2.addNode("age", "40");
		user2.addNode("city", "Limbe");
		
		
		
		JeddyObject names = new JeddyObject();
		names.addNode("names", "john");
		names.addNode("names", "Edward");
		names.addNode("names", "Jude");
		
		user1.addNode("names", names);
		
		JeddyObject user = new JeddyObject("users");
		user.addNode("users", user1);
		user.addNode("users", user2);
		
		System.out.println(user.toXml());*/
		
	}
}

class User{
	private String name = "ET Tanko";
	private int age = 50;
	private String[] USstates = {"NY","LA","IL","IA"};
	private List<String> categories;
	
	User(){
		categories = new ArrayList<String>();
		this.categories.add("Books");
		this.categories.add("Fashion");
		this.categories.add("Electronics");
		this.categories.add("Home");
	}
	
}