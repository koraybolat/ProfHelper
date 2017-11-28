package projPart1;

public abstract class Person {

	private String id;
	private String name;
	private String email;
	public static int x = 0;

	public Person(String name) {
		this.name = name;
		idCreator();
	}

	public abstract void initEmail();

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void idCreator() {
		x++;
		String[] xd = this.getName().toLowerCase().split(" ");

		if (x < 10) {
			id = xd[0].charAt(0) + "" + xd[1].charAt(0) + "000" + x;
		}
		if (x >= 10) {
			id = xd[0].charAt(0) + "" + xd[1].charAt(0) + "00" + x;
		}
	}

	public String toString() {
		return "My id is " + this.getId() + ". My name is " + this.getName() + ". My email is " + this.getEmail();
	}
}
