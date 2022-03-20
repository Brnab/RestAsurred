package co.com.sofka.util;

public enum log4jValues {

    LOG4J_PROPERTIES_FILE_PATH("\\src\\main\\resources\\log4j2.properties");

    private final String value;

    log4jValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
