package util;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * GUI工具类
 * 将重复使用的功能抽象到工具类里
 * 在使用时可以直接调用
 * 
 * 节约开发时间，提升效率，降低维护成本，使代码看上去更简洁，提高可读性
 *
*/
public class GUIUtil {
	private static String imageFolder="g:/project/myhutubill/img";
	//设置Button的图标以及提示文字
	public static void setImageIcon(JButton b,String fileName,String tip){
		ImageIcon i=new ImageIcon(new File(imageFolder,fileName).getAbsolutePath());
		b.setIcon(i);
		b.setPreferredSize(new Dimension(61,81));
		b.setToolTipText(tip);
		b.setVerticalTextPosition(JButton.BOTTOM);
		b.setHorizontalTextPosition(JButton.CENTER);
		b.setText(tip);
	}	
	//校验一个输入框是否为空
	public static boolean checkEmpty(JTextField tf,String input){
		String text=tf.getText().trim();
		if(text.length()==0){
			JOptionPane.showMessageDialog(null, input+" 不能为空");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	//校验输入框内容是否为数字格式
	public static boolean checkNumber(JTextField tf,String input){
		if(!checkEmpty(tf, input))
			return false;
		String text=tf.getText().trim();
		try{
			Integer.parseInt(text);
			return true;
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, input+" 必须为整数");
			return false;
		}
	}
	//校验输入框内容是否为0
	public static boolean checkZero(JTextField tf,String input){
		if(!checkNumber(tf, input))
			return false;
		String text=tf.getText().trim();
		if(0==Integer.parseInt(text)){
			JOptionPane.showMessageDialog(null, input+" 不能为0");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	//给多个组件设置前置色
	public static void setColor(Color color,JComponent...cs){
		for(JComponent each:cs){
			each.setForeground(color);
		}
	}
	//使用水晶皮肤
	public static void useLNF(){
		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//显示面板内容
	public static void showPanel(JPanel p,double rate){
		GUIUtil.useLNF();
		JFrame f=new JFrame();
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		CenterPanel cp=new CenterPanel(rate);
		f.setContentPane(cp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		cp.show(p);
	}
	//CenterPanel的缺省拉伸参数为0.85
	public static void showPanel(JPanel p){
		showPanel(p,0.85);
	}
	
}
