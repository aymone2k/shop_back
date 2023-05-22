package com.mercadona.api.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

/**
 * 
 */


/**
 * @author 2kalm
 * @return La table produits
 */
@Entity
@Table(name = "Product")
public class Product {
	private int id;
	private String libelle;
	private String description;
	private double prix;
	private int categorieId;
	
	private Promotion promotion;
	@Lob
	@Column(columnDefinition = "bytea")
    private byte[] image;
	
	private int version;
	/**
	 * 
	 */
	public Product() {
	}
	/**
	 * @param id
	 * @param libelle
	 * @param description
	 * @param prix
	 * @param promotion
	 * @param category
	
	 * @param image
	 * 
	 */
	public Product(int id, String libelle, String description, double prix, int categorieId,
			Promotion promotion, byte[] image) {
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.prix = prix;
	
		this.categorieId = categorieId;
		this.promotion = promotion;
		this.image = image;
		
	}
	/**
	 * @return the id_product
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	/**
	 * @param id_product the id_product to set
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
	 * @return the categorieId
	 * @return en créant un produit , on ne cré pas de nouvelle catégorie
	 * @return il peut avoir 1 à plusieurs produits pour 1 category = liaison ManyToOne, mais un seul produit par category 
	 */
	public int getCategorieId() {
		return categorieId;
	}
	/**
	 * @param categorieId2 the categorieId to set
	 */
	public void setCategorieId(int categorieId) {
		this.categorieId = categorieId;
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
	 * @return 
	 */
	public byte[] getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
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
