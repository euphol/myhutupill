package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import util.CenterPanel;
import util.GUIUtil;

public class MainPanel extends JPanel {
	/**
	 * 单例模式的主面板
	 */
	private static final long serialVersionUID = 1L;

	//皮肤设置必须放在第一句，为了在本单例模式的主面板实例化时
	//就设置皮肤，固将皮肤设置声明为静态
	static{
		GUIUtil.useLNF();
	}
	//单例模式，静态属性指向实例，并在初始化时将其构造
	public static MainPanel instance=new MainPanel();
	//public组件便于其他类获取
	public JToolBar tb=new JToolBar();
	public JButton bSpend=new JButton();
	public JButton bRecord=new JButton();
	public JButton bCategory=new JButton();
	public JButton bReport=new JButton();
	public JButton bConfig=new JButton();
	public JButton bBackup=new JButton();
	public JButton bRecover=new JButton();
	//居中的工作面板来显示不同功能
	public CenterPanel workingPanel;
	
	//单例模式，构造方法私有化
	private MainPanel(){
		GUIUtil.setImageIcon(bSpend, "home.png", "消费一览");
		GUIUtil.setImageIcon(bRecord, "record.png", "记一笔");
		GUIUtil.setImageIcon(bCategory, "category2.png", "消费分类");
		GUIUtil.setImageIcon(bReport, "report.png", "月消费报表");
		GUIUtil.setImageIcon(bConfig, "config.png", "设置");
		GUIUtil.setImageIcon(bBackup, "backup.png", "备份");
		GUIUtil.setImageIcon(bRecover, "restore.png", "恢复");
		
		tb.add(bSpend);
		tb.add(bRecord);
		tb.add(bCategory);
		tb.add(bReport);
		tb.add(bConfig);
		tb.add(bBackup);
		tb.add(bRecover);
		
		tb.setFloatable(false);
		workingPanel=new CenterPanel(0.8);
		setLayout(new BorderLayout());
		add(tb,BorderLayout.NORTH);
		add(workingPanel,BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(MainPanel.instance, 1);
	}
	
	

}
