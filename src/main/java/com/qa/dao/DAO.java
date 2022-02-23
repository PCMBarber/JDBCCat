package com.qa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public interface DAO<T> {
	
	T modelFromResultSet(ResultSet rs) throws SQLException;
	
	void create(T animal);
	
	T read(int id);
	
	List<T> readAll();
	
	boolean delete(int id);
}

