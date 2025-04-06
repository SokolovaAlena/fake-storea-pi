package products;

import config.BaseTest;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import static config.BaseTest.BASE_URI;

public class GetProductsTest extends BaseTest{


    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BASE_URI;
    }


    //вариант 1
    @Test
    public void shouldGetProducts() {

        Response response = RestAssured.given()
                .get(PRODUCTS_URL);

        Assertions.assertEquals(200, response.getStatusCode(),"Неверный статус код");
    }

    //вариант 2
    @Test
    public void shouldGetProducts2() {
       Response response =  RestAssured.given()
                .when()
                .get("/products")
               .andReturn();
        ResponseBody responseBody = response.getBody();
        ResponseGetProductsItem [] actualResult = responseBody.as(ResponseGetProductsItem[].class);
        Assertions.assertEquals(20, actualResult.length);
    }

}
