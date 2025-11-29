package HiLoGame;

import java.util.ArrayList;

public class Scoreboard {
    private int totalWins;
    private int totalGames;
    private final ArrayList<Round> roundData = new ArrayList<>();

    public void addRoundData(Round round){
        roundData.addLast(round);
    }

    public void incGames(){
        this.totalGames++;
    }

    public void incWins(){
        this.totalWins++;
    }

    public void displayScoreboard(){
        System.out.println("Total wins: "+totalWins);
        System.out.println("Total games: "+totalGames);
        System.out.println("Round Data: ");
        displayRoundData();
    }

    private void displayRoundData(){
        roundData.forEach(round -> this.displayRound(round));
    }

    private void displayRound(Round round){
        System.out.println(round);
    }
}
