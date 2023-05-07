/**
 * 
 */
package com.mercadona.api.model;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

/**
 * @author 2kalm
 * @return La table promotion
 */
@Entity
@Table(name="promotion")
public class Promotion {
	private long id_promo;
	private Date date_start;
	private Date date_end;
	private long taux_remise;
	private int prix_remise;
	private Product product;
	private int version;
	/**
	 * 
	 */
	public Promotion() {
	}
	/**
	 * @param id_promo
	 * @param date_start
	 * @param date_end
	 * @param taux_remise
	 * @param prix_remise
	 * @param products
	 */
	public Promotion(long id_promo, Date date_start, Date date_end, long taux_remise, int prix_remise,
			Product product) {
		this.id_promo = id_promo;
		this.date_start = date_start;
		this.date_end = date_end;
		this.taux_remise = taux_remise;
		this.prix_remise = prix_remise;
		this.product = product;
	}
	/**
	 * @return the id_promo
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId_promo() {
		return id_promo;
	}
	/**
	 * @param id_promo the id_promo to set
	 */
	public void setId_promo(long id_promo) {
		this.id_promo = id_promo;
	}
	/**
	 * @return the date_start
	 * @return la date de début de promotion
	 */
	public Date getDate_start() {
		return date_start;
	}
	/**
	 * @param date_start the date_start to set
	 */
	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}
	/**
	 * @return the date_end
	 * @return la date de fin de promotion
	 */
	public Date getDate_end() {
		return date_end;
	}
	/**
	 * @param date_end the date_end to set
	 */
	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}
	/**
	 * @return the taux_remise
	 * 
	 */
	public long getTaux_remise() {
		return taux_remise;
	}
	/**
	 * @param taux_remise the taux_remise to set
	 */
	public void setTaux_remise(long taux_remise) {
		this.taux_remise = taux_remise;
	}
	/**
	 * @return the prix_remise
	 * @return le prix remisé valable durant la période de promotion = prix de l'article *((100-taux_remise)%)
	 */
	public int getPrix_remise() {
		return prix_remise;
	}
	/**
	 * @param prix_remise the prix_remise to set
	 */
	public void setPrix_remise(int prix_remise) {
		this.prix_remise = prix_remise;
	}
	/**
	 * @return the products
	 * relation OneToOne bidirectionnelle
	 */
	@OneToOne(mappedBy = "promotion",
			cascade=CascadeType.ALL
			)
	@JsonIgnore
	public Product getProduct() {
		return product;
	}
	/**
	 * @param products the products to set
	 */
	public void setProduct(Product product) {
		this.product = product;
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
