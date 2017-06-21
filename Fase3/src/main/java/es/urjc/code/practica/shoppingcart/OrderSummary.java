package es.urjc.code.practica.shoppingcart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import es.urjc.code.practica.shoppingcart.OrderCart.OrderCartAttribute;
import es.urjc.code.practica.user.User;

import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;


@Entity
public class OrderSummary{
	
	
	public interface OrderSummaryAttribute{};
	
	@Id
	@JsonView(OrderSummaryAttribute.class)
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	/***Atributos de Cart ***/
	@JsonView(OrderSummaryAttribute.class)
	private String ordername;
	
	@JsonView(OrderSummaryAttribute.class)
	private String user;
	
	@JsonView(OrderSummaryAttribute.class)
	private String paymentmethod;
	
	@JsonView(OrderSummaryAttribute.class)
	private String state;
	
	@JsonView(OrderSummaryAttribute.class)
	private Double totalprice;
	
	
	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}




	@OneToMany
	@JsonView
	private List <OrderCart> order = new ArrayList<OrderCart>(); //new ArrayList<>();;
	
	protected OrderSummary (){
		
	}
	
	public OrderSummary(String ordername, String user, String paymentmethod) {
		super();
		this.ordername = ordername;
		this.user = user;
		this.paymentmethod = paymentmethod;
	}
	
	public OrderSummary(String ordername, String user, String paymentmethod, String state, Double totalprice) {
		super();
		this.ordername = ordername;
		this.user = user;
		this.paymentmethod = paymentmethod;
		this.state= state;
		this.totalprice = totalprice;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public List<OrderCart> getOrder() {
		return order;
	}

	public void setOrder(List<OrderCart> order) {
		this.order = order;
	}



	@Override
	public String toString() {
		return "OrderSummary [id=" + id + ", ordername=" + ordername + ", user=" + user + ", paymentmethod="
				+ paymentmethod + ", order=" + order + "]";
	}

	
	
	

}
