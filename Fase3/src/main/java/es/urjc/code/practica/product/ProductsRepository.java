package es.urjc.code.practica.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductsRepository extends JpaRepository<Product, Long>{

	Product findByName (String name);
	
	Product findByBrand (String brand);
	
	Product findByModel (String model);
	
	Product findByReference (String reference);
	
	Product findByImage (String image);
	
	
    

}
