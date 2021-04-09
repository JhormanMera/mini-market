package model;

public class Person {
	
	private String idType;
	private int id;
	
	public Person(String idType, int id) {
		this.idType=idType;
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}
	

}
