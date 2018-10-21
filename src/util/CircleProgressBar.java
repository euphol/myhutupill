package util;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 * 自定义环状进度条
 * 思路为绘制一个有宽度的圆环
 */
public class CircleProgressBar extends JPanel {

	private static final long serialVersionUID = 1L;
	private int minimumProgress;
	private int maximunProgress;
	private int progress;
	private String progressText;
	private Color backgroundColor;
	private Color foregroundColor;
	
	public CircleProgressBar(){
		minimumProgress=0;
		maximunProgress=100;
		progressText="0%";
	}
	//重写父类JPanel的paint方法，实现图形绘制
	public void paint(Graphics g){
		//必须先调用父类的paint以实例化Graphics g画笔
		super.paint(g);
		Graphics2D graphics2d=(Graphics2D)g;
		//开启抗锯齿
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int x=0;
		int y=0;
		int width=0;
		int height=0;
		int fontSize=0;
		if(getWidth()>=getHeight()){
			x=(getWidth()-getHeight())/2+25;
			y=25;
			width=getHeight()-50;
			height=getHeight()-50;
			fontSize=getWidth()/8;
		}else{
			x=25;
			y=(getHeight()-getWidth())/2+25;
			width=getWidth()-50;
			height=getWidth()-50;
			fontSize=getHeight()/8;
		}
		graphics2d.setStroke(new BasicStroke(20.0f));
		graphics2d.setColor(backgroundColor);
		graphics2d.drawArc(x, y, width, height, 0, 360);
		graphics2d.setColor(foregroundColor);
		graphics2d.drawArc(x, y, width, height, 90,
				-(int)(360*((progress*1.0)/(maximunProgress-minimumProgress))));
		graphics2d.setFont(new Font("黑体",Font.BOLD,fontSize));
		FontMetrics fontMetrics=graphics2d.getFontMetrics();
		int digitWidth=fontMetrics.stringWidth(progressText);
		int digitAscent=fontMetrics.getAscent();
		graphics2d.setColor(foregroundColor);
		graphics2d.drawString(progressText, getWidth()/2-digitWidth/2, getHeight()/2+digitAscent/2);
		
	}
	//获取当前进度
	public int getProgress(){
		return progress;
	}
	//设置当前进度并刷新环状进度条
	public void setProgress(int progress){
		if(progress>=minimumProgress&&progress<=maximunProgress)
			this.progress=progress;
		if(progress>maximunProgress)
			this.progress=maximunProgress;
		this.progressText=String.valueOf(progress+"%");
		this.repaint();
	}
	//获取背景色
	public Color getBackgroundColor(){
		return backgroundColor;
	}
	//设置背景色
	public void setBackgroundColor(Color backgroundColor){
		this.backgroundColor=backgroundColor;
		this.repaint();
	}
	//获取前景色
	public Color getForegroundColor(){
		return foregroundColor;
	}
	public void setForegroundColor(Color foregroundColor){
		this.foregroundColor=foregroundColor;
		this.repaint();
	}
	public static void main(String[] args) {
		GUIUtil.useLNF();
		JPanel p=new JPanel();
		CircleProgressBar cpb=new CircleProgressBar();
		cpb.setBackgroundColor(ColorUtil.blueColor);
		cpb.setProgress(0);
		JButton b=new JButton("点击");
		p.setLayout(new BorderLayout());
		p.add(cpb,BorderLayout.CENTER);
		p.add(b, BorderLayout.SOUTH);
		GUIUtil.showPanel(p);
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SwingWorker<Object, Object>(){

					@Override
					protected Object doInBackground() throws Exception {
						// TODO Auto-generated method stub
						for(int i=0;i<100;i++){
							cpb.setProgress(i+1);
							cpb.setForegroundColor(ColorUtil.getByPercentage(i+1));
							try{
								Thread.sleep(100);
							}catch(InterruptedException e1){
								e1.printStackTrace();
							}
						}
						return null;
					}
					
				}.execute();
				
			}
		});
	}

}
