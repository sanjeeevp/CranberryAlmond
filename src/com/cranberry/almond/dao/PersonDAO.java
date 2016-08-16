package com.cranberry.almond.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cranberry.almond.Criteria.Person;
import com.cranberry.almond.connection.ConnectionUtil;
import com.cranberry.almond.service.PersonService;

public class PersonDAO {
	static Statement statement = null;
	static ResultSet rs = null;
	static Connection conn = null;
	static PreparedStatement ps = null;

	public static void main(String args[]) {
		Person p = new Person();
		p.setfName("Mira");
		p.setlName("panthi");
		p.setPhoneNum(222);
		p.setCity("ny");

		List<Person> pList = PersonService.getList();
//		for(Person p : pList){
//		System.out.println);
//		}
		//insertData(p);
		//retrieveData();
	}

	// INSERT DATA
	public static void insertData(Person p) {
		try {
			conn = ConnectionUtil.openConnection();
			statement = conn.createStatement();
			String fName = p.getfName();
			String lName = p.getlName();
			long phone = p.getPhoneNum();
			String city = p.getCity();

			ps = conn
					.prepareStatement("insert into  Employee.Person values (?, ? , ?, ?)");

			ps.setLong(1, 555);
			ps.setString(2, "Mira");
			ps.setString(3, "Paudel");
			ps.setString(4, "new york");

//			String sql = "INSERT INTO Person "
//					+ "VALUES (fName, 'Mira', 'Panthi', 25)";
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(ps, conn, rs);
		}
		System.out.println("Inserted records into the Person table");
	}

	// RETRIEVE DATA
	public static List<Person> retrieveData() {
		List<Person>  personList = new ArrayList();
		Person person;
		try {
			conn = ConnectionUtil.openConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery("SELECT * FROM Person");
			while (rs.next()) {
				 person = new Person();

				person.setPhoneNum(rs.getInt("phone_number"));
				person.setfName(rs.getString("first_name"));
				person.setlName(rs.getString("last_name"));
				person.setCity(rs.getString("city"));
				
				personList.add(person);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(ps, conn, rs);
		}
		return personList;
	}

}
