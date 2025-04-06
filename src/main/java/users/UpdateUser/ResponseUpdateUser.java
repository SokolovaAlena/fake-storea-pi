package users.UpdateUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUpdateUser {

	@JsonProperty("password")
	private String password;

	@JsonProperty("name")
	private Name name;

	@JsonProperty("email")
	private String email;

	@JsonProperty("username")
	private String username;
}