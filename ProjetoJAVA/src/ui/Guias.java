package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageProducer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Guias extends JFrame{
	
	TelaConfima tc = new TelaConfima();
	TelaConsulta tct = new TelaConsulta();
	TelaDeletar td = new TelaDeletar();
	
	private JTable table;
	private JScrollPane scrollPane;
	
	private JTabbedPane	tabbedPane;
	private JPanel panelCreditar;
	private JPanel panelDebitar;
	private JPanel panelInicial;
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
		
		createPageInicial();
		createPage1();
		createPage2();
		createPage3();
		createPage4();
		createPageCreditar();
		createPageDebitar();
		
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Inicial", panelInicial);
		tabbedPane.addTab( "Cadastrar", panel1);
		tabbedPane.addTab( "Atualizar", panel2);
		tabbedPane.addTab( "Deletar", panel3);
		tabbedPane.addTab( "Listar", panel4);
		tabbedPane.addTab( "Creditar",panelCreditar );
		tabbedPane.addTab( "Debitar", panelDebitar );
		topPanel.add( tabbedPane, BorderLayout.CENTER);
	}
	private void createPageDebitar() {
		panelDebitar = new JPanel();
		panelDebitar.setLayout(null);
		
		componentesTelaDebitar(panelDebitar);
	}
	private void componentesTelaDebitar(JPanel painel) {
		numeroDaConta(painel, 10, 15, 150, 20 );
		debitar(painel);
		panelDebitar.add(botaoOkDebitar());
		
	}
	private void createPageCreditar(){
		panelCreditar = new JPanel();
		panelCreditar.setLayout(null);
		
		componentesTelaCreditar(panelCreditar);
		
	}
private void componentesTelaCreditar(JPanel painel) {
		numeroDaConta(painel, 10, 15, 150, 20 );
		creditar(painel);
		panelCreditar.add(botaoOkCreditar());
	}
	//	public void startProduction(ImageConsumer ic){
