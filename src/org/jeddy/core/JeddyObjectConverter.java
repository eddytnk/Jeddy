package org.jeddy.core;

import java.util.Collection;
import java.util.List;


public class JeddyObjectConverter {

	/**
	 * Convert JeddyObject to JSON String
	 * @param jEddyObj
	 * @return
	 */
	protected String toJson(JeddyObject jEddyObj) {
		StringBuilder sb = new StringBuilder();
		Collection<List<JeddyNode>> nodeList = jEddyObj.getNodes().values(); 
		
		sb.append("{");
		int nodeCnt = 0;
		for(List<JeddyNode> nodes :nodeList) {
			int cnt = 0;
			int size = nodes.size();
			if(size>1) { // a list of Nodes with same key
				sb.append("\""+nodes.get(0).getKey()+"\":");
				sb.append("[");
				for(JeddyNode n:nodes) {
					if(n.getValue().getClass()==JeddyObject.class) {
						String out = this.toJson((JeddyObject) n.getValue());
						sb.append(out);
					}else {
						sb.append("\""+n.getValue()+"\"");
					}
					if(cnt<(size-1)) {
						sb.append(",");
					}
					cnt++;
				}
				sb.append("]");
			}else {
				if(nodes.get(0).getValue().getClass()==JeddyObject.class) {
					String out = this.toJson((JeddyObject) nodes.get(0).getValue());
					sb.append(out);
				}else {
					sb.append("\""+nodes.get(0).getKey()+"\":"+"\""+nodes.get(0).getValue()+"\"");
				}
			}
			if(nodeCnt<(nodeList.size()-1)) {
				sb.append(",");
			}
			nodeCnt++;
		}
		sb.append("}");
		return sb.toString();
	}
	
	
	
	protected String toXml(JeddyObject jEddyObj, boolean xmlProlog) {
		StringBuilder sb = new StringBuilder();
		Collection<List<JeddyNode>> nodeList = jEddyObj.getNodes().values(); 
		
		if(xmlProlog) {
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		}
		String ParrentTag = jEddyObj.getName();
		if(ParrentTag == null || ParrentTag == "") {
			ParrentTag = "data";
		}
		sb.append("<"+ParrentTag+">");
		
		for(List<JeddyNode> nodes :nodeList) {
			int size = nodes.size();
			if(size>1) { // a list of Nodes with same key
				sb.append("<"+nodes.get(0).getKey()+">");
				for(JeddyNode n:nodes) {
					sb.append("<value>");
					if(n.getValue().getClass()==JeddyObject.class) {
						String out = this.toXml((JeddyObject) n.getValue(),false);
						sb.append(out);
					}else {
						sb.append(n.getValue());
					}
					sb.append("</value>");
				}
				sb.append("</"+nodes.get(0).getKey()+">");
			}else {
				JeddyNode n = nodes.get(0);
				sb.append("<"+n.getKey()+">");
				if(n.getValue().getClass()==JeddyObject.class) {
					String out = this.toXml((JeddyObject) n.getValue(),false);
					sb.append(out);
				}else {
					sb.append(n.getValue());
				}
				sb.append("</"+n.getKey()+">");
			}
		}
		sb.append("</"+ParrentTag+">");
		return sb.toString();
	}
	
}
