package api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyTestApi {
    private static final Logger logger = LoggerFactory.getLogger(DummyTestApi.class);


    public static void main(String[] args) {
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");
        System.out.println("This is Demo class example. " +
                "Tests need to be placed in this package");

    }
}
