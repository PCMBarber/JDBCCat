package com.qa.main;

import com.qa.animals.Cat;
import com.qa.dao.CatDAO;

public class Runner {
	public static void main(String[] args) {
		
			CatDAO catDAO = new CatDAO();
			
			catDAO.readAllGeneric("2 union select * from users");
	}
}
