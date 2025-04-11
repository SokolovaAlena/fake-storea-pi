package products;

import config.BaseTest;
import groovyjarjarantlr4.runtime.BaseRecognizer;
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



public class GetProductsTest extends BaseTest{


    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = getHost();
    }



    //вариант 1
    @Test
    public void shouldGetProducts() {

        Response response = RestAssured.given()
                .get(getProductsEndpoint());

        Assertions.assertEquals(200, response.getStatusCode(),"Неверный статус код");
    }

    //вариант 2
    @Test
    public void shouldGetProducts2() {
       Response response =  RestAssured.given()
                .when()
                .get(getProductsEndpoint())
               .andReturn();
        ResponseBody responseBody = response.getBody();
        ResponseGetProductsItem [] actualResult = responseBody.as(ResponseGetProductsItem[].class);
        Assertions.assertEquals(20, actualResult.length);
    }

}
