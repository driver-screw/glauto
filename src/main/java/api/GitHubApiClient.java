package api;

import config.harder.ConfigHarder;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GitHubApiClient {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final String SEARCH_REPOSITORIES_URI = "/search/repositories";
    protected final String SEARCH_COMMITS_URI = "/search/commits";
    private RequestSpecification requestSpec;


    {
        RestAssured.baseURI = ConfigHarder.getProperty("github_base_url");
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Accept", "application/json");
        builder.addHeader("X-GitHub-Api-Version", "2022-11-28");

        requestSpec = builder.build();
    }

    /**
     * Only for positive scenarios
     */
    public JsonPath searchRepos(String repoName) {

        logger.info("Getting repo '{}'", repoName);
        logger.debug("GET {}{}{}{}", RestAssured.baseURI, SEARCH_REPOSITORIES_URI, "?q=", repoName);
        JsonPath response = RestAssured
                .given(requestSpec)
                .queryParam("q", repoName)
                .get(SEARCH_REPOSITORIES_URI)
                .then()
//                .log().all()
                .assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .extract().jsonPath();
        logger.debug("Response:{}{}", System.lineSeparator(), response.prettify());
        return response;
    }

    /**
     * Only for positive scenarios
     */
    public JsonPath searchCommit(String commit) {

        logger.info("Getting commit '{}'", commit);
        logger.debug("GET {}{}{}{}", RestAssured.baseURI, SEARCH_COMMITS_URI, "?q=", commit);
        JsonPath response = RestAssured
                .given(requestSpec)
                .queryParam("q", commit)
                .get(SEARCH_COMMITS_URI)
                .then()
//                .log().all()
                .assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .extract().jsonPath();
        logger.debug("Response:{}{}", System.lineSeparator(), response.prettify());
        return response;
    }
}
