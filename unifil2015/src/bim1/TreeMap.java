package bim1;

public class TreeMap {
	TreeMapNode topNode = null;

	public void add(Comparable key, Object value) {
		if (topNode == null)
			topNode = new TreeMapNode(key, value);
		else
			topNode.add(key, value);
	}

	public Object get(Comparable key) {
		return topNode == null ? null : topNode.find(key);
	}
	
	public void prin(){
		topNode.print();
	}
}
