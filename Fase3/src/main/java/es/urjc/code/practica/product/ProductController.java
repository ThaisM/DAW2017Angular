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

