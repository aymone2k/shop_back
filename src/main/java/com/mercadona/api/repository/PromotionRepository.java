/**
 * 
 */
package com.mercadona.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadona.api.model.Promotion;

/**
 * @author 2kalm
 *
 */
@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
	
	

}
