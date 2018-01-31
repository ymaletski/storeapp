package ru.mail.yura.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ru.mail.yura.constant.Role;
/**
 * @author User
 *
 */
@Entity
@Table(name = "T_USER")
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "select u from User u"),
	@NamedQuery(name = "User.findAllWithDetails", 
		query = "select distinct u from User u left join fetch u.news n order by u.id"),
	@NamedQuery(name = "User.findById", 
		query = "select u from User u where u.id = :id"),
	@NamedQuery(name = "User.findByIdWithDetails", 
		query = "select u from User u left join fetch u.news n where u.id = :id"),
	@NamedQuery(name = "User.softDelete", 
		query = "update User u set u.isActive=false where u.id = :id")
})
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1473284101831504111L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "F_USER_ID")
	private Long id;
	
	@Column(name = "F_FIRST_NAME")
	@NotNull
	@Size(min = 2, max = 45)
	private String firstName;
	
	@Column(name = "F_LAST_NAME")
	@NotNull
	@Size(min = 2, max = 45)
	private String lastName;
	
	@Column(name = "F_EMAIL")
	@NotNull
	@Size(min = 5, max = 45)
	private String email;
	
	@Column(name = "F_INFORMATION")
	@Size(max = 255)
	private String information;
	
	@Column(name = "F_ROLE")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(name = "F_PASSWORD")
	@NotNull
	@Size(min = 5, max = 45)
	private String password;
	
	@Column(name = "F_TEL_NUM")
	@Size(max = 20)
	private String telephoneNumber;
	
	@Column(name = "F_IS_ACTIVE")
	@NotNull
	private boolean isActive;
	
	@OneToOne(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
	)
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "F_USER_ID",	nullable = false)
	private List<News> news = new ArrayList<News>();
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String email, 
			String information, Role role, String password, 
			String telephoneNumber, boolean isActive) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.information = information;
		this.role = role;
		this.telephoneNumber = telephoneNumber;
		this.isActive = isActive;
	}
	
	public String toString() {
		String str = null;
		str = "User id: " + id + ", first name: " + firstName + ", last name: " + 
		lastName + "\n" + "email: " + email + "\n" + 
		"information: " + information + "\n" + 
		"role: " + role + ", telephone number: " + telephoneNumber + "\n" + 
		"is active: " + isActive + ".";
		if (address != null) {
			str = str + "\n" + address;
		}
		if (news != null) {
			for (News oneNews : news) {
			str = str + "\n" + oneNews;
			}
		}
		return str;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role user) {
		this.role = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}
	
}
