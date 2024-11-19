package codegen;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UniqueCodeGenerator {


    private static final String PREFIX = "CA-";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public static void main(String[] args) {
        // Generate and print 10 unique codes as an example
        for (int i = 0; i < 10; i++) {
            System.out.println(generateUniqueCode());
        }
    }

    /**
     * Generates a unique code based on the current date and time.
     *
     * @return A unique code in the format PREFIX + date-time components.
     */
    public static String generateUniqueCode() {
        String dateTimePart = DATE_FORMAT.format(new Date());
        return PREFIX + dateTimePart;
    }
    
}
