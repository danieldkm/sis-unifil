

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Banco {

	private Statement stm;
	private ResultSet rs;
	private Connection conBD;
	
	public Banco() {
		try {
			ConnectionBD con = new ConnectionBD();
			conBD = con.getConn();
			stm = conBD.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addCliente(String dataCadastro, String nome, String dataNasc, String cpf, String rg, String endereco,
			String bairro, String cidade, String cep, String telefone, String celular, String sexo, String nat,
			String estCivil, String estado) {
		
		try {
			stm.executeUpdate("INSERT INTO cliente (cod_cliente, data_cadastro, nome, data_nascimento, cpf, " +
					"rg, endereco, bairro, cidade," + 
					"cep, telefone, celular, sexo, estado_civil, estador, naturalidade)" +
					"VALUES (NULL,'"+dataCadastro+"','"+nome+"','"+dataNasc+"','"+cpf+"','"+rg+"','"+endereco+
					"','"+bairro+"','"+cidade+"','"+cep+"','"+telefone+"','"+celular+"','"+sexo+"','"+estCivil+"','"+estado+"','"+nat+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addProduto(String dataCadastro, String desc, String comp, double precoCusto, double precoVenda,
			double margem, String unidade, double desc_max, double icms, double ipi, double qtdEstoque, int estoqueMin,
			int estoqueMax, int fornecedor, char iat, char ippt, char sit_trib) {
		
		try {
			stm.executeUpdate("INSERT INTO produto (cod_produto, data_cadastro, descricao, complemento, preco_custo, preco_venda" +
					", margem, unidade, desc_max, icms, ipi, qtd_estoque, estoque_minimo, estoque_maximo," +
					"fornecedor, iat, ippt, sit_trib) " +
					"VALUES (NULL,'"+dataCadastro+"','"+desc+"','"+comp+"','"+precoCusto+"','"+precoVenda+
					"','"+margem+"','"+unidade+"','"+desc_max+"','"+icms+"','"+ipi+"','"+qtdEstoque+"','"+estoqueMin+"','"+estoqueMax+
					"','"+fornecedor+"','"+iat+"','"+ippt+"','"+sit_trib+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getCodClienteMax(){
		int a = 0;
		try {
			rs = stm.executeQuery("SELECT MAX(cod_cliente) FROM cliente");
			rs.first();
			a = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public int getCodProdutoMax(){
		int a = 0;
		try {
			rs = stm.executeQuery("SELECT MAX(cod_produto) FROM produto");
			rs.first();
			a = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public ArrayList<String> buscaCliente(String nome) {
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			rs = stm.executeQuery("SELECT * FROM cliente WHERE nome LIKE '%" + nome + "%' ORDER BY nome");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			rs.first();
			list.add(rs.getString("cod_cliente"));
			list.add(rs.getString("nome"));
			list.add(rs.getString("cpf"));
			list.add(rs.getString("rg"));
			list.add(rs.getString("endereco"));
			list.add(rs.getString("bairro"));
			list.add(rs.getString("data_cadastro"));
			list.add(rs.getString("data_nasc"));
			list.add(rs.getString("cidade"));
			list.add(rs.getString("cep"));
			list.add(rs.getString("estado"));
			list.add(rs.getString("telefone"));
			list.add(rs.getString("celular"));
			list.add(rs.getString("sexo"));
			list.add(rs.getString("naturalidade"));
			list.add(rs.getString("est_civil"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList buscaProdutoCod(int cod) {
		ArrayList list = new ArrayList();
		
		try {
			rs = stm.executeQuery("SELECT cod_produto, descricao, preco_venda, unidade FROM produto WHERE cod_produto = " + cod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				list.add(rs.getInt("cod_produto"));
				list.add(rs.getString("descricao"));
				//list.add(rs.getDouble("preco_custo"));
				list.add(rs.getDouble("preco_venda"));
				list.add(rs.getString("unidade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList buscaProdutoDesc(String desc) {
		ArrayList list = new ArrayList();
		
		try {
			rs = stm.executeQuery("SELECT cod_produto, descricao, unidade, qtd_estoque, preco_venda, sit_trib, ippt, iat" +
					"  FROM produto WHERE descricao LIKE '%" + desc + "%' ORDER BY descricao");
			
			while (rs.next()) {
				list.add(rs.getInt("cod_produto"));
				list.add(rs.getString("descricao"));
				list.add(rs.getString("unidade"));
				list.add(rs.getInt("qtd_estoque"));
				list.add(rs.getDouble("preco_venda"));
				list.add(rs.getString("sit_trib"));
				list.add(rs.getString("iat"));
				list.add(rs.getString("ippt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<String> tabProd() {
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			rs = stm.executeQuery("SELECT cod_produto, descricao, unidade, iat, ippt, sit_trib, preco_venda FROM produto");
			while (rs.next()) {
				list.add(rs.getString("cod_produto"));
				list.add(rs.getString("descricao"));
				list.add(rs.getString("unidade"));
				list.add(rs.getString("iat"));
				list.add(rs.getString("ippt"));
				list.add(rs.getString("sit_trib"));
				list.add(rs.getString("preco_venda"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<String> estoque() {
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			rs = stm.executeQuery("SELECT cod_produto, descricao, unidade, qtd_estoque, data_cadastro FROM produto");
			while (rs.next()) {
				list.add(rs.getString("cod_produto"));
				list.add(rs.getString("descricao"));
				list.add(rs.getString("unidade"));
				list.add(rs.getString("qtd_estoque"));
				list.add(rs.getString("data_cadastro"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void geraCupomFiscalBanco(int coo, int ccf, int codCliente, String fabImp, double valorTotal, 
			double desconto, char situacao, String meioPgto,  String data,  String hora, double acrescimo) {
		try {
			stm.executeUpdate("INSERT INTO cupom_fiscal VALUES ('"+coo+"','"+ccf+"','"+codCliente+"','"+
					fabImp+"','"+valorTotal+"','"+desconto+"','"+situacao+"','"+meioPgto+"','"+data+"','"+hora+"','"+acrescimo+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getMD5() {
		String aux = "";
		try {
			rs = stm.executeQuery("SELECT md5 FROM dados_analise_paf");
			rs.first();
			aux = rs.getString("md5");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aux;
	}
	
	public String getNLaudo() {
		String aux = "";
		try {
			rs = stm.executeQuery("SELECT n_laudo FROM dados_analise_paf");
			rs.first();
			aux = rs.getString("n_laudo");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aux;
	}
	
	public void updateSitCupomC(int ccf) {
		try {
			stm.executeUpdate("UPDATE cupom_fiscal SET situacao = 'C' WHERE ccf = "+ccf);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList meiosPgto(String dataIni, String dataFim) {
		ArrayList list = new ArrayList();
		try {
			rs = stm.executeQuery("SELECT data_emissao, meio_pgto, valor_total FROM cupom_fiscal WHERE data_emissao BETWEEN '" + dataIni + 
					"' AND '" + dataFim+"'");
			while(rs.next()) {
				list.add(rs.getString("data_emissao"));
				list.add(rs.getString("meio_pgto"));
				list.add(rs.getString("valor_total"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void geraCupomNaoFiscalBanco(int coo, String data, String hora, String fab, int gnf) {
		try {
			stm.executeUpdate("INSERT INTO cupom_nao_fiscal VALUES ('"+coo+"','"+data+"','"+hora+"','"+
					fab+"','"+gnf+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cadastraECF(String marca, String modelo, String fab, String razao, String data, String versao) {
		try {
			stm.executeUpdate("INSERT INTO impressora VALUES ('"+marca+"','"+modelo+"','"+fab+"','"+
					razao+"','"+data+"','"+versao+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void gravaItemVendido(String coo, String ccf, String n_item, String fab, String qtd, String vl_uni,
			String acrescimo, String desconto, String vl_total, String qtd_canc, String iat, String ippt,
			String data, String hora) {
		try {
			stm.executeUpdate("INSERT INTO item_vendido VALUES ('"+coo+"','"+ccf+"','"+n_item+"','"+
					fab+"','"+qtd+"','"+vl_uni+"','"+acrescimo+"','"+desconto+"','"+vl_total+"','"+qtd_canc
					+"','"+iat+"','"+ippt+"','"+data+"','"+hora+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateR01(String serie, String dataIni, String dataFim) {
		try {
			stm.executeUpdate("UPDATE r01 SET data_ini = '" + dataIni + "', data_fim = '" + dataFim + "' WHERE fab = '" + serie + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void r01(String fab, String mf, String tipo, String marca, String modelo, String versaoSB, String data,
			String nECF, String cnpj, String ieUser, String cnpjDesenv, String ieDesenv, String imDesenv,
			String denominacao, String nomePAF, String versaoPAF, String md5, String dataInicial, String dataFinal,
			String vR) {
		try {
			stm.executeUpdate("INSERT INTO r01 VALUES ('"+fab+"','"+mf+"','"+tipo+"','"+marca+"','"+
					modelo+"','"+versaoSB+"','"+data+"','"+nECF+"','"+cnpj+"','"+ieUser+"','"+cnpjDesenv
					+"','"+ieDesenv+"','"+imDesenv+"','"+denominacao+"','"+nomePAF+"','"+versaoPAF
					+"','"+md5+"','"+dataInicial+"','"+dataFinal+"','"+vR+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void r02(String fab, String mf, String modelo, String nUser, String crz, String coo, String cro,
			String dataMov, String data, String hora, String venda, String param) {
		try {
			stm.executeUpdate("INSERT INTO r02 VALUES ('"+fab+"','"+mf+"','"+modelo+"','"+nUser+"','"+
					crz+"','"+coo+"','"+cro+"','"+dataMov+"','"+data+"','"+hora
					+"','"+venda+"','"+param+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void r03(String fab, String mf, String modelo, String nUser, String crz, String totalizador, String vl) {
		try {
			stm.executeUpdate("INSERT INTO r03 VALUES ('"+fab+"','"+mf+"','"+modelo+"','"+
					nUser+"','"+crz+"','"+totalizador+"','"+vl+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void r04(String fab, String mf, String modelo, String nUser, String ccf, String coo, String data,
			String subTotal, String descSub, String tipoDesc, String acSub, String tipoAc, String vlTotal, String ic,
			String cancAc, String ordemAcDesc, String nome, String cpf) {
		try {
			stm.executeUpdate("INSERT INTO r04 VALUES ('"+fab+"','"+mf+"','"+modelo+"','"+
					nUser+"','"+ccf+"','"+coo+"','"+data+"','"+subTotal+"','"+descSub+"','"+tipoDesc
					+"','"+acSub+"','"+tipoAc+"','"+vlTotal+"','"+ic+"','"+cancAc
					+"','"+ordemAcDesc+"','"+nome+"','"+cpf+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void r05(String fab, String mf, String modelo, String nUser, String coo, String ccf, String nItem,
			String codProd, String desc, String qtd, String uni, String vl_Uni, String desconto, String acrescimo,
			String vl_total, String totalizador, String iCanc, String qtdCanc, String vlCanc, String cancAcrescimo,
			String iat, String ippt, String data) {
		try {
			stm.executeUpdate("INSERT INTO r05 VALUES ('"+fab+"','"+mf+"','"+modelo+"','"+
					nUser+"','"+coo+"','"+ccf+"','"+nItem+"','"+codProd+"','"+desc+"','"+qtd
					+"','"+uni+"','"+vl_Uni+"','"+desconto+"','"+acrescimo+"','"+vl_total
					+"','"+totalizador+"','"+iCanc+"','"+qtdCanc+"','"+vlCanc+"','"+cancAcrescimo
					+"','"+iat+"','"+ippt+"',2 ,2, '"+data+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void r06(String fab, String mf, String modelo, String nUser, String coo, String gnf, String grg,
			String cdc, String denominacao, String data, String hora) {
		try {
			stm.executeUpdate("INSERT INTO r06 VALUES ('"+fab+"','"+mf+"','"+modelo+"','"+
					nUser+"','"+coo+"','"+gnf+"','"+grg+"','"+cdc+"','"+denominacao+"','"+data
					+"','"+hora+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void r07(String fab, String mf, String modelo, String nUser, String coo, String ccf, String gnf,
			String meio, String vl, String est, String vlEst) {
		try {
			stm.executeUpdate("INSERT INTO r07 VALUES ('"+fab+"','"+mf+"','"+modelo+"','"+
					nUser+"','"+coo+"','"+ccf+"','"+gnf+"','"+meio+"','"+vl+"','"+est
					+"','"+vlEst+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList getR01(String serie) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			rs = stm.executeQuery("SELECT fab, mf_adicional, tipo_ecf, marca_ecf, modelo_ecf, versaoSB, data_horaSB, " +
					"nECF, cnpj_user, ie_user, cnpj_desenv, ie_desenv, im_desenv, denominacao_desenv, nome_PAF, versao_PAF, " +
					"md5, versao_er FROM r01 WHERE fab = " + "'"+serie+"'");
			while(rs.first()) {
				list.add(rs.getString("fab"));
				list.add(rs.getString("mf_adicional"));
				list.add(rs.getString("tipo_ecf"));
				list.add(rs.getString("marca_ecf"));
				list.add(rs.getString("modelo_ecf"));
				list.add(rs.getString("versaoSB"));
				list.add(rs.getString("data_horaSB"));
				list.add(rs.getString("nECF"));
				list.add(rs.getString("cnpj_user"));
				list.add(rs.getString("ie_user"));
				list.add(rs.getString("cnpj_desenv"));
				list.add(rs.getString("ie_desenv"));
				list.add(rs.getString("im_desenv"));
				list.add(rs.getString("denominacao_desenv"));
				list.add(rs.getString("nome_PAF"));
				list.add(rs.getString("versao_PAF"));
				list.add(rs.getString("md5"));
				list.add(rs.getString("versao_er"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList getR02(String dataIni, String dataFim, String serie) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			rs = stm.executeQuery("SELECT fab, mf_adicional, modelo_ecf, n_usuario, crz, coo, cro, data_mov, data_rz, " +
					"hora_rz, venda_bruta, parametro_ecf FROM r02 WHERE fab = '" + serie + "' AND data_mov BETWEEN '" + dataIni + 
					"' AND '" + dataFim+"'");
			while(rs.next()) {
				list.add(rs.getString("fab"));
				list.add(rs.getString("mf_adicional"));
				list.add(rs.getString("modelo_ecf"));
				list.add(rs.getString("n_usuario"));
				list.add(rs.getString("crz"));
				list.add(rs.getString("coo"));
				list.add(rs.getString("cro"));
				list.add(rs.getString("data_mov"));
				list.add(rs.getString("data_rz"));
				list.add(rs.getString("hora_rz"));
				list.add(rs.getString("venda_bruta"));
				list.add(rs.getString("parametro_ecf"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList getR03(String dataIni, String dataFim, String serie) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			rs = stm.executeQuery("SELECT fab, mf_adicional, modelo_ecf, n_usuario, crz, totalizador, vl_ac " +
					"FROM r03 WHERE fab = '" + serie + "' AND data_mov BETWEEN '" + dataIni + 
					"' AND '" + dataFim+"'");
			while(rs.next()) {
				list.add(rs.getString("fab"));
				list.add(rs.getString("mf_adicional"));
				list.add(rs.getString("modelo_ecf"));
				list.add(rs.getString("n_usuario"));
				list.add(rs.getString("crz"));
				list.add(rs.getString("totalizador"));
				list.add(rs.getString("vl_ac"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList getR04(String dataIni, String dataFim, String serie) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			rs = stm.executeQuery("SELECT fab, mf_adicional, modelo_ecf, n_usuario, ccf, coo, data_emissao, " +
					"subtotal, desconto, it_desconto, acrescimo, it_acrescimo, vl_total, i_canc, canc_acrescimo, " +
					"ordem_ap_desc_acresc, nome_cliente, cpf FROM r04 WHERE fab = '" + serie + "' AND data_mov BETWEEN '" 
					+ dataIni + "' AND '" + dataFim+"'");
			while(rs.next()) {
				list.add(rs.getString("fab"));
				list.add(rs.getString("mf_adicional"));
				list.add(rs.getString("modelo_ecf"));
				list.add(rs.getString("n_usuario"));
				list.add(rs.getString("ccf"));
				list.add(rs.getString("coo"));
				list.add(rs.getString("data_emissao"));
				list.add(rs.getString("subtotal"));
				list.add(rs.getString("desconto"));
				list.add(rs.getString("it_desconto"));
				list.add(rs.getString("acrescimo"));
				list.add(rs.getString("it_acrescimo"));
				list.add(rs.getString("vl_total"));
				list.add(rs.getString("i_canc"));
				list.add(rs.getString("canc_acrescimo"));
				list.add(rs.getString("ordem_ap_desc_acresc"));
				list.add(rs.getString("nome_cliente"));
				list.add(rs.getString("cpf"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
