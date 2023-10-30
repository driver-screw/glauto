package api;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Verify {
    protected final static Logger logger = LoggerFactory.getLogger(Verify.class);

    public static void verifyTotalCount(int expected, JsonPath jp) {
        int actualTotalCount = jp.get("total_count");
        logger.info("Verify Total Count should be '{}'",expected);
        Assertions.assertEquals(expected, actualTotalCount,
                ()->"total_count='%d' and should be '%d'".formatted(actualTotalCount,expected));
    }
}
