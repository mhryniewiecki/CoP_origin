package common.fileService;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author Michal.Hryniewiecki
 */
public class ConfigFile {

    private static final String FILENAME;

    static {
        FILENAME = System.getProperty("filename");
        System.out.println("Config filename set is: " + FILENAME);
    }
    private static Properties properties = new Properties();

    private static boolean isInitialized = false;

    public static void init() throws Exception {
        if (!isInitialized) {
            properties = readFile();
            isInitialized = true;
        }
    }

    private static Properties readFile() throws Exception {
        File file = new File(FILENAME);
        if (!file.exists()) {
            throw new Exception("Config file " + FILENAME + " does not exist [Exception]");
        }
        Properties properties = new Properties();
        FileInputStream in = new FileInputStream(FILENAME);
        properties.load(in);
        in.close();

        return properties;
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
