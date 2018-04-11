package org.jeddy.core;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JeddyObject {
	
	private String name;
	private Map<String, List<JeddyNode>> nodes;
	
	public JeddyObject() {
		this.nodes = new LinkedHashMap<String, List<JeddyNode>>();
	}
	public JeddyObject(String name) {
		this.nodes = new LinkedHashMap<String, List<JeddyNode>>();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	protected Map<String, List<JeddyNode>> getNodes() {
		return nodes;
	}
	protected void setNodes(Map<String, List<JeddyNode>>  nodes) {
		this.nodes = nodes;
	}
	protected void addNode(JeddyNode node) {
		String key = node.getKey();
		List<JeddyNode> keyValues = this.nodes.get(key);
		if(keyValues == null) {
			keyValues = new LinkedList<JeddyNode>();
			keyValues.add(node);
		}else {
			keyValues.add(node);
		}
		this.nodes.put(node.getKey(),keyValues);
	}
	
	/**
	 * Add a new key:value pair
	 * @param key
	 * @param value
	 */
	public void addNode(String key, JeddyObject value) {
		JeddyNode node = new JeddyNode(key, value);
		this.addNode(node);
	}
	/**
	 * Add a new key:value pair
	 * @param key
	 * @param value
	 */
	public void addNode(String key, String value) {
		JeddyNode node = new JeddyNode(key, value);
		this.addNode(node);
	}
	/**
	 * get the value of the key
	 * @param key
	 * @return
	 */
//	public Object get(String key) {
//		return this.nodes.get(key);
//	}
	
	
	

}