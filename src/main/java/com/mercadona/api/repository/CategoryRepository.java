/**
 * 
 */
package com.mercadona.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadona.api.model.Category;

/**
 * @author 2kalm
 *
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
