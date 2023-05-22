/**
 * 
 */
package com.mercadona.api.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

/**
 * @author 2kalm
 * @return La table promotion, relation OneTOne unidirectionnelle entre propotion et produit
 */
@Entity
@Table(name="promotion")
public class Promotion {
	private int id;
	@Temporal(TemporalType.DATE)
	private Date date_start;
	@Temporal(TemporalType.DATE)
	private Date date_end;
	private int taux_remise;
	private Product product;

	private int version;
	/**
	 * 
	 */
	public Promotion() {
	}
		
	/**
	 * @param id
	 * @param date_start
	 * @param date_end
	 * @param taux_remise
	 * @param product
	 * @param version
	 */
	public Promotion(int id, Date date_start, Date date_end, int taux_remise, Product product, int version) {
		this.id = id;
		this.date_start = date_start;
		this.date_end = date_end;
		this.taux_remise = taux_remise;
	this.product=product;
		this.version = version;
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
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	public int getTaux_remise() {
		return taux_remise;
	}
	/**
	 * @param taux_remise the taux_remise to set
	 */
	public void setTaux_remise(int taux_remise) {
		this.taux_remise = taux_remise;
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
