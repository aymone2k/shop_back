/**
 * 
 */
package com.mercadona.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadona.api.model.Category;
import com.mercadona.api.model.Product;

/**
 * @author 2kalm
 *
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	public List<Category> findByLibelle(String marque);

}
