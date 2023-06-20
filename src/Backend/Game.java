package Backend;
public class Game {
    private final String save;
    private final String gameFormat;
    private final boolean incrementTime;
    private final char whoseMove;

    public Game(String save, String gameFormat, boolean incrementTime, String whoseMove) {
        this.save = save;
        this.gameFormat = gameFormat;
        this.incrementTime = incrementTime;
        this.whoseMove = whoseMove.charAt(0);
    }

    public String getSave() {
        return save;
    }

    public String getGameFormat() {
        return gameFormat;
    }

    public boolean isIncrementTime() {
        return incrementTime;
    }

    public char getWhoseMove() {
        return whoseMove;
    }

    @Override
    public String toString() {
        return "Game{" + "save=" + save + ", gameFormat=" + gameFormat + ", incrementTime=" + incrementTime + ", whoseMove=" + whoseMove + '}';
    }
    
    
    
}
