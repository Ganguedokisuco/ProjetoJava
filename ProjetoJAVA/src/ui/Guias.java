package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import dado.NegociosTabelModel;
import fachada.Conta;

public class Guias extends JFrame{
	
	TelaConfima tc = new TelaConfima();
	
	private JTable table;
	private JScrollPane scrollPane;
	
	private JTabbedPane	tabbedPane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	
	//Metodo para criar as Guias
	public void tabbedPane(){
		
		setTitle("Banco do Brasil");
		setSize(500, 400);
		setBackground(Color.GRAY);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);
		
		createPage1();
		createPage2();
		createPage3();
		createPage4();
		
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab( "Cadastrar", panel1);
		tabbedPane.addTab( "Atualizar", panel2);
		tabbedPane.addTab( "Deletar", panel3);
		tabbedPane.addTab( "Listar", panel4);
		topPanel.add( tabbedPane, BorderLayout.CENTER);
	}
	//Painel de Cadastrar
	public void createPage1()
	{
		panel1 = new JPanel();
		panel1.setLayout( null );

		componentesTela(panel1);
	}
	//Painel de Atualizar
	public void createPage2()
	{
		panel2 = new JPanel();
		panel2.setLayout(null);
		
		componentesTela(panel2);
	}
	//Painel de Deletar
	public void createPage3()
	{
		panel3 = new JPanel();
		panel3.setLayout(null);

		componentesTela(panel3);
	}
	//Painel de Listar
	public void createPage4(){
		panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		
		//Label Conta
		JLabel label = new JLabel( "CONTAS" );
		label.setBounds( 10, 15, 150, 20 );
		panel4.add( label );
		
		//INSTANCIA DA CLASSE PARA CRIAR TABLE
		//Cria os nomes das colunas
		String columnNames[] = { "Nome", "CPF", "Numero da Conta"};
		
		//Cria alguns valores
		String dataValues[][] =
		{
				{"Henderson", "123456789", "14BC10" },
				{"Chico", "987654321", "12AB34" },
				{"Bill", "192837465", "09WZ81" }
		};
		
		//	Cria novas tabelas
		table = new JTable(dataValues, columnNames);
		
		//Adiciona a tabela para uma tela scrolling
		scrollPane = new JScrollPane(table);
		panel4.add(scrollPane, BorderLayout.CENTER);
		
	}
	//Componentes das telas Principais
	public void componentesTela(JPanel painel){
		//NOME
		JLabel label1 = new JLabel( "Nome:" );
		label1.setBounds( 10, 15, 150, 20 );
		painel.add( label1 );

		JTextField fieldNome = new JTextField();
		fieldNome.setBounds( 10, 35, 150, 20 );
		painel.add( fieldNome );
		
		
		//CPF
		JLabel label2 = new JLabel( "CPF:" );
		label2.setBounds( 10, 60, 150, 20 );
		painel.add( label2 );

		JTextField fieldCPF = new JTextField();
		fieldCPF.setBounds( 10, 80, 150, 20 );
		painel.add( fieldCPF );
		
		//NUMERO DA CONTA
		JLabel labelConta = new JLabel("Numero da Conta: ");
		labelConta.setBounds(10, 105, 150, 20);
		painel.add(labelConta);
		
		JTextField fieldConta = new JTextField();
		fieldConta.setBounds( 10, 125, 150, 20);
		painel.add(fieldConta);
		
		//SALDO INICIAL
		JLabel labelSaldo = new JLabel("Saldo Inicial: ");
		labelSaldo.setBounds(10, 150, 150, 20);
		painel.add(labelSaldo);
				
		JTextField fieldSaldo = new JTextField();
		fieldSaldo.setBounds( 10, 170, 150, 20);
		painel.add(fieldSaldo);		
		
		//BOTAO AVANCAR
		painel.add(BotaoAvancar());
	}
	//Botao de Avançar para seguir a tela de Confirmação
	public Component BotaoAvancar(){
		JButton botaoAvancar = new JButton("Avançar");
		
		botaoAvancar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//GATILHO PARA NOVA JANELA DE CONFIRMAÇÃO DE AÇÃO
				tc.telaConfirma();
				tc.setVisible(true);
			}
		});
		botaoAvancar.setBounds(380, 300, 85, 30);
		return botaoAvancar;
		
	}
	
}
