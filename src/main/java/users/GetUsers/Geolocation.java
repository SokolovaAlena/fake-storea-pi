package users.GetUsers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geolocation{

	@JsonProperty("lat")
	private String lat;

	@JsonProperty("long")
	private String jsonMemberLong;

	public String getLat(){
		return lat;
	}

	public String getJsonMemberLong(){
		return jsonMemberLong;
	}
}