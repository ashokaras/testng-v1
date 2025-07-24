package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APIUtils {

    public Response response = null;

    public void sendAPIRequest(String requestType, String endPoint, String payload) {
        try {
            RestAssured.baseURI = "";
            switch (requestType) {
                case "get":
                    response = given().
                            when().get(endPoint).
                            then().extract().response();
                    break;
                case "post":
                    response = given()
                            .when().body(payload)
                            .post(endPoint).then().extract().response();
                    break;
                case "put":
                    response = given()
                            .when().body(payload)
                            .put(endPoint).then().extract().response();
                    break;
            }
        }catch(Exception  e) {
            e.printStackTrace();
        }
    }

}
