package api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyTestApi {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(DummyTestApi.class);
        logger.info("Hello World Log");
        System.out.println("This is Demo class example. " +
                "Tests need to be placed in this package");

    }
}
