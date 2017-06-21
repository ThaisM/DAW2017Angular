package es.urjc.code.practica.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
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
		repository.save(new Product("sunglasses1", "brand1", "model1", "reference1", "gafas de sol","Marca","red", "M", null, null, false, 0.50, 5, "producto1", "description1", true));
		repository.save(new Product("sunglasses2", "brand2", "model2", "reference2", "gafas de sol","Marca","black", "S", null, null, false, 0.50, 5, "producto2", "description2", false));
		repository.save(new Product("sunglasses3", "brand3", "model3", "reference3", "gafas de sol", "Marca","blue", "XL", null, null, false, 0.50, 5, "producto3", "description3", false));
		repository.save(new Product("sunglasses4", "brand4", "model4", "reference4", "gafas de sol", "Marca","red", "M", null, null, false, 0.50, 5, "producto4", "description4", true));
		repository.save(new Product("sunglasses5", "brand5", "model5", "reference5", "gafas de sol", "Marca","red", "M", null, null, false, 0.50, 5, "producto21", "description5", false));
		repository.save(new Product("lents6", "brand6", "model6", "reference6", "lentillas", "Diarias", null, null, "0.25", "8.50", false, 0.50, 5, "producto6", "description6", true));
		
		repository.save(new Product("lents7", "brand7", "model7", "reference7", "lentillas", "Diarias", null, null," 0.25", "8.50", false, 0.50, 5, "producto7", "description7", true));
		repository.save(new Product("lents8", "brand8", "model8", "reference8", "lentillas", "Mensuales", null, null, "0.25", "8.50", false, 0.50, 5, "producto8", "description8", true));
		repository.save(new Product("lents9", "brand9", "model9", "reference9", "lentillas", "Quincenales", null, null, "0.25", "8.50", false, 0.50, 5, "producto9", "description9", true));
		repository.save(new Product("lents10", "brand10", "model10", "reference10", "lentillas", "Quincenales", null, null, "0.25", "8.50", false, 0.50, 5, "producto10", "description10", false));
		repository.save(new Product("accesory11", "brand11", "model11", "reference11", "liquidosyaccesorios", "Accesorios", null, null, null, null, false, 0.50, 5, "producto11", "description11", true));
		repository.save(new Product("accesory12", "brand12", "model12", "reference12", "liquidosyaccesorios", "Accesorios", null, null, null, null, false, 0.50, 5, "producto12", "description12", true));
		repository.save(new Product("accesory13", "brand13", "model13", "reference13", "liquidosyaccesorios", "Accesorios", null, null, null, null, false, 0.50, 5, "producto13", "description13", true));
		repository.save(new Product("accesory14", "brand14", "model14", "reference14", "liquidosyaccesorios", "Accesorios", null, null, null, null, false, 0.50, 5, "producto14", "description14", false));
		repository.save(new Product("accesory15", "brand15", "model15", "reference15", "liquidosyaccesorios", "Accesorios", null, null, null, null, false, 0.50, 5, "producto15", "description15", true));
	    //Hasta aquí son 11 productos
		
		//Metemos los siguientes nuevos para probar la paginación
		
		repository.save(new Product("accesory16", "brand11", "model11", "reference11", "liquidosyaccesorios", "Accesorios", null, null, null, null, false, 0.50, 5, "producto16", "description11", false));
		repository.save(new Product("accesory17", "brand12", "model12", "reference12", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 0.50, 5, "producto17", "description12", true));
		repository.save(new Product("accesory18", "brand13", "model13", "reference13", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 0.50, 5, "producto18", "description13", false));
		repository.save(new Product("accesory19", "brand14", "model14", "reference14", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 0.50, 5, "producto19", "description14", true));
		repository.save(new Product("accesory20", "brand15", "model15", "reference15", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 0.50, 5, "producto23", "description15", false));
		repository.save(new Product("accesory21", "brand11", "model11", "reference11", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 0.50, 5, "producto21", "description11",false));
		repository.save(new Product("accesory22", "brand12", "model12", "reference12", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 0.50, 5, "producto22", "description12", false));
		repository.save(new Product("accesory23", "brand13", "model13", "reference13", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 0.50, 5, "producto23", "description13", true));
		repository.save(new Product("accesory24", "brand14", "model14", "reference14", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 0.50, 5, "producto24", "description14", true));
		repository.save(new Product("accesory25", "brand15", "model15", "reference15", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 0.50, 5, "producto25", "description15", true));
		repository.save(new Product("accesory26", "brand11", "model11", "reference11", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 0.50, 5, "producto26", "description11", false));
		repository.save(new Product("accesory27", "brand12", "model12", "reference12", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 0.50, 5, "producto1", "description12", true));
		repository.save(new Product("accesory28", "brand13", "model13", "reference13", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 0.50, 5, "producto12", "description13", true));
		repository.save(new Product("accesory29", "brand14", "model14", "reference14", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 0.50, 5, "producto12", "description14", true));
		repository.save(new Product("accesory30", "brand15", "model15", "reference15", "liquidosyaccesorios", "Liquidos", null, null, null, null, false, 0.50, 5, "producto13", "description15", false));
	
		
		//Guardamos producto ejemplo para mostrar las lentillas
		repository.save(new Product("ONE DAY ACUVUE MOIST 30 UNIDADES",
				                    "Acuvue","model1","reference1","lentillas","Quincenales","bluecolor",
				                    "noSize","noSpherePredef","noRadioPredef",false,19.34,5,"producto12",
				                    "Referencia: LA3 " + "\n" + "Lente de contacto de hidrogel. El componente usado en su fabricación es altamente hidratante y aporta gran comodidad a lo largo del día."
				                    + " Contiene filtro UV. Cada caja contiene 30 unidades.", false));
		
		//SEGUNDO EJEMPLO: RAY BAN 4165 601/71 55
		repository.save(new Product("RAY BAN 4165 601/71 55",
                "rayban","model1","reference1","gafas de sol","Marca","redcolor",
                "medium","0","0",false,
                61.60,5,"/producto12",
                "Referencia: 21006065 ", false));
		
		repository.save(new Product("LIMPIA GAFAS AROMA MANZANA",
                "visionlynx","model1","reference1","liquidosyaccesorios", "Liquidos","nocolor",
                "nosize","0","0",false,
                3.20,5,"producto12",
                "Referencia: 21006067 ", true));
		
	}
   
	// VIEW
	@RequestMapping("/admin/products/")
	public String productList(Model model) {
		
		Page<Product> products = repository.findAll(new PageRequest(0,10));
		model.addAttribute("productos", products);

		return "admin_product_list";
	} 
	
	
	
		@RequestMapping(value="/admin/add/", method = RequestMethod.POST)
		//@RequestMapping(value = "/image/upload", method = RequestMethod.POST)
		public String productAdd(Model model, 
				@RequestParam("imageTitle") String imageTitle,
				@RequestParam("file") MultipartFile file,  Product product) {
	
			String fileName = imageTitle + ".jpg";
	
			if (!file.isEmpty()) {
				try {
	
					File filesFolder = new File(FILES_FOLDER);
					if (!filesFolder.exists()) {
						filesFolder.mkdirs();
					}
	
					File uploadedFile = new File(filesFolder.getAbsolutePath(), fileName);
					file.transferTo(uploadedFile);
	
					
					//Código para guardar la entidad imagen en Base de datos
					Image image = new Image(imageTitle, filesFolder.getPath());
					
					imageRepository.save(image);
					
					
					product.setImage(imageTitle);
					
					repository.save(product);
					
					return "redirect:/profile";
	
				} catch (Exception e) {
					
					model.addAttribute("fileName",fileName);
					model.addAttribute("error",
							e.getClass().getName() + ":" + e.getMessage());
					
					return "redirect:/adminadd";
				}
			} else {
				
				model.addAttribute("error",	"The file is empty");
				
				return "redirect:/adminadd";
			}
		}
		
		
	
		@RequestMapping("/files/{fileName}")
		public void productAdd2(@PathVariable String fileName,
				HttpServletResponse response) throws FileNotFoundException, IOException {
	
			File file = new File(FILES_FOLDER, fileName+ ".jpg");
	
			if (file.exists()) {
				response.setContentType("image/jpeg");
				response.setContentLength(new Long(file.length()).intValue());
				FileCopyUtils
						.copy(new FileInputStream(file), response.getOutputStream());
			} else {
				response.sendError(404, "File" + fileName + "(" + file.getAbsolutePath()
						+ ") does not exist");
			}
		}
	
			
	
 
		@RequestMapping(value="/admin/edit/{id}", method = RequestMethod.POST)
		public String editProduct(Model model, @PathVariable long id, 
				Product productupdated,
				@RequestParam("imageTitle") String imageTitle, 
				@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
			
			
	    	
			if (repository.exists(id)){
				
				Product producto = repository.findOne(id);
				model.addAttribute("producto",producto);
				
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
				
				System.out.println(imagen);
				
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
					productupdated.setImage(imageTitle);
					producto.setImage(productupdated.getImage());
				//fin imagen//
				}

				producto.setReference(productupdated.getReference());
				producto.setSize(productupdated.getSize());
				producto.setSphere(productupdated.getSphere());
				producto.setType(productupdated.getType());
				
				
				repository.save(producto);
			}
			return "redirect:/profile";
			
		}
		
		
		
	
	@RequestMapping(value = "/admin/product/delete/{id}")
	public String deleteProduct(@PathVariable long id) {

		if (repository.exists(id)) {
			repository.delete(id);
			return "redirect:/admin";
		}
		return "redirect:/profile";
	}
}

