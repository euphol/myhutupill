package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.CenterPanel;
import util.ColorUtil;
import util.GUIUtil;

public class ConfigPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	static{
		GUIUtil.useLNF();
	}
	public static ConfigPanel instance=new ConfigPanel();
	JLabel lBudget=new JLabel("����Ԥ��");
	public JTextField tfBudget=new JTextField("0");
	JLabel lMysql=new JLabel("Mysql��װĿ¼");
	public JTextField tfMysqlPath=new JTextField("");
	
	JButton bSubmit=new JButton("����");
	
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
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(ConfigPanel.instance);
	}
}