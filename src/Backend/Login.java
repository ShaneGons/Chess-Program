package Backend;
import libraryFunctions.*;
import Main.main;
import HashMaps.HashData;

public class Login {
    public static boolean createAccount(String email, char[] password){ //checks that password is not null
        try {
            if (!repository.checkIfEmailIsAlreadyUsed(email)) { //ensures email isn't taken
                repository.addAccountToDataBase(email, HashData.byteArrayToString(HashData.getHashValue(password))); //add to table
                return true;
            }System.out.println("Email already used");
        }catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }
    
    public static userAccount loginUser(String email, char[] password, userAccount account){
        try {
            if (repository.checkIfAccountIsInDataBase(email, HashData.byteArrayToString(HashData.getHashValue(password)))) {
                account = repository.findAccountInDatabase(email);
                return account;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
