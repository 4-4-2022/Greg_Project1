package com.project1.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "display_suite")
public class DisplaySuite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "suite")
	private String suite;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "description")
	private String description;
	
	public DisplaySuite(long id, String suite, float price, String description) {
		super();
		this.id = id;
		this.suite = suite;
		this.price = price;
		this.description = description;
	}
	public DisplaySuite() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, id, price, suite);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisplaySuite other = (DisplaySuite) obj;
		return Objects.equals(description, other.description) && id == other.id
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& Objects.equals(suite, other.suite);
	}
	@Override
	public String toString() {
		return "DisplaySuite [id=" + id + ", suite=" + suite + ", price=" + price + ", description=" + description
				+ "]";
	}
	

}
