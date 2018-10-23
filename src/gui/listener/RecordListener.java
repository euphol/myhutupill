package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.SpendPanel;
import service.RecordService;
import util.GUIUtil;

public class RecordListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		RecordPanel p=RecordPanel.instance;
		if(0==p.cbModel.cs.size()){
			JOptionPane.showMessageDialog(p, "暂无消费分类，无法添加");
			MainPanel.instance.workingPanel.show(CategoryPanel.instance);
			return;
		}
		if(!GUIUtil.checkZero(p.tfSpend, "消费金额"))
			return;
		int spend=Integer.parseInt(p.tfSpend.getText());
		Category c=p.getSelectedCategory();
		String comment=p.tfComment.getText();
		Date date=p.datepick.getDate();
		new RecordService().add(spend, c, comment, date);
		JOptionPane.showMessageDialog(p, "添加成功");
		
		MainPanel.instance.workingPanel.show(SpendPanel.instance);
	}

}
