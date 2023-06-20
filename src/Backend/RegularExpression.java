
package Backend;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    // requires digit + lowercase char + uppercase char + punctuation + symbol
    private static final String regexPass =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    private static final Pattern passPattern = Pattern.compile(regexPass);

    public static boolean isValidPassword(final String password) {
        Matcher matcher = passPattern.matcher(password);
        return matcher.matches();
    }
    
    private static final String regexEmail = "^(.+)@(.+)$";
    private static final Pattern emailPattern = Pattern.compile(regexEmail);
    
    public static boolean isValidEmail(final String email){
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }
    
}
