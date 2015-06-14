package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Guias extends JFrame{
	
	
	TelaConfima tc = new TelaConfima();
	TelaConsulta tct = new TelaConsulta();
	TelaDeletar td = new TelaDeletar();
	TelaConsultaLista tcl = new TelaConsultaLista();
	
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
	private JPanel panelHelp;
	private ImageIcon im;
	
	//Metodo para criar as Guias
	public void tabbedPane(){
		
		setTitle("URANUS v2.0");
		setSize(640, 400);
		setBackground(Color.GRAY);
		setResizable(false);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);
		
		
		//Organização das Guias
		createPageInicial();
		createPage1();
		createPage2();
		createPage3();
		createPage4();
		createPageCreditar();
		createPageDebitar();
		//createPageHelp();
		
		//Criar icone para renderizar na guia
		JLabel lbl = new JLabel();
		Icon icon = new ImageIcon(getClass().getResource("/icons/help.png")); 
		lbl.setIcon(icon);
		
		//Adicionar algum espaço entre texto e icone, e posição do texto para RHS
		lbl.setIconTextGap(5);
		lbl.setHorizontalTextPosition(SwingConstants.RIGHT);
		
		//Criar icone para renderizar na guia Cadastrar
		Icon iconCadastrar = new ImageIcon(getClass().getResource("/icons/file.png")); 
		
		//Criar icone para renderizar na guia Atualizar
		Icon iconAtualiza = new ImageIcon(getClass().getResource("/icons/find-new-users.png"));
		
		//Criar icone para renderizar na guia Creditar
		Icon iconCreditar = new ImageIcon(getClass().getResource("/icons/money_add.png"));

		//Criar icone para renderizar na guia Debitadar
		Icon iconDebita = new ImageIcon(getClass().getResource("/icons/money_delete.png"));

		//Criar icone para renderizar na guia Deletar
		Icon iconDeletar = new ImageIcon(getClass().getResource("/icons/delete.png"));
		
		//Criar icone para renderizar na guia Listar
		Icon iconListar = new ImageIcon(getClass().getResource("/icons/list.png"));
		
		//Criar icone para renderizar na guia Iniciar
		Icon iconIniciar = new ImageIcon(getClass().getResource("/icons/home.png"));
		
		//Guias
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Inicial",icon, panelInicial);	
		tabbedPane.addTab( "Cadastrar",iconCadastrar, panel1 );
		//tabbedPane.setTabComponentAt(1, lblCadastrar);
		tabbedPane.addTab( "Atualizar",iconAtualiza, panel2);
		tabbedPane.addTab( "Deletar",iconDeletar, panel3);
		tabbedPane.addTab( "Listar",iconListar, panel4);
		tabbedPane.addTab( "Creditar", iconCreditar,panelCreditar );
		tabbedPane.addTab( "Debitar", iconDebita,panelDebitar);
		tabbedPane.addTab( "",panelHelp);
		tabbedPane.setTabComponentAt(7, lbl);	
		
		//Função de ativar chamada de arquivo externo
		ChangeListener changeListener = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent changeEvent) {
				JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
				int index = sourceTabbedPane.getSelectedIndex();
				
			if(index == 7){	
				try {
						java.awt.Desktop.getDesktop().open( new File( "C:/Users/Eduardo/Desktop/Redes.txt" ));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
			}
		}
	};
		tabbedPane.addChangeListener(changeListener);
		
		topPanel.add( tabbedPane, BorderLayout.CENTER);
	}
	/*
	 * INUTILIZADO
	 */
	
	//Criar painel de Help
	private void createPageHelp(){
		panelHelp = new JPanel();
		panelHelp.setLayout(null);	
		
		//componentesTelaHelp(panelHelp);
	}
	//Componentes do painel de Help
	private void componentesTelaHelp(JPanel painel) {
		JButton b = new JButton("Help");
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			   
			}
		});
		b.setBounds(215,150,70,30);
		painel.add(b);
	}
	
	//Criar painel de Debitar
	private void createPageDebitar() {
		panelDebitar = new JPanel();
		panelDebitar.setLayout(null);
		
		componentesTelaDebitar(panelDebitar);
	}
	//Criar componentes painel Debitar
	
	private void componentesTelaDebitar(JPanel painel) {
		numeroDaConta(painel, 10, 15, 150, 20 );
		debitar(painel);
		panelDebitar.add(botaoOkDebitar());
		
	}
	//Criar painel de Creditar
	private void createPageCreditar(){
		panelCreditar = new JPanel();
		panelCreditar.setLayout(null);
		
		componentesTelaCreditar(panelCreditar);
		
	}
	//Criar componenetes painel Creditar
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
	//Criar painel Inicial
	private void createPageInicial() {
		panelInicial = new JPanel();
		panelInicial.setLayout(null);

		componentesTelaInicial(panelInicial);
		
	}
	//Componentes da tela Inicial
	private void componentesTelaInicial(JPanel painel) {
		//Boas vindas
		JLabel labelB = new JLabel("Bem Vindo!");
		labelB.setBounds(300, 10, 150, 80);
		painel.add(labelB);
		// 
		JLabel labelC = new JLabel("URANUS é um programa desenvolvido para contas bancárias.");
		labelC.setBounds(140, 80, 500, 20);
		painel.add(labelC);

		JLabel labelD = new JLabel("Desenvolvedores: ");
		labelD.setBounds(140, 180, 120, 20);
		painel.add(labelD);
	
		JLabel labelEduardo = new JLabel("- Eduardo Torres Medeiros de Araújo");
		labelEduardo.setBounds(160, 200, 250, 20);
		painel.add(labelEduardo);
	
		JLabel labelChico = new JLabel("- Francisco de Assis Alcântara Neto");
		labelChico.setBounds(160, 220, 250, 20);
		painel.add(labelChico);
		
		JLabel labelHend = new JLabel("- Henderson Aryel Alves Martins");
		labelHend.setBounds(160, 240, 250, 20);
		painel.add(labelHend);
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
		
		//Botao de CONSULTA
		JButton botaoConsulta = new JButton("Consulta");
		botaoConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tcl.telaConsultaLista();
				tcl.setVisible(true);
			}
		});
		panel4.add(botaoConsulta, FlowLayout.LEFT);
		//Campo de consulta
		JTextField campoC = new JTextField("                           ");
		panel4.add(campoC);
		//Label Conta
		JLabel label = new JLabel( "CONTAS" );
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
		panel4.add(scrollPane);
		
	}
	//Componentes das tela de CADASTRO
	public void componentesTelaCadastrar(JPanel painel){
		
		nome(painel);		
		cpf(painel,10,60,150,20);
		dataNascimento(painel);
		numeroDaConta(painel, 10, 150, 150, 20);
		
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
	public void dataNascimento(JPanel painel){
		//Data de Nascimento
		JLabel labeldataNascimento = new JLabel("Data de Nascimento: ");
		labeldataNascimento.setBounds(10, 105, 150, 20);
		painel.add(labeldataNascimento);
				
		JTextField fielddataNascimento = new JTextField();
		fielddataNascimento.setBounds(10, 125, 150, 20);
		painel.add(fielddataNascimento);	
	}
	//
	public void numeroDaConta(JPanel painel, int x, int y , int width, int height){
		//NUMERO DA CONTA 10, 105, 150, 20
		JLabel labelConta = new JLabel("Número da Conta: ");
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
		botaoAvancar.setBounds(520, 300, 100, 30);
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
		botaoAtualizar.setBounds(520, 300, 100, 30);
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
		botaoDeletar.setBounds(520, 300, 100, 30);
		return botaoDeletar;
	}
	public Component botaoOkCreditar(){
		JButton botaoOk = new JButton("Creditar");
		
		botaoOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Botão para confirmar ação de Debitar e Creditar
				JOptionPane.showMessageDialog(null, "Creditado com Sucesso!");
		
			}
		});
		botaoOk.setBounds(520, 300, 100, 30);
		return botaoOk;
	}
	public Component botaoOkDebitar(){
		JButton botaoOk = new JButton("Debitar");
		
		botaoOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Botão para confirmar ação de Debitar e Creditar
				JOptionPane.showMessageDialog(null, "Debitado com Sucesso!");
				
			}
		});
		botaoOk.setBounds(520, 300, 100, 30);
		return botaoOk;
	}
	
}
