/**
 * 
 */
package com.mercadona.api.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mercadona.api.model.Product;
import com.mercadona.api.model.Promotion;
import com.mercadona.api.repository.ProductRepository;
import com.mercadona.api.service.ProductService;
import com.mercadona.api.service.ResourceNotFoundException;

import jakarta.validation.Valid;

/**
 * @author 2kalm
 * @return creer, read , update un produit
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	 @Autowired
	 private PromotionController promoCtrl;
	 
	 @Autowired
	 private ProductService productSrv; 
	
	 
	
	/**
	 * @param <Object>
	 * @param entity
	 * @return création d'un produit
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	@PostMapping("/V1")
	public ResponseEntity<Object> createV1(@RequestBody Product product) {
		if(!this.productRepo.existsById(product.getId())) {
			productSrv.saveProductToDBV2(product);
			return new ResponseEntity<Object>(product, HttpStatus.CREATED);
		}else {
			
			return new ResponseEntity<Object>(product, HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	
	/**
	 * @param <Object>
	 * @param entity
	 * @return création d'un produit
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	@CrossOrigin
	@PostMapping("/V2")
	public String createV2( @RequestParam("image") MultipartFile file, @RequestParam("libelle") String libelle, @RequestParam("description") String description, @RequestParam("prix") String prix, @RequestParam("categorieId") String categorieId) throws NumberFormatException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		productSrv.saveProductToDBV3(file, libelle, description, Double.parseDouble(prix), Integer.parseInt(categorieId));
		return "produit crée";
	}
	
		
	/**
	 * @param <Object>
	 * @param entity
	 * @return création d'un produit
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	@CrossOrigin
	@PostMapping("/V3")
	public String createV3( @RequestParam("image") MultipartFile file, @RequestParam("libelle") String libelle, @RequestParam("description") String description, @RequestParam("prix") String prix, @RequestParam("categorieId") String categorieId, @RequestParam("promotion_tx") String taux,@RequestParam("promotion_Date1") String date1,@RequestParam("promotion_Date2") String date2) throws NumberFormatException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		productSrv.saveProductToDB(file, libelle, description, Double.parseDouble(prix), Integer.parseInt(categorieId), Integer.parseInt(taux), dateFormat.parse(date1), dateFormat.parse(date2) );
		return "produit crée";
	}
	
	
	
	
	/**
	 * @return la liste des products
	 * @see org.springframework.data.repository.ListCrudRepository#findAll()
	 */
	@CrossOrigin(origins ="http://localhost:4200")
	@GetMapping("/")
	public List<Product> findAll() {
		System.out.println(productRepo.findAll());
		return productRepo.findAll();
	}

	/**
	 * @param id
	 * @return l'product suivant son ID
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id) {
		return productRepo.findById(id).get();
		
		
	}

	
   @GetMapping("/image/{img}")
    public byte[] getProductImageV2(@PathVariable String img) {
        return productRepo.findByImage(img);
       
        
     //   HttpHeaders headers = new HttpHeaders();
       // headers.setContentType(MediaType.IMAGE_JPEG); // Remplacez par le type MIME approprié pour votre image
        //headers.setContentType(MediaType.IMAGE_PNG);
        //return new ResponseEntity<>(product, headers, HttpStatus.OK);
    }
	
	
	/**
	 * @param id
	 * @return modifie le product suivant son ID et la promotion passé en paramètre
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	/**@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct2(@PathVariable(value = "id") int productId,
			@Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + productId));

		product.setCategorieId(productDetails.getCategorieId());
		product.setDescription(productDetails.getDescription());
		product.setImage(productDetails.getImage());
		product.setLibelle(productDetails.getLibelle());
		product.setPrix(productDetails.getPrix());
		
		
		
		if(product.getPromotion() != null) {
			product.setPromotion(productDetails.getPromotion());
		}else {
			//update promo
			
			// puis update product
			promoCtrl.updatePromo(product.getPromotion().getId(), productDetails.getPromotion());
			
		}
		
		final Product updatedproduct = productRepo.save(product);
		return ResponseEntity.ok(updatedproduct);
	}*/
	
	/**
	 * @param id
	 * @return supression de product suivant son ID
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteproduct(@PathVariable(value = "id") Integer productId)
			throws ResourceNotFoundException {
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + productId));

		productRepo.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		
		// voir pour delete la promotion en meme temps
	}
	
	
	/**
	 * @param id
	 * @return affiche le product par prix croissant
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@GetMapping("/prixasc")
	public List<Product> prixasc(){
		return productRepo.findAllByOrderByPrixAsc();
	}	
	
	/**
	 * @param id
	 * @return affiche le product par prix décroissant
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@GetMapping("/prixdesc")
	public List<Product> prixdesc(){
		return productRepo.findAllByOrderByPrixDesc();
	}
	
	/**
	 * @param id
	 * @return affiche le product suivant un mot recherché
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@GetMapping("/findbydesc/{str}")
	public List<Product> desc(@PathVariable String str){
		return productRepo.findByDescriptionContainingOrLibelleContainingIgnoreCase(str, str);
	}
	
	/**
	 * @param id
	 * @return affiche le product suivant un prix compris entre 2 fourchettes
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@GetMapping("/findbyprix/{min}/{max}")
	public List<Product> prix(@PathVariable int min, @PathVariable int max){
		return productRepo.findByPrixBetween(min, max);
	}
	
	/**
	 * @param id
	 * @return affiche tous les products par ordre alphabetique
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@GetMapping("/findallasc")
	public List<Product> m1(){
		return productRepo.findAllByOrderByLibelleAsc();
	}
	
	/**
	 * @param id
	 * @return affiche tous les products par ordre déalphabethique
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@GetMapping("/findalldesc")
	public List<Product> m2(){
		return productRepo.findAllByOrderByLibelleDesc();
	}
}
