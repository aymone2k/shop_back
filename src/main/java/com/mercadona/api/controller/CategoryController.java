/**
 * 
 */
package com.mercadona.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadona.api.model.Category;
import com.mercadona.api.repository.CategoryRepository;

/**
 * @author 2kalm
 * @return l'admin doit pouvoir enregistrer des catégories qu'il pourra selectionner lors de la création ou de la modification d'un produit.
 * on ne peut pas modifier ou supprimer une catégorie
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	/**
	 * @param <Object>
	 * @param entity
	 * @return création d'un produit
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	@PostMapping("/")
	public ResponseEntity<Object> create(@RequestBody Category category) {
		if(!this.categoryRepo.existsById(category.getId())) {
			this.categoryRepo.save(category);
			return new ResponseEntity<Object>(category, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Object>(category, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	
	/**
	 * @return la liste des categorys
	 * @see org.springframework.data.repository.ListCrudRepository#findAll()
	 */
	@GetMapping("/")
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}

	/**
	 * @param id
	 * @return l'category suivant son ID
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@GetMapping("/{id}")
	public Category findById(@PathVariable Integer id) {
		return categoryRepo.findById(id).get();
	}
	
	/**
	 * @param id
	 * @return l'category suivant son nom
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@GetMapping("/{str}")
	public List<Category> findByCategory(@PathVariable String str) {
		return categoryRepo.findByLibelle(str);
	}
	
	

}
