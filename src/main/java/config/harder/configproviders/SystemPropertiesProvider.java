package config.harder.configproviders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemPropertiesProvider implements IPropertyProvider {
    private static final Logger logger = LoggerFactory.getLogger(SystemPropertiesProvider.class);
    private static SystemPropertiesProvider systemPropertiesProvider;

    @Override
    public String getProperty(String propName) {
        return System.getProperty(propName);
    }

    public static IPropertyProvider getInstance() {
        if (systemPropertiesProvider == null) {
            systemPropertiesProvider = new SystemPropertiesProvider();
        }
        return systemPropertiesProvider;
    }
}
