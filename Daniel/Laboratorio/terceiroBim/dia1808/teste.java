package dia1808;

public class teste {

	public static void main(String[] args) {
		Projeto p = new Projeto("Sis", 1030);
		p.registrarHora(2);
		System.out.println(p.custoAtual());
		
		ProjetoHardware ph = new ProjetoHardware("SIS Hardware", 1000, 90, 80, 70, 60);
		ph.registrarHora(1);
		System.out.println(ph.custoAtual());
		
		ProjetoSotware ps = new ProjetoSotware("SIS Software", 900, 90, 80);
		ps.registrarHora(1);
		System.out.println(ps.custoAtual());
	}

}
