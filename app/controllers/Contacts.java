package controllers;

import models.Contact;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import views.html.*;

public class Contacts extends Controller {
	static Form<Contact> contactForm = new Form(Contact.class);

	public static Result index() {
		// List<Contact> contacts = Contact.find.all();
		List<Contact> contacts = Contact.find.orderBy("name desc").findList();
		return ok(index.render(contacts, contactForm));
	}

	public static Result create() {

		Form<Contact> form = contactForm.bindFromRequest(request());

		if (!form.hasErrors()) {
			form.get().save();
			return redirect(routes.Contacts.index());
		} else {
			return badRequest(index.render(Contact.find.all(), form));
		}

	}

	public static Result edit(Long id) {
		Contact contact = Contact.find.byId(id);

		if (contact == null) {
			return redirect(routes.Contacts.index());
		} else {
			Form<Contact> form = contactForm.fill(contact);
			return ok(edit.render(id, form));
		}
	}

	public static Result update(Long id) {
		Form<Contact> form = contactForm.bindFromRequest(request());

		if (!form.hasErrors()) {
			form.get().update(id);
			return redirect(routes.Contacts.index());
		} else {
			return badRequest(index.render(Contact.find.all(), form));
		}
	}

	public static Result delete(Long id) {
		Contact contact = Contact.find.byId(id);
		if (contact != null) {
			contact.delete();

		}

		return redirect(routes.Contacts.index());

	}
	
	public static Result show(Long id) {
		Contact contact = Contact.find.byId(id);

		if (contact == null) {
			return redirect(routes.Contacts.index());
		} else {

			return ok(show.render(contact));
		}
	}

	
}
