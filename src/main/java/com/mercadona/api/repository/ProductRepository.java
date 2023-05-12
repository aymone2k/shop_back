/**
 * 
 */
package com.mercadona.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadona.api.model.Product;

/**
 * @author 2kalm
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	/**
	 * @ return les produits composés de mots identiques aux mot passé en paramettre, qu'ils soient dans la drescription, le libellé 
	 */
	public List<Product> findByDescriptionContainingOrLibelleContaining(String chaine, String str);
	public List<Product> findByPrixBetween(double min, double max);
	public List<Product> findAllByOrderPrixAsc();
	public List<Product> findAllByOrderPrixDesc();
	public List<Product> findByPrixLessThan(double valeur);
	public List<Product> findAllByOrderByLibelleAsc();
	public List<Product> findAllByOrderByLibelleDesc();
	

}
