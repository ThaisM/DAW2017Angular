package es.urjc.code.practica.product;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import es.urjc.code.practica.images.Image;
import es.urjc.code.practica.images.ImageRepository;
import es.urjc.code.practica.user.UserComponent;

@Controller
public class ProductController {
	
	@Autowired
	private ProductsRepository repository;
	
	
	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private UserComponent userComponent;
	
	private static final String FILES_FOLDER = "files";
	
	@PostConstruct
	public void init() {
		repository.save(new Product("sunglasses1", "brand1", "model1", "reference1", "type1", "red", "M", null, null, false, 0.50, 5, "/files/product1.jpg", "description1"));
		repository.save(new Product("sunglasses2", "brand2", "model2", "reference2", "type1", "black", "S", null, null, false, 0.50, 5, "/files/product2.jpg", "description2"));
		repository.save(new Product("sunglasses3", "brand3", "model3", "reference3", "type1", "blue", "XL", null, null, false, 0.50, 5, "/files/product3.jpg", "description3"));
		repository.save(new Product("sunglasses4", "brand4", "model4", "reference4", "type1", "red", "M", null, null, false, 0.50, 5, "/files/product4.jpg", "description4"));
		repository.save(new Product("sunglasses5", "brand5", "model5", "reference5", "type5", "red", "M", null, null, false, 0.50, 5, "/files/product5.jpg", "description5"));
		repository.save(new Product("lents6", "brand6", "model6", "reference6", "type2", null, null, "0.25", "8.50", false, 0.50, 5, "/files/product6.jpg", "description6"));
		
		//repository.save(new Product("lents7", "brand7", "model7", "reference7", "type2", null, null, 0.25, 8.50, false, 0.50, 5, "/files/product7.jpg", "description7"));
		//repository.save(new Product("lents8", "brand8", "model8", "reference8", "type2", null, null, 0.25, 8.50, false, 0.50, 5, "/files/product8.jpg", "description8"));
		//repository.save(new Product("lents9", "brand9", "model9", "reference9", "type2", null, null, 0.25, 8.50, false, 0.50, 5, "/files/product9.jpg", "description9"));
		//repository.save(new Product("lents10", "brand10", "model10", "reference10", "type2", null, null, 0.25, 8.50, false, 0.50, 5, "/files/product10.jpg", "description10"));
		repository.save(new Product("accesory11", "brand11", "model11", "reference11", "type3", null, null, null, null, false, 0.50, 5, "/files/product11.jpg", "description11"));
		repository.save(new Product("accesory12", "brand12", "model12", "reference12", "type3", null, null, null, null, false, 0.50, 5, "/files/product12.jpg", "description12"));
		repository.save(new Product("accesory13", "brand13", "model13", "reference13", "type3", null, null, null, null, false, 0.50, 5, "/files/product13.jpg", "description13"));
		repository.save(new Product("accesory14", "brand14", "model14", "reference14", "type3", null, null, null, null, false, 0.50, 5, "/files/product14.jpg", "description14"));
		repository.save(new Product("accesory15", "brand15", "model15", "reference15", "type3", null, null, null, null, false, 0.50, 5, "/files/product15.jpg", "description15"));
	    //Hasta aquí son 11 productos
		
		//Metemos los siguientes nuevos para probar la paginación
		
		repository.save(new Product("accesory16", "brand11", "model11", "reference11", "type3", null, null, null, null, false, 0.50, 5, "/files/product11.jpg", "description11"));
		repository.save(new Product("accesory17", "brand12", "model12", "reference12", "type3", null, null, null, null, false, 0.50, 5, "/files/product12.jpg", "description12"));
		repository.save(new Product("accesory18", "brand13", "model13", "reference13", "type3", null, null, null, null, false, 0.50, 5, "/files/product13.jpg", "description13"));
		repository.save(new Product("accesory19", "brand14", "model14", "reference14", "type3", null, null, null, null, false, 0.50, 5, "/files/product14.jpg", "description14"));
		repository.save(new Product("accesory20", "brand15", "model15", "reference15", "type3", null, null, null, null, false, 0.50, 5, "/files/product15.jpg", "description15"));
		repository.save(new Product("accesory21", "brand11", "model11", "reference11", "type3", null, null, null, null, false, 0.50, 5, "/files/product11.jpg", "description11"));
		repository.save(new Product("accesory22", "brand12", "model12", "reference12", "type3", null, null, null, null, false, 0.50, 5, "/files/product12.jpg", "description12"));
		repository.save(new Product("accesory23", "brand13", "model13", "reference13", "type3", null, null, null, null, false, 0.50, 5, "/files/product13.jpg", "description13"));
		repository.save(new Product("accesory24", "brand14", "model14", "reference14", "type3", null, null, null, null, false, 0.50, 5, "/files/product14.jpg", "description14"));
		repository.save(new Product("accesory25", "brand15", "model15", "reference15", "type3", null, null, null, null, false, 0.50, 5, "/files/product15.jpg", "description15"));
		repository.save(new Product("accesory26", "brand11", "model11", "reference11", "type3", null, null, null, null, false, 0.50, 5, "/files/product11.jpg", "description11"));
		repository.save(new Product("accesory27", "brand12", "model12", "reference12", "type3", null, null, null, null, false, 0.50, 5, "/files/product12.jpg", "description12"));
		repository.save(new Product("accesory28", "brand13", "model13", "reference13", "type3", null, null, null, null, false, 0.50, 5, "/files/product13.jpg", "description13"));
		repository.save(new Product("accesory29", "brand14", "model14", "reference14", "type3", null, null, null, null, false, 0.50, 5, "/files/product14.jpg", "description14"));
		repository.save(new Product("accesory30", "brand15", "model15", "reference15", "type3", null, null, null, null, false, 0.50, 5, "/files/product15.jpg", "description15"));
	
		
		//Guardamos producto ejemplo para mostrar las lentillas
		repository.save(new Product("ONE DAY ACUVUE MOIST 30 UNIDADES",
				                    "Acuvue","model1","reference1","30_uds","bluecolor",
				                    "noSize","noSpherePredef","noRadioPredef",false,
				                    19.34,5,"/files/acuvue.jpg",
				                    "Referencia: LA3 " + "\n" + "Lente de contacto de hidrogel. El componente usado en su fabricación es altamente hidratante y aporta gran comodidad a lo largo del día. Contiene filtro UV. Cada caja contiene 30 unidades."
				                    ));
		
		//SEGUNDO EJEMPLO: RAY BAN 4165 601/71 55
		repository.save(new Product("RAY BAN 4165 601/71 55",
                "rayban","model1","reference1","1_uds","redcolor",
                "medium",null,null,false,
                61.50,5,"/files/rayban.jpg",
                "Referencia: 21006065 "));
		
	}
   
