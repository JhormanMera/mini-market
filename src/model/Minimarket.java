package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

	public boolean addPerson(String idType, int id) {
		boolean registered =false;
		Person p = new Person(idType,  id);
		String a = Integer.toString(id);
		char[] digits= a.toCharArray();
		int digit=Integer.parseInt(String.valueOf(digits[digits.length-2]));
		boolean dateVerf=false;
		if(digit%2==0&&day%2!=0) {
			dateVerf=true;
		}else if(digit%2!=0&&day%2==0) {
			dateVerf=true;
		}
		if(dateVerf) {
			if(idType.equalsIgnoreCase("TARJETA DE IDENTIDAD")) {
				attempsNum++;
				//PONER EXCEPCION
			}else {
				people.add(p);
				registered =true;
			}
		}else {
			attempsNum++;
			//PONER EXCEPCION
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
