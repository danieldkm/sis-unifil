package br.com.teste.controller;

import javax.annotation.PostConstruct;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

//@RequestScoped
//@ManagedBean
@Named
@RequestScoped
public class Hello {

	@PostConstruct
	public void init() {
		System.out.println(" Bean executado! ");
	}

	public String getMessage() {
		return "Hello World JSF!";
	}

	public static void main(String[] args) {
		//>> com sinal
		int x = 16;
		System.out.println(x);
		x = x >> 2;
		System.out.println(x);
		// ex1
		int y = 200;
		System.out.println(y);
		y = y << 2;
		System.out.println(y);
		// ex2
		int y2 = 200;
		System.out.println(y2);
		y2 <<= 2;
		System.out.println(y2);

		int z = -200;
		System.out.println(z);
		z <<= 3;
		System.out.println(z);
		
		//>>> sem sinal
		int e = 200;
		System.out.println(e);
		e >>>= 2;
		System.out.println(e);

		int e2 = -200;
		System.out.println(e2);
		e2 >>>= 2;
		System.out.println(e2);
		
		//operadores bit a bit
		int n1 = 10 & 9;
		System.out.println(n1);
		int n2 = 10 | 9;
		System.out.println(n2);
		int n3 = 10 ^ 9;
		System.out.println(n3);
		int n4 = 8; // 1000
		System.out.println(n4);
		n4 = ~n4;
		System.out.println(n4);
		int n5 = 8; // binario - 1000
		System.out.println(n5);
		n5 = ~n5;
		System.out.println(n5);

	}

}