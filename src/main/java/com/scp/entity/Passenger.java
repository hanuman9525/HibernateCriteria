package com.scp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "passenger_tbl")
public class Passenger {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int Id;
	private String name;
	private String email;
	private String arrival;
	private String departure;

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(String name, String email, String arrival, String departure) {
		super();

		this.name = name;
		this.email = email;
		this.arrival = arrival;
		this.departure = departure;
	}

	@Override
	public String toString() {
		return "Passenger [Id=" + Id + ", name=" + name + ", email=" + email + ", arrival=" + arrival + ", departure="
				+ departure + "]";
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

}
