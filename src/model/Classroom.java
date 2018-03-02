package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="classroom")

public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="building")
	String building;
	@Column(name="room_number")
	String roomNumber;
	@Column(name="campus")
	String campus;
	@Column(name="type")
	String type;
	@Column(name="capacity")
	int capacity;
	
	public Classroom() {
		super();
	}
	
	public Classroom(String building, String roomNumber, String campus, String type, int capacity) {
		super();
		this.building = building;
		this.roomNumber = roomNumber;
		this.campus = campus;
		this.type = type;
		this.capacity = capacity;
	}
	
	

	public Classroom(String building, String roomNumber) {
		super();
		this.building = building;
		this.roomNumber = roomNumber;
	}

	public int getId() {
		return id;
	}
	
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "Classroom [building=" + building + ", roomNumber=" + roomNumber + ", campus=" + campus + ", type="
				+ type + ", capacity=" + capacity + "]";
	}
	
	public String returnItemDetails() {
		return building + " " + roomNumber + " " + campus + " " + type + " " + capacity;
	}
}
