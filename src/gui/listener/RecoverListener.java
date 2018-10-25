package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import gui.panel.RecoverPanel;
import service.ConfigService;
import util.MysqlUtil;

public class RecoverListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		RecoverPanel p=RecoverPanel.instance;
		String mysqlPath=new ConfigService().get(ConfigService.mysqlPath);
		if(mysqlPath==null||mysqlPath.isEmpty()){
			JOptionPane.showMessageDialog(p, "«Î≈‰÷√mysql¬∑æ∂");
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
		int returnVal=fc.showOpenDialog(p);
		File file=fc.getSelectedFile();
		if(returnVal == JFileChooser.APPROVE_OPTION){
			if(!file.getName().toLowerCase().endsWith(".sql"))
                file = new File(file.getParent(),file.getName()+".sql");
			try{
				MysqlUtil.recover(mysqlPath, file.getAbsolutePath());
				JOptionPane.showMessageDialog(p, "ª÷∏¥≥…π¶");
			}catch(Exception e1){
				e1.printStackTrace();
				JOptionPane.showMessageDialog(p, "ª÷∏¥ ß∞‹\r\n,¥ÌŒÛ:\r\n"+e1.getMessage());
			}
		}
				

	}

}
