package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private StringUtils() {
    }

    /**
     * Looking for pattern matching in input string.
     *
     * @param input   input string
     * @param pattern regular expression
     * @return matched string if found or empty string
     */
    public static String getStringByPattern(String input, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        if (m.find()) {
            return m.group();
        }
        return "";
    }

}
