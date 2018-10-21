package gui.panel;

import javax.swing.JButton;

import util.CenterPanel;
import util.ColorUtil;
import util.GUIUtil;

public class RecoverPanel extends CenterPanel {
	private static final long serialVersionUID = 1L;
	static{
		GUIUtil.useLNF();
	}
	public static RecoverPanel instance=new RecoverPanel(0.2);
	
	public JButton bRecover=new JButton("»Ö¸´");
	
	private RecoverPanel(double rate){
		super(rate);
		GUIUtil.setColor(ColorUtil.blueColor, bRecover);
		this.show(bRecover);
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(RecoverPanel.instance);
	}
}
