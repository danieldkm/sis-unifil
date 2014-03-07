package atividade5;

import java.util.ArrayList;

import tarefa1.Pessoa;

public class Teste {

	public static void main(String[] args) {
		Banco b = new Banco();
		
		Pessoa p1 = new Pessoa("Pessoa1", "Email1", "codigo1", "cpf1", "Data1");
		Pessoa p2 = new Pessoa("Pessoa2", "Email2", "codigo2", "cpf2", "Data2");
		Pessoa p3 = new Pessoa("Pessoa3", "Email3", "codigo3", "cpf3", "Data3");
		Pessoa p4 = new Pessoa("Pessoa4", "Email4", "codigo4", "cpf4", "Data4");
		Pessoa p5 = new Pessoa("Pessoa5", "Email5", "codigo5", "cpf5", "Data5");
		b.inserirPessoa(p1);
		b.inserirPessoa(p2);
		b.inserirPessoa(p3);
		b.inserirPessoa(p4);
		b.inserirPessoa(p5);
//		
//		ArrayList<Pessoa> pessoas = b.consultaPessoa();
//		for (Pessoa p : pessoas) {
//			System.out.println("Nome: " + p.getNome());
//			System.out.println("Email: " + p.getEmail());
//			System.out.println("Codigo: " + p.getCodigo());
//			System.out.println("CPF: " + p.getCpf());
//			System.out.println("Data: " + p.getData());
//		}
		
		
		
		
		
		
	}
}
