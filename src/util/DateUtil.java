package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	static long millisecondsOfOneDay=1000*60*60*24;
	
	public static java.sql.Date util2sql(java.util.Date d){
		return new java.sql.Date(d.getTime());
	}

	/*
	 * ��ȡ���죬��ʱ���������Ϊ���ڿؼ����ص����ڵ�ʱ����Ϊ0
	 * @return
	 */
	public static Date today(){
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		return c.getTime();
	}
	
	/*
	 * ��ȡ�³�
	 * @return
	 */
	public static Date monthBegin(){
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DATE,1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		return c.getTime();
	}
	
	/*
	 * ��ȡ��ĩ
	 * @return
	 */
	public static Date monthEnd(){
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DATE,1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		c.add(Calendar.MONTH, 1);
		return c.getTime();	
	}
	
	/*
	 * ��ȡ��������
	 * @return
	 */
	public static int thisMonthTotalDay(){
		long lastDayMilliSeconds=monthEnd().getTime();
		long firstDayMilliSeconds=monthBegin().getTime();
		
		return (int)((lastDayMilliSeconds-firstDayMilliSeconds)/millisecondsOfOneDay);
	}
	
	/*
	 * ��ȡ����ʣ������
	 * @return
	 */
	public static int thisMonthLeftDay(){
		long lastDayMilliSeconds=monthEnd().getTime();
		long todayMilliSeconds=today().getTime();
		return (int)((lastDayMilliSeconds-todayMilliSeconds)/millisecondsOfOneDay);
	}
	public static void main(String[] args) {
		System.out.println(monthBegin());
	}
}
