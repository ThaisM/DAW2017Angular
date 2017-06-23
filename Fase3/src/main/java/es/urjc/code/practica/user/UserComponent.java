package es.urjc.code.practica.user;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import es.urjc.code.practica.shoppingcart.OrderCart;


@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserComponent {

	private User user;
	
	private List<OrderCart> listaproductoscarrito = new ArrayList<OrderCart>();

	public User getLoggedUser() {
		return user;
	}

	public void setLoggedUser(User user) {
		this.user = user;
	}
	
	public List<OrderCart> getListProducts(){
        return this.listaproductoscarrito;
	}
	
	public void setListProducts(List<OrderCart> listaproductoscarrito){
        this.listaproductoscarrito = listaproductoscarrito;
	}

	public boolean isLoggedUser() {
		return this.user != null;
	}

}

