package config.harder.configproviders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;


public class PropertiesProvider implements IPropertyProvider {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesProvider.class);
    private static PropertiesProvider propertiesProvider;
    private final Properties prop = new Properties();


    public static PropertiesProvider getInstance() {
        if (propertiesProvider == null) {
            propertiesProvider = new PropertiesProvider();
        }
        return propertiesProvider;
    }

    {
        String rootResourcesPath = Objects.requireNonNull(PropertiesProvider.class.getResource("../")).getPath();
        System.out.println(rootResourcesPath);
        String configPath = rootResourcesPath + "config.properties";
        try {
            prop.load(new FileInputStream(configPath));
            logger.debug("Properties loaded");
        } catch (IOException e) {
            logger.error("Properties not loaded", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getProperty(String propName) {
        return prop.getProperty(propName);
    }
}
