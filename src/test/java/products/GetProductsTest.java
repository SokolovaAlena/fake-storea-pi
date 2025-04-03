package products;

import config.BaseTest;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import static config.BaseTest.BASE_URI;

public class GetProductsTest {


    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BaseTest.BASE_URI;
    }

//    @BeforeAll
//    public static void logRequestAndResponse (){
////        включить логирование запросов и ответов
//        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
//    }

    //вариант 1
    @Test
    public void shouldGetProducts() {

        Response response = RestAssured.given()
                .get("/products");

        Assertions.assertEquals(200, response.getStatusCode(),"Неверный статус код");
    }

    //вариант 2
    @Test
    public void shouldGetProducts2() {
        RestAssured.given()
                .when()
                .get("/products")
                .then()
                .statusCode(200);
    }

}