	// VIEW
	/*@RequestMapping("/admin/products/")
	public String productList(Model model) {

		model.addAttribute("products", repository.findAll());
		

		return "admin_product_list";
	} */
	
	//NEW
	//Añadir un producto como Administrador	

		@RequestMapping(value="/admin/add/", method = RequestMethod.POST)
		//@RequestMapping(value = "/image/upload", method = RequestMethod.POST)
		public String ProductAdd(Model model, 
				@RequestParam("imageTitle") String imageTitle,
				@RequestParam("file") MultipartFile file, Product product) throws IllegalStateException, IOException {
			
			//TITULO DE LA IMAGEN
			String imageName = imageTitle + ".jpg";
			
			//SI SE HA SELECCIONADO LA FOTO
			if (!file.isEmpty()) {
					//Insertamos la imagen en la carpeta files
				File filesFolder = new File(FILES_FOLDER);
				if (!filesFolder.exists()) {
					filesFolder.mkdirs();
				}
				
				File uploadedFile = new File(filesFolder.getAbsolutePath(), imageName);
				file.transferTo(uploadedFile);
					
				Image image = new Image(imageName, filesFolder.getPath());
				imageRepository.save(image); 	
				product.setImage("//"+filesFolder.getPath()+"/"+imageName);
			}
			repository.save(product);
			return "product_added";	
			
		}
		
	
	
		
 
		@RequestMapping(value="/admin/edit/{id}", method = RequestMethod.POST)
		public String editProduct(Model model, @PathVariable long id, 
				Product productupdated,
				@RequestParam("imageTitle") String imageTitle, 
				@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
			
			
	    	
			if (repository.exists(id)){
				
				Product producto = repository.findOne(id);
				
				producto.setBrand(productupdated.getBrand());
				producto.setColour(productupdated.getColour());
				producto.setDescription(productupdated.getDescription());
				producto.setModel(productupdated.getModel());
				producto.setName(productupdated.getName());
				producto.setPrice(productupdated.getPrice());
				producto.setPublished(productupdated.getPublished());
				producto.setQuantity(productupdated.getQuantity());
				producto.setRadio(productupdated.getRadio());
				
				
				//imagen//
				
				//TITULO DE LA IMAGEN
				
				String imagen = productupdated.getImage();
				
				System.out.println("imagen");
				
				String imageName = imageTitle + ".jpg";
				
				//SI SE HA SELECCIONADO LA FOTO
				if (!file.isEmpty()) {
						//Insertamos la imagen en la carpeta files
					File filesFolder = new File(FILES_FOLDER);
					if (!filesFolder.exists()) {
						filesFolder.mkdirs();
					}
					
					File uploadedFile = new File(filesFolder.getAbsolutePath(), imageName);
					file.transferTo(uploadedFile);
						
					Image image = new Image(imageName, filesFolder.getPath());
					imageRepository.save(image); 	
					productupdated.setImage("/"+filesFolder.getPath()+"/"+imageName);
					producto.setImage(productupdated.getImage());
				//fin imagen//
				}

				producto.setReference(productupdated.getReference());
				producto.setSize(productupdated.getSize());
				producto.setSphere(productupdated.getSphere());
				producto.setType(productupdated.getType());
				
				
				repository.save(producto);
			}
			return "product_updated";
			
		}
		
		
		
	
	@RequestMapping(value = "/admin/product/delete/{id}")
	public String deleteProduct(@PathVariable long id) {

		if (repository.exists(id)) {
			repository.delete(id);
			return "product_deleted";
		}
		return "/admin";
	}
}

