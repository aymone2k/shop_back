/**
 * 
 */
package com.mercadona.api.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

/**
 * @author 2kalm
 * @return La table category
 */
@Entity
@Table(name="category")
public class Category {
	private int id;
	private String libelle;

	private int version;
	/**
	 * 
	 */
	public Category() {
	}
	/**
	 * @param id
	 * @param libelle
	 * @param products
	 */
	public Category(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
		
	}

	/**
	 * @return the id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	/**
	 * @param id_product the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
		return "Category [id=" + id + ", libelle=" + libelle +  ", version="
				+ version + "]";
	}
}
