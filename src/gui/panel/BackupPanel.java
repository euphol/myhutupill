package gui.panel;

import javax.swing.JButton;

import gui.listener.BackupListener;
import util.CenterPanel;
import util.ColorUtil;
import util.GUIUtil;

public class BackupPanel extends WorkingPanel {

	private static final long serialVersionUID = 1L;
	static{
		GUIUtil.useLNF();
	}
	public static BackupPanel instance=new BackupPanel();
	
	public JButton bBackup=new JButton("±¸·Ý");
	
	private BackupPanel(){
		GUIUtil.setColor(ColorUtil.blueColor, bBackup);
		this.add(bBackup);
        addListener();
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(BackupPanel.instance);
	}
	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		BackupListener listener = new BackupListener();
        bBackup.addActionListener(listener);
		
	}
	
}
