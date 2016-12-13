package jsample.builder;

/**
 * 
 * Person class which contains various attributes i.e. variables. However, only
 * 'firstName' and 'city' are mandatory attributes, rest of the attributes are
 * optional attributes.
 * 
 * Person class is also immutable class.
 *
 */
public class Person {

	private String lastName;
	private String firstName;
	private String middleName;
	private String streetAddress;
	private String city;
	private String state;
	private boolean isFemale;
	private boolean isEmployed;
	private boolean isHomeOwner;

	/**
	 * Constructor of the class is private for avoiding direct instance creation
	 * of this class.
	 * 
	 */
	private Person(String lastName, String firstName, String middleName, String streetAddress, String city,
			String state, boolean isFemale, boolean isEmployed, boolean isHomeOwner) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.isFemale = isFemale;
		this.isEmployed = isEmployed;
		this.isHomeOwner = isHomeOwner;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public boolean isFemale() {
		return isFemale;
	}

	public boolean isEmployed() {
		return isEmployed;
	}

	public boolean isHomewOwner() {
		return isHomeOwner;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [");
		if (lastName != null)
			builder.append("lastName=").append(lastName).append(", ");
		if (firstName != null)
			builder.append("firstName=").append(firstName).append(", ");
		if (middleName != null)
			builder.append("middleName=").append(middleName).append(", ");
		if (streetAddress != null)
			builder.append("streetAddress=").append(streetAddress).append(", ");
		if (city != null)
			builder.append("city=").append(city).append(", ");
		if (state != null)
			builder.append("state=").append(state).append(", ");
		builder.append("isFemale=").append(isFemale).append(", isEmployed=").append(isEmployed).append(", isHomeOwner=")
				.append(isHomeOwner).append("]");
		return builder.toString();
	}

	/**
	 * 
	 * This is the builder class based on Builder design pattern for creating
	 * instance of Person class.
	 * 
	 * It is suggested to make builder class as nested static class inside the
	 * same class.
	 *
	 */
	public static class PersonBuilder {
		private String lastName;
		private String firstName;
		private String middleName;
		private String streetAddress;
		private String city;
		private String state;
		private boolean isFemale;
		private boolean isEmployed;
		private boolean isHomeOwner;

		/**
		 * Constructor of builder class contains mandatory attributes of Person
		 * class.
		 */
		public PersonBuilder(String firstName, String city) {
			this.firstName = firstName;
			this.city = city;
		}

		/**
		 * Setter method are present for setting optional attributes.
		 */
		public PersonBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public PersonBuilder setMiddleName(String middleName) {
			this.middleName = middleName;
			return this;
		}

		public PersonBuilder setStreetAddress(String streetAddress) {
			this.streetAddress = streetAddress;
			return this;
		}

		public PersonBuilder setState(String state) {
			this.state = state;
			return this;
		}

		public PersonBuilder setFemale(boolean isFemale) {
			this.isFemale = isFemale;
			return this;
		}

		public PersonBuilder setEmployed(boolean isEmployed) {
			this.isEmployed = isEmployed;
			return this;
		}

		public PersonBuilder setHomeOwner(boolean isHomeOwner) {
			this.isHomeOwner = isHomeOwner;
			return this;
		}

		/**
		 * build method will create immutable instance of Person class.
		 */
		public Person build() {
			return new Person(lastName, firstName, middleName, streetAddress, city, state, isFemale, isEmployed,
					isHomeOwner);
		}
	}
}