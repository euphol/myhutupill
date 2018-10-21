package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.model.CategoryTableModel;
import util.ColorUtil;
import util.GUIUtil;

public class CategoryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	static{
		GUIUtil.useLNF();
	}
	public static CategoryPanel instance=new CategoryPanel();
	
	public JButton bAdd=new JButton("ÐÂÔö");
	public JButton bEdit=new JButton("±à¼­");
	public JButton bDelete=new JButton("É¾³ý");
	
	public CategoryTableModel ctm=new CategoryTableModel();
	public JTable t=new JTable(ctm);
	
	private CategoryPanel(){
		GUIUtil.setColor(ColorUtil.blueColor, bAdd,bEdit,bDelete);
		JScrollPane sp=new JScrollPane(t);
		JPanel pSubmit=new JPanel();
		pSubmit.add(bAdd);
		pSubmit.add(bEdit);
		pSubmit.add(bDelete);
		
		this.setLayout(new BorderLayout());
		this.add(sp, BorderLayout.CENTER);
		this.add(pSubmit, BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(CategoryPanel.instance);
	}
}
