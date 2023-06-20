package Backend;
public class userAccount {
    private String email;
    private int blitzRating;
    private int rapidRating;
    private int classicalRating;
    private int numberOfWins;
    private int numberOfLosses;
    private int numberOfDraws;
    private int numberOfGamesPlayed;
    private int winRate;

    public userAccount() {
    }
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBlitzRating() {
        return blitzRating;
    }

    public void setBlitzRating(int blitzRating) {
        this.blitzRating = blitzRating;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfLosses() {
        return numberOfLosses;
    }

    public void setNumberOfLosses(int numberOfLosses) {
        this.numberOfLosses = numberOfLosses;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public void setNumberOfDraws(int numberOfDraws) {
        this.numberOfDraws = numberOfDraws;
    }

    public int getNumberOfGamesPlayed() {
        return numberOfGamesPlayed;
    }

    public void setNumberOfGamesPlayed() {
        this.numberOfGamesPlayed = numberOfWins+numberOfLosses+numberOfDraws;
    }

    public int getWinRate() {
        return winRate;
    }

    public void setWinRate() {
        setNumberOfGamesPlayed();
        if (numberOfGamesPlayed != 0) {
            this.winRate = (numberOfWins*100)/numberOfGamesPlayed;
        }else this.winRate = 100;
    }

    public int getRapidRating() {
        return rapidRating;
    }

    public void setRapidRating(int rapidRating) {
        this.rapidRating = rapidRating;
    }

    public int getClassicalRating() {
        return classicalRating;
    }

    public void setClassicalRating(int classicalRating) {
        this.classicalRating = classicalRating;
    }

    @Override
    public String toString() {
        return "Email: "+email+" Wins:"+numberOfWins+" Losses:"+numberOfLosses+" Draws:"+numberOfDraws+" Games Played:"+numberOfGamesPlayed+" winRate:"+winRate;
    }
}
