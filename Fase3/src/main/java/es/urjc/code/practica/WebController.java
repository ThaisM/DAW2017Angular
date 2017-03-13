package es.urjc.code.practica;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.urjc.code.practica.user.User;
import es.urjc.code.practica.user.UserComponent;
import es.urjc.code.practica.user.UserRepository;

@Controller
public class WebController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserComponent userComponent;
	
	
   @RequestMapping("/")
    public String index(Model model, HttpServletRequest request) {
	   
	   if (userComponent.isLoggedUser()){
   		return home(model,request);
   		}
    	return "index";
    } 
    

    @RequestMapping("/login")
    public String login() {
    	return "login_form";
    }
    
    @RequestMapping("/loginerror")
    public String loginerror() {
    	return "login_form_error";
    }
    

    @RequestMapping("/home")
    public String home(Model model, HttpServletRequest request) {
    	
    	model.addAttribute("admin", request.isUserInRole("ADMIN"));
    	
    	Principal p = request.getUserPrincipal();
    	User user = userRepository.findByName(p.getName());
    	
    	User user2 = userComponent.getLoggedUser();
    	
    	model.addAttribute("user", user2.getName());
    	model.addAttribute("logueado", userComponent.isLoggedUser());
    	
    	System.out.println("User: "+user);
    	System.out.println("User2: "+user2);
    	
    
	
    	return "index";
    }
    
    @RequestMapping("/admin")
    public String admin(Model model) {
    	
    	model.addAttribute("logueado", userComponent.isLoggedUser());
    	
    	return "admin_product";
    }
    
    
    @RequestMapping("/adminadd")
    public String admin_add_product(Model model) {
    	
    	model.addAttribute("logueado", userComponent.isLoggedUser());
    	
    	return "admin_add_product";
    }
    
    @RequestMapping("/profile")
    public String profile(Model model, HttpServletRequest request) {


    	model.addAttribute("user", request.isUserInRole("USER"));
    	
    	Principal p = request.getUserPrincipal();
    	User user = userRepository.findByName(p.getName());
    	
    	
    	model.addAttribute("user", user.getName());
    	model.addAttribute("logueado", userComponent.isLoggedUser());
    	
    
    	if (request.isUserInRole("ADMIN")){
    		return admin(model);
    	}
    	
    	
    	return "profile";
    	
    }
    
    @RequestMapping("/usercart")
    public String usercart(Model model) {
    	
    	model.addAttribute("logueado", userComponent.isLoggedUser());
	   
    	return "user_cart_shopping";
    } 
    
    
    @RequestMapping("/payment")
    public String payment1(Model model) {
    	
    	model.addAttribute("logueado", userComponent.isLoggedUser());
	   
    	return "payment_gateway";
    } 
    
    
    @RequestMapping("/user_orders")
    public String user_orders(Model model) {
    	
    	model.addAttribute("logueado", userComponent.isLoggedUser());
	   
    	return "user_orders";
    } 
    
    @RequestMapping("/user_orders_sum")
    public String user_orders_summary(Model model) {
    	
    	model.addAttribute("logueado", userComponent.isLoggedUser());
	   
    	return "user_order_summary";
    } 
    
    
    
}
