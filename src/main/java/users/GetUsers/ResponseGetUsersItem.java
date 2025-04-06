package users.GetUsers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseGetUsersItem{

	@JsonProperty("password")
	private String password;

	@JsonProperty("address")
	private Address address;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("__v")
	private int v;

	@JsonProperty("name")
	private Name name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("email")
	private String email;

	@JsonProperty("username")
	private String username;

	public String getPassword(){
		return password;
	}

	public Address getAddress(){
		return address;
	}

	public String getPhone(){
		return phone;
	}

	public int getV(){
		return v;
	}

	public Name getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getEmail(){
		return email;
	}

	public String getUsername(){
		return username;
	}
}