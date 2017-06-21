package es.urjc.code.practica.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import es.urjc.code.practica.images.Image;
import es.urjc.code.practica.images.ImageRepository;
import es.urjc.code.practica.user.User;

@RestController
public class ProductRestController {
	
	interface ProductView extends Product.ProductAttribute{};
	
	@Autowired
	private ProductsRepository repository;
	
	@Autowired
	private ImageRepository imageReporsitory;
	
	private static final String FILES_FOLDER = "files";
	
	
	@JsonView(ProductView.class)
	@RequestMapping(value = "/api/products/", method= RequestMethod.GET)
	public List<Product> getProductsPage(Pageable page){
		
		/*
		//This System.out print all the size of my repository
		System.out.println(this.repository.findAll().size());
		//This for print the name for my 20 first objects
		for(Product v:this.repository.findAll(page)){
			System.out.println(v.getName());
		}
		// This print 20
		System.out.println(this.repository.findAll(page).getSize());
		//This print the page number = 0 
		System.out.println(page.getPageNumber());
		//This print the page size = 20 
		System.out.println(page.getPageSize());
		
		
		Integer seconds = 2;
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		}
		*/
		
		List<Product> listProducts = repository.findAll(page).getContent();
		return listProducts;
	}
	

	@RequestMapping(value = "/api/products/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product product) {

		repository.save(product);
		return product;
	}
	
	@RequestMapping(value = "/api/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable long id) {

		Product product = repository.findOne(id);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	@RequestMapping(value = "/api/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product updateProduct) {

		Product product = repository.findOne(id);
		if (product != null) {

			updateProduct.setId(id);
			repository.save(updateProduct);

			return new ResponseEntity<>(updateProduct, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}

	@RequestMapping(value = "/api/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteProduct(@PathVariable long id) {

		repository.delete(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/product/{name}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductByName(@PathVariable String name) {

		Product product = repository.findByName(name);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}

