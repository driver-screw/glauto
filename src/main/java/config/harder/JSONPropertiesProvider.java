package config.harder;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class JSONPropertiesProvider implements IPropertyProvider {
    private static final Logger logger = LoggerFactory.getLogger(JSONPropertiesProvider.class);
    private static JSONPropertiesProvider jsonPropertiesProvider;
    private final JsonObject jsonObject;

    public static JSONPropertiesProvider getInstance() {
        if (jsonPropertiesProvider == null) {
            jsonPropertiesProvider = new JSONPropertiesProvider();
        }
        return jsonPropertiesProvider;
    }

    {
        String rootResourcesPath = Objects.requireNonNull(PropertiesProvider.class.getResource("")).getPath();
        System.out.println(rootResourcesPath);
        String configPath = rootResourcesPath + "config.json";
        try {
            jsonObject = JsonParser.parseReader(new FileReader(configPath)).getAsJsonObject();
            logger.debug("Properties loaded");

        } catch (IOException e) {
            logger.error("Properties NOT loaded", e);
            throw new RuntimeException(e);

        }
    }

    @Override
    public String getProperty(String propName) {
        String value = Optional.ofNullable(jsonObject.get(propName)).orElse(new JsonPrimitive("")).getAsString();
        if (!value.isEmpty()) {
            logger.info("Property \"{}\" = \"{}\"", propName, value);
        }
        return value;
    }
}
