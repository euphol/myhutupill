package gui.panel;

import javax.swing.JButton;

import util.CenterPanel;
import util.ColorUtil;
import util.GUIUtil;

public class BackupPanel extends CenterPanel {

	private static final long serialVersionUID = 1L;
	static{
		GUIUtil.useLNF();
	}
	public static BackupPanel instance=new BackupPanel(0.2);
	
	public JButton bBackup=new JButton("±¸·Ý");
	
	private BackupPanel(double rate){
		super(rate);
		GUIUtil.setColor(ColorUtil.blueColor, bBackup);
		this.show(bBackup);
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(BackupPanel.instance);
	}
	
}
