package es.urjc.code.practica.shoppingcart;

import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderCartRepository extends JpaRepository<OrderCart, Long>{
	
	OrderCart findById (long id);
	
	OrderCart findByName (String productname); 
	
	OrderCart findByPrice (Double price);

}
