package be.justice;
public class DefaultVersion {
    public String version() {
        return Runtime.version().toString();
    }
}