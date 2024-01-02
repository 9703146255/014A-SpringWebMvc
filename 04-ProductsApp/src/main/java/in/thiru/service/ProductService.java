package in.thiru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.thiru.entity.Products;
import in.thiru.repo.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository pRepo;

	@Override
	public List<Products> getAllProducts() {
		return pRepo.findAll();

	}

	@Override
	public boolean saveProducts(Products products) {
		Products save = pRepo.save(products);
		if (save.getProductId() != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void deleteProducts(Integer productId) {

		pRepo.deleteById(productId);

	}

	@Override
	public Products getProductsById(Integer productId) {

		Optional<Products> findById = pRepo.findById(productId);
		
		if(findById.isPresent())
		{
			Products products = findById.get();
		}
		
		
		return null;
	}

}
