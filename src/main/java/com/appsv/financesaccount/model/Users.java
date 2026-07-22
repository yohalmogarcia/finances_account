package com.appsv.financesaccount.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_users")
	private Integer pkUsers;
	
	@Column(name="username_user")
	private String usernameUser;
	
	@Column(name="email_user")
	private String emailUser;
	
	@Column(name="password_hash_user")
	private String passwordHashUser;
	
	@Column(name="active_user")
	private Boolean activeUser;
	
	@Column(name="created_date", updatable = false)
	private LocalDateTime createdDate;
	
	@PrePersist
	protected void onCreate() {
		this.createdDate = LocalDateTime.now();
	}

	public Integer getPkUsers() {
		return pkUsers;
	}

	public void setPkUsers(Integer pkUsers) {
		this.pkUsers = pkUsers;
	}

	public String getUsernameUser() {
		return usernameUser;
	}

	public void setUsernameUser(String usernameUser) {
		this.usernameUser = usernameUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getPasswordHashUser() {
		return passwordHashUser;
	}

	public void setPasswordHashUser(String passwordHashUser) {
		this.passwordHashUser = passwordHashUser;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public Boolean getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(Boolean activeUser) {
		this.activeUser = activeUser;
	}	
	
}
