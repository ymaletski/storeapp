package ru.mail.yura.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "T_GOODS")
@NamedQueries({
	@NamedQuery(name = "Goods.findAll", query = "select g from Goods g"),
	@NamedQuery(name = "Goods.findById", 
		query = "select g from Goods g where g.id = :id"),
	@NamedQuery(name = "Goods.softDelete", 
		query = "update Goods g set g.isActive=false where g.id = :id")
})
public class Goods implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3228910005531965169L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "F_GOODS_ID")
	private Long id;
	
	@Column(name = "F_NAME")
	@NotNull
	@Size(min = 2, max = 45)
	private String name;
	
	@Column(name = "F_INVENTORY_NUM")
	@NotNull
	@Size(min = 2, max = 20)
	private String inventoryNumber;
	
	@Column(name = "F_DESCRIPTION")
	private String description;
	
	@Column(name = "F_PRICE")
	@NotNull
	private Double price;
	
	@Column(name = "F_IS_ACTIVE")
	@NotNull
	private boolean isActive;
	
	public Goods() {
		
	}
	
	public Goods(String name, String inventoryNumber, String description, Double price, boolean isActive) {
		this.name = name;
		this.inventoryNumber = inventoryNumber;
		this.description = description;
		this.price = price;
		this.isActive = isActive;
	}
	
	public String toString() {
		String str = null;
		str = "Goods id: " + id + ", name: " + name + ", inventory number: " 
		+ inventoryNumber + "\n" + "description: " + description + "\n" 
		+ "price: " + price + ", is active: " + isActive + ".";
		return str;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
