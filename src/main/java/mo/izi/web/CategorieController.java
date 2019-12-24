package mo.izi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mo.izi.dao.CategoryRepository;
import mo.izi.dao.ProductRepository;
import mo.izi.entities.Category;
import mo.izi.entities.Product;

@RestController
public class CategorieController {
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/categoryByKeyWord/{name}")
	public Category findCategorieByKeyWord(@PathVariable("name") String name) {
		return categoryRepository.findByNameIgnoreCaseContains(name);
	}

	@PostMapping("/addProductTocategory")
	public void addProductToCategory(@RequestBody RegisterProduct registerProduct) {
		Category category = categoryRepository.findByNameIgnoreCaseContains(registerProduct.getCategory());
		Product product = new Product();
		product.setDesignation(registerProduct.getDesignation());
		product.setPrice(registerProduct.getPrice());
		product.setCategory(category);
		productRepository.save(product);
		category.getProducts().add(product);
		categoryRepository.save(category);
	}
}
