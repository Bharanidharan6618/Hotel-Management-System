package com.jspiders.programs;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class Hotel_DAO {
	public static void add(Connection con,Scanner sc) {
		try{
			System.out.println("Enter Id : ");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Name : ");
			String name=sc.nextLine();
			System.out.println("Enter Contact : ");
			long contact=sc.nextLong();
			System.out.println("Enter Room No : ");
			int room=sc.nextInt();
			String query="INSERT INTO RESERVATION(ID,NAME,CONTACT,ROOM) VALUE(?,?,?,?)";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setInt(1, id);
			psmt.setString(2, name);
			psmt.setLong(3, contact);
			psmt.setInt(4, room);
			int count=psmt.executeUpdate();
			if(count!=0) {
				System.out.println("Reservation Completed !!");
			}else {
				System.out.println("Try Again !!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void update(Connection con,Scanner sc) {
		try {
			System.out.println("Enter Name : ");
			String name=sc.next();
			System.out.println("Enter Contact : ");
			long contact=sc.nextLong();
			System.out.println("Enter Room No : ");
			int room=sc.nextInt();
			System.out.println("Enter Id :-> to Update Reservation : ");
			int id=sc.nextInt();
			String query="UPDATE RESERVATION SET NAME=?,CONTACT=?,ROOM=? WHERE ID=?";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, name);
			psmt.setLong(2, contact);
			psmt.setInt(3, room);
			psmt.setInt(4, id);
			int count=psmt.executeUpdate();
			if(count!=0) {
				System.out.println("Reservation Updated !!");
			}else {
				System.out.println("Try Again !!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void remove(Connection con,Scanner sc) {
		try {
			System.out.println("Enter Id : ");
			int id=sc.nextInt();
			String query="DELETE FROM RESERVATION WHERE ID=?";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setInt(1, id);
			int count=psmt.executeUpdate();
			if(count!=0) {
				System.out.println("Reservation Deleted !!");
			}else {
				System.out.println("Try Again !!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void getById(Connection con,Scanner sc) {
		try {
			System.out.println("Enter Id : ");
			int id=sc.nextInt();
			String query="SELECT * FROM RESERVATION WHERE ID=?";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setInt(1, id);;
			ResultSet rs=psmt.executeQuery();
			System.out.println("Id\tName\tContact\tRoom\tRDate");
			System.out.println("------------------------------------------------------------");
			if(rs.next()) {
				int id1=rs.getInt(1);
				String name=rs.getString(2);
				long contact=rs.getLong(3);
				int room=rs.getInt(4);
				String r_date=rs.getString(5);
				System.out.println(id1+"\t"+name+"\t"+contact+"\t"+room+"\t"+r_date);
			}
			System.out.println("------------------------------------------------------------");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void readAll(Connection con,Scanner sc) {
		try {
			String query="SELECT * FROM RESERVATION";
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery(query);
			System.out.println("Id\tName\tContact\tRoom\tRDate");
			System.out.println("------------------------------------------------------------");
			while(rs.next()) {
				int id1=rs.getInt(1);
				String name=rs.getString(2);
				long contact=rs.getLong(3);
				int room=rs.getInt(4);
				Timestamp ts=rs.getTimestamp(5);
				System.out.println(id1+"\t"+name+"\t"+contact+"\t"+room+"\t"+ts);
			}
			System.out.println("------------------------------------------------------------");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}