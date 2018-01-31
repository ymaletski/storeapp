package ru.mail.yura.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "T_ADDRESS")
@NamedQueries({
	@NamedQuery(name = "Address.findAll", query = "select a from Address a"),
	@NamedQuery(name = "Address.findAllWithDetails", 
			query = "select a from Address a left join fetch a.user u"),
	@NamedQuery(name = "Address.findById", 
		query = "select a from Address a where a.id = :id"),
	@NamedQuery(name = "Address.findByIdWithDetails", 
	query = "select a from Address a left join fetch a.user u where a.id = :id")
})
public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4299781077968478745L;
	
	@Id
	@GeneratedValue(generator = "addressKeyGenerator")
	@org.hibernate.annotations.GenericGenerator(
			name = "addressKeyGenerator", 
			strategy = "foreign", 
			parameters = 
			@org.hibernate.annotations.Parameter(name = "property", value = "user")
	)
	@Column(name = "F_ADDRESS_ID")
	private Long id;

	@Column(name = "F_CITY")
	@NotNull
	@Size(max = 45)
	private String city;
	
	@Column(name = "F_STREET")
	@NotNull
	@Size(max = 45)
	private String street;
	
	@Column(name = "F_BUILDING_NUM")
	@NotNull
	@Size(max = 10)
	private String buildingNumber;
	
	@Column(name = "F_ZIPCODE")
	@NotNull
	@Size(max = 12)
	private String zipcode;
	
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private User user;
	
	public Address() {
		
	}
	
	public Address(User user) {
		this.user = user;
	}
	
	public Address(User user, String city, String street, String buildingNumber, String zipcode) {
		this.user = user;
		this.city = city;
		this.street = street;
		this.buildingNumber = buildingNumber;
		this.zipcode = zipcode;
	}
	
	public String toString() {
		String str = null;
		str = "Address id: " + id + ", city: " + city + "\n" + 
		"street: " + street + ", buildingNumber: " + buildingNumber + "\n" + 
		"zipcode: " + zipcode + ".";
		return str;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
