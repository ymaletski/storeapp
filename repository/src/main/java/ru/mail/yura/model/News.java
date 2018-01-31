package ru.mail.yura.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "T_NEWS")
@NamedQueries({
	@NamedQuery(name = "News.findAll", query = "select n from News n"),
	@NamedQuery(name = "News.findAllWithDetails", 
			query = "select n from News n left join fetch n.user u"),
	@NamedQuery(name = "News.findById", 
		query = "select n from News n where n.id = :id"),
	@NamedQuery(name = "News.findByIdWithDetails", 
	query = "select n from News n left join fetch n.user u where n.id = :id")
})
public class News implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2574728724256838653L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "F_NEWS_ID")
	private Long id;
	
	@Column(name = "F_CAPTION")
	private String caption;
	
	@Column(name = "F_CONTENT")
	@NotNull
	@Size(min = 2, max = 45)
	private String content;
	
	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "F_PHOTO")
	private byte[] photo;
	
	@Column(name = "F_DATE")
	@NotNull
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(iso = ISO.DATE)
	private DateTime date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "F_USER_ID", updatable = false, insertable = false)
	@NotNull
	private User user;
	
	public News() {
		
	}
	
	public News(String caption, String content, DateTime date) {
		this.caption = caption;
		this.content = content;
		this.date = date;
	}
	
	public String toString() {
		String str = null;
		str = "News id: " + id + "\n" + 
		"news caption: " + caption + "\n" + 
		"news content: " + content + "\n" + 
		"news date: " + 
		org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd").print(date);
		return str;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
