package utilities;

import java.io.InputStream;

import java.util.Properties;

public final class ConfigReader {

    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            final InputStream inputStream =
                    ConfigReader.class.getClassLoader()
                            .getResourceAsStream("configure.properties");

            if (inputStream == null) {
                throw new RuntimeException("configure.properties not found in classpath");
            }
            PROPERTIES.load(inputStream);

        } catch (Exception e) {
            throw new RuntimeException("Properties file loading failed", e);
        }
    }

    private ConfigReader() {
    }

    public static String optString(final String key,final String defaultValue) {
        final String value = PROPERTIES.getProperty(key);
        return value != null ? value : defaultValue;
    }

    public static String optString(final String key) {
        return optString(key, "");
    }
}