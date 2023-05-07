/**
 * 
 */
package com.mercadona.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadona.api.model.Admin;
import com.mercadona.api.repository.AdminRepository;

/**
 * @author 2kalm
 * @return creer, read un admin
 */

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepo;

	/**
	 * @param <Object>
	 * @param entity
	 * @return création d'un admin
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody Admin admin) {
		if(!this.adminRepo.existsById(admin.getId())) {
			this.adminRepo.save(admin);
			return new ResponseEntity<Object>(null, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}
		
	}

	/**
	 * @return la liste des admin
	 * @see org.springframework.data.repository.ListCrudRepository#findAll()
	 */
	@CrossOrigin
	@GetMapping("/all")
	public List<Admin> findAll() {
		return adminRepo.findAll();
	}

	/**
	 * @param id
	 * @return l'admin suivant son ID
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@CrossOrigin
	@GetMapping("/{id}")
	public Admin findById(@PathVariable Integer id) {
		return adminRepo.findById(id).get();
	}

		
	

}
