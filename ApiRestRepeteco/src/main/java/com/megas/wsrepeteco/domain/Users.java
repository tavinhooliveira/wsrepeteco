package com.megas.wsrepeteco.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Users {
	
	@Id
	private Long id;
	
	private String id_fb_users;	
	
	private String name;
	
	private String imagem;
		
	private String link;
	
	private String email;
	
	private String city;
	
	private String gender;
	
	private String preference;
	
	private String numberWhats;
		
	private String nationality;
		
	private Integer friendsTotalFb;
	
	private Integer friendsTotalApp;
	
	private boolean flagDisplayCount;
	
	private boolean flagDisplayHot;
	
	private boolean flagNotificationMatch;
	
	private boolean flagNotificationFriends;
	
		
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@JsonInclude(Include.NON_NULL)
	private Date createData;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@JsonInclude(Include.NON_NULL)
	private Date updateData;
		
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "users")
	private List<Friends> friends;
	
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "users")
	private List<Matchs> matchs;
	
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "users")
	private List<Notification> notification;
		
	public Users() {}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the imagem
	 */
	public String getImagem() {
		return imagem;
	}


	/**
	 * @param imagem the imagem to set
	 */
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}


	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}


	/**
	 * @return the preference
	 */
	public String getPreference() {
		return preference;
	}


	/**
	 * @param preference the preference to set
	 */
	public void setPreference(String preference) {
		this.preference = preference;
	}


	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}


	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	/**
	 * @return the friendsTotalFb
	 */
	public Integer getFriendsTotalFb() {
		return friendsTotalFb;
	}


	/**
	 * @param friendsTotalFb the friendsTotalFb to set
	 */
	public void setFriendsTotalFb(Integer friendsTotalFb) {
		this.friendsTotalFb = friendsTotalFb;
	}


	/**
	 * @return the friends
	 */
	public List<Friends> getFriends() {
		return friends;
	}


	/**
	 * @param friends the friends to set
	 */
	public void setFriends(List<Friends> friends) {
		this.friends = friends;
	}
	
	
	public List<Matchs> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<Matchs> matchs) {
		this.matchs = matchs;
	}

	/**
	 * @return the friendsTotalApp
	 */
	public Integer getFriendsTotalApp() {
		return friendsTotalApp;
	}

	/**
	 * @param friendsTotalApp the friendsTotalApp to set
	 */
	public void setFriendsTotalApp(Integer friendsTotalApp) {
		this.friendsTotalApp = friendsTotalApp;
	}

	/**
	 * @return the createData
	 */
	public Date getCreateData() {
		return createData;
	}

	/**
	 * @param createData the createData to set
	 */
	public void setCreateData(Date createData) {
		this.createData = createData;
	}

	/**
	 * @return the updateData
	 */
	public Date getUpdateData() {
		return updateData;
	}

	/**
	 * @param updateData the updateData to set
	 */
	public void setUpdateData(Date updateData) {
		this.updateData = updateData;
	}

	public boolean isFlagDisplayCount() {
		return flagDisplayCount;
	}

	public void setFlagDisplayCount(boolean flagDisplayCount) {
		this.flagDisplayCount = flagDisplayCount;
	}

	public boolean isFlagDisplayHot() {
		return flagDisplayHot;
	}

	public void setFlagDisplayHot(boolean flagDisplayHot) {
		this.flagDisplayHot = flagDisplayHot;
	}

	public boolean isFlagNotificationMatch() {
		return flagNotificationMatch;
	}

	public void setFlagNotificationMatch(boolean flagNotificationMatch) {
		this.flagNotificationMatch = flagNotificationMatch;
	}

	public boolean isFlagNotificationFriends() {
		return flagNotificationFriends;
	}

	public void setFlagNotificationFriends(boolean flagNotificationFriends) {
		this.flagNotificationFriends = flagNotificationFriends;
	}

	public List<Notification> getNotification() {
		return notification;
	}

	public void setNotification(List<Notification> notification) {
		this.notification = notification;
	}

	public String getNumberWhats() {
		return numberWhats;
	}

	public void setNumberWhats(String numberWhats) {
		this.numberWhats = numberWhats;
	}
	
	


}