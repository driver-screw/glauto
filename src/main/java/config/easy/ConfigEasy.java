package config.easy;

public class ConfigEasy {
    private static final int REQUEST_TIMEOUT = 29;
    private static final String USER_NAME = System.getProperty("user.name");
    private static final String OS_NAME = System.getProperty("os.name");


    public static int getRequestTimeout() {
        return REQUEST_TIMEOUT;
    }

    public static String getUserName() {
        return USER_NAME;
    }

    public static String getOsName() {
        return OS_NAME;
    }

    public static void main(String[] args) {
        System.out.println("request_timeout=" + REQUEST_TIMEOUT);
        System.out.println(OS_NAME);
        System.out.println("-".repeat(90));
        System.getenv().entrySet().forEach(System.out::println);
        System.out.println("-".repeat(90));
        System.out.println(System.getProperty("user.name"));
        System.out.println("-".repeat(90));
        System.getProperties().forEach((k, v) -> System.out.printf("%s=%s%n", k, v));
    }
}
