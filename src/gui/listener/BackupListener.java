package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import gui.panel.BackupPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import service.ConfigService;
import util.MysqlUtil;

public class BackupListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		BackupPanel p=BackupPanel.instance;
		String mysqlPath=new ConfigService().get(ConfigService.mysqlPath);
		if(mysqlPath==null||mysqlPath.isEmpty()){
			JOptionPane.showMessageDialog(p, "请配置mysql路径");
			MainPanel.instance.workingPanel.show(ConfigPanel.instance);
			ConfigPanel.instance.tfMysqlPath.grabFocus();
			return;
		}
		JFileChooser fc=new JFileChooser();
		fc.setSelectedFile(new File("myhutubill.sql"));
		fc.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return ".sql";
			}
			
			@Override
			public boolean accept(File f) {
				if(f.isDirectory())
					return true;
				return f.getName().toLowerCase().endsWith(".sql");
			}
		});
		int returnVal=fc.showSaveDialog(p);
		File file=fc.getSelectedFile();
		if(returnVal==JFileChooser.APPROVE_OPTION){
			if(!file.getName().toLowerCase().endsWith(".sql"))
				file=new File(file.getParent(),file.getName()+".sql");
			try {
				MysqlUtil.backup(mysqlPath, file.getAbsolutePath());
				JOptionPane.showMessageDialog(p, "备份成功，备份文件位于：\r\n"+file.getAbsolutePath());
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(p, "备份失败\r\n，错误：\r\n"+e1.getMessage());
			}
		}
	}

}
