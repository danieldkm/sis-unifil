package com;

import java.io.IOException;
import java.util.ArrayList;

public class Ex05 extends Config{
	
	private ArrayList<Processos> memoria = new ArrayList();
	private String texto = "";
	private Processos processo;
	
	public void executar(String[] args) throws IOException {
		Ex03 _3 = new Ex03();
		_3.executar(args);
		System.out.println("Ocupação Inicial:");
		System.out.println("H|0|" + totalChunks);
		ocupacaoPid(args);
		for (int i = 0; i < processos.size(); i++) {
			for (int j = 0; j < processos.get(i).size(); j++) {
				if(j == 0){
					System.out.println(processos.get(i).get(j).getFuncao() + " processo " + processos.get(i).get(j).getPidEscolhido() +", ocupação de " + processos.get(i).get(j).getTamanhoPid() + " chunks");
					texto += processos.get(i).get(j).getTipoOcupacao() + "|" + processos.get(i).get(j).getPosicao() + "|" + processos.get(i).get(j).getTamanhoPid();
				} else {
					texto += " -> " +  processos.get(i).get(j).getTipoOcupacao() + "|" + processos.get(i).get(j).getPosicao()+"|" + processos.get(i).get(j).getTamanhoPid();
				}
			}
			System.out.println(texto+"\n");
			texto = "";
		}
	}

}
