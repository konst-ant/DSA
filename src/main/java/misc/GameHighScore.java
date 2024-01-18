package misc;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

/**
 * This class keeps internally a storage of game winners. The storage has bounded size and winners are maintained ordered
 * by their score index-wise, i.e. the top will be at index 0.
 *
 * You can add extra people into winners set, and they will be saved if having score "high enough". That is to say, if there is
 * still free place, the winner with whatever score will be added (but put to appropriate place according to his score).
 * However, if there is no place left, the newcomer will be added in competitive fashion - only highest score winners will get
 * recorded, pushing out others.
 *
 * @author Konstantin Antipin
 */
public class GameHighScore {

    public GameHighScore(int capacity) {
        winners = new ScoreCard[capacity];
    }

    private int size = 0;

    private ScoreCard[] winners;

    @Data
    @AllArgsConstructor
    static class ScoreCard {
        int score;
        String name;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(ScoreCard card) {
        if (isEmpty()) {
            size++;
            winners[size-1] = card;
            return;
        }

        if (size < winners.length || card.getScore() > winners[size - 1].getScore()) {
            if (size < winners.length) {
                size++;
            }
            int cardPlace = size-1;
            while (cardPlace > 0 && winners[cardPlace - 1].getScore() < card.getScore()) {
                winners[cardPlace] = winners[cardPlace - 1];
                cardPlace--;
            }
            winners[cardPlace] = card;
        }
    }

    public void print() {

        System.out.println(Arrays.toString(winners));
    }

    public static void main(String[] args) {
        GameHighScore gameHighScore = new GameHighScore(5);
        gameHighScore.put(new ScoreCard(1, "John"));
        gameHighScore.put(new ScoreCard(18, "Peter"));
        gameHighScore.put(new ScoreCard(3, "Mary"));
        gameHighScore.put(new ScoreCard(2, "Jane"));
        gameHighScore.put(new ScoreCard(44, "Bill"));
        gameHighScore.put(new ScoreCard(7, "Kate"));
        gameHighScore.put(new ScoreCard(114, "Jack"));
        gameHighScore.put(new ScoreCard(19, "Paul"));


        gameHighScore.print();
    }
}
