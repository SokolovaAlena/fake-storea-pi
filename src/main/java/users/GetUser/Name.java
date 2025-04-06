package users.GetUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Name{

	@JsonProperty("firstname")
	private String firstname;

	@JsonProperty("lastname")
	private String lastname;
}