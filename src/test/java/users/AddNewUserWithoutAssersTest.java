package users;

import config.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AddNewUserWithoutAssersTest {
    private static final String ADD_URL = "/users";

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BaseTest.BASE_URI;
    }


    @DisplayName("Добавить нового пользователя со всеми параметрами")
    @Tag("Positive")
    @Test
    public void addNewUserWithAllFieldsTest (){
        NewUser newUser = NewUserGenerator.generateNewUser();

        given().body(newUser)
                .post(ADD_URL)
                .then().log().all()
                .statusCode(200)
                .body("id",notNullValue())
                .body("id", anyOf(equalTo(1), equalTo(11)));
    }


    @DisplayName("Добавить нового пользователя без имени")
    @Tag("Positive")
    @Test
    public void addNewUserWithoutUserNameTest (){
        NewUser newUser = NewUserGenerator.generateNewUserWithoutUserName();

        given().body(newUser)
                .post(ADD_URL)
                .then().log().all()
                .statusCode(200)
                .body("id",notNullValue())
                .body("id", anyOf(equalTo(1), equalTo(11)));

    }


    @DisplayName("Добавить нового пользователя без email")
    @Tag("Positive")
    @Test
    public void addNewUserWithoutEmailTest(){
        NewUser newUser = NewUserGenerator.generateNewUserWithoutEmail();

        given().body(newUser)
                .post(ADD_URL)
                .then().log().all()
                .statusCode(200)
                .body("id",notNullValue())
                .body("id", anyOf(equalTo(1), equalTo(11)));

    }

    @DisplayName("Добавить нового пользователя без пароля")
    @Tag("Positive")
    @Test
    public void addNewUserWithoutPasswordTest(){
        NewUser newUser = NewUserGenerator.generateNewUserWithoutPassword();

        given().body(newUser)
                .post(ADD_URL)
                .then().log().all()
                .statusCode(200)
                .body("id",notNullValue())
                .body("id", anyOf(equalTo(1), equalTo(11)));

    }
}
