package Ex8_27;

class AutomovelBasico extends Automovel
  { 
  private boolean retrovisorDoLadoDoPassageiro; 
  private boolean limpadorDoVidroTraseiro;
  private boolean radioAMFM;

  AutomovelBasico(String m,String c,byte comb,
                  boolean retro,boolean limpa,boolean radio)
    {
    super(m,c,comb); // A inicialização dos campos herdados é feita pela superclasse.
    retrovisorDoLadoDoPassageiro = retro; // a inicialização dos campos desta classe
    limpadorDoVidroTraseiro = limpa;      // é feita diretamente pelo construtor
    radioAMFM = radio;
    }

  AutomovelBasico(String m,String c,byte comb)
    {
    super(m,c,comb); // a inicialização dos campos herdados é feita pela superclasse
    retrovisorDoLadoDoPassageiro = true;
    limpadorDoVidroTraseiro = true;
    radioAMFM = true;
    }

  public float quantoCusta()
    {
    float preco = super.quantoCusta(); // calcula o preço-base do automóvel
    if (retrovisorDoLadoDoPassageiro) preco += 280;
    if (limpadorDoVidroTraseiro)      preco += 650;
    if (radioAMFM)                    preco += 190;
    return preco;
    }

  public String toString() 
    {
    String resultado = super.toString(); // a string que irá receber a concatenação
                                         // dos campos, já recebendo os dados 
                                         // formatados do automóvel
    if (retrovisorDoLadoDoPassageiro) 
      resultado +=  "Com retrovisor do lado do passageiro\n";
    if (limpadorDoVidroTraseiro)
      resultado +=  "Com limpador do vidro traseiro\n";
    if (radioAMFM)                  
      resultado +=  "Com radio AM/FM\n";
    return resultado;  // retorna o resultado da concatenação
    }

  } // fim da classe AutomovelBasico
