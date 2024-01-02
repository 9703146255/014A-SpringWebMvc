package in.thiru.service;

import java.util.List;

import in.thiru.entity.Products;

public interface IProductService {
	
	List<Products> getAllProducts();
	
	 boolean saveProducts(Products products);
	 void deleteProducts(Integer productId);
	 
	 
	 public Products getProductsById(Integer productId);

}
