package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.time.chrono.JapaneseDate;

import javax.swing.*;
import javax.swing.plaf.PanelUI;

public class TelaConsultaLista extends JFrame{
		
	private JPanel panelConsultaA;
	protected JFrame tcl;

	public void frameMain(JPanel painel){
		setSize(350, 270);
		setBackground(Color.GRAY);
		getContentPane().add(painel);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	//Tela de Consulta de Atualização
	public void telaConsultaLista(){
		
		setTitle("Consulta");
		
		JPanel panelTela = new JPanel();
		panelTela.setLayout(new BorderLayout());
		frameMain(panelTela);
		
		//Painel de Atualizar
		
		panelConsultaListar(panelConsultaA);
		
		panelTela.add(panelConsultaA, BorderLayout.CENTER);
		panelTela.setVisible(true);
	}
	
	//Painel para tela de Atualizar
	public void panelConsultaListar(JPanel painel){
		
		panelConsultaA = new JPanel();
		panelConsultaA.setLayout(null);	
		//Componentes pertencentes ao painel de atualizar
		nome(panelConsultaA);
		numeroConta(panelConsultaA);
		saldo(panelConsultaA);
		dataDeNascimento(panelConsultaA);
		dataUltimoAcesso(panelConsultaA);

		//Botoes
		panelConsultaA.add(botaoVoltar());
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
		labelDataNasc.setBounds( 10, 105, 150, 20 );
		painel.add(labelDataNasc);
		//CAMPO DATA DE NASCIMENTO
		JTextField fieldDataNasc = new JTextField();
		fieldDataNasc.setBounds( 150, 105, 150, 20 );
		
		painel.add( fieldDataNasc );
	}
	//DATA DE ULTIMO ACESSO
	public void dataUltimoAcesso(JPanel painel){
		//LABEL DATA DE ULTIMO ACESSO
		JLabel labelDataAcesso = new JLabel("Data do ultimo acesso: ");
		labelDataAcesso.setBounds( 10, 135, 150, 20 );
		painel.add(labelDataAcesso);
		//CAMPO DATA DE NASCIMENTO
		JTextField fieldDataAcesso = new JTextField();
		fieldDataAcesso.setBounds( 150, 135, 150, 20 );
	
		painel.add( fieldDataAcesso );
	}
	//BOTOES
	public Component botaoVoltar(){
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Voltar para pagina inicial
				tcl = new JFrame();
				dispatchEvent(new WindowEvent(tcl, WindowEvent.WINDOW_CLOSING));
			}
		});
		botaoVoltar.setBounds(130, 180, 75, 30);
		return botaoVoltar;
	}	
}
