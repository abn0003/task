package com.lumi.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserInfo {
	
	@Id
	@GeneratedValue
	public Long id;
	public String name;
	public String upn;
	public String country;
	
    @Override
    public String toString() {
        return "UserInfo [id=" + id + ", name=" + name
                + ", upn=" + upn + ", country=" + country + "]";
    }
}