package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import gui.model.CategoryComboBoxModel;
import util.CenterPanel;
import util.ColorUtil;
import util.GUIUtil;

public class RecordPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	static{
		GUIUtil.useLNF();
	}
	public static RecordPanel instance=new RecordPanel();
	
	JLabel lSpend=new JLabel("花费(¥)");
	JLabel lCategory=new JLabel("分类");
	JLabel lComment=new JLabel("备注");
	JLabel lDate=new JLabel("日期");
	//声明为public便于其他类调用
	public JTextField tfSpend=new JTextField("0");
	public CategoryComboBoxModel cbModel=new CategoryComboBoxModel();
	public JComboBox<String> cbCategory=new JComboBox<>(cbModel);
	public JTextField tfComment=new JTextField();
	public JXDatePicker datepick=new JXDatePicker(new Date());
	JButton bSubmit=new JButton("记一笔");
	//重写构造函数实现初始化
	private RecordPanel(){
		GUIUtil.setColor(ColorUtil.grayColor, lSpend,lCategory,lComment,lDate);
		GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
		JPanel pInput=new JPanel();
		CenterPanel pSubmit=new CenterPanel(0.3);
		int gap=40;
		pInput.setLayout(new GridLayout(4,2,gap,gap));
		pInput.add(lSpend);
		pInput.add(tfSpend);
		pInput.add(lCategory);
		pInput.add(cbCategory);
		pInput.add(lComment);
		pInput.add(tfComment);
		pInput.add(lDate);
		pInput.add(datepick);
		
		pSubmit.show(bSubmit);
		
		this.setLayout(new BorderLayout());
		this.add(pInput,BorderLayout.NORTH);
		this.add(pSubmit, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(RecordPanel.instance);
	}
	

}
