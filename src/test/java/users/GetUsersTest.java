package users;

import config.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import users.GetUser.ResponseGetUsers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static users.GetUser.GetUserResponseSampleGenerator.getuserWithId1;

public class GetUsersTest extends BaseTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = getHost();
    }


    @DisplayName("Получить информацию по существующему пользователю")
    @Tag("Positive")
    @ParameterizedTest
    @ValueSource(ints = {1})
    public void getUserTest(int id) {

        given().
                pathParam("id", id)
                .get(getUsersEndpoint()+ "/{id}")
                .then()
//                .log().all()
                .statusCode(200)
                .body("id", equalTo(id))
                .body("address.geolocation.lat", equalTo("-37.3159"))
                .body("address.geolocation.long", equalTo("81.1496"))
                .body("address.city", equalTo("kilcoole"))
                .body("name.firstname", equalTo("john"));
    }

    @Test
    public void getUserWithId1Test (){

        Response response = RestAssured.given().
                pathParam("id", 1)
                .get(getUsersEndpoint()+ "/{id}")
                .andReturn();
        ResponseBody responseBody = response.getBody();
        ResponseGetUsers myresp = responseBody.as(ResponseGetUsers.class);

        Assertions.assertEquals(getuserWithId1(),myresp);
    }

}
