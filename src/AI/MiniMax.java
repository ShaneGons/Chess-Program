package AI;
import Game.*;
import Pieces.*;
import java.util.LinkedList;
public class MiniMax {
    private final BoardEvaluator boardEvaluator;
    private Player aiPlayer;
    private Player player;
    private final int searchDepth;
    private long executionTime;
    
    public MiniMax(Player player1, Player player2, int searchDepth){
        this.boardEvaluator = null;
        if (player1.getUserName().equalsIgnoreCase("AI")) {
            this.aiPlayer = player1;
            this.player = player2;
        }else{
            this.aiPlayer = player2;
            this.player = player1;
        }
        this.searchDepth = searchDepth;
    }
    public Move execute(final Board board) {
        System.out.println(board.currentPlayer.toString());
        final long startTime = System.currentTimeMillis();
        Move bestMove = new Move();
        int highestSeenValue = Integer.MIN_VALUE;
        int lowestSeenValue = Integer.MAX_VALUE;
        int currentValue;
        for (int i = 0; i < board.currentPlayer.getPiecesInPlay().size(); i++) {
            Piece currentPiece = board.currentPlayer.getPiecesInPlay().get(i);
            for (int j = 0; j < currentPiece.getMovementSq().size(); j++) {
                Board newPosition = new Board();
                newPosition.setBoard(board);
                newPosition.currentPlayer = board.currentPlayer;
                Move move = new Move();
                move.setMovingPiece(currentPiece);
                move.setOgPosition(currentPiece.getPosition());
                move.setOgRank(currentPiece.getRank());
                move.setOgFile(currentPiece.getFile());
                move.setFinalRank(move.calcRank((int) currentPiece.getMovementSq().get(j)));
                move.setFinalFile(move.calcFile((int) currentPiece.getMovementSq().get(j)));
                move.setFinalPosition();
                move.setReplacedPiece(board.getPiece(move.getFinalRank(), move.getFinalFile()));
                if (newPosition.moveToSq(move, player, aiPlayer)) {
                    newPosition.currentPlayer = (board.currentPlayer.equals(player))? aiPlayer:player;
                    currentValue = (board.currentPlayer.getColour() == 'W')? min(newPosition, searchDepth - 1) : max(newPosition, searchDepth - 1);
                    if (board.currentPlayer.getColour() == 'W' && currentValue >= highestSeenValue) {
                        highestSeenValue = currentValue;
                        System.out.println(highestSeenValue);
                    bestMove = move;
                    }else if (board.currentPlayer.getColour() == 'B' && currentValue <= lowestSeenValue) {
                        lowestSeenValue = currentValue;
                        bestMove = move;
                    }
                }
            }
        }

        this.executionTime = System.currentTimeMillis() - startTime;
        System.out.println(executionTime);
        return bestMove;
    }

    private int min(final Board board,final int depth) {
        if(depth == 0){
            return boardEvaluator.evaluate(board, depth);
        }int lowestValue = Integer.MAX_VALUE;
        for (int i = 0; i < board.currentPlayer.getPiecesInPlay().size(); i++) {
            Piece currentPiece = board.currentPlayer.getPiecesInPlay().get(i);
            for (int j = 0; j < currentPiece.getMovementSq().size(); j++) {
                Board newPosition = new Board();
                newPosition.setBoard(board);
                newPosition.currentPlayer = board.currentPlayer;
                Move move = new Move();
                move.setMovingPiece(currentPiece);
                move.setOgPosition(currentPiece.getPosition());
                move.setOgRank(currentPiece.getRank());
                move.setOgFile(currentPiece.getFile());
                move.setFinalRank(move.calcRank((int) currentPiece.getMovementSq().get(j)));
                move.setFinalFile(move.calcFile((int) currentPiece.getMovementSq().get(j)));
                if (newPosition.moveToSq(move, aiPlayer, player)) {
                    newPosition.currentPlayer = (board.currentPlayer.equals(aiPlayer))? player:aiPlayer;
                    final int currentValue = max(newPosition, depth-1);
                    if (currentValue <= lowestValue){
                        lowestValue = currentValue;
                    }
                }
            }
        }
        return lowestValue;
    }

    private int max(final Board board, final int depth){
        if(depth == 0){
            return boardEvaluator.evaluate(board, depth);
        }int highestValue = Integer.MIN_VALUE;
        for (int i = 0; i < board.currentPlayer.getPiecesInPlay().size(); i++) {
            Piece currentPiece = board.currentPlayer.getPiecesInPlay().get(i);
            for (int j = 0; j < currentPiece.getMovementSq().size(); j++) {
                Board newPosition = new Board();
                newPosition.setBoard(board);
                newPosition.currentPlayer = board.currentPlayer;
                Move move = new Move();
                move.setMovingPiece(currentPiece);
                move.setOgPosition(currentPiece.getPosition());
                move.setOgRank(currentPiece.getRank());
                move.setOgFile(currentPiece.getFile());
                move.setFinalRank(move.calcRank((int) currentPiece.getMovementSq().get(j)));
                move.setFinalFile(move.calcFile((int) currentPiece.getMovementSq().get(j)));
                if (newPosition.moveToSq(move, aiPlayer, player)) {
                    newPosition.currentPlayer = (board.currentPlayer.equals(aiPlayer))? player:aiPlayer;
                    final int currentValue = min(newPosition, depth-1);
                    if (currentValue >= highestValue){
                        highestValue = currentValue;
                    }
                }
            }
        }
        return highestValue;
    }
}
