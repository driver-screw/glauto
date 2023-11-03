package config.harder;

import config.harder.configproviders.IPropertyProvider;
import config.harder.configproviders.JSONPropertiesProvider;
import config.harder.configproviders.PropertiesProvider;
import config.harder.configproviders.SystemPropertiesProvider;
import config.harder.exceptions.PropertyNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ConfigHarder {
    private static final Logger logger = LoggerFactory.getLogger(ConfigHarder.class);
    private static final Map<String, String> prop = new HashMap<>();
    private static final List<IPropertyProvider> propertiesProviderList = Arrays.asList(PropertiesProvider.getInstance()
            , JSONPropertiesProvider.getInstance(), SystemPropertiesProvider.getInstance());
    private static final List<String> propertyNameList = Arrays.asList(
            "timeout",
            "user.name",
            "base_url",
            "github_base_url"
    );

    static {
        propertyNameList.forEach(key -> {
            Iterator<IPropertyProvider> iterator = propertiesProviderList.iterator();
            String value = "";
            while (iterator.hasNext()) {
                IPropertyProvider propertyProvider = iterator.next();
                value = propertyProvider.getProperty(key);
                if (value != null && !(value.isEmpty())) {
                    logger.info("{} are get from {}",key, propertyProvider.getClass().getSimpleName());
                    prop.put(key, value);
                    break;
                }
            }
            if (value == null || value.isEmpty()) {
                throw new PropertyNotFoundException("Property \"%s\" not found in any Property Provider%n".formatted(key));
            }

        });
    }

    public static String getProperty(String key) {
        return prop.get(key);
    }


}
