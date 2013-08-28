package dia2708;

import java.security.Permissions;

import dia2708.DataHora.Data;
import dia2708.DataHora.DataHora;
import dia2708.Funcionario.Funcionario0;
import dia2708.Funcionario.Pessoa0;
import dia2708.Lampada.Lampada;
import dia2708.Lampada.LampadaFluorescente;

public class Teste {

	public static void main(String[] args) {
//		DataHora dh = new DataHora((byte)21,(byte)33,(byte)50,(byte)27,(byte)08,(short)2013);
		DataHora dh = new DataHora((byte) 21, (byte) 33, (byte) 50, (byte) 27, (byte) 8, (short) 2013);
		DataHora dh2 = new DataHora((byte) 21, (byte) 33, (byte) 50, (byte) 27, (byte) 8, (short) 2013);
		System.out.println(dh.eIgual(dh2));
		
		Data dt = new Data((byte)21, (byte) 8, (short)2013);
		Data dtNasc = new Data((byte)12, (byte) 11, (short)1900);
		Data dtAdminssao = new Data((byte)1, (byte) 1, (short)2013);
//		Pessoa0 pessoa = new Funcionario0("Daniel2", 1, dt, f, dtAdminssao, 1000f);
		Pessoa0 p = new Pessoa0("Daniel", 1, dtNasc);
		Funcionario0 f = new Funcionario0("Daniel", 1, dt, p, dtAdminssao, 1000f);
		f.modificaNome("Tesdfsd");
		
		System.out.println(f);
		
		Lampada l = new Lampada();
		LampadaFluorescente lf = new LampadaFluorescente(10, false, (short)60);
		System.out.println(lf);
		
	}

}
