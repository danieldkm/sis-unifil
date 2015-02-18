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
		tm.add(1, "daniel");
		tm.add(2, "daniel2");
		tm.add(3, "daniel3");
		tm.add(4, "daniel4");
		System.out.println(tm.get(4).toString());
		System.out.println(tm.topNode.find("daniel"));
	}
}
