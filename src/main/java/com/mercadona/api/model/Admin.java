/**
 * 
 */
package com.mercadona.api.model;

import jakarta.persistence.*;

/**
 * @author 2kalm
 *@return La table Administrateur
 */

@Entity
public class Admin {
	private int id;
	private String name;
	private String password;
	private int version;
	
	public Admin() {
		
	}
	public Admin(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	/**
	 * @return the id
	 * @return l'id est unique et servira à l'administateur pour se connecter à son espace en plus de son password
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 * @return ne peut pas etre null
	 */
	@Column(name = "name", nullable = false)
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
	 * @return the password
	 * @return ne peut pas etre null
	 */
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the version
	 */
	@Version
	public int getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}
	
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + ", version=" + version
				+ "]";
	}
	
	
}
