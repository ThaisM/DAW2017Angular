package es.urjc.code.practica.offers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonView;

import es.urjc.code.practica.product.Product;
import es.urjc.code.practica.user.User.UserAttribute;

@Entity
public class Offer {
	
	public interface OfferAttribute{};

	@Id
	@JsonView(OfferAttribute.class)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
    private Product product;
    
    	public Offer(){
    		
    	}
    	
    	public Offer(Product product){

    		this.product=product;
    	}


	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}



	/*    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = (int) (prime * result + id);
	        result = prime * result + ((name == null) ? 0 : name.hashCode());
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (!(obj instanceof Offer))
	            return false;
	        Offer other = (Offer) obj;
	        if (id != other.id)
	            return false;
	        if (name == null) {
	            if (other.name != null)
	                return false;
	        } else if (!name.equals(other.name))
	            return false;
	        return true;
	    } */

	    @Override
	    public String toString() {
	        return "Offer [id=" + id + ", name=" + product +"]";
	    }
	


}