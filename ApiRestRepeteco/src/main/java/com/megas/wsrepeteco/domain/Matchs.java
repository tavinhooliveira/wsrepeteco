package com.megas.wsrepeteco.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Matchs {
	
	@Id
	private String id;
	
	@JsonInclude(Include.NON_NULL)
	private String id_fb_friends;
	
	@JsonInclude(Include.NON_NULL)
	private String name;
	
	@JsonInclude(Include.NON_NULL)
	private String read;
	
	@JsonInclude(Include.NON_NULL)
	private String imagem;
	
	@JsonInclude(Include.NON_NULL)
	private String link;
					
	private String option;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@JsonInclude(Include.NON_NULL)
	private Date dataMatch;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERS_ID")
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore			
	private Users users;
	
	private Long user_id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_fb_friends() {
		return id_fb_friends;
	}

	public void setId_fb_friends(String id_fb_friends) {
		this.id_fb_friends = id_fb_friends;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Date getDataMatch() {
		return dataMatch;
	}

	public void setDataMatch(Date dataMatch) {
		this.dataMatch = dataMatch;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}
	
	
	
				

}
