package com.qa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qa.animals.Cat;
import com.qa.dbconnection.JDBCConnection;
import java.sql.ResultSetMetaData;

public class CatDAO implements DAO<Cat> {

	@Override
	public Cat modelFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("ID");
		String name = rs.getString("catName");
		int age = rs.getInt("catAge");
		return new Cat(id, name, age);
	}

	@Override
	public void create(Cat animal) {
		try (Connection connection = JDBCConnection.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("insert into cat values(?,?,?)");) {
			
			
			statement.setInt(1, animal.getID());
			statement.setString(2, animal.getName());
			statement.setInt(3, animal.getAge());
			statement.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cat read(int id) {
		Cat found = null;
		try (Connection connection = JDBCConnection.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from cat where id=" + id)) {
			while (resultSet.next()) {
				found = modelFromResultSet(resultSet);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}

	@Override
	public List<Cat> readAll() {
		ArrayList<Cat> found = new ArrayList<Cat>();
		try (Connection connection = JDBCConnection.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from cat")) {
			while (resultSet.next()) {
				found.add(modelFromResultSet(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}

	public void readAllGeneric(String id) {
		try (Connection connection = JDBCConnection.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from cat where id="+id)) {
			
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (resultSet.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String name = rsmd.getColumnName(i);
					System.out.print(name+": "+resultSet.getObject(name)+" ");
				}
				System.out.println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
