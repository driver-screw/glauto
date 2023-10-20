package config.harder;

import java.util.*;

public class ConfigHarder {
    private static final Map<String, String> prop = new HashMap<>();
    private static final List<IPropertyProvider> propertiesProviderList = Arrays.asList(PropertiesProvider.getInstance()
            , JSONPropertiesProvider.getInstance(), SystemPropertiesProvider.getInstance());
    private static final List<String> propertyNameList = Arrays.asList(
            "timeout",
            "user.name",
            "base_url"
    );

    static {
        propertyNameList.forEach(key -> {
            Iterator<IPropertyProvider> iterator = propertiesProviderList.iterator();
            String value = "";
            while (iterator.hasNext()) {
                value = iterator.next().getProperty(key);
                if (value != null && !(value.isEmpty())) {
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
