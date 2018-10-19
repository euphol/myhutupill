package gui.panel;

import javax.swing.JLabel;

public class SpendPanel {
	//单例模式
	public static SpendPanel instance=new SpendPanel();
	private SpendPanel(){
		
	}
	
	JLabel lMonthSpend=new JLabel("本月消费");
	JLabel lTodaySpend=new JLabel("今日消费");
	JLabel lAvgSpendPerDay=new JLabel("日均消费");
	JLabel lMonthLeft=new JLabel("本月剩余");
	JLabel lDayAvgAvailable=new JLabel("日均可用");
	JLabel lMonthLeftDay=new JLabel("距离月末");
	
	JLabel vMonthSpend=new JLabel("¥2300");
	JLabel vTodaySpend=new JLabel("¥25");
	JLabel vAvgSpendPerDay=new JLabel("¥120");
	JLabel vMonthLeft=new JLabel("¥200");
	JLabel vDayAvgAvailable=new JLabel("¥20");
	JLabel vMonthLeftDay=new JLabel("10天");
	
	

}
