package com;

import java.io.IOException;

public class Ex07 extends Config {

	public void executar(String[] args) throws IOException {
		Ex03 _3 = new Ex03();
		_3.executar(args);
		Ex04 _4 = new Ex04();
		_4.executar(args);
		boolean continuar = true;
		String co = "";
		while (continuar) {
			_4.ex7 = true;
			_4.novoTexto(pidRemovido.get(0).getPidAtual().charAt(0),
					"inserido", args);
			pidRemovido.remove(0);
			System.out.println("Finalizar ex07?S/N");
			co = scanner.nextLine().toLowerCase();;
			if(co.equals("s")){
				continuar = false;
			}
		}
		_4.ex7 = false;
	}

}
