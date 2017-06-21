package es.urjc.code.practica.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonView;

import es.urjc.code.practica.product.Product.ProductAttribute;

@Entity
public class User {
	
	public interface UserAttribute{};

	@Id
	@JsonView(UserAttribute.class)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonView(UserAttribute.class)
	private String name;
	
	@JsonView(UserAttribute.class)
	private String passwordHash;
	
	//@JsonView(UserAttribute.class)
	private String confirmpasswordHash;
	
	public String getConfirmpasswordHash() {
		return confirmpasswordHash;
	}

	public void setConfirmpasswordHash(String confirmpassword) {
		this.confirmpasswordHash = new BCryptPasswordEncoder().encode(confirmpassword);
	}
	
	@JsonView(UserAttribute.class)
	private String surnames;
	
	@JsonView(UserAttribute.class)
	private String email;
	
	@JsonView(UserAttribute.class)
	private String birthdate;
	
	// ATRIBUTOS DE DIRECCIÓN DE FACTURACION
			
			@JsonView(UserAttribute.class)
			private String address;
			
			@JsonView(UserAttribute.class)
			private String address2;
			
			@JsonView(UserAttribute.class)
			private int zipcode;
			
			@JsonView(UserAttribute.class)
			private String locality;
			
			@JsonView(UserAttribute.class)
			private String province;
			
			@JsonView(UserAttribute.class)
			private String country;
			
			@JsonView(UserAttribute.class)
			private String phone;
			
			@JsonView(UserAttribute.class)
			private String nid;
			
			@JsonView(UserAttribute.class)
			private String other;

	public String getOther() {
				return other;
			}

			public void setOther(String other) {
				this.other = other;
			}

	@JsonView(UserAttribute.class)		
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	//Constructor 
	
	public User() {
	}

	
	public User(String name, String password, String... roles) {
		this.name = name;
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
		this.roles = new ArrayList<>(Arrays.asList(roles));
	}
	
	public User(String name, String surnames , String email, String password, String birthdate, 
				String address, int zipcode, String locality, String province, String country, String phone, String nid, String... roles){
		
		this.name = name;
		this.surnames = surnames;
		this.email = email;
		this.birthdate = birthdate;
		this.address = address;
		this.zipcode = zipcode;
		this.locality = locality;
		this.province = province;
		this.country = country;
		this.phone = phone;
		this.nid = nid;
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
		this.roles = new ArrayList<>(Arrays.asList(roles));
		
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String password){
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
	}

	
	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	
		
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}
		

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwordHash=" + passwordHash + ", roles=" + roles
				+ ", surnames=" + surnames + ", email=" + email + ", birthdate=" + birthdate + ", address=" + address
				+ ", address2=" + address2 + ", zipcode=" + zipcode + ", locality=" + locality + ", province="
				+ province + ", Country=" + country + "]";
	}



	
	
	
	

}