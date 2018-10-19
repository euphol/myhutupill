package util;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CenterPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	//拉伸比率，面板上显示的组件，是否拉伸
	private double rate;
	private JComponent c;
	private boolean strech;
	//构造方法
	public CenterPanel(double rate,boolean strech){
		this.rate=rate;
		this.strech=strech;
		this.setLayout(null);
	}
	public CenterPanel(double rate){
		this(rate,true);
	}
	//移除其他组件，加入组件c
	public void show(JComponent p){
		this.c=p;
		Component[] cs=getComponents();
		for(Component each:cs){
			remove(each);
		}
		add(p);
		this.updateUI();
	}
	//依据是否拉伸，将相应大小的组件c放到面板中央
	public void repaint(){
		if(null!=c){
			Dimension containerSize=this.getSize();
			Dimension componentSize=c.getPreferredSize();
			if(strech)
				c.setSize((int)(containerSize.width*rate),(int)(containerSize.height*rate));
			else
				c.setSize(componentSize);
			
			c.setLocation((containerSize.width-c.getSize().width)/2, (containerSize.height-c.getSize().height)/2);
		}
		super.repaint();
	}
	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setSize(400,400);
		f.setLocationRelativeTo(null);
		CenterPanel cp=new CenterPanel(0.85,true);
		f.setContentPane(cp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		JButton b=new JButton("test");
		cp.show(b);
	}

}
