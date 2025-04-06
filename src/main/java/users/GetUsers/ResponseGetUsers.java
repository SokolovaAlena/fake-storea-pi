package users.GetUsers;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGetUsers{

	@JsonProperty("ResponseUpdateUser")
	private List<ResponseGetUsersItem> responseGetUsers;

	public List<ResponseGetUsersItem> getResponseGetUsers(){
		return responseGetUsers;
	}

}