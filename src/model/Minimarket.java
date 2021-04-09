package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import exception.*;

public class Minimarket {
	private ArrayList <Person> people;
	private int attempsNum;

	public Minimarket() {
		people=new ArrayList<>();	
	}

	public boolean addPerson(Date date,String type, int id) throws AgeException,DayException{
		SimpleDateFormat objSDFDay= new SimpleDateFormat("dd");
		int day= Integer.parseInt(objSDFDay.format(date)); 	
		boolean registered =false;
		String a = Integer.toString(id);
		String b=a.substring(a.length()-2,a.length()-1);
		int digit = Integer.parseInt(b);
		boolean dateVerf=false;
		if(digit%2==0&&day%2!=0) {
			dateVerf=true;
		}else if(digit%2!=0&&day%2==0) {
			dateVerf=true;
		}
		IdType idType = IdType.valueOf(type);
		if(idType.equals(IdType.TI)) {
			attempsNum++;
			throw new AgeException();
		}else {
			if(dateVerf) {
				Person p = new Person(idType,  id);
				people.add(p);
				registered =true;
			}else {
				attempsNum++;
				throw new DayException();
			}
		}
		return registered;
	}

	public int getAttempsNum() {
		return attempsNum;
	}

	public void setAttempsNum(int attempsNum) {
		this.attempsNum = attempsNum;
	}

	public ArrayList <Person> getPeople() {
		return people;
	}

	public void setPeople(ArrayList <Person> people) {
		this.people = people;
	}
}
