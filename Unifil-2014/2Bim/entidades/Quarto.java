package entidades;

public class Quarto {

	private int id;
	private String descricao;
	private String tipo;
	private int capacidade;
	
	public Quarto() {
	}
	
	public Quarto(String descricao, String tipo, int capacidade) {
		this.descricao = descricao;
		this.tipo = tipo;
		this.capacidade = capacidade;
	}
	
	public Quarto(int id, String descricao, String tipo, int capacidade) {
		this(descricao, tipo, capacidade);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	@Override
	public String toString() {
		return "Quarto [id=" + id + ", descricao=" + descricao + ", tipo="
				+ tipo + ", capacidade=" + capacidade + "]";
	}
	

}
