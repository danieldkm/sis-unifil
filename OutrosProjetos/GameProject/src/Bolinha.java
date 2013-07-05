import Bola.BD_BolaMovimento;
import Bola.BD_BolaParada;
import Engine.ProvedorDeServicos;
import Engine.Estruturas_de_Dados.PriorityQueue.Prioridade;
import Engine.Sprites_AND_Animacoes.PhysicsVector;
import Engine.Sprites_AND_Animacoes.Sprite;
import State_Machine_Abstraction.Estado;
import State_Machine_Abstraction.Maquina_de_Estados;
import State_Machine_Abstraction.StateEvent;
import State_Machine_Abstraction.Transicao;

public class Bolinha {

	public static final float VEL_BOLINHA = 350F;

	private Maquina_de_Estados SM_Bolinha;

	private Sprite sprBolinha;

	private Estado<BD_BolaParada, BD_BolaParada> E_Parada;

	private Estado<BD_BolaMovimento, BD_BolaMovimento> E_Movimento;

	private class T_ParadaToMovimento extends Transicao {
		public T_ParadaToMovimento() {
			super(E_Movimento, "Bola Parada -> Bola Movimento");
		}

		@Override
		public boolean clausula() {
			return E_Parada.getComportamento().isContRegressivaTerminada();
		}

		@Override
		public void efetuarTransicao() {
			PhysicsVector vetorDirecao = new PhysicsVector(-1, 0.5f);
			PhysicsVector vetorVelocidade = vetorDirecao
					.multiplicarPorConstante(VEL_BOLINHA);
			sprBolinha.setVelocidade(vetorVelocidade);
			E_Parada.getComportamento().setContRegressivaTerminada(false);
		}

	}

	public Maquina_de_Estados getSM_Bolinha() {
		return SM_Bolinha;
	}

	public void setSM_Bolinha(Maquina_de_Estados sM_Bolinha) {
		SM_Bolinha = sM_Bolinha;
	}

	public Sprite getSprBolinha() {
		return sprBolinha;
	}

	public void setSprBolinha(Sprite sprBolinha) {
		this.sprBolinha = sprBolinha;
	}

	private class T_MovimentoToParada extends Transicao {
		public T_MovimentoToParada() {
			super(E_Parada, "Bola Movimento -> Bola Parada");
		}

		public boolean clausula() {
			return saiuPelaDireita() || saiuPelaEsquerda();
		}

		private boolean saiuPelaEsquerda() {
			return sprBolinha.getAcelX() + sprBolinha.getImage().getWidth(null) < 0;
		}

		private boolean saiuPelaDireita() {
			return sprBolinha.getAcelX() > ProvedorDeServicos.getTelaX();
		}

		@Override
		public void efetuarTransicao() {
			StateEvent evento = null;

			if (saiuPelaDireita()) {
				evento = new EventoPontoFeito(this, "SM Placar",
						SM_Bolinha.getNome(), 'E');
			} else if (saiuPelaEsquerda()) {
				evento = new EventoPontoFeito(this, "SM Placar",
						SM_Bolinha.getNome(), 'E');
			}
			this.sendStateEvent(Prioridade.MUITO_ALTA,
					ProvedorDeServicos.getFilaDeEventos(), evento);
			
			PhysicsVector novoVetor = new PhysicsVector(ProvedorDeServicos.getTelaX() / 2, ProvedorDeServicos.getTelaY() / 2);
			
			sprBolinha.setPosicao(novoVetor);
		}

	}

}
