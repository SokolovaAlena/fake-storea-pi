package users;

import config.BaseTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetUsersTest {

    private static final String ADD_URL = "/users";

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BaseTest.BASE_URI;
    }



    @DisplayName("Получить информацию по существующему пользователю")
    @Tag("Positive")
    @ParameterizedTest
    @ValueSource(ints = {1})
    public void getUserTest(int id) {
        String pathParam = "/" + id;
        given().
                get(ADD_URL + pathParam)
                .then()
                .log().all()
                .statusCode(200)
                .body("id",equalTo(id))
                .body("address.geolocation.lat",equalTo("-37.3159"))
                .body("address.geolocation.long",equalTo("81.1496"))
                .body("address.city",equalTo("kilcoole"))
                .body("name.firstname",equalTo("jhjkj"));
    }
}
