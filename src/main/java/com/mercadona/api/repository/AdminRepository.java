/**
 * 
 */
package com.mercadona.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadona.api.model.Admin;

/**
 * @author 2kalm
 *
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
