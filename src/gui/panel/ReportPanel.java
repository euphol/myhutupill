package gui.panel;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entity.Record;
import service.ReportService;
import util.ChartUtil;
import util.GUIUtil;

public class ReportPanel extends WorkingPanel {

	private static final long serialVersionUID = 1L;
	static{
		GUIUtil.useLNF();
	}
	public static ReportPanel instance=new ReportPanel();
	
	public JLabel l=new JLabel();
	
	private ReportPanel(){
		this.setLayout(new BorderLayout());
		List<Record> rs=new ReportService().listThisMonthRecords();
		Image i=ChartUtil.getImage(rs,400, 300);
		ImageIcon icon=new ImageIcon(i);
		l.setIcon(icon);
		this.add(l);
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(ReportPanel.instance);
	}
	@Override
	public void updateData() {
		List<Record> rs=new ReportService().listThisMonthRecords();
		Image i=ChartUtil.getImage(rs,400, 300);
		ImageIcon icon=new ImageIcon(i);
		l.setIcon(icon);
		
	}
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}
}
