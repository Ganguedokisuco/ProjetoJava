package ui;

import java.awt.event.WindowEvent;

public class GuiMain {

	public static void main(String[] args) {
		ImagemPainel imp = new ImagemPainel();
		imp.setLocationRelativeTo(null);
		imp.setVisible(true);
		int x=0;
		
		if(imp.isVisible()){
			try{	
				while(x!=3000)
					x++;
				Thread.sleep(x);
				if(x==3000){
					Guias mainFrame = new Guias();//Instancia das Guias
					mainFrame.tabbedPane();//Chamada do metodo de criação das guias
					imp.dispatchEvent(new WindowEvent(imp, WindowEvent.WINDOW_CLOSING));
					mainFrame.setLocationRelativeTo(null);
					mainFrame.setVisible(true);
				}
			}catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
		}
		
	}
	
}
