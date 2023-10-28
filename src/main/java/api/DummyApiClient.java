package api;

import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyApiClient {

    private static final Logger logger = LoggerFactory.getLogger(DummyApiClient.class);

    public static void main(String[] args) {
        String url = "https://httpbin.org/get";
        logger.debug("{} {}", "GET", url);
        String print = RestAssured.given()
                .get("https://httpbin.org/get")
                .body().prettyPeek().asPrettyString();
        logger.debug("{}{}{}", "response:", System.lineSeparator(), print);
    }
}
