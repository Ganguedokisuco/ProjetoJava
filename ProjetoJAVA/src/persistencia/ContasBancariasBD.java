package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.postgresql.core.ConnectionFactory;
import org.postgresql.core.Logger;
import org.postgresql.core.ProtocolConnection;
import org.postgresql.util.HostSpec;

import facade.Conta;
import modelo.ListaConta;

public class ContasBancariasBD implements IContasBancarias {
	ConectarBanco cbd = new ConectarBanco();
	
	@Override
	public void adicionar(Conta conta) {
		// TODO Auto-generated method stub
		try{
			cbd.conexao();
			
			String insertSql = "INSERT INTO conta(cpf,nome,numero,saldo) VALUES(?,?,?,?)";
			PreparedStatement pst = cbd.conn.prepareStatement(insertSql);
			
//			pst.setString(1, "12345678910");
//			pst.setString(2, "Chico");
//			//pst.setString(3, "10/05/2015");
//			pst.setInt(3, 12345);
//			pst.setDouble(4, 0);
			System.out.println("Numero: "+conta.getNumero()+"\n CPF: "+conta.getCpf()+"Nome: "+conta.getNome());
			pst.setString(1,conta.getCpf());
			pst.setString(2,conta.getNome());
			pst.setString(3,conta.getNumero());
			//pst.setString(4,conta.getData());
			pst.setDouble(4,conta.getSaldo());
			
			pst.executeUpdate();
			
			pst.close();
			
			JOptionPane.showMessageDialog(null, "Dados inseridos no banco!");
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Dados não inseridos no banco!");
		}finally{
			try {
				cbd.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		JDBC
		
	}

	@Override
	public List<Conta> listar() {
		
		List<Conta> contas = new ArrayList<>();
		
		try{
		cbd.conexao();
		
		String listarsql = "SELECT * FROM conta";
		PreparedStatement psl = cbd.conn.prepareStatement(listarsql);
		int resultadoDoStatement = psl.executeUpdate();
		
		System.out.printf("resultadoDoStatement = %d", resultadoDoStatement);
		
		ResultSet rs = psl.executeQuery();
		
		while (rs.next()) {
			Conta conta = new Conta();

			int i = 0;
			String numero = rs.getString(++i);
			double saldo = rs.getDouble(++i);

			conta.getCpf();
			conta.getNome();
			conta.getNumero();
			conta.getData();
			conta.getSaldo();			

			contas.add(conta);

			System.out.printf("CPF: %s, Nome: %s, Numero: %s, Data: %s, saldo = %.2f\n",
					conta.getCpf(), conta.getNome(),conta.getNumero(),conta.getData(),conta.getSaldo());
		}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		cbd.conn.close();
		return contas;
	}

	@Override
	public void deletar(String numero) {
		// TODO Auto-generated method stub
		try{
			cbd.conexao();
			
			String insertDel = "DELETE FROM conta WHERE cpf = ?";
			PreparedStatement pst = cbd.conn.prepareStatement(insertDel);
			pst.setString(1, numero);
			String consultaDeletar = "SELECT * FROM conta";

			pst.executeUpdate();
			
			pst.close();
			
			JOptionPane.showMessageDialog(null, "Dados deletados do banco!");
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Dados não deletados no banco!");
		}finally{
			try {
				cbd.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void atualizar(String numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debitar(double saldo) {
		
		
	}

	@Override
	public void creditar(double saldo) {
		String consultaCreditar = "UPDATE conta SET saldo = ? WHERE ...";
		
	}
}