package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class CategoryComboBoxModel implements ComboBoxModel<String> {
	//��list�������з������࣬Ҳ��������������Ԫ��
	public List<String> cs=new ArrayList<>();
	//cΪ��ǰ��ѡ�е�Ԫ��
	String c;
	//����ʱ���������Ϣ
	public CategoryComboBoxModel(){
		cs.add("����");
		cs.add("��ͨ");
		cs.add("ס��");
		cs.add("����");
		c=cs.get(0);
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return cs.size();
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return cs.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		c=(String) anItem;
		
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return c;
	}

}
