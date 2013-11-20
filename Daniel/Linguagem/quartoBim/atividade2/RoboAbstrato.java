package atividade2;

/** 
 * A classe abstrata RoboAbstrato define que métodos e campos mínimos uma classe
 * que implementa um robô deve conter. 
 * Esta classe é declarada como sendo abstrata, assim não pode ser instanciada
 * diretamente. Alguns de seus métodos têm corpo, podendo ser herdados diretamente
 * por outra classe, ou sobrepostos. Os métodos que são declarados como sendo abstratos
 * não têm corpo, e devem obrigatoriamente ser implementados pelas classes herdeiras
 * (a não ser que as classes herdeiras sejam também abstratas).
 */
abstract class RoboAbstrato // declaração da classe abstrata
  {
 /**
  * Declaração dos campos da classe
  */
  private String nomeDoRobo;
  private int posicaoXAtual,posicaoYAtual;
  private short direcaoAtual; // permite maior flexibilidade na representação da 
                              // direção - consideraremos que são valores em graus
     
 /**
  * O construtor para a classe RoboAbstrato, que recebe argumentos para inicializar 
  * todos os campos da classe.
  * @param n o nome do robô
  * @param px a posição X atual
  * @param py a posição Y atual
  * @param d a direção atual
  */
  RoboAbstrato(String n,int px,int py,short d)
    {
    nomeDoRobo = n;
    posicaoXAtual = px;
    posicaoYAtual = py;
    direcaoAtual = d;
    } // fim do construtor com todos os argumentos

 /**
  * Esta versão do método move modifica a posição do robô em uma unidade na direção
  * em que o robô está. Este método não recebe argumentos, e chama o método move com
  * argumentos.
  */
  public void move()
    {
    move(1);
    } // fim do método move

 /**
  * Esta versão do método move modifica a posição do robô em um número de unidades na
  * direção em que o robô está. O método é declarado como abstrato e não tem corpo, 
  * pois não sabemos exatamente como um robô (instância de classe que herda desta) irá
  * implementar seus movimentos.
  * @param passos o número de "passos" para o robô
  */
  public abstract void move(int passos);

 /**
  * Este método permite a modificação do campo posiçãoXAtual, já que o método move
  * foi declarado como abstrato e não existe outra maneira de modificar a posição 
  * do robô.
  * @param passos o número de "passos" que serão usados para modificar a posição X
  *        (horizontal) atual do robô
  */
  public void moveX(int passos)
    {
    posicaoXAtual += passos;
    }

 /**
  * Este método permite a modificação do campo posiçãoYAtual, já que o método move
  * foi declarado como abstrato e não existe outra maneira de modificar a posição 
  * do robô.
  * @param passos o número de "passos" que serão usados para modificar a posição Y
  *        (vertical) atual do robô
  */
  public void moveY(int passos)
    {
    posicaoYAtual += passos;
    }

 /**
  * O método mudaDireção permite que a direção do robô seja mudada depois de ele ter
  * sido criado.
  * @param novaDireção a nova direção para o robô.
  */
  public void mudaDirecao(short novaDirecao)
    {
    direcaoAtual = novaDirecao;
    } // fim do método mudaDireção

 /**
  * Este método permite a verificação do calor do campo direçãoAtual, já que o mesmo
  * foi declarado como sendo privado.
  * @return o valor do campo direçãoAtual
  */
  public short qualDirecaoAtual()
    {
    return direcaoAtual;
    }

 /**
  * O método toString não recebe argumentos e retorna uma string contendo os valores 
  * dos campos da classe formatados.
  * @return uma string com os valores dos campos formatados.
  */
  public String toString()
    {
    String resultado = "Nome do robô:"+nomeDoRobo+"\n";
    resultado = resultado+"Posição do robô: ("+posicaoXAtual+","+
                                               posicaoYAtual+")\n";
    resultado = resultado+"Direção do robô:"+direcaoAtual;
    return resultado;                                   
    } // fim do método toString

  } // fim da classe abstrata RoboAbstrato
