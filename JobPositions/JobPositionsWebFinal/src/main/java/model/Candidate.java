package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Candidate implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private String city;
	private String country;
	private Long mobile;
	private Long phone;
	private String course;
	private String school;
	
	private List<Application> applications = new ArrayList<>();
	

}
