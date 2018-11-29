package ohtu;

import java.util.HashMap;
import java.util.Map;

public class scoreSetter {
    private Map<Integer, String> scoreMap;
    
    public scoreSetter() {
        Map<Integer, String> score = new HashMap<>();
        score.put(0, "Love-All");
        score.put(1, "Fifteen-All");
        score.put(2, "Thirty-All");
        //score.put(default, "Deuce");
    }

    public String getScore(int score) {
        return scoreMap.get(score);
    }

}
