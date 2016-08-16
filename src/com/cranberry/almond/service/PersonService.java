package com.cranberry.almond.service;

import java.util.List;

import com.cranberry.almond.Criteria.Person;
import com.cranberry.almond.dao.PersonDAO;

public class PersonService {

	public static void insertPerson(Person p){
		PersonDAO.insertData(p);
		//TODO
	}
	public static void findPerson(Person p){
		//TODO
	}
	public static void deletePerson(Person p){
		//TODO
	}
	public static List<Person> getList(){
		List<Person> personList = PersonDAO.retrieveData();
		//TODO
		return personList;
	}
}
