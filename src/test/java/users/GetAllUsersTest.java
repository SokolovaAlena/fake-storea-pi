package users;

import config.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import users.GetUsers.ResponseGetUsersItem;

public class GetAllUsersTest extends BaseTest {
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = getHost();
    }

    @Test
    public void getAllUsersTest() {
        Response response = RestAssured.given()
                .get(getUsersEndpoint())
                .andReturn();
        ResponseBody responseBody = response.getBody();
        ResponseGetUsersItem[] users = responseBody.as(ResponseGetUsersItem[].class);

        Assertions.assertEquals(10, users.length);
    }
}
