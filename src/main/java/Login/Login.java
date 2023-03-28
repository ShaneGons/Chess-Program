package Login;
public class Login {
    protected static boolean createAccount(String email, String confirmEmail, char[] password, char[] confirmPassword){
        System.out.println(email);
        if (email != null && confirmEmail != null && password != null && confirmPassword != null) {
            userAccount newAccount = new userAccount(email);
        }
        return true;
    }
    protected static boolean loginUser(String email, char[] password){
        
        return false;
    }
}
