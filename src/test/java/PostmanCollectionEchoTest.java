import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostmanCollectionEchoTest {
    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void getRequestWoopsTest() {
        Response response =
                given()
                        .when().get("/get?foo1=bar1&foo2=bar2")
                        .then().log().body()
                        .extract().response();
        Assertions.assertEquals(response.getStatusCode(), 200);
        Assertions.assertEquals(response.jsonPath().getString("args.foo1"), "bar1");
        Assertions.assertEquals(response.jsonPath().getString("args.foo2"), "bar2");
    }

    @Test
    public void getRequestTest() {
        Response response =
                given()
                        .when().get("/get?foo1=bar1&foo2=bar2")
                        .then().log().body()
                        .extract().response();
        Assertions.assertEquals(response.getStatusCode(), 200);
        Assertions.assertEquals(response.jsonPath().getString("args.foo1"), "bar1");
        Assertions.assertEquals(response.jsonPath().getString("args.foo2"), "bar2");
    }

    @Test
    public void postRequestTest() {

        String requestBody = "This is expected to be sent back as part of response body.";
        Response response =
                given()
                        .contentType(ContentType.TEXT)
                        .body(requestBody)
                        .when()
                        .post("/post")
                        .then().log().body()
                        .statusCode(200)
                        .extract().response();
        Assertions.assertEquals(response.getStatusCode(), 200);
        Assertions.assertEquals("This is expected to be sent back as part of response body.", response.jsonPath().getString("data"));
    }

    @Test
    public void postFormDataRequestTest() {
        Response response =
                RestAssured.given().config(RestAssured.config()
                                .encoderConfig(EncoderConfig.encoderConfig()
                                        .encodeContentTypeAs("x-www-form-urlencoded",
                                                ContentType.URLENC)))
                        .contentType(ContentType.URLENC.withCharset("UTF-8"))
                        .log().all()
                        .formParam("foo1", "bar1")
                        .formParam("foo2", "bar2")
                        .when()
                        .post("/post")
                        .then().log().all()
                        .extract().response();
        Assertions.assertEquals(200,response.getStatusCode());
        Assertions.assertEquals("bar2",response.jsonPath().getString("form.foo2"));
        Assertions.assertEquals("bar1",response.jsonPath().getString("form.foo1"));

    }

    @Test
    public void putRequestTest() {
        String responseBody = "This is expected to be sent back as part of response body";
        Response response =
                given()
                        .contentType(ContentType.TEXT)
                        .body(responseBody)
                        .when()
                        .put("/put")
                        .then().log().body()
                        .statusCode(200)
                        .extract().response();
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(responseBody, response.jsonPath().getString("data"));
    }

    @Test
    public void patchRequestTest() {
        String responseBody = "This is expected to be sent back as part of response body.";
        Response response =
                given()
                        .body(responseBody)
                        .contentType(ContentType.TEXT)
                        .when()
                        .patch("/patch")
                        .then().log().body()
                        .extract().response();
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(responseBody, response.jsonPath().getString("data"));
    }

    @Test
    public void deleteRequestTest() {
        String responseBody = "This is expected to be sent back as part of response body.";
        Response response =
                given()
                        .body(responseBody)
                        .when()
                        .delete("/delete")
                        .then().log().body()
                        .extract().response();
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(responseBody, response.jsonPath().getString("data"));

    }
}