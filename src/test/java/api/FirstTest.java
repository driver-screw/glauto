package api;

import api.verify.VerifyForRepository;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

public class FirstTest extends BaseApiTest {

    @Test
    public void testSearchForExistingRepo() {
        logger.info("Test testSearchForExistingRepo");
        JsonPath repos = client.searchRepos("junit-team/junit5-samples");
        VerifyForRepository.verifyTotalCount(3, repos);
    }

    @Test
    public void testSearchForNonExistingRepo() {
        logger.info("Test testSearchForNonExistingRepo");
        JsonPath repos = client.searchRepos("non-existing-repo-asdfggfdswefrgthngf");
        VerifyForRepository.verifyTotalCount(0, repos);

    }

    @Test
    public void testSearchNonExistedCommit() {
        logger.info("Test testSearchNonExistedCommit");
        JsonPath commits = client.searchCommit("non-existing-comit-asdfggfdswefrgthngf");
        VerifyForRepository.verifyTotalCount(0, commits);
    }
}
