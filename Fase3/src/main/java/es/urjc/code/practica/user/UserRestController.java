package es.urjc.code.practica.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;


import es.urjc.code.practica.images.Image;
import es.urjc.code.practica.images.ImageRepository;

@RestController
public class UserRestController {
	
	interface UserView extends User.UserAttribute{};
	
	@Autowired
	private UserRepository repository;
	
	
	private static final String FILES_FOLDER = "files";
	
	
	@JsonView(UserView.class)
	@RequestMapping(value = "/api/users/", method= RequestMethod.GET)
	public List<User> getProductsPage(Pageable page){
		
		
		List<User> listUsers = repository.findAll(page).getContent();
		return listUsers;
	}
	
	@RequestMapping(value = "/api/users/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User createBook(@RequestBody User user) {

		repository.save(user);

		return user;
	}
	
	@RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable long id) {

		User user = repository.findOne(id);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	@RequestMapping(value = "/api/users/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User updateUser) {

		User user = repository.findOne(id);
		if (user != null) {

			updateUser.setId(id);
			repository.save(updateUser);

			return new ResponseEntity<>(updateUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}

	@RequestMapping(value = "/api/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable long id) {

		repository.delete(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}

