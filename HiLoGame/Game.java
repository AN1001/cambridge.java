package HiLoGame;
import java.util.Scanner;

public class Game {
    private final Scoreboard curGameScoreboard = new Scoreboard();

    void main(){
        Round curRound;

        int output = -2;
        Scanner in = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter difficulty 0,1,2,3 for easy, medium, hard, expert... Don't even try entering something else\n");

        try {
            int difficulty = Integer.parseInt(in.nextLine());  // Read user input
            curRound = new Round(difficulty);
        } catch (Exception e){
            System.out.println("Great, no game for you now");
            System.exit(0);
            // Line below not needed (IDE forced it)
            curRound = new Round(3);
        }

        curGameScoreboard.addRoundData(curRound);

        while(output!=0 && output!=404){
            System.out.println("Submit guess: ");
            output = curRound.submitGuess(Integer.parseInt(in.nextLine()));
            if(output==-1){
                System.out.println("Guess higher");
            } else if(output==1){
                System.out.println("Guess lower");
            }
        }
        if(output==0){
            System.out.println("You win");
            curGameScoreboard.incGames();
            curGameScoreboard.incWins();
        } else {
            System.out.println("You lose");
            curGameScoreboard.incGames();
        }

        System.out.println("Play again? (y)");
        if(in.nextLine().equalsIgnoreCase("y")){
            main();
        } else {
            curGameScoreboard.displayScoreboard();
            System.out.println("Goodbye");
        }
    }
}
