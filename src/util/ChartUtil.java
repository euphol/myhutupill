package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

import entity.Record;

public class ChartUtil {
	/*
	 * ��״ͼ������
	 */
	//��ȡ�����б��е����ֵ��������״ͼ�����곤��
	public static int max(double[] sampleValues){
		int max=0;
		for(double each:sampleValues){
			if(each>max)
				max=(int)each;
		}
		return max;
	}
	//�������ں�����
	private static String[] sampleLables(List<Record> rs){
		String[] sampleLables=new String[rs.size()];
			for (int i = 0; i < sampleLables.length; i++) {
				if(0==i%5)
					sampleLables[i]=String.valueOf(i+1+"��");
			}
			return sampleLables;
	}
	//����ͼ��
	public static Image getImage(List<Record> rs, int width,int height){
		double[] sampleValues=sampleValues(rs);
		String[] sampleLables=sampleLables(rs);
		int max=max(sampleValues);
		Color[] sampleColors=new Color[]{ColorUtil.blueColor};
		
		BarChart chart=new BarChart();
		chart.setSampleCount(sampleValues.length);
		chart.setSampleValues(0, sampleValues);
		chart.setSampleLabels(sampleLables);
		chart.setSampleColors(sampleColors);
		chart.setRange(0, max*1.2);
		chart.setValueLinesOn(true);
		chart.setSampleLabelsOn(true);
		chart.setSampleLabelStyle(Chart.BELOW);
		
		chart.setFont("rangeLabelFont",new Font("Dialog",Font.BOLD,12));
		chart.setFont("sampleLabelFont",new Font("Dialog",Font.BOLD,12));
		chart.setLegendOn(true);
		chart.setLegendPosition(Chart.BOTTOM);
		chart.setLegendLabels(new String[]{"�����ѱ���"});
		chart.setFont("legendFont",new Font("Dialog",Font.BOLD,15));
		chart.setChartBackground(Color.white);
		chart.setBackground(ColorUtil.backgroundColor);
		Image im=chart.getImage(width,height);
		return im;
	}
	private static double[] sampleValues(List<Record> rs) {
		// TODO Auto-generated method stub
		double[] result=new double[rs.size()];
		for (int i = 0; i < result.length; i++) {
			result[i]=rs.get(i).getSpend();
		}
		return result;
	}

	
}
