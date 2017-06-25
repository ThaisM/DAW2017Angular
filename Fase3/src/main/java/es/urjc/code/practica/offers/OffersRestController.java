package es.urjc.code.practica.offers;

import com.fasterxml.jackson.annotation.JsonView;
import es.urjc.code.practica.product.ProductRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OffersRestController {

    @Autowired
    private OfferRepository offersRepository;

    @RequestMapping(value = "/api/offers/", method= RequestMethod.GET)
    public ResponseEntity<List<Offer>> getOffers(){

        List<Offer> offers = offersRepository.findAll();

        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/offersPage/", method= RequestMethod.GET)
    public ResponseEntity<List<Offer>> getOffersByPage(Pageable page){

        List<Offer> offers = offersRepository.findAll(page).getContent();

        return new ResponseEntity<>(offers, HttpStatus.OK);
    }
}