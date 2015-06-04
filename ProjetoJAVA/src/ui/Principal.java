package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal {
	
	private JFrame janela;
	private JPanel panelPrincipal;

	public static void main(String[] args) {

		Principal principal = new Principal();
		principal.mostraTela();
	}

	/**
	 * Método que faz chamada aos principais componentes da minha tela.
	 */
	private void mostraTela() {
		preparaJanela();
		preparaPanel();
		mostraBotaoSair();
		mostraBotaoEscolha();
		mostraPanel();
		mostraJanela();
	}

	private void mostraBotaoEscolha() {

		JButton btnEscolha = new JButton("Anexos...");
		
		btnEscolha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser("/Userss/jefferson/Pictures/");

				int retorno = fileChooser.showOpenDialog(null);
				System.out.printf("returno = %d\n", retorno);

				if(retorno == JFileChooser.APPROVE_OPTION) {
					File arquivo  = fileChooser.getSelectedFile();
					System.out.printf("arquivo = %s", arquivo);
				} else {
//					Não selecionou arquivos nem diretórios
				}
			}
		});
		
		panelPrincipal.add(btnEscolha);
	}

	/**
	 * Método desligar o sistema.
	 */
	private void mostraBotaoSair() {
		
		JButton btnSair = new JButton("Sair");

		btnSair.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

//			JOptionPane.showMessageDialog(janela, 
//											"Saindo do sistema...",
//											"Importante",
//											JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
			}
		});
		panelPrincipal.add(btnSair);
	}

	private void mostraPanel() {
		janela.add(panelPrincipal);
	}

	private void preparaPanel() {
		panelPrincipal = new JPanel();
	}

	private void preparaJanela() {
		janela = new JFrame();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setLayout(new FlowLayout());
	}
	
	private void mostraJanela() {
		janela.setSize(540, 540);
		janela.setVisible(true);
	}
}