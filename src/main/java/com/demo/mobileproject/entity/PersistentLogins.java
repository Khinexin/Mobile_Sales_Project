package com.demo.mobileproject.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "persistent_logins") @Data
public class PersistentLogins {
	
	@Id
	@Column(name = "series", columnDefinition = "varchar(64)")
	private String series;
	
	@Column(name = "username", columnDefinition = "varchar(100) not null")
	private String username;
	
	@Column(name = "token", columnDefinition = "varchar(64) not null")
	private String token;
	
	@Column(name = "last_used", columnDefinition = "timestamp not null")
	private Date last_used;

}
