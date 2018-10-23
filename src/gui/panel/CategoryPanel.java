package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import entity.Category;
import gui.listener.CategoryListener;
import gui.model.CategoryTableModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

public class CategoryPanel extends WorkingPanel {

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
		t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane sp=new JScrollPane(t);
		JPanel pSubmit=new JPanel();
		pSubmit.add(bAdd);
		pSubmit.add(bEdit);
		pSubmit.add(bDelete);
		
		this.setLayout(new BorderLayout());
		this.add(sp, BorderLayout.CENTER);
		this.add(pSubmit, BorderLayout.SOUTH);
		addListener();
	}
	public void addListener() {
		CategoryListener l=new CategoryListener();
		bAdd.addActionListener(l);
		bEdit.addActionListener(l);
		bDelete.addActionListener(l);
		
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(CategoryPanel.instance);
	}
	public Category getSelectedCategory(){
		Category category=null;
		int index=t.getSelectedRow();
		if(index!=-1)
			category=ctm.cs.get(index);
		return category;
	}
	public void updateData(){
		ctm.cs=new CategoryService().list();
		t.updateUI();
		t.getSelectionModel().setSelectionInterval(0,0);
		if(0==ctm.cs.size()){
			bEdit.setEnabled(false);
			bDelete.setEnabled(false);
		}else{
			bEdit.setEnabled(true);
			bDelete.setEnabled(true);
		}
		
	}
}
