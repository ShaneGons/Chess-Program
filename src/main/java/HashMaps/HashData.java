package HashMaps;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.nio.*;
import java.nio.charset.Charset;

public class HashData {
    private static String hashAlgo = "SHA-256"; // this sets the algorithm that the data will be hashed by
    
    public static byte[] getHashValue(char[] password) throws NoSuchAlgorithmException {
        byte[] bytePassword = toBytes(password);
        MessageDigest digest = MessageDigest.getInstance(hashAlgo);
        digest.reset();
        byte[] hash = digest.digest(bytePassword);
        return hash;
    }
    // this changes the password which is a char array to a byte array so it can be hashed 
    private static byte[] toBytes(char[] chars) {
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(charBuffer);
        byte[] bytes = Arrays.copyOfRange(byteBuffer.array(),
                  byteBuffer.position(), byteBuffer.limit());
        Arrays.fill(byteBuffer.array(), (byte) 0); // clear sensitive data
        return bytes;
    }
}
