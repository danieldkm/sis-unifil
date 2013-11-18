package com;

import java.io.IOException;

public class Ex08 extends Config{

	public void executar(String[] args) throws IOException {
		Ex03 _3 = new Ex03();
		_3.executar(args);
		Ex04 _4 = new Ex04();
		_4.ex8 = true;
		_4.executar(args);
		_4.ex8 = false;
	}
}
