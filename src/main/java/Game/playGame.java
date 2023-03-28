package Game;
import java.util.ArrayList;
import java.util.Scanner;
import Pieces.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import libraryFunctions.*;

public class playGame {
    private static int moveCounter = 1;
    private static char whoseMove = 'W';
    private static boolean gameOver = false;
    private static Board chessBoard = new Board("StartingPosition");
    private static ArrayList<Piece> piecesBlocking = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        playGame("d");
    }
    public static void playGame(String saveFile){
        try {
            Connection con = libraryFunctions.repository.getConnection();
            Statement stmt = con.createStatement();
            System.out.println("j");
            String sql = "Select "+saveFile+" From app.tbl_savedgames";
            ResultSet game = stmt.executeQuery(sql);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("djfd");
//        while (!gameOver){
//                try {
//                    boolean validMove = true;
//                    do {
//                        System.out.println("Piece to move");
//                        Piece pieceToMove = input.nextPiece();
//                        System.out.println("To which square");
//                        int finalRank = getRank();
//                        int finalFile = getFile();
//                        validMove = pieceToMove.isLegalMove(finalRank, finalFile, chessBoard);
//                    } while (!validMove);
//                    playMove();
//                    whoseMove = (whoseMove == 'W')? 'B':'W';
//                    isKingInCheck();
//                    continueGame();
//                }catch (Exception e){
//                    System.out.println("Exception: "+e);
//                }
//            }
    }
}
