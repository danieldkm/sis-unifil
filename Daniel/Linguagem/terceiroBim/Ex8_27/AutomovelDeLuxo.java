package Ex8_27;

class AutomovelDeLuxo extends AutomovelBasico
  { 
  private static final byte NUMEROMAXIMODEPRESTACOES = 36;

  private boolean direcaoHidraulica;
  private boolean cambioAutomatico;
  private boolean vidrosETravasEletricos;

  AutomovelDeLuxo(String m,String c,byte comb,
                  boolean retro,boolean limpa,boolean radio,
                  boolean dir,boolean camb,boolean vidro)
    {
    super(m,c,comb,retro,limpa,radio); // a inicialização dos campos herdados é 
                                       // feita pela superclasse
    direcaoHidraulica = dir; // a inicialização dos campos desta classe é feita
    cambioAutomatico = camb; // diretamente pelo construtor
    vidrosETravasEletricos = vidro;
    }

  AutomovelDeLuxo(String m,String c,byte comb)
    {
    super(m,c,comb); // a inicialização dos campos herdados é feita pela superclasse
    direcaoHidraulica = true;
    cambioAutomatico = true;
    vidrosETravasEletricos = true;
    }

  public float quantoCusta()
    {
    float preco = super.quantoCusta(); // calcula o preço-base do automóvel
    if (direcaoHidraulica) preco      += 5340;
    if (cambioAutomatico)  preco      += 7500;
    if (vidrosETravasEletricos) preco += 2320;
    return preco;
    }

  public byte quantasPrestacoes()
    {
    return NUMEROMAXIMODEPRESTACOES;
    }

  public String toString() 
    {
    String resultado = super.toString(); // a string que irá receber a concatenação
                                         // dos campos, já recebendo os dados 
                                         // formatados do automóvel
    if (direcaoHidraulica) 
      resultado +=  "Com direcao hidraulica\n";
    if (cambioAutomatico)
      resultado +=  "Com cambio automatico\n";
    if (vidrosETravasEletricos)                  
      resultado +=  "Com vidros e travas eletricas\n";
    return resultado;  // retorna o resultado da concatenação
    }

  } // fim da classe AutomovelDeLuxo
