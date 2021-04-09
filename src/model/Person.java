package model;

public class Person {
	private IdType idType;
	private int id;
	
	public Person(IdType idType, int id) {
		this.idType=idType;
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IdType getIdType() {
		return idType;
	}

	public void setIdType(IdType idType) {
		this.idType = idType;
	}
	

}
