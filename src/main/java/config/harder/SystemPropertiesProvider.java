package config.harder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemPropertiesProvider implements IPropertyProvider {
    private static final Logger logger = LoggerFactory.getLogger(SystemPropertiesProvider.class);
    private static SystemPropertiesProvider systemPropertiesProvider;

    @Override
    public String getProperty(String propName) {
        String value = System.getProperty(propName);
        if (value != null) {
            logger.info("Property \"{}\" = \"{}\"", propName, value);
        }
        return value;
    }

    public static IPropertyProvider getInstance() {
        if (systemPropertiesProvider == null) {
            systemPropertiesProvider = new SystemPropertiesProvider();
        }
        return systemPropertiesProvider;
    }
}
