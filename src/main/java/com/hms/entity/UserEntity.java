package com.hms.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(	name = "users",
		uniqueConstraints = {

				@UniqueConstraint(columnNames = "email")
		})
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;




	@OneToMany(mappedBy = "user")
	private List<ClaimEntity> claimEntityList  ;

	@OneToMany(mappedBy = "user")
	private List<CommandeEntity> commandeEntityList  ;
	//@NotBlank
	//@Size(max = 20)

	private String phone;
	private String firstName;
	private String lastName;
	private String cin;
	private String adresse;
	private String Roles;


	//@NotBlank
	//@Size(max = 50)
	//@Email
	private String email;

	//@NotBlank
	//@Size(max = 120)
	private String password;



	public UserEntity() {
	}


	public UserEntity(String email, String password,String roles
			, String phone,String firstName,String lastName, String cin, String adresse ) {

		this.email = email;
		this.password = password;
		this.Roles=roles;
		this.phone=phone;
		this.firstName=firstName;
		this.lastName=lastName;
		this.cin=cin;
		this.adresse=adresse;
	}
	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRoles(String roles) {Roles = roles;}
	public String getRoles() {return Roles;}
	public String getPhone() {		return phone;	}
	public void setPhone(String phone) {		this.phone = phone;	}
	public String getFirstName() {		return firstName;	}
	public void setFirstName(String firstName) {		this.firstName = firstName;	}
	public String getLastName() {		return lastName;	}
	public void setLastName(String lastName) {		this.lastName = lastName;	}
	public String getCin() {		return cin;	}
	public void setCin(String cin) {		this.cin = cin;	}
	public String getAdresse() {		return adresse;	}
	public void setAdresse(String adresse) {this.adresse = adresse;	}

	public List<CommandeEntity> getCommandeEntityList() {
		return commandeEntityList;
	}

	public void setCommandeEntityList(List<CommandeEntity> commandeEntityList) {
		this.commandeEntityList = commandeEntityList;
	}

	public List<ClaimEntity> getClaimEntityList() {
		return claimEntityList;
	}

	public void setClaimEntityList(List<ClaimEntity> claimEntityList) {
		this.claimEntityList = claimEntityList;
	}
}
