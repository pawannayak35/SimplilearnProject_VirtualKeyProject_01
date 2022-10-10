package virtualkey.project01;

import java.util.*;
import java.io.*;

public class LockerCompany {
	
	// Retrieving the file names in an ascending order
	public static void listingFile() {
		File file = new File("D:\\1.Simplilearn\\Simplilearn Project\\Locker Directory");
		file.mkdir();
		
		if(file.isDirectory()) {
			List<String> listFile = Arrays.asList(file.list());
			// sorting the file in  ascending order
			Collections.sort(listFile);
			System.out.println("--------------------------------------------------");
			System.out.println("These are files. Sorting by file_name in ascending order");
			
			// Iterator inteface and method  1. way for traversing the list
			Iterator itr = listFile.iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
			
			// this is just for knowlegde
			// 2. way for traversing the list is foreach method
//			for(String s:listFile) {
//				System.out.println(s);
//			}
		}else {
			System.out.println(file.getAbsolutePath()+" not found");
		}
		LockerCompany.mainMenu();
	}
	
	// add a file method or create file
	public static void createFile() {
		File fileDir = new File("D:\\1.Simplilearn\\Simplilearn Project\\Locker Directory");
		// make a directory
		fileDir.mkdir();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the File Name :");
		String fileName = scan.nextLine();
		File file = new File("D:\\1.Simplilearn\\Simplilearn Project\\Locker Directory\\"+fileName+".txt");
		try {
			if(file.createNewFile()) {
				System.out.println("File "+file.getName()+" is created successfully.");
				fileBusinessOperation();
			}else {
				System.out.println("File "+file.getName()+" is already exists.");
				fileBusinessOperation();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	// delete a file method 
	public static void deleteMethod() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the file name which you want to delete :");
		String fileName = scan.nextLine();
		File file = new File("D:\\1.Simplilearn\\Simplilearn Project\\Locker Directory\\"+fileName+".txt");
		try {
			if(file.delete()) {
				System.out.println("File "+file.getName()+" is deleted successfully");
				fileBusinessOperation();
			}else {
				System.out.println("File "+file.getName()+" is already deleted");
				fileBusinessOperation();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	// search a file method
	public static void searchMethod() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the file name which you want to search :");
		String fileName = scan.nextLine();
		File file = new File("D:\\1.Simplilearn\\Simplilearn Project\\Locker Directory\\"+fileName+".txt");
		try {
			if(file.exists()) {
				System.out.println("File "+file.getName()+" is Found successfully.");
				System.out.println("Location of file is "+file.getAbsolutePath());
				fileBusinessOperation();
			}else {
				System.out.println("File "+file.getName()+" does not exists.");
				fileBusinessOperation();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	// Display welcome Screen details such as Application Name & Developer Name
	public static void welcomeScreen() {
		System.out.println("***********************************************************");
		System.out.println("Welcome to Lockers Pvt. Ltd.");
		System.out.println("LockedMe.com");
		System.out.println("Developed by Pawan Kumar");
		System.out.println("***********************************************************");
	}
	
	// Generic features and three operations
	public static void mainMenu() {
		System.out.println("Please select one of the following");
		System.out.println("1. The current file names in ascending order");
		System.out.println("2. Business-level operations(Add, Delete Search)");
		System.out.println("3. ⌫ Close Application");
		Scanner scan = new Scanner(System.in);
		while(true) {
			try {
				
				int option = scan.nextInt();
				
				switch(option) {
				case 1:
//					System.out.println("These are file names in ascending order");
					listingFile();
					break;
				case 2:
					LockerCompany.fileBusinessOperation();
					break;
				case 3:
					System.out.println("Have a nice day!! Thanks for Using LockedMe.com");
					System.out.println("Application Closed Successfully");
					System.exit(option);
					break;
				default:
					System.out.println("Oops! You Enter the Wrong Numner!");
					System.out.println("Please Enter the Valid Number");
					break;
				}
			}catch(Exception e) {
				System.out.println("Oops!! Please Enter the valid number");
				System.out.println(e);
			}
		}
	}
	
	// Business-level operations
	public static void fileBusinessOperation() {
		System.out.println("Please select one of the following");
		System.out.println("1. Add a File");
		System.out.println("2. Delete a File");
		System.out.println("3. Search a File");
		System.out.println("4. ↩ MAIN MENU");
		Scanner scan2 = new Scanner(System.in);
		while(true) {
			try {
				int choice = scan2.nextInt();
				switch(choice) {
				case 1:
					System.out.println("You have selected the add file option");
					createFile();
					break;
				case 2:
					System.out.println("You have selected the delete file option");
					deleteMethod();
					break;
				case 3:
					System.out.println("You have selected the search file option");
					searchMethod();
					break;
				case 4:
					System.out.println("Go to the Main Menu");
//					main(null);
					mainMenu();
					
					break ;
				default:
					System.out.println("Enter the Valid Number");
					break;
				}
			}catch(Exception e) {
				System.out.println("Enter the Valid Number");
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// there are two ways for calling a method
		// 1. class_name.method_name or
		// LockerCompany.welcomeScreen();
		// 2. method_name only
		welcomeScreen();
		LockerCompany.mainMenu();

	}

}
