package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import exception.*;

public class Minimarket {
	private ArrayList <Person> people;
	private Date date;
	private SimpleDateFormat objSDFDay;
	private int day;
	private int attempsNum;

	public Minimarket() {
		people = new ArrayList<Person>();
		objSDFDay= new SimpleDateFormat("dd");
		date= new Date();
		this.day= Integer.parseInt(objSDFDay.format(date)); 	
	}

	public boolean addPerson(String type, int id) throws AgeException,DayException{
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
		if(dateVerf) {
			if(idType.equals(IdType.TI)) {
				attempsNum++;
				throw new AgeException();
			}else {
				Person p = new Person(idType,  id);
				people.add(p);
				registered =true;
			}
		}else {
			attempsNum++;
			throw new DayException();
		}
		return registered;
	}

	public int getAttempsNum() {
		return attempsNum;
	}

	public void setAttempsNum(int attempsNum) {
		this.attempsNum = attempsNum;
	}
}
