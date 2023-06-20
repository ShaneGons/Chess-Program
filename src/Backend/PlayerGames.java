package Backend;
public class PlayerGames {
    private String save, email,whoseMove;
    private int time;

    public PlayerGames(String save, String email, int time, String whoseMove) {
        this.save = save;
        this.email = email;
        this.whoseMove = whoseMove;
        this.time = time;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWhoseMove() {
        return whoseMove;
    }

    public void setWhoseMove(String whoseMove) {
        this.whoseMove = whoseMove;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
