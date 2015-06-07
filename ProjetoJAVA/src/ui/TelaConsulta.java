package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.JapaneseDate;

import javax.swing.*;
import javax.swing.plaf.PanelUI;

public class TelaConsulta extends JFrame{
	
	private JPanel panelConsultaA;

	public void frameMain(JPanel painel){
		setSize(350, 355);
		setBackground(Color.GRAY);
		getContentPane().add(painel);
		setVisible(true);
	}
	
	//Tela de Consulta de Atualização
	public void telaConsultaAtualiza(){
		
		setTitle("Atualizar");
		
		JPanel panelTela = new JPanel();
		panelTela.setLayout(new BorderLayout());
		frameMain(panelTela);
		
		//Painel de Atualizar
		
		panelConsultaAtualizar(panelConsultaA);
		
		panelTela.add(panelConsultaA, BorderLayout.CENTER);
		panelTela.setVisible(true);
	}
	
	//Painel para tela de Atualizar
	public void panelConsultaAtualizar(JPanel painel){
		
		panelConsultaA = new JPanel();
		panelConsultaA.setLayout(null);	
		//Componentes pertencentes ao painel de atualizar
		nome(panelConsultaA);
		numeroConta(panelConsultaA);
		cpf(panelConsultaA);
		saldo(panelConsultaA);
		dataDeNascimento(panelConsultaA);
		dataUltimoAcesso(panelConsultaA);
		//Botao de voltar
		//panelConsultaA.add(botaoVoltar());
		//Label
		mensagemAtualizar(panelConsultaA);
		//Botoes
		panelConsultaA.add(botaoNaoAtualizar());
		panelConsultaA.add(botaoSimAtualizar());
	}
	
	//NOME
	public void nome(JPanel painel){
		//LABEL NOME
		JLabel labelNome = new JLabel("Nome: ");
		labelNome.setBounds( 10, 15, 150, 20 );
		painel.add(labelNome);
		//CAMPO NOME
		JTextField fieldNome = new JTextField();
		fieldNome.setBounds( 150, 15, 150, 20 );
	
		painel.add( fieldNome );
	}
	//NUMERO DA CONTA
	public void numeroConta(JPanel painel){
		//LABEL NUMERO DA CONTA
		JLabel labelNumeroConta = new JLabel("Numero da Conta: ");
		labelNumeroConta.setBounds( 10, 45, 150, 20 );
		painel.add(labelNumeroConta);
		//CAMPO NUMERO DA CONTA
		JTextField fieldNumeroConta = new JTextField();
		fieldNumeroConta.setBounds( 150, 45, 150, 20 );
	
		painel.add( fieldNumeroConta );
	}
	//CPF
	public void cpf(JPanel painel){
		//LABEL CPF
		JLabel labelCpf = new JLabel("CPF: ");
		labelCpf.setBounds( 10, 105, 150, 20 );
		painel.add(labelCpf);
		//CAMPO CPF
		JTextField fieldCPF = new JTextField();
		fieldCPF.setBounds( 150, 105, 150, 20 );
		
		painel.add( fieldCPF );
	}
	//SALDO
	public void saldo(JPanel painel){
		//LABEL SALDO
		JLabel labelSaldo = new JLabel("Saldo Disponível: ");
		labelSaldo.setBounds( 10, 75, 150, 20 );
		painel.add(labelSaldo);
		//CAMPO NUMERO DA CONTA
		JTextField fieldSaldo = new JTextField();
		fieldSaldo.setBounds( 150, 75, 150, 20 );
		
		painel.add( fieldSaldo );
	}
	//
	public void dataDeNascimento(JPanel painel){
		//LABEL DATA DE NASCIMENTO
		JLabel labelDataNasc = new JLabel("Data de Nascimento: ");
		labelDataNasc.setBounds( 10, 135, 150, 20 );
		painel.add(labelDataNasc);
		//CAMPO DATA DE NASCIMENTO
		JTextField fieldDataNasc = new JTextField();
		fieldDataNasc.setBounds( 150, 135, 150, 20 );
		
		painel.add( fieldDataNasc );
	}
	//DATA DE ULTIMO ACESSO
	public void dataUltimoAcesso(JPanel painel){
		//LABEL DATA DE ULTIMO ACESSO
		JLabel labelDataAcesso = new JLabel("Data do ultimo acesso: ");
		labelDataAcesso.setBounds( 10, 165, 150, 20 );
		painel.add(labelDataAcesso);
		//CAMPO DATA DE NASCIMENTO
		JTextField fieldDataAcesso = new JTextField();
		fieldDataAcesso.setBounds( 150, 165, 150, 20 );
	
		painel.add( fieldDataAcesso );
	}
	//Mensagem de excluir
	public void mensagemExcluir(JPanel painel){
		JLabel label = new JLabel("Você deseja deletar?");
		label.setBounds(103, 210, 200, 30);
		painel.add(label);
	}
	//Mensagem de Atualizar
	public void mensagemAtualizar(JPanel painel){
		JLabel label = new JLabel("Você deseja atualizar?");
		label.setBounds(103, 210, 200, 30);
		painel.add(label);
	}
	//BOTOES
/*//	public Component botaoVoltar(){
//		JButton botaoVoltar = new JButton();
//		botaoVoltar.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				//Voltar para pagina inicial
//				
//			}
//		});
//		
//		return botaoVoltar;
//	}
*/	
	public Component botaoSimAtualizar(){
		JButton botaoSimA = new JButton("OK");
		botaoSimA.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ação de atualizar
				JOptionPane.showMessageDialog(null, "Dados atualizado com sucesso!");
				
			}
		});
		botaoSimA.setBounds(170, 260, 57, 30);
		return botaoSimA;
	}
	public Component botaoNaoAtualizar(){
		JButton botaoNaoA = new JButton("Cancelar");
		botaoNaoA.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ação de cancelar
				
				
			}
		});
		botaoNaoA.setBounds (70, 260, 90, 30);
		return botaoNaoA;
	}
}
