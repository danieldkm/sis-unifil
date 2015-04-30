package bim1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// boolean b = true;
		// String s = (b != b) ? (b = !b) ? "Hello" : "hello" : (b = !b) ?
		// "World"
		// : "world";
		// System.out.println(s);

//		boolean b = false;
//		String s;
//		if (b == b) {
//			if (b = !b) {
//				s = "Hello1";
//			} else {
//				s = "hello2";
//			}
//		} else {
//			if (b = !b) {
//				s = "World1";
//			} else {
//				s = "world2";
//			}
//		}
//		System.out.println(s);
		
		TreeMap tm = new TreeMap();
//		Node n1 = new Node("A", 1, 0.33);
		tm.add(1, "daniel1");
		tm.add(2, "daniel2");
		tm.add(3, "daniel3");
		tm.add(4, "daniel4");
//		tm.prin();
		System.out.println(tm.get(1).toString());
		System.out.println(tm.topNode.find(1));
	}
}
