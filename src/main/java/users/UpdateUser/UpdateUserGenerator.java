package users.UpdateUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


public class UpdateUserGenerator {

    public static ResponseUpdateUser createUpdUserObj (){
        return ResponseUpdateUser.builder()
                .username("john_doe_updated")
                .email("john.updated@example.com")
                .password("12343")
                .name(Name.builder()
                        .firstname("johnUpd")
                        .lastname("doeUpd")
                        .build())
                .build();
    }
}
