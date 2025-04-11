package users;

import config.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.*;
import users.newUser.NewUser;
import users.newUser.NewUserGenerator;
import users.newUser.ResponseToAddNewUser;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AddNewUserTest extends BaseTest{

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = getHost();
    }


    @DisplayName("Добавить нового пользователя со всеми параметрами")
    @Tag("Positive")
    @Test
    public void addNewUserWithAllFieldsTest (){
        NewUser newUser = NewUserGenerator.generateNewUser();

        given().body(newUser)
                .post(getUsersEndpoint())
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
                .post(getUsersEndpoint())
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
                .post(getUsersEndpoint())
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
        Response response = given().body(newUser)
                .when()
                .post(getUsersEndpoint())
                .andReturn();
        ResponseBody responseBody = response.getBody();
        ResponseToAddNewUser myresp = responseBody.as(ResponseToAddNewUser.class);

        Assertions.assertEquals(1, myresp.getId());
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
