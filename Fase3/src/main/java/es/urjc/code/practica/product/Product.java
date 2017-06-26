package es.urjc.code.practica.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Product {
	
	public interface ProductAttribute{};
	
	@Id
	@JsonView(ProductAttribute.class)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/*** Main ***/
	@JsonView(ProductAttribute.class)
	private String name;
	
	@JsonView(ProductAttribute.class)
	private String brand;
	
	@JsonView(ProductAttribute.class)
	private String model;

	
	@JsonView(ProductAttribute.class)
	private String reference;
	
	// ***** Acotar type
	@JsonView(ProductAttribute.class)
	private String type;
	
	@JsonView(ProductAttribute.class)
	private String subtype;
	
	@JsonView(ProductAttribute.class)
	private String colour;
	
	@JsonView(ProductAttribute.class)
	private String size;
	
	@JsonView(ProductAttribute.class)
	private String sphere;
	
	@JsonView(ProductAttribute.class)
	private String radio;
	
	@JsonView(ProductAttribute.class)
	private Boolean published;
	
	@JsonView(ProductAttribute.class)
	private Double price;
	
	@JsonView(ProductAttribute.class)
	private Integer quantity;
	
	/*** Images ***/	
	@JsonView(ProductAttribute.class)
	private String image;
	
	/*** Description ***/
	@JsonView(ProductAttribute.class)
	private String description;

	/*** OFFER ***/
	@JsonView(ProductAttribute.class)
	private Boolean offer;
	
	public Product(){}

	public Product(String name, String brand, String model, String reference, String type, String subtype, String colour, 
			String size, String sphere, String radio, Boolean published, Double price, Integer quantity, 
			String image, String description, boolean offer) {
		super();
		this.name = name;
		this.brand = brand;
		this.model = model;
		this.reference = reference;
		this.type = type;
		this.subtype=subtype;
		this.colour = colour;
		this.size = size;
		this.sphere = sphere;
		this.radio = radio;
		this.published = published;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.description = description;
		this.offer = offer;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSphere() {
		return sphere;
	}

	public void setSphere(String sphere) {
		this.sphere = sphere;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getOffer() {
		return offer;
	}

	public void setOffer(Boolean offer) {
		this.offer = offer;
	}

	@Override
	public String toString() {
		return "Product [ id: " + id + "\n" + 
			   "          name: " + name + "\n" + 
			   "	      brand: " + brand + "\n" +
			   " 		  model: " + model + "\n" +
			   "		  reference: " + reference + "\n" +
			   "		  type: " + type + "\n" + 
			   "		  colour: " + colour + "\n" + 
			   "		  size: " + size + "\n" +	
			   "   	 	  sphere: " + sphere + "\n" + 
			   "		  radio: " + radio + "\n" + 
			   "		  published: " + published + "\n" + 
			   " 		  price: " + price + "\n" + 
			   "  		  quantity: " + quantity + "\n" + 
			   " 		  description=" + description + "]";
	}

}
