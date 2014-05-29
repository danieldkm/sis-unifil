package iterator;

import java.util.ArrayList;

public class ObjectIterator implements Iterator {

	ArrayList<Object> o;
	int pos = 0;

	public ObjectIterator(ArrayList<Object> lista) {
		o = lista;
	}

	@Override
	public boolean hasNext() {
		if (pos >= o.size() || o.get(pos) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Object next() {
		Object ob = o.get(pos);
		pos++;
		return ob;
	}

}
