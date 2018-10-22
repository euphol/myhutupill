package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

public class CategoryListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		CategoryPanel p=CategoryPanel.instance;
		JButton b=(JButton)e.getSource();
		if(b==p.bAdd){
			String name=JOptionPane.showInputDialog("输入分类名").trim();
			if(name.isEmpty()){
				JOptionPane.showMessageDialog(p, "分类名不能为空");
				return;
			}
			new CategoryService().add(name);
		}
		if(b==p.bDelete){
			Category c=p.getSelectedCategory();
			if(c==null){
				JOptionPane.showMessageDialog(p, "请选择一条分类");
				return;
			}
			if(0!=c.getRecordNumber()){
				JOptionPane.showMessageDialog(p, "本分类下有消费记录存在，不能删除");
				return;
			}
			if(JOptionPane.OK_OPTION!=JOptionPane.showConfirmDialog(p, "确认删除？"))
				return;
			int id=c.getId();
			new CategoryService().delete(id);
		}
		if(b==p.bEdit){
			Category c=p.getSelectedCategory();
			int id=c.getId();
			String name=JOptionPane.showInputDialog("修改分类名",c.getName()).trim();
			if(name.isEmpty()){
				JOptionPane.showMessageDialog(p, "分类名不能为空");
				return;
			}
			new CategoryService().update(id, name);
		}
		p.updateData();
	}

}
