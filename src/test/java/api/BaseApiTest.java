package api;

import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseApiTest {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected GitHubApiClient client;

    @BeforeEach
    public void setUp() {
        client = new GitHubApiClient();
    }
}
