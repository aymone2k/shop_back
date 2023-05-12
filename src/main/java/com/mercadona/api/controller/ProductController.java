/**
 * 
 */
package com.mercadona.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mercadona.api.model.Product;
import com.mercadona.api.repository.ProductRepository;
import com.mercadona.api.service.ResourceNotFoundException;

import jakarta.validation.Valid;

/**
 * @author 2kalm
 * @return creer, read , update un produit
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	/**
	 * @param <Object>
	 * @param entity
	 * @return création d'un produit
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	@CrossOrigin
	@PostMapping("/")
	public ResponseEntity<Object> create(@RequestBody Product product) {
		if(!this.productRepo.existsById(product.getId_product())) {
			this.productRepo.save(product);
			return new ResponseEntity<Object>(null, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	
	/**
	 * @return la liste des products
	 * @see org.springframework.data.repository.ListCrudRepository#findAll()
	 */
	@CrossOrigin
	@GetMapping("/")
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	/**
	 * @param id
	 * @return l'product suivant son ID
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@CrossOrigin
	@GetMapping("/{id}")
	public Product findById(@PathVariable Integer id) {
		return productRepo.findById(id).get();
	}

	
	
	
	/**
	 * @param id
	 * @return modifie le product suivant son ID
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer productId,
			@Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + productId));

		product.setCategory(productDetails.getCategory());
		product.setDescription(productDetails.getDescription());
		product.setImage(productDetails.getImage());
		product.setLibelle(productDetails.getLibelle());
		product.setPrix(productDetails.getPrix());
		product.setPromotion(productDetails.getPromotion());
		
		final Product updatedproduct = productRepo.save(product);
		return ResponseEntity.ok(updatedproduct);
	}
	
	
	/**
	 * @param id
	 * @return supression de product suivant son ID
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@CrossOrigin
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteproduct(@PathVariable(value = "id") Integer productId)
			throws ResourceNotFoundException {
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + productId));

		productRepo.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	/**
	 * @param id
	 * @return affiche le product par prix croissant
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@CrossOrigin
	@GetMapping("/prixasc")
	public List<Product> prixasc(){
		return productRepo.findAllByOrderPrixAsc();
	}	
	
	/**
	 * @param id
	 * @return affiche le product par prix décroissant
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@CrossOrigin
	@GetMapping("/prixdesc")
	public List<Product> prixdesc(){
		return productRepo.findAllByOrderPrixDesc();
	}
	
	/**
	 * @param id
	 * @return affiche le product suivant un mot recherché
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@CrossOrigin
	@GetMapping("/findbydesc/{str}")
	public List<Product> desc(@PathVariable String str){
		return productRepo.findByDescriptionContainingOrLibelleContaining(str, str);
	}
	
	/**
	 * @param id
	 * @return affiche le product suivant un prix compris entre 2 fourchettes
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@CrossOrigin
	@GetMapping("/findbyprix/{min}/{max}")
	public List<Product> prix(@PathVariable int min, @PathVariable int max){
		return productRepo.findByPrixBetween(min, max);
	}
	
	/**
	 * @param id
	 * @return affiche tous les products par ordre croissant
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@CrossOrigin
	@GetMapping("/findallasc/{min}/{max}")
	public List<Product> m1(){
		return productRepo.findAllByOrderByLibelleAsc();
	}
	
	/**
	 * @param id
	 * @return affiche tous les products par ordre décroissant
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@CrossOrigin
	@GetMapping("/findalldesc/{min}/{max}")
	public List<Product> m2(){
		return productRepo.findAllByOrderByLibelleDesc();
	}
}
