package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class CategoryComboBoxModel implements ComboBoxModel<String> {
	//用list储存所有分类种类，也就是所有下拉框元素
	public List<String> cs=new ArrayList<>();
	//c为当前所选中的元素
	String c;
	//构造时导入分类信息
	public CategoryComboBoxModel(){
		cs.add("餐饮");
		cs.add("交通");
		cs.add("住宿");
		cs.add("话费");
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
