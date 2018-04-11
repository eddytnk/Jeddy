package org.jeddy.core;

import java.util.Collection;
import java.util.List;


public class JeddyObjectConverter {

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
}
