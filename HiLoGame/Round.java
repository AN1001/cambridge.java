package HiLoGame;

public class Round {
    private final int randomNum;
    public final int difficulty;
    private int guessesLeft;

    // Difficulty 0,1,2,3 for easy, medium, hard, expert
    public Round(int difficulty) {
        // Generate random num between 0 and 100, use 101 as int casting
        // truncates/rounds down
        this.randomNum = (int) (Math.random() * 101);
        this.difficulty = difficulty;
        // Because 7 is the minimum guesses needed in worst case
        // And as difficulty decreases more guesses are given
        this.guessesLeft = (6 - this.difficulty) * 2 + 1;
    }

    @Override
    public String toString() {
        return "Number: " + this.randomNum + " Difficulty: " + this.difficulty + " Guesses left: " + this.guessesLeft;
    }

    public int submitGuess(int guess){
        guessesLeft--;
        if(guess==randomNum){
            return 0;
        } else if(guessesLeft!=0) {
            if(guess>randomNum) {
                return 1;
            } else {
                return -1;
            }
        } else {
            // You used your last guess and failed to find
            // the right number - hence game must end
            return 404;
        }
    }
}
