package com.jspiders.programs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
public class MainOfHotel_DAO {
	private static final String dburl="jdbc:mysql://localhost:3306/hotel_db?user=root&password=Bharani@123";
	public static void main(String[] args) {
		Connection con=null;
		Scanner sc=new Scanner(System.in);
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loading Completed !!");
			con=DriverManager.getConnection(dburl);
			if(con!=null) {
				System.out.println("Connection Created !!");
			}else {
				System.out.println("Try Again !!");
			}
			System.out.println("----------------------------");
			System.out.println("Welcome to Hotel Reservation");
			System.out.println("----------------------------");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		while(true) {
		System.out.println("1.Check-In\n2.Update Reservation\n3.Check-Out\n4.List Of Reservation \n"
					+ "5.Get Reservation\n6.Exit");
		System.out.println("----------------------------");
		System.out.print("Choose An Option : ");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:System.out.println("Welcome to Check-In : ");
			Hotel_DAO.add(con, sc);
			break;
		case 2:System.out.println("Welcome to Update Reservation : ");
			Hotel_DAO.update(con, sc);
			break;
		case 3:System.out.println("Welcome to Check-Out : ");
			Hotel_DAO.remove(con, sc);
			break;
		case 4:System.out.println("List of All Reservation : ");
			Hotel_DAO.getById(con, sc);
			break;
		case 5:System.out.println("Get Reservation : ");
			Hotel_DAO.readAll(con, sc);
			break;
		case 6:System.out.println("Exiting !!!");
		    System.exit(0);
			break;
		default:System.out.println("Invalid Choice !!!");
		}
		}
	}
}