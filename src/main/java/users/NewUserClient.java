package users;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NewUserClient {
    private static final String ADD_URL = "/users";

    public Response create(NewUser newUser) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(newUser)
                .when()
                .post(ADD_URL);
    }

}
