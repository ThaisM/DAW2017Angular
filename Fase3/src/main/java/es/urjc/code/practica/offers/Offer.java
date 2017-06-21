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

    private String category;

    private String name;

    private Double price;
    
    	public Offer(){
    		
    	}
    	
    	public Offer( String category, String name, Double price){
    		
    		this.category=category;
    		this.name=name;
    		this.price=price;
    	}


	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCategory(){
	        return category;
	    }

	    public void setCategory(String category){
	        this.category = category;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name= name;
	    }

	    public Double getPrice() {
	        return price;
	    }

	    public void setPrice(Double price) {
	        this.price= price;
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
	        return "Offer [id=" + id + ", name=" + name+ ", price=" + price
	                +"]";
	    }
	


}