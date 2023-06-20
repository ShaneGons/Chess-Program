package libraryFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import Backend.*;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;
//This class gets things in and out of the databases does operations on data

public class repository {

    private static final String DatabaseLocation = System.getProperty("user.dir") + "\\NEA.accdb";

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            return con;
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }
        return null;
    }
    public static void addAccountToDataBase(String email, String password) {
        try {
            Connection con = getConnection(); // establishes conection to database
            final String sql = "SELECT Logins.* FROM Logins"; //selects all records from Logins table
            ResultSet rs = executeSQL.executeQuery(con, sql); // stores all records as a result set
            System.out.println(rs.next());
            rs.moveToInsertRow(); // moves to the empty row to insert record
            rs.updateString("Email", email);
            rs.updateString("Password", password);
            rs.updateInt("Wins", 0);
            rs.updateInt("Losses", 0);
            rs.updateInt("Draws", 0);
            rs.updateInt("BlitzRating", 1000);
            rs.updateInt("RapidRating", 1000);
            rs.updateInt("ClassicalRating", 1000);
            rs.insertRow(); // inserts record into database
            con.close(); // closes connection
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void wait(int timeInMilliseconds){
        try {
            Thread.sleep(timeInMilliseconds);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
    public static boolean checkIfAccountIsInDataBase(String email, String password){
        if (checkIfEmailIsAlreadyUsed(email)) { // checks if email is already in use
            try {
                System.out.println(email);
                Connection con = getConnection();
                final String sql = "SELECT Logins.* FROM Logins";
                ResultSet rs = executeSQL.executeQuery(con, sql);
                while (rs.next()){ //cycles through all records
                    if (rs.getString("Password").equals(password)) { // checks if the entered password hash matches the hash in the database
                        rs.close();
                        con.close();
                        System.out.println("jd");
                        return true;
                    }
                }rs.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }
    public static boolean checkIfEmailIsAlreadyUsed(String email){
        try {
            Connection con = getConnection(); 
            System.out.println(email);
            final String sql = "SELECT Logins.* FROM Logins";
            ResultSet rs = executeSQL.executeQuery(con, sql);
            while (rs.next()){ // Cycles through all records
                if (rs.getString("Email").equals(email)) { //checking if records email is the one we are looking for
                    con.close();
                    rs.close();
                    return true;
                }
            }rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public static userAccount findAccountInDatabase(String email){
        try {
            Connection con = getConnection();
            final String sql = "SELECT Logins.* FROM Logins";
            ResultSet rs = executeSQL.executeQuery(con, sql);
            while (rs.next()){ // cycles through array
                if (rs.getString("Email").equals(email)) { // checks if email matches the email of the record
                    userAccount account = new userAccount();
                    account.setEmail(email);
                    account.setNumberOfWins(rs.getInt("Wins"));
                    account.setNumberOfLosses(rs.getInt("Losses"));
                    account.setNumberOfDraws(rs.getInt("Draws"));
                    account.setNumberOfGamesPlayed();
                    account.setWinRate();
                    account.setBlitzRating(rs.getInt("BlitzRating"));
                    account.setRapidRating(rs.getInt("RapidRating"));
                    account.setClassicalRating(rs.getInt("ClassicalRating"));
                    rs.close();
                    con.close();
                    return account; // returns account info stored in the database
                }
            }rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("hhh");
        return null;
    }
    public static LinkedList returnAllAccountsInDatabase(){
        LinkedList<userAccount> allAccounts = new LinkedList(); // list to store all the accounts
        try {
            Connection con = repository.getConnection();
            final String sql = "SELECT Logins.* FROM Logins";
            ResultSet rs = executeSQL.executeQuery(con, sql);
            while (rs.next()){ //loops through table
                if (!rs.getString("Email").equals("AI")) {
                    userAccount tempAccount = new userAccount();
                    tempAccount.setEmail(rs.getString("Email"));
                    tempAccount.setNumberOfWins(rs.getInt("Wins"));
                    tempAccount.setNumberOfLosses(rs.getInt("Losses"));
                    tempAccount.setNumberOfDraws(rs.getInt("Draws"));
                    tempAccount.setBlitzRating(rs.getInt("BlitzRating"));
                    tempAccount.setRapidRating(rs.getInt("RapidRating"));
                    tempAccount.setClassicalRating(rs.getInt("ClassicalRating"));
                    tempAccount.setNumberOfGamesPlayed();
                    tempAccount.setWinRate();
                    // creates a temp account and then with the info from the database without the password
                    allAccounts.add(tempAccount); //adds accounts to list
                }
                
            }rs.close();
            con.close();
            return allAccounts; //returns list
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public static userAccount[] mergeSort(userAccount[] array, Object choice){
        if (array.length <= 1) { //if array is empty or only has one item it can't be sorted
            return array;
        }
        int midpoint = array.length / 2; //findMidPoint ofArray
        userAccount[] left = new userAccount[midpoint];
        //Splits the array into two arrays
        userAccount[] right = new userAccount[midpoint+(array.length%2)]; //if array size if odd the sum of right's and left's length will be 1 off 
        // thus add 1 size of right
        
        for (int i = 0; i < midpoint; i++) {
            left[i] = array[i];
        }for (int j = 0; j < right.length; j++) {
            right[j] = array[midpoint+j];
        }
        // Populates the left and right array with the contents of array
        
        userAccount[] result = new userAccount[array.length]; // stores soreted array
        left = mergeSort(left,choice);
        right = mergeSort(right,choice);
        
        //recursively calls itself sorting the creates sub arrays of array
        if (choice.equals("Wins")) {
            result = mergeForWins(left,right);
        }else if (choice.equals("Losses")) {
            result = mergeForLosses(left,right);
        }else if (choice.equals("Draws")) {
            result = mergeForDraws(left,right);
        }else if (choice.equals("Games Played")) {
            result = mergeForGamesPlayed(left,right);
        }else if (choice.equals("Win Rate")) {
            result = mergeForWinRate(left,right);
        }else if (choice.equals("Blitz Rating")) {
            result = mergeForBlitzRating(left,right);
        }else if (choice.equals("Rapid Rating")) {
            result = mergeForRapidRating(left,right);
        }else if (choice.equals("Classical Rating")){
            result = mergeForClassicalRating(left,right);
        }
        return result;
    }
    
    private static userAccount[] mergeForDraws(userAccount[] left, userAccount[] right){
        userAccount[] result = new userAccount[left.length + right.length]; // result array needs to be the size of the sum of the sub arrays
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        
        while (leftPointer < left.length || rightPointer < right.length){ // while either arrays are not full
            if (leftPointer < left.length && rightPointer < right.length) { // checks if both arrays are not full
                if (left[leftPointer].getNumberOfDraws() > right[rightPointer].getNumberOfDraws()) { // checks if the item in the left array is smaller than the right array
                    result[resultPointer++] = left[leftPointer++]; //swaps items
                }else result[resultPointer++] = right[rightPointer++];
                // this adds the the smaller item to the result array
            }else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            }else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
            // if one of the arrays is full the other sub array fills the result array 
        }
        return result;
    }
    private static userAccount[] mergeForWins(userAccount[] left, userAccount[] right){
        userAccount[] result = new userAccount[left.length + right.length]; // result array needs to be the size of the sum of the sub arrays
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        
        while (leftPointer < left.length || rightPointer < right.length){ // while either arrays are not full
            if (leftPointer < left.length && rightPointer < right.length) { // checks if both arrays are not full
                if (left[leftPointer].getNumberOfWins() > right[rightPointer].getNumberOfWins()) { // checks if the item in the left array is smaller than the right array
                    result[resultPointer++] = left[leftPointer++]; //swaps items
                }else result[resultPointer++] = right[rightPointer++];
                // this adds the the smaller item to the result array
            }else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            }else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
            // if one of the arrays is full the other sub array fills the result array 
        }
        return result;
    }
    private static userAccount[] mergeForLosses(userAccount[] left, userAccount[] right){
        userAccount[] result = new userAccount[left.length + right.length]; // result array needs to be the size of the sum of the sub arrays
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        
        while (leftPointer < left.length || rightPointer < right.length){ // while either arrays are not full
            if (leftPointer < left.length && rightPointer < right.length) { // checks if both arrays are not full
                if (left[leftPointer].getNumberOfLosses() > right[rightPointer].getNumberOfLosses()) { // checks if the item in the left array is smaller than the right array
                    result[resultPointer++] = left[leftPointer++]; //swaps items
                }else result[resultPointer++] = right[rightPointer++];
                // this adds the the smaller item to the result array
            }else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            }else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
            // if one of the arrays is full the other sub array fills the result array 
        }
        return result;
    }
    private static userAccount[] mergeForGamesPlayed(userAccount[] left, userAccount[] right){
        userAccount[] result = new userAccount[left.length + right.length]; // result array needs to be the size of the sum of the sub arrays
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        
        while (leftPointer < left.length || rightPointer < right.length){ // while either arrays are not full
            if (leftPointer < left.length && rightPointer < right.length) { // checks if both arrays are not full
                if (left[leftPointer].getNumberOfGamesPlayed() > right[rightPointer].getNumberOfGamesPlayed()) { // checks if the item in the left array is smaller than the right array
                    result[resultPointer++] = left[leftPointer++]; //swaps items
                }else result[resultPointer++] = right[rightPointer++];
                // this adds the the smaller item to the result array
            }else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            }else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
            // if one of the arrays is full the other sub array fills the result array 
        }
        return result;
    }
    private static userAccount[] mergeForWinRate(userAccount[] left, userAccount[] right){
        userAccount[] result = new userAccount[left.length + right.length]; // result array needs to be the size of the sum of the sub arrays
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        
        while (leftPointer < left.length || rightPointer < right.length){ // while either arrays are not full
            if (leftPointer < left.length && rightPointer < right.length) { // checks if both arrays are not full
                if (left[leftPointer].getWinRate()> right[rightPointer].getWinRate()) { // checks if the item in the left array is smaller than the right array
                    result[resultPointer++] = left[leftPointer++]; //swaps items
                }else result[resultPointer++] = right[rightPointer++];
                // this adds the the smaller item to the result array
            }else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            }else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
            // if one of the arrays is full the other sub array fills the result array 
        }
        return result;
    }
    private static userAccount[] mergeForBlitzRating(userAccount[] left, userAccount[] right){
        userAccount[] result = new userAccount[left.length + right.length]; // result array needs to be the size of the sum of the sub arrays
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        
        while (leftPointer < left.length || rightPointer < right.length){ // while either arrays are not full
            if (leftPointer < left.length && rightPointer < right.length) { // checks if both arrays are not full
                if (left[leftPointer].getBlitzRating() > right[rightPointer].getBlitzRating()) { // checks if the item in the left array is smaller than the right array
                    result[resultPointer++] = left[leftPointer++]; //swaps items
                }else result[resultPointer++] = right[rightPointer++];
                // this adds the the smaller item to the result array
            }else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            }else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
            // if one of the arrays is full the other sub array fills the result array 
        }
        return result;
    }
    private static userAccount[] mergeForRapidRating(userAccount[] left, userAccount[] right){
        userAccount[] result = new userAccount[left.length + right.length]; // result array needs to be the size of the sum of the sub arrays
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        
        while (leftPointer < left.length || rightPointer < right.length){ // while either arrays are not full
            if (leftPointer < left.length && rightPointer < right.length) { // checks if both arrays are not full
                if (left[leftPointer].getRapidRating() > right[rightPointer].getRapidRating()) { // checks if the item in the left array is smaller than the right array
                    result[resultPointer++] = left[leftPointer++]; //swaps items
                }else result[resultPointer++] = right[rightPointer++];
                // this adds the the smaller item to the result array
            }else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            }else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
            // if one of the arrays is full the other sub array fills the result array 
        }
        return result;
    }
    private static userAccount[] mergeForClassicalRating(userAccount[] left, userAccount[] right){
        userAccount[] result = new userAccount[left.length + right.length]; // result array needs to be the size of the sum of the sub arrays
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        
        while (leftPointer < left.length || rightPointer < right.length){ // while either arrays are not full
            if (leftPointer < left.length && rightPointer < right.length) { // checks if both arrays are not full
                if (left[leftPointer].getClassicalRating() > right[rightPointer].getClassicalRating()) { // checks if the item in the left array is smaller than the right array
                    result[resultPointer++] = left[leftPointer++]; //swaps items
                }else result[resultPointer++] = right[rightPointer++];
                // this adds the the smaller item to the result array
            }else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            }else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
            // if one of the arrays is full the other sub array fills the result array 
        }
        return result;
    }
    
    private static void printArray(userAccount[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].toString()+" ");
        }
        System.out.println();
    }
    
    public static boolean validateEmail(String Email){
        return true;
    }

   public static LinkedList getSavedGames(){
        try {
            Connection con = getConnection();
            final String sql = "SELECT Games.* FROM Games";
            ResultSet rs = executeSQL.executeQuery(con, sql);
            LinkedList<Game> games = new LinkedList<>();
            while (rs.next()){
                Game currentGame = new Game(rs.getString(2),rs.getString(1),rs.getBoolean(3),rs.getString(4));
                games.add(currentGame);
            }rs.close();
            con.close();
            return games;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static ResultSet getResultSet(String sql){
        try {
            Connection con = getConnection();
            ResultSet rs = executeSQL.executeQuery(con, sql);
            con.close();
            return rs;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public static void changeAccountDetail(String ogItem, String item, String columnLabel, String sql){
        try {
            Connection con = getConnection();
            ResultSet rs = executeSQL.executeQuery(con, sql);
            while (rs.next()){
                if (ogItem.equals(rs.getString(columnLabel))) {
                    rs.updateString(columnLabel, item);
                    rs.updateRow();
                }
            }
            con.close();
            rs.close();
        } catch (Exception e) {
        }
    }
    
    public static void deleteRecord(String sql){
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate(sql);
            System.out.println(rows+" rows were deleted");
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e+" in deleteRecord");
        }
    }
    public static void updateInt(String sql, String columnLabel, String identifier, int newInt, String primaryKey){
        try {
            Connection con = getConnection();
            ResultSet rs = executeSQL.executeQuery(con, sql);
            while (rs.next()){
                if (identifier.equals(rs.getString(primaryKey))) {
                    rs.updateInt(columnLabel, newInt);
                    rs.updateRow();
                }
            }rs.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println(e+" in updateInt");
        }
    }
    public static void updateWinsLossesDraws(String sql, String columnLabel, String identifier, int newInt, String primaryKey){
        try {
            Connection con = getConnection();
            ResultSet rs = executeSQL.executeQuery(con, sql);
            while (rs.next()){
                if (identifier.equals(rs.getString(primaryKey))) {
                    rs.updateInt(columnLabel, rs.getInt(columnLabel)+newInt);
                    rs.updateRow();
                }
            }rs.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println(e+" in updateInt");
        }
    }
    
    public static void updateString(String sql, String columnLabel, String identifier, String newString){
        try {
            Connection con = getConnection();
            ResultSet rs = executeSQL.executeQuery(con, sql);
            while (rs.next()){
                if (identifier.equals(rs.getString(columnLabel))) {
                    rs.updateString(columnLabel, newString);
                    rs.updateRow();
                }
            }rs.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println(e+" in update updateInt");
        }
    }
    public static void addGameToDataBase(Game newGame) {
        try {
            Connection con = getConnection(); // establishes conection to database
            final String sql = "SELECT Games.* FROM Games"; //selects all records from Logins table
            ResultSet rs = executeSQL.executeQuery(con, sql); // stores all records as a result set
            rs.moveToInsertRow(); // moves to the empty row to insert record
            rs.updateString("Save", newGame.getSave());
            rs.updateString("GameFormat", newGame.getGameFormat());
            rs.updateBoolean("IncrementTime", newGame.isIncrementTime());
            rs.updateString("WhoseMove", Character.toString(newGame.getWhoseMove()));
            rs.insertRow(); // inserts record into database
            System.out.println("record added");
            rs.close();
            con.close(); // closes connection
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void addPlayerGameToDataBase(PlayerGames newPlayerGame) {
        try {
            Connection con = getConnection(); // establishes conection to database
            final String sql = "SELECT PlayerGames.* FROM PlayerGames"; //selects all records from Logins table
            ResultSet rs = executeSQL.executeQuery(con, sql); // stores all records as a result set
            rs.moveToInsertRow(); // moves to the empty row to insert record
            rs.updateString("Save", newPlayerGame.getSave());
            rs.updateString("Email", newPlayerGame.getEmail());
            rs.updateInt("Time", newPlayerGame.getTime());
            rs.updateString("Colour", newPlayerGame.getWhoseMove());
            rs.insertRow(); // inserts record into database
            System.out.println("record added");
            rs.close();
            con.close(); // closes connection
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
       public static LinkedList getPlayerGame(String save){
        try {
            Connection con = getConnection();
            final String sql = "SELECT PlayerGames.* FROM PlayerGames";
            ResultSet rs = executeSQL.executeQuery(con, sql);
            LinkedList<PlayerGames> games = new LinkedList<>();
            while (rs.next()){
                if (rs.getString("Save").equals(save)) {
                    PlayerGames currentGame = new PlayerGames(rs.getString("Save"), rs.getString("Email"), rs.getInt("Time"), rs.getString("Colour"));
                games.add(currentGame);
                }
            }rs.close();
            con.close();
            return games;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
}
