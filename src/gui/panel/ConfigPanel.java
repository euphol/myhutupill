package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.listener.ConfigListener;
import util.CenterPanel;
import util.ColorUtil;
import util.GUIUtil;

public class ConfigPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	static{
		GUIUtil.useLNF();
	}
	public static ConfigPanel instance=new ConfigPanel();
	JLabel lBudget=new JLabel("本月预算");
	public JTextField tfBudget=new JTextField("0");
	JLabel lMysql=new JLabel("Mysql安装目录");
	public JTextField tfMysqlPath=new JTextField("");
	
	JButton bSubmit=new JButton("更新");
	
	public ConfigPanel(){
		GUIUtil.setColor(ColorUtil.grayColor,lBudget,lMysql);
		GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
		
		JPanel pInput=new JPanel();
		CenterPanel pSubmit=new CenterPanel(0.3);
		int gap=40;
		pInput.setLayout(new GridLayout(4, 1,gap,gap));
		
		pInput.add(lBudget);
		pInput.add(tfBudget);
		pInput.add(lMysql);
		pInput.add(tfMysqlPath);
		this.setLayout(new BorderLayout());
		this.add(pInput,BorderLayout.NORTH);
		
		pSubmit.show(bSubmit);
		this.add(pSubmit, BorderLayout.CENTER);
		
		addListener();
	}
	private void addListener() {
		ConfigListener l=new ConfigListener();
		bSubmit.addActionListener(l);
		
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(ConfigPanel.instance);
	}
}
