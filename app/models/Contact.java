package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderBy;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.MinLength;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Contact extends Model {

	public static Finder<Long, Contact> find = new Finder<Long, Contact>(Long.class, Contact.class);

	public static Finder<Long, Contact> getFind() {
		return find;
	}

	public static void setFind(Finder<Long, Contact> find) {
		Contact.find = find;
	}

	@Id
	Long id;

	@Required
	@Email
	String emailAddress;

	@MinLength(value = 5)
	String name;

	@MinLength(value = 5)
	String address;

	@MinLength(value = 8)
	String phoneNumber;

	public String getAddress() {
		return address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
