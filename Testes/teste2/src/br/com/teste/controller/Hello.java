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
    public void init(){
        System.out.println(" Bean executado! ");
    }
     
    public String getMessage(){
        return "Hello World JSF!";
    }
 
}