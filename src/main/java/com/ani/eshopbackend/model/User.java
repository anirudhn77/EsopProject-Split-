package com.ani.eshopbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	    @Id
	@Column
	    private String email;
	@Column
	    private String password;
	@Column
	    private String username;
	@Column
	    private String mobileno;
	@Column
	    private String address;
	@Column
	    private String role;
	@Column
	    private boolean enabled;
	    public boolean isEnabled() {
	    return enabled;
	}
	public void setEnabled(boolean enabled) {
	    this.enabled = enabled;
	}
	    public String getRole() {
	        return role;
	    }
	    public void setRole(String role) {
	        this.role = role;
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
	    public String getUsername() {
	        return username;
	    }
	    public void setUsername(String username) {
	        this.username = username;
	    }
	    public String getMobileno() {
	        return mobileno;
	    }
	    public void setMobileno(String mobileno) {
	        this.mobileno = mobileno;
	    }
	    public String getAddress() {
	        return address;
	    }
	    public void setAddress(String address) {
	        this.address = address;
	    }
	}


