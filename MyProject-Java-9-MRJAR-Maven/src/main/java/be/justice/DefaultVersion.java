package be.justice;

public class DefaultVersion {
    public String version() {
        return System.getProperty("java.version");
    }
}