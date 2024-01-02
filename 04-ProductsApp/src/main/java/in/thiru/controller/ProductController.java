package in.thiru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.thiru.entity.Products;
import in.thiru.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService pService;

	@GetMapping("/products")
	public ModelAndView getProducts() {

		System.out.println("getProducts() :: method");

		List<Products> allProducts = pService.getAllProducts();
		ModelAndView mav = new ModelAndView();
		mav.addObject("products", allProducts);

		mav.setViewName("index");

		return mav;

	}

	@GetMapping("/addProductsPage")
	public ModelAndView showProductAddPage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("products", new Products());

		System.out.println("showProductAddPage() :: method");
		mav.setViewName("addProductsPage");

		return mav;
	}

	@GetMapping("/edit")
	public ModelAndView editProducts(@RequestParam("productId")  Integer productId, RedirectAttributes redirectAttributes) {
	

		Products productsById = pService.getProductsById(productId);

		if (productsById != null) {
	        // Add the product as a flash attribute for the next request
	        redirectAttributes.addFlashAttribute("products", productsById);

	        // Redirect to the addProductsPage for editing
	        return new ModelAndView("redirect:/addProductsPage");
	    } else {
	        // Handle the case where the product with the given ID is not found
	        // You might want to redirect to an error page or handle it appropriately
	        return new ModelAndView("redirect:/error");
	    }

	}

	@PostMapping("/addProductsPage")
	public ModelAndView saveProduct(Products products) {
		boolean saveProducts = pService.saveProducts(products);
		ModelAndView mav = new ModelAndView();

		if (saveProducts) {
			mav.addObject("successMessage", "Record Saved");
		} else {
			mav.addObject("errorMessage", "Record not saved");
		}

		mav.setViewName("addProductsPage");

		return mav;

	}

	@GetMapping("/delete")
	public ModelAndView deleteProduct(@RequestParam("productId") Integer productId) {

		pService.deleteProducts(productId);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/products");

		return mav;

	}

}
