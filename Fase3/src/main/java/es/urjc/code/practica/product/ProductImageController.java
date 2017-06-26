package es.urjc.code.practica.product;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ProductImageController {
	
	private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "files");
	
	@Autowired
	private ProductsRepository productRepository;
	
	@RequestMapping(value = "/api/image/uploadToProduct/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> handleFileUpload(@RequestParam MultipartFile file, 
			@PathVariable long id) throws IOException {
		
		if (file.isEmpty()) {
			throw new RuntimeException("The file is empty");
		}

		if (!Files.exists(FILES_FOLDER)) {
			Files.createDirectories(FILES_FOLDER);
		}
		
		Product product = productRepository.findOne(id);
		
		int hash = file.hashCode();
		String fileName = "image-" + hash  + ".jpg";
		
		
		File uploadedFile = new File(FILES_FOLDER.toFile(), fileName);
				
		file.transferTo(uploadedFile);
		
		product.setImage("/api/images/" + fileName);
		
		productRepository.save(product);
		
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@RequestMapping("/api/images/{fileName:.+}")
	public void handleFileDownload(@PathVariable String fileName, HttpServletResponse res)
			throws FileNotFoundException, IOException {
		
		Path image = FILES_FOLDER.resolve(fileName);

		if (Files.exists(image)) {
			res.setContentType("image/jpeg");
			res.setContentLength((int) image.toFile().length());
			FileCopyUtils.copy(Files.newInputStream(image), res.getOutputStream());
		} else {
			res.sendError(404, "File" + fileName + "(" + image.toAbsolutePath() + ") does not exist");
		}
	}

}
