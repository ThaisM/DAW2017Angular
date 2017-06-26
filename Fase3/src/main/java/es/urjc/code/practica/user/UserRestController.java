package es.urjc.code.practica.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class UserRestController {
	
	interface UserView extends User.UserAttribute{};
	
	@Autowired
	private UserRepository repository;

	@Autowired
	private UserComponent userComponent;
	
	
	private static final String FILES_FOLDER = "files";
	

	@JsonView(UserView.class)
	@RequestMapping(value = "/api/loggedUser/", method=RequestMethod.GET)
	public User getUsers(){
		return userComponent.getLoggedUser();
	}

	@JsonView(UserView.class)
	@RequestMapping(value = "/api/users/", method= RequestMethod.GET)
	public List<User> getUsers(Pageable page){
		
		
		List<User> listUsers = repository.findAll(page).getContent();
		return listUsers;
	}
	
	@RequestMapping(value = "/api/users/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User user) {

		User newUser = new User(user.getName(), user.getSurnames(), user.getEmail(), user.getPasswordHash(),"01/01/2000",
				user.getAddress(), user.getZipcode(), user.getLocality(), user.getProvince(), user.getCountry(),user.getPhone(), user.getNid(), "ROLE_USER");

		repository.save(newUser);

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

			user.setName(updateUser.getName());
			user.setSurnames(updateUser.getSurnames());
			user.setEmail(updateUser.getEmail());
			user.setAddress(updateUser.getAddress());
			user.setZipcode(updateUser.getZipcode());
			repository.save(user);

			return new ResponseEntity<>(updateUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}

	@RequestMapping(value = "/api/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteUser(@PathVariable long id) {

		repository.delete(id);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/users/changePassword/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> deleteUser(@RequestBody String password, @PathVariable long id) {

		User user = repository.findOne(id);

		if(user.getId() == userComponent.getLoggedUser().getId()){
			user.setPasswordHash(new BCryptPasswordEncoder().encode(password));
			repository.save(user);

			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(HttpStatus.UNAUTHORIZED);
	}

}

