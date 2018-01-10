package com.megas.wsrepeteco.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String id_fb_users;
	
	private String id_fb_friends;
	
	private String option;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date data_modify;
	
	
	public Option() {}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the id_fb_users
	 */
	public String getId_fb_users() {
		return id_fb_users;
	}


	/**
	 * @param id_fb_users the id_fb_users to set
	 */
	public void setId_fb_users(String id_fb_users) {
		this.id_fb_users = id_fb_users;
	}




	/**
	 * @return the option
	 */
	public String getOption() {
		return option;
	}


	/**
	 * @param option the option to set
	 */
	public void setOption(String option) {
		this.option = option;
	}


	/**
	 * @return the id_fb_friends
	 */
	public String getId_fb_friends() {
		return id_fb_friends;
	}


	/**
	 * @param id_fb_friends the id_fb_friends to set
	 */
	public void setId_fb_friends(String id_fb_friends) {
		this.id_fb_friends = id_fb_friends;
	}


	/**
	 * @return the data_modify
	 */
	public Date getData_modify() {
		return data_modify;
	}


	/**
	 * @param data_modify the data_modify to set
	 */
	public void setData_modify(Date data_modify) {
		this.data_modify = data_modify;
	}

	
	


	
}
