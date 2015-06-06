package ui;

public class GuiMain {

	
	public static void main(String[] args) {
		
		Guias mainFrame = new Guias();//Instancia das Guias
		mainFrame.tabbedPane();//Chamada do metodo de criação das guias
		mainFrame.setVisible(true);
	}
	
}
