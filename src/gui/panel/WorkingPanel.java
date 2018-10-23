package gui.panel;

import javax.swing.JPanel;

public abstract class WorkingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public abstract void updateData();
	public abstract void addListener();

}
