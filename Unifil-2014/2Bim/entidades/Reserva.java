package entidades;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Reserva {

	private int id;
	private String visitante;
	private String quarto;
	private Date dtEntrada;
	private Date dtSaida;
	private String pagamento;
	private String status;
	
	public Reserva() {
		// TODO Auto-generated constructor stub
	}
	
	public Reserva(String visitante, String quarto, Date dtEntrada,
			Date dtSaida, String pagamento, String status) {
		super();
		this.visitante = visitante;
		this.quarto = quarto;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
		this.pagamento = pagamento;
		this.status = status;
	}

	public Reserva(int id, String visitante, String quarto, Date dtEntrada,
			Date dtSaida, String pagamento, String status) {
		this(visitante, quarto, dtEntrada, dtSaida, pagamento, status);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVisitante() {
		return visitante;
	}

	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}

	public String getQuarto() {
		return quarto;
	}

	public void setQuarto(String quarto) {
		this.quarto = quarto;
	}
	
	public String getDtEntrada() {
		SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
		if(dtEntrada == null){
			return null;
		}
		return dt1.format(dtEntrada);
	}

	public Date getDtEntrada2() {
		return dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	
	public String getDtSaida() {
		SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
		if(dtSaida == null){
			return null;
		}
		return dt1.format(dtSaida);
	}

	public Date getDtSaida2() {
		return dtSaida;
	}

	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
