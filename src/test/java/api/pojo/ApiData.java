package api.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiData {
	
	//private String testCase;
	@JsonProperty("user_first_name")
	private String firstName;
	@JsonProperty("user_last_name")
	private String lastName;
	@JsonProperty("user_contact_number")
	private String contactInfo;
	@JsonProperty("user_email_id")
	private String email;
	
	private Address userAddress;
	
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
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}
	
}
