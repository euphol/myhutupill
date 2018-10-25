package gui.panel;

import javax.swing.JButton;

import gui.listener.RecoverListener;
import util.ColorUtil;
import util.GUIUtil;

public class RecoverPanel extends WorkingPanel {
	private static final long serialVersionUID = 1L;
	static{
		GUIUtil.useLNF();
	}
	public static RecoverPanel instance=new RecoverPanel();
	
	public JButton bRecover=new JButton("»Ö¸´");
	
	private RecoverPanel(){
		GUIUtil.setColor(ColorUtil.blueColor, bRecover);
		this.add(bRecover);
        addListener();
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(RecoverPanel.instance);
	}
	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addListener() {
		RecoverListener listener = new RecoverListener();
        bRecover.addActionListener(listener);
		
	}
}
