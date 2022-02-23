package com.qa.animals;

public class Cat {
	
	private int ID;
	private String name;
	private int age;
	
	public Cat(int iD, String name, int age) {
		super();
		ID = iD;
		this.name = name;
		this.age = age;
	}
	
	

	public Cat(String name, int age) {
		super();
		ID = 0;
		this.name = name;
		this.age = age;
	}



	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cat [ID=" + ID + ", name=" + name + ", age=" + age + "]";
	}
	
}
