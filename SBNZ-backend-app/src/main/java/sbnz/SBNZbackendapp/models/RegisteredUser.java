package sbnz.SBNZbackendapp.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("user")
public class RegisteredUser extends User{

	private static final long serialVersionUID = 1L;
	
	public RegisteredUser() {
		super();
	}
}
