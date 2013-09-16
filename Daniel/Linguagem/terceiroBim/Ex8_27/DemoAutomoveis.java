package Ex8_27;

class DemoAutomoveis
  {
  public static void main(String[] argumentos)
    {
    Automovel a = new Automovel("Fusca","verde",Automovel.MOVIDOAALCOOL);
    System.out.println(a); // toString (implicitamente)
    System.out.println(a.quantoCusta());
    System.out.println(a.quantasPrestacoes());

    AutomovelBasico ab = new AutomovelBasico("Corsa","cinza",Automovel.MOVIDOAGASOLINA,
                                             true,true,false);
    System.out.println(ab); // toString (implicitamente)
    System.out.println(ab.quantoCusta());
    System.out.println(ab.quantasPrestacoes()); // método herdado, sem modificações

    AutomovelDeLuxo al = new AutomovelDeLuxo("Classe A","azul",
                                             Automovel.MOVIDOAGASOLINA);
    System.out.println(al); // toString (implicitamente)
    System.out.println(al.quantoCusta());
    System.out.println(al.quantasPrestacoes()); // método superposto
    }

  } // fim da classe DemoAutomoveis
