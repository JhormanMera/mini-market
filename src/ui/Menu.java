package ui;

import java.util.Scanner;

import model.Minimarket;

public class Menu {
	private final static int ADD_PERSON = 1;
	private final static int SHOW_ATTEMPS = 2;
	private final static int EXIT = 3;
	private static Scanner sc = new Scanner(System.in);
	private Minimarket minimarket;
	
	public Menu() {
		this.minimarket= new Minimarket();
	}
	public void startProgram() {
		System.out.println("*****¡Bienvenido al minimercado Mi Barrio Te Quiere!*****");
		int option;
		do {
			showMenu();
			option = readOption();
			doOperation(option);
		} while(option != EXIT);
	}
	public void showMenu() {
		System.out.println("\n"+"(1) Registrar el ingreso de una persona");
		System.out.println("(2) Consultar la cantidad de personas que han intentado ingresar");
		System.out.println("(3) Salir del programa");
	}
	
	public int readOption() {
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	}
	public void addPerson() {
		System.out.println("Tipo De Documento de Identidad");
		System.out.println("(1) Tarjeta De Identidad"+"\n"+"(2) Cedula De Ciudadania"+"\n"+"(3) Pasaporte"+"\n"+"(4) Cedula De Extranjeria");
		int choice = sc.nextInt();
		sc.nextLine();
		String idType="";
		switch(choice) {
		case 1:
			idType="Tarjeta De Identidad";
			break;
		case 2:
			idType="Cedula De Ciudadania";
			break;
		case 3:
			idType="Pasaporte";
			break;
		case 4:
			idType="Cedula De Extranjeria";
			break;
		default:
			System.out.println("Opcion invalida, repita nuevamente");
	}
		System.out.println("Ingrese el numero de documento (Sin puntos)");
		int id = sc.nextInt();
		sc.nextLine();
		
		if(minimarket.addPerson(idType,id)) {
			System.out.println("\n"+"***Ingreso agregado correctamente***");
		}
	}
	public void doOperation(int choice) {
		switch(choice) {
			case ADD_PERSON:
				addPerson();
				break;
			case SHOW_ATTEMPS:
				System.out.println("El numero de personas que ha intentado ingresar al minimercado es: "+minimarket.getAttempsNum());				
				break;
			case EXIT:
				break;
			default:
				System.out.println("Opcion invalida, repita nuevamente");
		}
	}
}
