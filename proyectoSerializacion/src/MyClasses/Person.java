package MyClasses;

import java.io.Serializable;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// Attributes
	private String dni;
	private String name;
	private int age;
	
	// Constructors
	public Person() {
		super();
	}

	public Person(String dni, String name, int age) {
		super();
		this.dni = dni;
		this.name = name;
		this.age = age;
	}

	// Getters and Setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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
}
