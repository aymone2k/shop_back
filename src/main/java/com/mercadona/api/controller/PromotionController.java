/**
 * 
 */
package com.mercadona.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadona.api.model.Product;
import com.mercadona.api.model.Promotion;
import com.mercadona.api.repository.PromotionRepository;
import com.mercadona.api.service.ResourceNotFoundException;

import jakarta.validation.Valid;

/**
 * @author 2kalm
 * @return 
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/promo")
public class PromotionController {
	@Autowired
	private PromotionRepository promoRepo;
	
	/**
	 * @return la liste des promotions en cours
	 * @see org.springframework.data.repository.ListCrudRepository#findAll()
	 */
	@GetMapping("/")
	public List<Promotion> findAll() {
		return promoRepo.findAll();
	}

	/**
	 * @param id
	 * @return une promotion suivant son ID
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@GetMapping("/{id}")
	public Promotion findById(@PathVariable int id) {
		return promoRepo.findById(id).get();
	}

	/**
	 * @param id
	 * @return modifie la promo suivant son ID
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
/**	@PutMapping("/{id}")
	public ResponseEntity<Promotion> updatePromo(@PathVariable(value = "id") Integer promoId,
			@Valid @RequestBody Promotion promoDetails) throws ResourceNotFoundException {
		Promotion promo = promoRepo.findById(promoId)
				.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + promoId));

		promo.setDate_end(promoDetails.getDate_end());
		promo.setDate_start(promoDetails.getDate_start());
		promo.setTaux_remise(promoDetails.getTaux_remise());
	
		
		final Promotion updatedpromo = promoRepo.save(promo);
		return ResponseEntity.ok(updatedpromo);
	}
*/
}
