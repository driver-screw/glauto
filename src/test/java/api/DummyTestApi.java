package api;

import config.harder.ConfigHarder;
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


        String timeout = ConfigHarder.getProperty("timeout");
        String baseUrl = ConfigHarder.getProperty("base_url");
        String userName = ConfigHarder.getProperty("user.name");

        System.out.println(timeout);
        System.out.println(baseUrl);
        System.out.println(userName);

    }
}
