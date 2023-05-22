package com.mercadona.api.service;

import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mercadona.api.model.Product;
import com.mercadona.api.model.Promotion;
import com.mercadona.api.repository.ProductRepository;
import com.mercadona.api.repository.PromotionRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	private PromotionRepository promoRepo;
	
	public void saveProductToDB(MultipartFile file, String libelle, String description, double prix, int categorieId, int taux, Date date1, Date date2 ) {
		Product p = new Product();
		Promotion pro = new Promotion();
		if(taux!= 0) {
		pro.setDate_end(date1);
		pro.setDate_start(date1);
		pro.setTaux_remise(taux);
		}
		
		System.out.println("top:"+file+"-"+ libelle+"-"+ description+"-"+ prix+"-"+ categorieId +"taux:"+ taux);
		
		p.setLibelle(libelle);
		p.setPrix(prix);
		p.setCategorieId(categorieId); 
		p.setDescription(description);
		p.setPromotion(pro);
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			System.out.println("format image invalide");
		}
	
		try {
			//p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
			p.setImage(file.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(p);
	//	p.setPromotion(null);
	 productRepo.save(p);
	}

	public void saveProductToDBV3(MultipartFile file, String libelle, String description, double prix, int categorieId ) {
		Product p = new Product();
		
		p.setLibelle(libelle);
		p.setPrix(prix);
		p.setCategorieId(categorieId); 
		p.setDescription(description);
		
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			System.out.println("format image invalide");
		}
	
		try {
			//p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
			p.setImage(file.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(p);
	//	p.setPromotion(null);
	 productRepo.save(p);
	}
	
	public void saveProductToDBV2(Product product ) {
		Product p = new Product();
		Promotion pro = new Promotion();
		
		if(product.getPromotion() != null) {
		pro.setDate_end(product.getPromotion().getDate_end());
		pro.setDate_start(product.getPromotion().getDate_start());
		pro.setTaux_remise(product.getPromotion().getTaux_remise());
		}
		 
		p.setLibelle(product.getLibelle());
		p.setPrix(product.getPrix());
		p.setCategorieId(product.getCategorieId()); 
		p.setDescription(product.getDescription());
		p.setPromotion(pro);
		
	 productRepo.save(p);
	}

}
