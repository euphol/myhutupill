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
			String name=JOptionPane.showInputDialog("���������").trim();
			if(name.isEmpty()){
				JOptionPane.showMessageDialog(p, "����������Ϊ��");
				return;
			}
			new CategoryService().add(name);
		}
		if(b==p.bDelete){
			Category c=p.getSelectedCategory();
			if(c==null){
				JOptionPane.showMessageDialog(p, "��ѡ��һ������");
				return;
			}
			if(0!=c.getRecordNumber()){
				JOptionPane.showMessageDialog(p, "�������������Ѽ�¼���ڣ�����ɾ��");
				return;
			}
			if(JOptionPane.OK_OPTION!=JOptionPane.showConfirmDialog(p, "ȷ��ɾ����"))
				return;
			int id=c.getId();
			new CategoryService().delete(id);
		}
		if(b==p.bEdit){
			Category c=p.getSelectedCategory();
			int id=c.getId();
			String name=JOptionPane.showInputDialog("�޸ķ�����",c.getName()).trim();
			if(name.isEmpty()){
				JOptionPane.showMessageDialog(p, "����������Ϊ��");
				return;
			}
			new CategoryService().update(id, name);
		}
		p.updateData();
	}

}
