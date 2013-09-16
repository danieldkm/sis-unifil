package Ex8_27;

class Automovel
  { 
  public static final byte MOVIDOAGASOLINA = 1;
  public static final byte MOVIDOAALCOOL   = 2;
  public static final byte MOVIDOADIESEL   = 3;
  public static final byte MOVIDOAGAS      = 4;
  private static final byte numeroMaximoPrestacoes = 24;
      
  private String modelo;       // o modelo do automÃ³vel
  private String cor;          // a cor do automÃ³vel
  private byte combustivel;    // o tipo de combustÃ­vel do automÃ³vel, veja lista 
                               // declarada anteriormente nesta classe

  Automovel(String m,String c,byte comb)
    {
    modelo = m;
    cor = c;
    combustivel = comb;
    }

  public float quantoCusta()
    {
    float prestacao = 0; // a variÃ¡vel deve ser inicializada
    switch(combustivel)
      {
      case MOVIDOAGASOLINA: prestacao = 12000.0f; break; // Notem o sufixo 'f' ao final 
      case MOVIDOAALCOOL:   prestacao = 10500.0f; break; // de cada valor para denotar
      case MOVIDOADIESEL:   prestacao = 11000.0f; break; // um valor do tipo float e nÃ£o
      case MOVIDOAGAS:      prestacao = 13000.0f; break; // double (que seria o default)
      }
    return prestacao;
    }

  public byte quantasPrestacoes()
    {
    return numeroMaximoPrestacoes;
    }

  public String toString() 
    {
    String resultado; // a string que irÃ¡ receber a concatenaÃ§Ã£o dos campos
    resultado = modelo+" "+cor+"\n"; // inicializamos o resultado com o modelo e cor
    switch(combustivel) // adicionamos a descriÃ§Ã£o do combustÃ­vel
      {
      case MOVIDOAGASOLINA: resultado += "Movido a Gasolina\n"; break;
      case MOVIDOAALCOOL:   resultado += "Movido a Alcool\n"; break;
      case MOVIDOADIESEL:   resultado += "Movido a Diesel\n"; break;
      case MOVIDOAGAS:      resultado += "Movido a Gas\n"; break;
      }
    return resultado;  // retorna o resultado da concatenaÃ§Ã£o
    }

  } // fim da classe Automovel
