package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


//Esta classe poder� ser usada por qualquer outra classe que fa�a acesso ao banco de dados. 

public abstract class GenericDao {
	private Connection connection;

	protected GenericDao() {
		this.connection = ConnectionDataBase.getConnection();
	}

	protected Connection getConnection() {
		return connection;
	}

	protected void save(String insertSql, Object... parametros)
			throws SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(insertSql);

		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}

		pstmt.execute();
		pstmt.close();
	}

	protected void update(String updateSql, Object id, Object... parametros)
			throws SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(updateSql);

		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}
		pstmt.setObject(parametros.length + 1, id);
		pstmt.execute();
		pstmt.close();
	}

	protected void delete(String deleteSql, Object... parametros)
			throws SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(deleteSql);

		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}

		pstmt.execute();
		pstmt.close();
	}
	
	protected void selectNome(String selectNome,Object id, Object... parametros) throws SQLException{
		PreparedStatement pstmt = getConnection().prepareStatement(selectNome);

		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}
		pstmt.setObject(parametros.length + 1, id);
		pstmt.execute();
		pstmt.close();		
	}
}
