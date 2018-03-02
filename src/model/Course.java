package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")

public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String CRN;
	@Column(name = "course_name")
	private String courseName;
	@Column(name = "start_time")
	private String startTime;
	@Column(name = "end_time")
	private String endTime;
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Instructor teacher;
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Classroom location;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String cRN, String courseName, String startTime, String endTime, Instructor teacher,
			Classroom location) {
		CRN = cRN;
		this.courseName = courseName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.teacher = teacher;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCRN() {
		return CRN;
	}

	public void setCRN(String cRN) {
		CRN = cRN;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Instructor getTeacher() {
		return teacher;
	}

	public void setTeacher(Instructor teacher) {
		this.teacher = teacher;
	}

	public Classroom getLocation() {
		return location;
	}

	public void setLocation(Classroom location) {
		this.location = location;
	}

}
