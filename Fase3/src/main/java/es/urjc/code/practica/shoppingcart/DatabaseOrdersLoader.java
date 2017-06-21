package es.urjc.code.practica.shoppingcart;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class DatabaseOrdersLoader {

	@Autowired 
	private OrderSummaryRepository repository;
	
	@Autowired 
	private OrderCartRepository cartrepository;
	
	@PostConstruct
	private void init() {
		
		/*
		 * String name, Double price, Integer quantity, String size, String sphere,
			String radio, String diameter, String eye
			
			Order Cart
		 */

		OrderCart c1= new OrderCart ("name1",20.4,1,"size1","0","0","0","0");
		OrderCart c2= new OrderCart ("name2",20.4,1,"size1","0","0","0","0");
		OrderCart c3= new OrderCart ("name3",20.4,1,"size1","0","0","0","0");
		OrderCart c4= new OrderCart ("name3",20.4,1,"size1","0","0","0","0");
		OrderCart c5= new OrderCart ("name3",20.4,1,"size1","0","0","0","0");
		OrderCart c6= new OrderCart ("name3",20.4,1,"size1","0","0","0","0");
		
		
		cartrepository.saveAndFlush(c1);
		cartrepository.saveAndFlush(c2);
		cartrepository.saveAndFlush(c3); 
		
		cartrepository.saveAndFlush(c4);
		cartrepository.saveAndFlush(c5);
		cartrepository.saveAndFlush(c6);
	
		
		OrderSummary order1 = new OrderSummary ("order1","user1","paymentcard1");
		OrderSummary order2 = new OrderSummary ("order2","user2","paymentcard2");
		OrderSummary order3 = new OrderSummary ("order3","user3","paymentcard2");
		OrderSummary order4 = new OrderSummary ("order4","user4","paymentcard2");
		
		order1.getOrder().add(c1);
		order2.getOrder().add(c2);
		order2.getOrder().add(c3);
		
		order3.getOrder().add(c4);
		order3.getOrder().add(c5);
		
		order4.getOrder().add(c6);
		
		repository.save(order1);
		repository.save(order2);
		
		repository.save(order3);
		repository.save(order4);
/*		
		Player p1 = new Player("Torres", 10);
		Player p2 = new Player("Iniesta", 10);
		
		playerRepository.save(p1);
		playerRepository.save(p2);
		
		Team team = new Team("Selección", 1);
		
		team.getPlayers().add(p1);
		team.getPlayers().add(p2);

		teamRepository.save(team);*/
		
		
		
	}
	
}
