package libraryFunctions;
import java.security.*;
public class helper {

    public static String hashPassword(String password) {
        //This should hash the password (Use a message digest = https://www.tutorialspoint.com/java_cryptography/java_cryptography_message_digest.htm)
        return password;
    }

    public static boolean CompareHashed(String databasePassword, String userEnteredPassword) {
        return hashPassword(userEnteredPassword).equals(databasePassword);
    }

}
