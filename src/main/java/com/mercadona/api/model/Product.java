/**
 * 
 */
package com.mercadona.api.model;

import jakarta.persistence.*;

/**
 * @author 2kalm
 * @return La table produits
 */
@Entity
@Table(name = "Product")
public class Product {
	private int id_product;
	private String libelle;
	private String description;
	private double prix;
	private Category category;
	private Promotion promotion;
	private String image;
	private int version;
	/**
	 * 
	 */
	public Product() {
	}
	/**
	 * @param id_product
	 * @param libelle
	 * @param description
	 * @param prix
	 * @param promotion
	 * @param category
	
	 * @param image
	 * 
	 */
	public Product(int id_product, String libelle, String description, double prix, Category category,
			Promotion promotion, String image) {
		this.id_product = id_product;
		this.libelle = libelle;
		this.description = description;
		this.prix = prix;
	
		this.category = category;
		this.promotion = promotion;
		this.image = image;
		
	}
	/**
	 * @return the id_product
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_product() {
		return id_product;
	}
	/**
	 * @param id_product the id_product to set
	 */
	public void setId_product(int id_product) {
		this.id_product = id_product;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return le prix de base du produit
	 */
	public double getPrix() {
		return prix;
	}
	/**
	 * @param d the prix to set
	 */
	public void setPrix(double d) {
		this.prix = d;
	}
	
	/**
	 * @return l' ID_category
	 * @return il peut avoir 1 à plusieurs produits pour 1 category = liaison ManyToOne, mais un seul produit par category 
	 */
	@ManyToOne(
			
			cascade = CascadeType.ALL
	
			)
	@JoinColumn(name="CATEGORY_ID")
	public Category getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	/**
	 * @return l' ID_promotion
	 * @return il ne peut avoir qu'1 produit par promotion = liaison OneToOne 
	 *relation OneToOne bidirectionnelle
	 */
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_promotion")
	public Promotion getPromotion() {
		return promotion;
	}
	/**
	 * @param promotion the promotion to set
	 */
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	/**
	 * @return the image
	 * @return est stocké en base de donnée l'url de l'image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
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
	
	
}
