package utils;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {


    public static RequestSpecification getRequestSpecification(){
        return RestAssured.given()
                .baseUri(ConfigReader.getProperty("baseUrl"))
                .header("api_key",ConfigReader.getProperty("apiKey"))
                .contentType("application/json")
                .log().all();
    }

    public static Response getRequest(String endpoint) {
        return RestAssured.given()
                          .baseUri(ConfigReader.getProperty("baseUrl"))
                          .get(endpoint);
    }

    public static Response postRequest(String endpoint,String body){
        return RestAssured.given()
                .baseUri(ConfigReader.getProperty("baseUrl"))
                .header("Content-Type","application/json")
                .body(body)
                .post(endpoint);
    }

    public static Response putRequest(String endpoint, String body){
        return RestAssured.given()
                .baseUri(ConfigReader.getProperty("baseUrl"))
                .header("Content-Type","application/json")
                .body(body)
                .put(endpoint);
    }

    public static Response deleteRequest(String endpoint){
        return RestAssured.given()
                .given()
                .relaxedHTTPSValidation() // HTTPS doğrulamasını gevşetir
                .spec(getRequestSpecification())
                .log().all() // Tüm isteği logla
                .when()
                .delete(endpoint)
                .andReturn(); // Exception fırlatmayı önler ve yanıtı döner
    }


}
