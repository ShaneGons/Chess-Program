package Backend;
import GUI.EmailVerification;
import java.io.File;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class Email {
    private static int verified = -1;
    private final static String from = "thisisnotanautomatedbot@gmail.com";
    private static String otp;
    
    public static boolean validateEmail(String email, boolean verified){
        return verified;
    }
    public static void sendEmail(userAccount account){
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com"); 
        p.put("mail.smtp.port", "587");
        Session s = Session.getInstance(p, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(from, "Suzette123");
            }
        });
        try {
            Message message = new MimeMessage(s);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(
            Message.RecipientType.TO, InternetAddress.parse(account.getEmail()));
            message.setSubject("Chess program OTP");
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            
            Random digit = new Random();
            int firstDigit = digit.nextInt(9);
            int secondDigit = digit.nextInt(9);
            int thirdDigit = digit.nextInt(9);
            int fourthDigit = digit.nextInt(9);
            int fifthDigit = digit.nextInt(9);
            int sixthDigit = digit.nextInt(9);
            otp = String.valueOf(firstDigit)+String.valueOf(secondDigit)+String.valueOf(thirdDigit)+
                    String.valueOf(fourthDigit)+String.valueOf(fifthDigit)+String.valueOf(sixthDigit);
            mimeBodyPart.setContent(otp, "text/html; charset=utf-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);
            Transport.send(message);
            
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Couldn't send email, please check email address given");
        }
    }
    public static boolean checkOTP(String OTP){
        return (otp.equals(OTP))? true:false;
    }
}
