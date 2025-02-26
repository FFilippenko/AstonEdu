package lesson_17;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestPostmanEcho {
    private static String baseURL = "https://postman-echo.com/";
    private static final String BODY = "{ \"name\": \"Filipp\", \"age\": 34,\"non-ASCII-symbols\": \"Привет\"," +
            " \"empty-value\": \"\", \"null-value\": null}";

    private static Stream<String> bodyProvider() {
        return Stream.of("", BODY);
    }

    @Test
    public void testGetRequest() {
        given()
                .queryParam("name", "Filipp")
                .queryParam("non-ASCII-symbols", "Привет")
                .queryParam("empty-value", "")
                .when()
                .get(baseURL + "get")
                .then()
                .statusCode(200)
                .body("args.name", equalTo("Filipp"))
                .body("args.non-ASCII-symbols", equalTo("Привет"))
                .body("url", equalTo(baseURL +
                        "get?name=Filipp&non-ASCII-symbols=%D0%9F%D1%80%D0%B8%D0%B2%D0%B5%D1%82&empty-value="))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .log().all();
    }

    @ParameterizedTest
    @MethodSource("bodyProvider")
    public void testPostRawTextRequest(String body) {
        given()
                .header("Content-Type", "text/plain; charset=UTF-8")
                .body(body)
                .when()
                .post(baseURL + "post")
                .then()
                .statusCode(200)
                .body("data", equalTo(body))
                .body("url", equalTo(baseURL + "post"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.content-type", equalTo("text/plain; charset=UTF-8"))
                .log().all();
    }

    @Test
    public void testPostFormDataRequest() {
        given()
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("name", "Filipp")
                .formParam("age", 34)
                .formParam("non-ASCII-symbols", "Привет")
                .formParam("empty-value", "")
                .when()
                .post(baseURL + "post")
                .then()
                .statusCode(200)
                .body("form.name", equalTo("Filipp"))
                .body("form.age", equalTo("34"))
                .body("form.non-ASCII-symbols", equalTo("Привет"))
                .body("form.empty-value", equalTo(""))
                .body("url", equalTo(baseURL + "post"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=UTF-8"))
                .log().all();
    }

    @ParameterizedTest
    @MethodSource("bodyProvider")
    public void testPutRequest(String body) {
        given()
                .header("Content-Type", "text/plain; charset=UTF-8")
                .body(body)
                .when()
                .put(baseURL + "put")
                .then()
                .statusCode(200)
                .body("data", equalTo(body))
                .body("url", equalTo(baseURL + "put"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.content-type", equalTo("text/plain; charset=UTF-8"))
                .log().all();
    }

    @ParameterizedTest
    @MethodSource("bodyProvider")
    public void testPatchRequest(String body) {
        given()
                .header("Content-Type", "text/plain; charset=UTF-8")
                .body(body)
                .when()
                .patch(baseURL + "patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(body))
                .body("url", equalTo(baseURL + "patch"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.content-type", equalTo("text/plain; charset=UTF-8"))
                .log().all();
    }

    @ParameterizedTest
    @MethodSource("bodyProvider")
    public void testDeleteRequest(String body) {
        given()
                .header("Content-Type", "text/plain; charset=UTF-8")
                .body(body)
                .when()
                .delete(baseURL + "delete")
                .then()
                .statusCode(200)
                .body("data", equalTo(body))
                .body("url", equalTo(baseURL + "delete"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.content-type", equalTo("text/plain; charset=UTF-8"))
                .log().all();
    }
}