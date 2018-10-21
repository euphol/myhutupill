package service;

import java.util.Collections;
import java.util.List;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;

public class CategoryService {
	CategoryDAO categoryDao=new CategoryDAO();
	RecordDAO recordDao=new RecordDAO();
	
	public List<Category> list(){
		List<Category> cs=categoryDao.list();
		if(null==cs)
			return null;
		for(Category each:cs){
			List<Record> rs=recordDao.list(each.getId());
			each.setRecordNumber(rs.size());
		}
		Collections.sort(cs, (c1,c2)->c2.getRecordNumber()-c1.getRecordNumber());
		return cs;
	}
	
	public void add(String name){
		Category c=new Category();
		c.setName(name);
		categoryDao.add(c);
	}
	
	public void update(int id,String name){
		Category c=new Category();
		c.setName(name);
		c.setId(id);
		categoryDao.update(c);
	}
	
	public void delete(int id){
		categoryDao.delete(id);
	}

}
