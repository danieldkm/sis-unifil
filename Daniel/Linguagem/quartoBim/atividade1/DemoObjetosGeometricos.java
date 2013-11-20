package atividade1;

/**
 * A classe DemoObjetosGeometricos demonstra instÃ¢ncias de classes que 
 * implementam a interface ObjetoGeometrico.
 */
class DemoObjetosGeometricos // declaraÃ§Ã£o da classe
  {
 /**
  * O mÃ©todo main permite a execuÃ§Ã£o desta classe. Este mÃ©todo contÃ©m declaraÃ§Ãµes de
  * instÃ¢ncias das classes Circulo e Retangulo, duas classes que implementam a 
  * interface ObjetoGeometrico. 
  * @param argumentos os argumentos que podem ser passados para o mÃ©todo via linha 
  *        de comando, mas que neste caso serÃ£o ignorados.
  */
  public static void main(String[] argumentos)
    {
    // Declaramos algumas instÃ¢ncias das classes Circulo e Retangulo
    Circulo c1 = new Circulo(new Ponto2D(0,0),100); // centrado na origem, raio 100
    Circulo c2 = new Circulo(new Ponto2D(-1,-1),1); // centrado em (-1,-1), raio 1
    Circulo c3 = new Circulo(new Ponto2D(10,8),0); // centrado em (10,8), raio 0 (!)
    Retangulo r1 = new Retangulo(new Ponto2D(-2,-2), // um canto estÃ¡ em (-2,-2)
                                 new Ponto2D(2,2));  // e o outro em (2,2)
    Retangulo r2 = new Retangulo(new Ponto2D(-100,-1), // um canto estÃ¡ em (-100,1)
                                 new Ponto2D(100,1));  // e o outro em (100,1)
    Retangulo r3 = new Retangulo(new Ponto2D(0,0),  // um canto estÃ¡ em (0,0)
                                 new Ponto2D(0,0)); // e o outro tambÃ©m !
    // Vamos imprimir os dados completos de cada um destes objetos geomÃ©tricos
    imprimeTodosOsDados(c1);
    imprimeTodosOsDados(c2);
    imprimeTodosOsDados(c3);
    imprimeTodosOsDados(r1);
    imprimeTodosOsDados(r2);
    imprimeTodosOsDados(r3);
    } // fim do mÃ©todo main

 /**
  * O mÃ©todo imprimeTodosOsDados imprime todos os dados de uma instÃ¢ncia de uma
  * classe que implemente a interface ObjetoGeometrico. 
  * @param og uma instÃ¢ncia de qualquer classe que implemente a interface 
  *           ObjetoGeometrico. 
  */
  private static void imprimeTodosOsDados(ObjetoGeometrico og)
    {
    // Primeiro, imprime os dados padrÃ£o do objeto - podemos fazer isto diretamente
    // atravÃ©s da chamada implÃ­cita ao mÃ©todo toString
    System.out.println(og);
    // Podemos imprimir a sua Ã¡rea e perÃ­metro com chamadas diretas aos mÃ©todos das
    // classes
    System.out.println("PerÃ­metro:"+og.calcularPerimetro());
    System.out.println("Ã�rea:"+og.calcularArea());
    // Imprimimos uma linha em branco para melhor visualizaÃ§Ã£o dos resultados
    System.out.println(); 
    } // fim do mÃ©todo imprimeTodosOsDados   

  } // fim da classe DemoObjetosGeometricos
