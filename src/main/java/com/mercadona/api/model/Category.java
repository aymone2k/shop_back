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
	private long id_category;
	private String libelle;
	private Collection<Product> products;
	private int version;
	/**
	 * 
	 */
	public Category() {
	}
	/**
	 * @param id_category
	 * @param libelle
	 * @param products
	 */
	public Category(long id_category, String libelle, Collection<Product> products) {
		this.id_category = id_category;
		this.libelle = libelle;
		this.products = products;
	}

	/**
	 * @return the id_category
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId_category() {
		return id_category;
	}
	
	/**
	 * @param id_product the id_category to set
	 */
	public void setId_category(long id_category) {
		this.id_category = id_category;
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
	 * @return the products
	 * @return une category est composée d'1 à plusieurs produits, mais un seul produit par category
	 */
	@OneToMany
	@JsonIgnore
	public Collection<Product> getProducts() {
		return products;
	}
	
	/**
	 * @param products the products to set
	 */
	public void setProducts(Collection<Product> products) {
		this.products = products;
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
		return "Category [id_category=" + id_category + ", libelle=" + libelle + ", products=" + products + ", version="
				+ version + "]";
	}
}
