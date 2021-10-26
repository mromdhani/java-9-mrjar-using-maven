package be.justice;

import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        logger.info(String.format("Running on %s", new DefaultVersion().version()));
    }

}