package es.urjc.code.practica.offers;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
 
    Offer findById(Long id);

}
