package Backend;

import GUI.*;
import Game.GameBoard;
import Game.Player;

public class Run {
    private static LoginScreen loginScreen;
    private static CreateAccountScreen createAccount;
    private static MainMenuGUI mainMenu;
    private static LeaderboardGUI leaderboard;
    private static ViewDetailsGUI viewDetails;
    private static ChangeDetails changeDetails;
    private static AiDifficulty aiDifficulty;
    private static SavedGamesGUI savedGames;
    private static GameOptionsGUI gameOptions;
    private static GameBoard game;
    private static EmailVerification emailVerification;
    private static EndGame endGame;
    
    public static void runLoginScreen(int newProgram, userAccount account){
        loginScreen = new LoginScreen(account);
        loginScreen.runLoginScreen(newProgram);
    }
    
    public static void runCreateAccountScreen(){
        createAccount = new CreateAccountScreen();
    }
    
    public static void runMainMenu(){
        mainMenu = new MainMenuGUI();
        mainMenu.runMainMenuGUI();
    }
    
    public static void runLeaderboardGUI(){
        leaderboard = new LeaderboardGUI();
        leaderboard.openLeaderboard();
    }
    
    public static void runViewDetails(){
        viewDetails = new ViewDetailsGUI();
        viewDetails.AccountInfo();
    }
    
    public static void runChangeDetails(){
        changeDetails = new ChangeDetails();
        changeDetails.runChangeDetails();
        
    }
    
    public static void runAiDifficulty(userAccount ai){
        aiDifficulty = new AiDifficulty(ai);
        aiDifficulty.runAiDifficulty();
    }
  
    public static void runSavedGamesGUI(userAccount secondAccount, boolean aiGame, int aiSearchDepth){
        savedGames = new SavedGamesGUI(secondAccount, aiGame, aiSearchDepth);
        savedGames.runSavedGames();
    }
    
    public static void runGameOptions(String gameChoice, userAccount secondAccount, PlayerGames player1, PlayerGames player2, boolean aiGame, int aiSearchDepth){
        gameOptions = new GameOptionsGUI(gameChoice, secondAccount, player1, player2, aiGame, aiSearchDepth);
        gameOptions.runGameOptions();
    }
    
    public static void runGameBoard(String saveFile, boolean aiGame, Player player1, Player player2, int aiSearchDepth, char whoseMove, String gameFormat, boolean incrementTime){
        game = new GameBoard(saveFile, aiGame, player1, player2, aiSearchDepth,whoseMove, gameFormat, incrementTime);
        game.runGameBoard();
    }
    
    public static void runEmailVerification(int newProgram, userAccount account){
        Email.sendEmail(account);
        emailVerification = new EmailVerification(newProgram,account);
        emailVerification.runEmailVerification();
    }
    
    public static void runEndGame(PlayerGames playerGames1, PlayerGames playerGames2, String gameFormat, char whoseMove, boolean increment, String fenString){
        endGame = new EndGame();
        endGame.runEndGame(playerGames1, playerGames2, gameFormat, whoseMove, increment, fenString);
    }
    
    public static void unHideGameBoard(){
        game.frame.setVisible(true);
        game.gamePanel.setVisible(true);
    }
    
    public static void createAccount(userAccount account, char[] pass){
        Email.sendEmail(account);
        emailVerification = new EmailVerification(0,account, pass);
        emailVerification.runEmailVerification();
    }
    
    public static void destroyObject(int object){
        switch (object){
            case 0:
                loginScreen = null;
                break;
            case 1:
                createAccount = null;
                break;
            case 2:
                mainMenu = null;
                break;
            case 3:
                leaderboard = null;
                break;
            case 4:
                viewDetails = null;
                break;
            case 5:
                changeDetails = null;
                break;
            case 6:
                aiDifficulty = null;
                break;
            case 7: 
                savedGames = null;
                break;
            case 8:
                gameOptions = null;
                break;
            case 9:
                game.frame.dispose();
                game = null;
                break;
            case 10:
                emailVerification = null;
                break;
            case 11:
                endGame = null;
                break;
        }
                
    }
}
