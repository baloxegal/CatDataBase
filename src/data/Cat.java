package data;

import java.util.Scanner;

public class Cat implements FelineInterface, Cloneable {
	
	private Integer id;
	private String name;
	private String race;
	private int year;
		
	public Cat(Integer id, String name, String race, int year) {
		
		this.id = id;
		this.name = name;
		this.race = race;
		setYear(year);
			
	}
	
//Constructor of copy
//	public Cat(Cat cat) {
//		this(cat.getId(), cat.getName(), cat.getRace(), cat.getYear());
//	}
	
	public String toString() {
		return "ID: " + id + ", Cat's name: " + name + ", Cat's race: " + race + ", Cat's age: " + year;
	}
	@Override
	public FelineInterface clone() throws CloneNotSupportedException {
		return (FelineInterface) super.clone();
	}
	@Override
	public void setId(Integer id) {
		for(;;) {
			if(id >= 0) {
					this.id = id;
					break;
			}
			else {
				System.out.println("Enter valid id");
				Scanner in = new Scanner(System.in);
				id = in.nextInt();
				in.close();
			}
		}
	}
	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setRace(String race) {
		this.race = race;
	}
	@Override
	public String getRace() {
		return race;
	}
	@Override
	public void setYear(int year) {
		for(;;) {
			if(year > 0 && year < 25) {
				this.year = year;
				break;
			}
			else {
				System.out.println("Enter valid age");
				Scanner in = new Scanner(System.in);
				year = in.nextInt();
				in.close();
			}
		}
	}
	@Override
	public int getYear() {
		return year;
	}
}