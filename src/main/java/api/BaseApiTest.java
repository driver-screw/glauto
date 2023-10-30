package api;

import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseApiTest {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected static GitHubApiClient client;

    @BeforeAll
    public static void setUp() {
        client = new GitHubApiClient();
    }
}
