
public class User {

	private String name;
	private String surname;
	private Date birthdate;
	private String gender;
	private Address cont_address;
	private Phone number;
	
	public User(String name, String surname, Date birthdate, String gender, Address cont_address, Phone number) {
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.gender = gender;
		this.cont_address = cont_address;
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Address getCont_address() {
		return cont_address;
	}
	public void setCont_address(Address cont_address) {
		this.cont_address = cont_address;
	}
	public Phone getNumber() {
		return number;
	}
	public void setNumber(Phone number) {
		this.number = number;
	}
	
}
