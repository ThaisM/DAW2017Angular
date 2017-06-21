package es.urjc.code.practica.shoppingcart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderSummaryRepository extends JpaRepository<OrderSummary, Long>{
	
	OrderSummary findById (long id);
	
	OrderSummary findByOrdername (String ordername); 
	
	OrderSummary findByUser (String user);
	
	//List <OrderSummary> findAll ();


}
