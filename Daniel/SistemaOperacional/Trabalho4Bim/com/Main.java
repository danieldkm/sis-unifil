package com;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		Ex01 ex = new Ex01();
		try {
			ex.executar(args);
			ex.lerArquivo(args);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
