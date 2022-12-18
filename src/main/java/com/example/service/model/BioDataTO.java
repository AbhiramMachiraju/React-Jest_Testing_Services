package com.example.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "biodata")
/*@Data
@Getter
@Setter*/
public class BioDataTO {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long autoId;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name="NAME")
	private String name;
	
	
	@Min(value = 5, message = "Age should not be less than 5")
	@Max(value = 50, message = "Age should not be greater than 50")
	@Column(name="AGE")
	private int age;
	
	@Column(name="MOBILE")
	private String  mobile;
	
	@Size(min = 10, max = 200, message  = "ADDRESS must be between 10 and 200 characters")
	@Column(name="ADDRESS")
	private String adrs;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="COUNTRY")
	private String country;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAutoId() {
		return autoId;
	}

	public void setAutoId(Long autoId) {
		this.autoId = autoId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAdrs() {
		return adrs;
	}

	public void setAdrs(String adrs) {
		this.adrs = adrs;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
