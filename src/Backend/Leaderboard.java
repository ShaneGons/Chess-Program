package Backend;
import libraryFunctions.*;
import java.util.*;

public class Leaderboard {
    public static userAccount[] getSortedAccounts(Object choice){
        LinkedList<userAccount> allAccounts = repository.returnAllAccountsInDatabase();
        userAccount[] sortedAccounts = new userAccount[allAccounts.size()];
       
        for (int i = 0; i < allAccounts.size(); i++) {
            sortedAccounts[i] = allAccounts.get(i);
        }
        sortedAccounts = repository.mergeSort(sortedAccounts, choice);
        for (int i = 0; i < sortedAccounts.length; i++) {
            System.out.println(sortedAccounts[i].toString());
        }
        return sortedAccounts;
    }
}
