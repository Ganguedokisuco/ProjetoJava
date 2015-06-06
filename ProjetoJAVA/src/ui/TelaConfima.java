package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class TelaConfima extends JFrame{
	
		private JPanel panelConfirma ;
		private JFrame janela;
		
		//Tela de Confirma��o
		public void telaConfirma(){
			
			setTitle("Confirma��o");
			setSize(300, 200);
			setBackground(Color.GRAY);
			
			JPanel panelTela = new JPanel();
			panelTela.setLayout(new BorderLayout());
			getContentPane().add(panelTela);
			
			painelConfirma();
			
			panelTela.add(panelConfirma, BorderLayout.CENTER);
			
		}
		//Tela de Confirma��o
		public void painelConfirma(){
			panelConfirma = new JPanel();
			panelConfirma.setLayout(null);
			
			//LABEL CONFIRMA��O
			JLabel labelConfirma = new JLabel("Deseja Continuar? ");
			labelConfirma.setBounds( 90, 15, 150, 20 );
			panelConfirma.add(labelConfirma);
			
			botaoCancelar();
			botaoConfirmar();
			
			panelConfirma.add(botaoCancelar());
			panelConfirma.add(botaoConfirmar());
						
		}
		//Botao de Cancelar da tela de Confirma��o
		public Component botaoCancelar(){
			JButton botaoCancel = new JButton("Cancelar");
			
			botaoCancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				//FECHAR JANELA DE CONFIRMA��O	
					
				}
			});
			botaoCancel.setBounds(50, 100, 85, 30);
			return panelConfirma.add(botaoCancel);	
		}
		//Botao de Confirma��o da tela de Confirma��o
		public Component botaoConfirmar(){
			
			JButton botaoConfirma = new JButton("OK");
			
			botaoConfirma.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// FECHAR JANELA DE CONFIRMA��O E MOSTRAR UM JOPTIONPANE COM MENSAGEM DE SUCESSO
					JOptionPane.showMessageDialog(null,"Cadastro realizado com Sucesso!!");
				}
			});
			botaoConfirma.setBounds(150, 100, 85, 30);
			return panelConfirma.add(botaoConfirma);
		}	
}
