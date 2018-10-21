package gui.frame;

import javax.swing.JFrame;

import gui.panel.MainPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public static MainFrame instance=new MainFrame();
	
	private MainFrame(){
		this.setSize(500,540);
		this.setTitle("’À±æ");
		this.setContentPane(MainPanel.instance);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		instance.setVisible(true);
	}

}
