package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * Classe exemplo de acesso JDBC para a disciplina de Metodologia e Linguagem de Programa‹o III.
 * 
 * @author jefferson
 * @date 18/11/2014
 * @version 1.0
 *
 */

public class ConectarBanco {

	
	public Statement stm;//responsavel por preparar e realizar pesquisas no BD
	public ResultSet rs;//responsavel por armazenar o resultado de uma pesquisa passada para o Stm
	public Connection conn;//responsavel por realizar a conex�o com o BD
	
	private static String driver = "org.postgresql.Driver";
	private static String caminho = "jdbc:postgresql://localhost:5432/database_teste";
	private static String usuario = "postgres";
	private static String senha = "hbytes1234";
	
//	private static String driver =  "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	private static String caminho = "jdbc:sqlserver://localhost/Informatica";
//	private static String usuario = "sa";
//	private static String senha = "hbytes1234";
//	
	public Connection conexao(){
		
		try {//tentativa inicial
			System.setProperty("jdbc.Drivers", driver);//seta a propriedade do driver de conex�o
			conn = DriverManager.getConnection(caminho, usuario, senha);//realiza a conex�o com o BD
			
			JOptionPane.showMessageDialog(null,"Banco conectado com sucesso! ");
			return conn;
		} catch (SQLException e) {//excess�o 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"ERRO DE CONEXAO!\n Erro: "+e.getMessage());
		}
		return conn;
	}
        public void executaSql(String sql){
            try {
                stm = conn.createStatement();
                rs = stm.executeQuery(sql);
                 
            } catch (SQLException ex) {
                //JOptionPane.showMessageDialog(null,"ERRO de ExecutaSQL!\n Erro: "+ex.getMessage());
            }
        }
	public void desconecta(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao fechar conex�o!\n Erro: "+e.getMessage());
		}
	}
	
}