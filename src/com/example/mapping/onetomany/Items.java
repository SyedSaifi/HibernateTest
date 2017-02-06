package com.example.mapping.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEMS")
public class Items {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="item_id")
	private long id;
	
	@Column(name="item_total")
	private double itemTotal;
	
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="cart_id", nullable=false)
	@JoinTable(
			name="Cart_Item",
			joinColumns=
				@JoinColumn(name="item_id"),
			inverseJoinColumns=
				@JoinColumn(name="cart_id"))
	private Cart cart1;
	
	//Hibernate requires no-args constructor
		public Items(){}
		
		public Items(double total, int qty, Cart c){
			this.itemTotal=total;
			this.quantity=qty;
			this.cart1=c;
		}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart1() {
		return cart1;
	}

	public void setCart1(Cart cart1) {
		this.cart1 = cart1;
	}
	
}