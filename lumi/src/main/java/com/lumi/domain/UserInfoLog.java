package com.lumi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserInfoLog {
	
	@Id
	@GeneratedValue
	public Long id;
	public String name;
	public String upn;
	public String country;
	public Long visitorNumber;
	
    @Override
    public String toString() {
        return "UserInfoLog [id=" + id + ", name=" + name
                + ", upn=" + upn + ", country=" + country + ", visitorNumber=" + visitorNumber + "]";
    }
}
