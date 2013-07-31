package entity;

public class Produto {

	private int id;
	private String dataCadastro;
	private String descricao;
	private String complemento;
	private double precoCusto;
	private double precoVenda;
	private double margem;
	private String unidade;
	private double descontoMax;
	private double icms;
	private double ipi;
	private int qtdEstoque;
	private int estoqueMin;
	private int estoqueMax;
	private String fornecedor;
	private char iat;
	private char ippt;
	private char situacaoTributaria;

	public Produto(int id, String dataCadastro, String descricao,
			String complemento, double precoCusto, double precoVenda,
			double margem, String unidade, double descontoMax, double icms,
			double ipi, int qtdEstoque, int estoqueMin, int estoqueMax,
			String fornecedor, char iat, char ippt, char situacaoTributaria) {
		super();
		this.id = id;
		this.dataCadastro = dataCadastro;
		this.descricao = descricao;
		this.complemento = complemento;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.margem = margem;
		this.unidade = unidade;
		this.descontoMax = descontoMax;
		this.icms = icms;
		this.ipi = ipi;
		this.qtdEstoque = qtdEstoque;
		this.estoqueMin = estoqueMin;
		this.estoqueMax = estoqueMax;
		this.fornecedor = fornecedor;
		this.iat = iat;
		this.ippt = ippt;
		this.situacaoTributaria = situacaoTributaria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public double getMargem() {
		return margem;
	}

	public void setMargem(double margem) {
		this.margem = margem;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public double getDescontoMax() {
		return descontoMax;
	}

	public void setDescontoMax(double descontoMax) {
		this.descontoMax = descontoMax;
	}

	public double getIcms() {
		return icms;
	}

	public void setIcms(double icms) {
		this.icms = icms;
	}

	public double getIpi() {
		return ipi;
	}

	public void setIpi(double ipi) {
		this.ipi = ipi;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public int getEstoqueMin() {
		return estoqueMin;
	}

	public void setEstoqueMin(int estoqueMin) {
		this.estoqueMin = estoqueMin;
	}

	public int getEstoqueMax() {
		return estoqueMax;
	}

	public void setEstoqueMax(int estoqueMax) {
		this.estoqueMax = estoqueMax;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public char getIat() {
		return iat;
	}

	public void setIat(char iat) {
		this.iat = iat;
	}

	public char getIppt() {
		return ippt;
	}

	public void setIppt(char ippt) {
		this.ippt = ippt;
	}

	public char getSituacaoTributaria() {
		return situacaoTributaria;
	}

	public void setSituacaoTributaria(char situacaoTributaria) {
		this.situacaoTributaria = situacaoTributaria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		long temp;
		temp = Double.doubleToLongBits(descontoMax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + estoqueMax;
		result = prime * result + estoqueMin;
		result = prime * result
				+ ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + iat;
		temp = Double.doubleToLongBits(icms);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		temp = Double.doubleToLongBits(ipi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ippt;
		temp = Double.doubleToLongBits(margem);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(precoCusto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(precoVenda);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + qtdEstoque;
		result = prime * result + situacaoTributaria;
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (Double.doubleToLongBits(descontoMax) != Double
				.doubleToLongBits(other.descontoMax))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (estoqueMax != other.estoqueMax)
			return false;
		if (estoqueMin != other.estoqueMin)
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (iat != other.iat)
			return false;
		if (Double.doubleToLongBits(icms) != Double
				.doubleToLongBits(other.icms))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(ipi) != Double.doubleToLongBits(other.ipi))
			return false;
		if (ippt != other.ippt)
			return false;
		if (Double.doubleToLongBits(margem) != Double
				.doubleToLongBits(other.margem))
			return false;
		if (Double.doubleToLongBits(precoCusto) != Double
				.doubleToLongBits(other.precoCusto))
			return false;
		if (Double.doubleToLongBits(precoVenda) != Double
				.doubleToLongBits(other.precoVenda))
			return false;
		if (qtdEstoque != other.qtdEstoque)
			return false;
		if (situacaoTributaria != other.situacaoTributaria)
			return false;
		if (unidade == null) {
			if (other.unidade != null)
				return false;
		} else if (!unidade.equals(other.unidade))
			return false;
		return true;
	}
	
	
}
