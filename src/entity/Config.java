package entity;

public class Config {
	private int id;
	private String value;
	private String key;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public String getKey(){
		return key;
	}
	public void setKey(String key){
		this.key=key;
	}
	
	public String getValue(){
		return value;
	}
	public void setValue(String value){
		this.value=value;
	}
}
