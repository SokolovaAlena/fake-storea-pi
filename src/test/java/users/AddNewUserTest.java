package users;

import config.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

public class AddNewUserTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BaseTest.BASE_URI;
    }


    @DisplayName("Добавить нового пользователя со всеми параметрами")
    @Tag("Positive")
    @Test
    public void addNewUserWhithAllFieldsTest (){
        NewUserClient newUserClient = new NewUserClient();
        NewUser newUser = NewUserGenerator.generateNewUser();

        Response response =  newUserClient.create(newUser);

        Assertions.assertEquals(200,response.getStatusCode(),"wrong status code");

    }

    @DisplayName("Добавить нового пользователя без имени")
    @Tag("Positive")
    @Test
    public void addNewUserWithoutUserNameTest (){
        NewUserClient newUserClient = new NewUserClient();
        NewUser newUser = NewUserGenerator.generateNewUserWithoutUserName();

        Response response =  newUserClient.create(newUser);

        Assertions.assertEquals(200,response.getStatusCode(),"wrong status code");

    }


    @DisplayName("Добавить нового пользователя без email")
    @Tag("Positive")
    @Test
    public void addNewUserWithoutEmailTest(){
        NewUserClient newUserClient = new NewUserClient();
        NewUser newUser = NewUserGenerator.generateNewUserWithoutEmail();

        Response response =  newUserClient.create(newUser);

        Assertions.assertEquals(200,response.getStatusCode(),"wrong status code");
//        Assertions.assertNotNull(response.getBody("id"),"Id is null");

    }

    @DisplayName("Добавить нового пользователя без пароля")
    @Tag("Positive")
    @Test
    public void addNewUserWithoutPasswordTest(){
        NewUserClient newUserClient = new NewUserClient();
        NewUser newUser = NewUserGenerator.generateNewUserWithoutPassword();

        Response response =  newUserClient.create(newUser);

        Assertions.assertEquals(200,response.getStatusCode(),"wrong status code");

    }
}
