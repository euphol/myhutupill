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
 * GUI������
 * ���ظ�ʹ�õĹ��ܳ��󵽹�������
 * ��ʹ��ʱ����ֱ�ӵ���
 * 
 * ��Լ����ʱ�䣬����Ч�ʣ�����ά���ɱ���ʹ���뿴��ȥ����࣬��߿ɶ���
 *
*/
public class GUIUtil {
	private static String imageFolder="g:/project/myhutubill/img";
	//����Button��ͼ���Լ���ʾ����
	public static void setImageIcon(JButton b,String fileName,String tip){
		ImageIcon i=new ImageIcon(new File(imageFolder,fileName).getAbsolutePath());
		b.setIcon(i);
		b.setPreferredSize(new Dimension(61,81));
		b.setToolTipText(tip);
		b.setVerticalTextPosition(JButton.BOTTOM);
		b.setHorizontalTextPosition(JButton.CENTER);
		b.setText(tip);
	}	
	//У��һ��������Ƿ�Ϊ��
	public static boolean checkEmpty(JTextField tf,String input){
		String text=tf.getText().trim();
		if(text.length()==0){
			JOptionPane.showMessageDialog(null, input+" ����Ϊ��");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	//У������������Ƿ�Ϊ���ָ�ʽ
	public static boolean checkNumber(JTextField tf,String input){
		if(!checkEmpty(tf, input))
			return false;
		String text=tf.getText().trim();
		try{
			Integer.parseInt(text);
			return true;
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, input+" ����Ϊ����");
			return false;
		}
	}
	//У������������Ƿ�Ϊ0
	public static boolean checkZero(JTextField tf,String input){
		if(!checkNumber(tf, input))
			return false;
		String text=tf.getText().trim();
		if(0==Integer.parseInt(text)){
			JOptionPane.showMessageDialog(null, input+" ����Ϊ0");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	//������������ǰ��ɫ
	public static void setColor(Color color,JComponent...cs){
		for(JComponent each:cs){
			each.setForeground(color);
		}
	}
	//ʹ��ˮ��Ƥ��
	public static void useLNF(){
		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ʾ�������
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
	//CenterPanel��ȱʡ�������Ϊ0.85
	public static void showPanel(JPanel p){
		showPanel(p,0.85);
	}
	
}