//		  ImageProducer ip = getRealSource();
//		  if (ip == null) {
//		    ic.setDimensions(1,1);
//		    ic.imageComplete(ImageConsumer.SINGLEFRAMEDONE);
//		  }
//		 else {
//		    ip.startProduction(ic);
//		  }
//		}
//	public void getRealSource(){
//		
//	}
	private void createPageInicial() {
		panelInicial = new JPanel();
		panelInicial.setLayout(null);
		
		ImageProducer producer;
		//CHAMAR URL DE IMAGEM PARA BACKGROUND
//		panelInicial.createImage(producer);
		
	}
	//Painel de Cadastrar
	public void createPage1()
	{
		panel1 = new JPanel();
		panel1.setLayout( null );

		componentesTelaCadastrar(panel1);
	}
	//Painel de Atualizar
	public void createPage2()
	{
		panel2 = new JPanel();
		panel2.setLayout(null);
		
		componentesTelaAtualizar(panel2);
	}
	//Painel de Deletar
	public void createPage3()
	{
		panel3 = new JPanel();
		panel3.setLayout(null);

		componentesTelaDeletar(panel3);
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
		
		JButton botaoConsulta = new JButton("Consulta");
		botaoConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tct.telaConsultaAtualiza();
				tct.setVisible(true);
			}
		});
		panel4.add(botaoConsulta);
		//	Cria novas tabelas
		table = new JTable(dataValues, columnNames);
		
		//Adiciona a tabela para uma tela scrolling
		scrollPane = new JScrollPane(table);
		panel4.add(scrollPane, BorderLayout.CENTER);
		
	}
	//Componentes das tela de CADASTRO
	public void componentesTelaCadastrar(JPanel painel){
		
		nome(painel);		
		cpf(painel,10,60,150,20);
		numeroDaConta(painel, 10, 105, 150, 20);
		saldo(painel);
		
		//BOTAO AVANCAR
		painel.add(botaoCadastrar());
	}
	//Componenetes da tela de ATUALIZAR
	public void componentesTelaAtualizar(JPanel painel){
		cpf(painel,10,15,150,20);
		painel.add(botaoAtualizar());
	}
	//Componentes da tela de DELETAR
	public void componentesTelaDeletar(JPanel painel){
		cpf(painel,10,15,150,20);
		painel.add(botaoDeletar());
	}
	//Componentes da tela de DEBITAR
	public void componenetesTelaDebitar(JPanel painel){
		
	}
	//Componenetes da tela de CREDITAR
	public void componenetesTelaCreditar(JPanel painel){
		
	}
	public void creditar(JPanel painel){
		//CREDITAR
		JLabel labelCreditar = new JLabel("Valor Creditar: ");
		labelCreditar.setBounds(10, 60, 150, 20);
		painel.add(labelCreditar);
				
		JTextField fieldCreditar = new JTextField();
		fieldCreditar.setBounds( 10, 80, 150, 20);
		painel.add(fieldCreditar);
	}
	public void debitar(JPanel painel){
		//DEBITAR
		JLabel labelDebitar = new JLabel("Valor Debitar: ");
		labelDebitar.setBounds(10, 60, 150, 20);
		painel.add(labelDebitar);
				
		JTextField fieldDebitar = new JTextField();
		fieldDebitar.setBounds( 10, 80, 150, 20);
		painel.add(fieldDebitar);
	}
	public void saldo(JPanel painel){
		//SALDO INICIAL
		JLabel labelSaldo = new JLabel("Saldo Inicial: ");
		labelSaldo.setBounds(10, 150, 150, 20);
		painel.add(labelSaldo);
				
		JTextField fieldSaldo = new JTextField();
		fieldSaldo.setBounds( 10, 170, 150, 20);
		painel.add(fieldSaldo);	
	}
	//
	public void numeroDaConta(JPanel painel, int x, int y , int width, int height){
		//NUMERO DA CONTA 10, 105, 150, 20
		JLabel labelConta = new JLabel("Numero da Conta: ");
		labelConta.setBounds(x, y, width, height);
		painel.add(labelConta);
		
		JTextField fieldConta = new JTextField();
		fieldConta.setBounds( x, y+20, width, height);
		painel.add(fieldConta);
				
	}
	//
	public void cpf(JPanel painel,int x, int y, int width, int heigth){
		//CPF x=10, y=60, width=150, heigth=20;
		JLabel label2 = new JLabel( "CPF:" );
		label2.setBounds( x, y, width, heigth );
		painel.add( label2 );

		JTextField fieldCPF = new JTextField();
		fieldCPF.setBounds( x, y+20, width, heigth );
		painel.add( fieldCPF );	
	}
	//
	public void nome(JPanel painel){
		//NOME
		JLabel label1 = new JLabel( "Nome:" );
		label1.setBounds( 10, 15, 150, 20 );
		painel.add( label1 );
		//Campo de NOME
		JTextField fieldNome = new JTextField();
		fieldNome.setBounds( 10, 35, 150, 20 );
		painel.add( fieldNome );
	}
	//Botao de Avançar para seguir a tela de Confirmação
	public Component botaoCadastrar(){
		JButton botaoAvancar = new JButton("Cadastrar");
		
		botaoAvancar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//GATILHO PARA NOVA JANELA DE CONFIRMAÇÃO DE AÇÃO
				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
			}
		});
		botaoAvancar.setBounds(380, 300, 85, 30);
		return botaoAvancar;
		
	}
	//Botao de Atualizar os componentes no BD. Tela de Atualizar
	public Component botaoAtualizar(){
		JButton botaoAtualizar = new JButton("Atualizar");
		
		botaoAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ação de atualizar dados apartir de CPF
				tct.telaConsultaAtualiza();
				tct.setVisible(true);
			}
		});
		botaoAtualizar.setBounds(380, 300, 85, 30);
		return botaoAtualizar;
	}
	//Botao de Deletar os componentes do BD. Tela de Deletar
	public Component botaoDeletar(){
		JButton botaoDeletar = new JButton("Deletar");
		
		botaoDeletar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Chamada do metodo de tela com botoes de confirmar e cancelar
				td.telaConsultaDeletar();
				td.setVisible(true);
			}
		});
		botaoDeletar.setBounds(380, 300, 85, 30);
		return botaoDeletar;
	}
	public Component botaoOkCreditar(){
		JButton botaoOk = new JButton("Ok");
		
		botaoOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Botão para confirmar ação de Debitar e Creditar
				JOptionPane.showMessageDialog(null, "Creditado com Sucesso!");
		
			}
		});
		botaoOk.setBounds(380, 300, 85, 30);
		return botaoOk;
	}
	public Component botaoOkDebitar(){
		JButton botaoOk = new JButton("Ok");
		
		botaoOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Botão para confirmar ação de Debitar e Creditar
				JOptionPane.showMessageDialog(null, "Debitado com Sucesso!");
				
			}
		});
		botaoOk.setBounds(380, 300, 85, 30);
		return botaoOk;
	}
	
}
