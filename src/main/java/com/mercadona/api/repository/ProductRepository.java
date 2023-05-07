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
	
	//List<Product> findByCategoryProducts();
	//findByLastname(String lastname);
//voir si je peux retourner les 
}
