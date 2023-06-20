package Main;

import javax.swing.JFrame;
import Backend.userAccount;
import Backend.Run;
import Game.GameBoard;
import Game.Player;
import libraryFunctions.repository;
public class main {
    public static JFrame frame = new JFrame("NEA Project");
    public static userAccount currentAccount = null;
    
    public static void main(String[] args) {
        int frameWidth = 700;
        int frameHeight = 400;
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);frame.setVisible(true);
        Run.runLoginScreen(0, currentAccount);
        frame.setVisible(true);
//        Player player1 = new Player("s@2",'W',100);
//        Player player2 = new Player("AI",'B',100);
//        GameBoard game = new GameBoard("NewGame",true,player1, player2, 0, 'W', "Rapid", false);
//        game.runGameBoard();

    }
}
