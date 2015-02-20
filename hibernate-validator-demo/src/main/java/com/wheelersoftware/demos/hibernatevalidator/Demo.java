package com.wheelersoftware.demos.hibernatevalidator;

import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

public final class Demo {
	private static ClassValidator<User>
		userValidator = new ClassValidator<User>(User.class);

	public static void main(String[] args) {
		validateUser(createUser());
	}
	
	private static User createUser() {
		User user = new User();
		user.setFirstName("123456789012345678901");
		user.setEmail("aol.com");
		
		Address addr = new Address();
		addr.setStreet1("");
		addr.setCity("Moreno Valley");
		addr.setState("CA");
		addr.setZip("QWERTY");
		user.setAddress(addr);
		
		return user;
	}
	
	private static void validateUser(User user) {
		InvalidValue[] invalidValues = userValidator.getInvalidValues(user);
		for (InvalidValue value : invalidValues) {
			System.out.println("========");
			System.out.println(value);
			System.out.println("message=" + value.getMessage());
			System.out.println("propertyName=" + value.getPropertyName());
			System.out.println("propertyPath=" + value.getPropertyPath());
			System.out.println("value=" + value.getValue());
		}
	}
}
