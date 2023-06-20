package Game;
import Pieces.*;
import java.util.LinkedList;

public class Player {
    private String userName;
    private char colour;
    private int points;
    private int rating;
    private int time;
    LinkedList<Piece> piecesInPlay = new LinkedList();

    public Player(String userName, char colour, int rating) {
        this.userName = userName;
        this.colour = colour;
        this.rating = rating;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char getColour() {
        return colour;
    }

    public void setColour(char colour) {
        this.colour = colour;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LinkedList<Piece> getPiecesInPlay() {
        return piecesInPlay;
    }

    public void setPiecesInPlay(LinkedList<Piece> piecesInPlay) {
        this.piecesInPlay = piecesInPlay;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Player{" + "userName=" + userName + ", colour=" + colour + ", points=" + points + ", rating=" + rating + ", piecesInPlay=" + piecesInPlay + '}';
    }    
    
}
