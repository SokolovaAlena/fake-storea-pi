package users;

import config.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import users.UpdateUser.ResponseUpdateUser;
import users.UpdateUser.UpdateUserGenerator;

import static io.restassured.RestAssured.given;

public class UpdateUserTest extends BaseTest {
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = getHost();
    }

    @Test
    public void updateUserTest() {
        ResponseUpdateUser expectedUser = UpdateUserGenerator.createUpdUserObj();

        Response response =
                given()
                        .pathParam("id", 1)
                        .header("Content-Type", "application/json")
                        .body(UpdateUserGenerator.createUpdUserObj())
                        .when()
                        .put(getUsersEndpoint() + "/{id}")
                        .andReturn();

        ResponseBody responseBody = response.getBody();
        ResponseUpdateUser actualUser = responseBody.as(ResponseUpdateUser.class);

        Assertions.assertEquals(expectedUser,actualUser);

    }

}
