import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.hamcrest.Matchers.notNullValue;

public class AuthIntegrationTest {
    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void shouldReturnOKWithValidToken(){
        String loginPayload = """
                {
                "email": testuser@test.com,
                "password": "password123"
                }
                """;

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(loginPayload)
                .when()
                .post("auth/login")
                .then()
                .statusCode(200)
                .body("token",notNullValue())
                .extract().response();

        System.out.println("Generated Token: "+ response.jsonPath().getString("token"));
    }

    @Test
    public void shouldReturnUnauthorizedOnInvalidLogin(){
        String loginPayload = """
                {
                "email": invalid_user@test.com,
                "password": "wrongpassword"
                }
                """;

        Response response = (Response) RestAssured.given()
                .contentType(ContentType.JSON)
                .body(loginPayload)
                .when()
                .post("auth/login")
                .then()
                .statusCode(401);
    }
}
