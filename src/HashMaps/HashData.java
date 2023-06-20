package HashMaps;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.nio.*;
import java.nio.charset.Charset;

public class HashData {
    private static String hashAlgo = "SHA-256"; // this sets the algorithm that the data will be hashed by
    
    public static byte[] getHashValue(char[] password) throws NoSuchAlgorithmException {
        byte[] bytePassword = toBytes(password); //changes char array to byte array
        MessageDigest digest = MessageDigest.getInstance(hashAlgo); //sets the hashing algorithm that will be used
        digest.reset(); 
        byte[] hash = digest.digest(bytePassword); //stores hash
        return hash;
    }
    // this changes the password which is a char array to a byte array so it can be hashed 
    private static byte[] toBytes(char[] chars) {
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(charBuffer); //sets unicode character set to UTF-8
        byte[] bytes = Arrays.copyOfRange(byteBuffer.array(),
                  byteBuffer.position(), byteBuffer.limit());
        Arrays.fill(byteBuffer.array(), (byte) 0); // clear sensitive data
        return bytes;
    }
    //changes the hash into a string so it can be stored in the database.
    public static String byteArrayToString(byte[] byteArray){
        String string = "";
        for (int i = 0; i < byteArray.length; i++) {
            string = string+byteArray[i];
        }return string;
    }
}
