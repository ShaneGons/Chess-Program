package Backend;
import Main.main;
public class MainMenu {
    public static void makeChoice(int choice){
        switch (choice){
            case 0:
                Run.runLeaderboardGUI();
                break;
            case 1:
                userAccount secondPlayer = new userAccount();
                Run.runLoginScreen(2, secondPlayer);
                break;
            case 2:
                userAccount ai = new userAccount();
                ai.setEmail("AI");
                ai.setBlitzRating(1000);
                ai.setRapidRating(1000);
                ai.setClassicalRating(1000);
                Run.runAiDifficulty(ai);
                break;
            case 3:
                Run.runViewDetails();
                break;
        }Run.destroyObject(2);
    }
}
