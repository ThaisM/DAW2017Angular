package es.urjc.code.practica.offers;

import com.fasterxml.jackson.annotation.JsonView;

import es.urjc.code.practica.product.Product;
import es.urjc.code.practica.product.ProductRestController;
import es.urjc.code.practica.product.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.PostConstruct;

@RestController
public class OffersRestController {

    @Autowired
    private OfferRepository offersRepository;
    
    @Autowired
    private ProductsRepository productRepository;
    
    @PostConstruct
	public void init() {

		productRepository.save(new Product("sunglasses1", "brand1", "model1", "reference1", "gafas de sol","Marca","red", "M", null, null, false, 2.0, 5, "http://placehold.it/350x260", "description1", true));
		productRepository.save(new Product("sunglasses2", "brand2", "model2", "reference2", "gafas de sol","Marca","black", "S", null, null, false, 1.0, 5, "http://placehold.it/350x260", "description2", false));
		productRepository.save(new Product("sunglasses3", "brand3", "model3", "reference3", "gafas de sol", "Marca","blue", "XL", null, null, false, 0.50, 5, "http://placehold.it/350x260", "description3", false));
		productRepository.save(new Product("sunglasses4", "brand4", "model4", "reference4", "gafas de sol", "Marca","red", "M", null, null, false, 4.50, 5, "http://placehold.it/350x260", "description4", true));
		productRepository.save(new Product("sunglasses5", "brand5", "model5", "reference5", "gafas de sol", "Marca","red", "M", null, null, false, 7.50, 5, "http://placehold.it/350x260", "description5", false));
		productRepository.save(new Product("lents6", "brand6", "model6", "reference6", "lentillas", "Diarias", null, null, "0.25", "8.50", false, 3.50, 5, "http://placehold.it/350x260", "description6", true));

		productRepository.save(new Product("lents7", "brand7", "model7", "reference7", "lentillas", "Diarias", null, null," 0.25", "8.50", false, 8.0, 5, "http://placehold.it/350x260", "description7", true));
		productRepository.save(new Product("lents8", "brand8", "model8", "reference8", "lentillas", "Mensuales", null, null, "0.25", "8.50", false, 2.50, 5, "http://placehold.it/350x260", "description8", true));
		productRepository.save(new Product("lents9", "brand9", "model9", "reference9", "lentillas", "Quincenales", null, null, "0.25", "8.50", false, 1.50, 5, "http://placehold.it/350x260", "description9", true));
		productRepository.save(new Product("lents10", "brand10", "model10", "reference10", "lentillas", "Quincenales", null, null, "0.25", "8.50", false, 1.50, 5, "http://placehold.it/350x260", "description10", false));
		productRepository.save(new Product("accesory11", "brand11", "model11", "reference11", "liquidosyaccesorios", "Accesorios", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description11", true));
		productRepository.save(new Product("accesory12", "brand12", "model12", "reference12", "liquidosyaccesorios", "Accesorios", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description12", true));
		productRepository.save(new Product("accesory13", "brand13", "model13", "reference13", "liquidosyaccesorios", "Accesorios", null, null, null, null, false, 2.50, 5, "http://placehold.it/350x260", "description13", true));
		productRepository.save(new Product("accesory14", "brand14", "model14", "reference14", "liquidosyaccesorios", "Accesorios", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description14", false));
		productRepository.save(new Product("accesory15", "brand15", "model15", "reference15", "liquidosyaccesorios", "Accesorios", null, null, null, null, false, 0.70, 5, "http://placehold.it/350x260", "description15", true));
		//Hasta aquí son 11 productos

		//Metemos los siguientes nuevos para probar la paginación

		productRepository.save(new Product("accesory16", "brand11", "model11", "reference11", "liquidosyaccesorios", "Accesorios", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description11", false));
		productRepository.save(new Product("accesory17", "brand12", "model12", "reference12", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description12", false));
		productRepository.save(new Product("accesory18", "brand13", "model13", "reference13", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description13", false));
		productRepository.save(new Product("accesory19", "brand14", "model14", "reference14", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description14", false));
		productRepository.save(new Product("accesory20", "brand15", "model15", "reference15", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description15", false));
		productRepository.save(new Product("accesory21", "brand11", "model11", "reference11", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description11",false));
		productRepository.save(new Product("accesory22", "brand12", "model12", "reference12", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description12", false));
		productRepository.save(new Product("accesory23", "brand13", "model13", "reference13", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description13", false));
		productRepository.save(new Product("accesory24", "brand14", "model14", "reference14", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description14", false));
		productRepository.save(new Product("accesory25", "brand15", "model15", "reference15", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description15", false));
		productRepository.save(new Product("accesory26", "brand11", "model11", "reference11", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description11", false));
		productRepository.save(new Product("accesory27", "brand12", "model12", "reference12", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description12", false));
		productRepository.save(new Product("accesory28", "brand13", "model13", "reference13", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description13", false));
		productRepository.save(new Product("accesory29", "brand14", "model14", "reference14", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description14", false));
		productRepository.save(new Product("accesory30", "brand15", "model15", "reference15", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 1.50, 5, "http://placehold.it/350x260", "description15", false));

		Product productOffer1 = new Product("ONE DAY ACUVUE MOIST 30 UNIDADES",
				"Acuvue","model1","reference1","lentillas","Quincenales","bluecolor",
				"noSize","noSpherePredef","noRadioPredef",false,19.34,5,"http://placehold.it/350x260",
				"Referencia: LA3 " + "\n" + "Lente de contacto de hidrogel. El componente usado en su fabricación es altamente hidratante y aporta gran comodidad a lo largo del día."
						+ " Contiene filtro UV. Cada caja contiene 30 unidades.", true);
		Product productOffer2 = new Product("RAY BAN 4165 601/71 55",
				"rayban","model1","reference1","gafas de sol","Marca","redcolor",
				"medium","0","0",false,
				61.60,5,"http://placehold.it/350x260",
				"Referencia: 21006065 ", true);

		Product productOffer3 = new Product("LIMPIA GAFAS AROMA MANZANA",
				"visionlynx","model1","reference1","liquidosyaccesorios", "Liquidos","nocolor",
				"nosize","0","0",false,
				3.20,5,"http://placehold.it/350x260",
				"Referencia: 21006067 ", true);

		productRepository.save(productOffer1);

		productRepository.save(productOffer2);

		productRepository.save(productOffer3);

		Offer offer1 = new Offer(productOffer1);
		Offer offer2 = new Offer(productOffer2);
		Offer offer3 = new Offer( productOffer3);


		offersRepository.save(offer1);
		offersRepository.save(offer2);
		offersRepository.save(offer3);
		
	}

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
