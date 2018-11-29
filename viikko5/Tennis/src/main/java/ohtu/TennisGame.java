package ohtu;


public class TennisGame {

    static final int startingScore = 0;
    private int player1score;
    private int player2score;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1score = startingScore;
        this.player2score = startingScore;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1score += 1;
        else
            player2score += 1;
    }

    private boolean scoreIsEven() {
        return player1score == player2score;
    }

    private boolean playerHasOverThreePoints() {
        return player1score > 3 || player2score > 3;
    }

    private String setAnnouncement(int score) {
        // TODO: Move to HashMap
        switch (score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    private String findResult(int score) {
        if (score==1) return "Advantage player1";
        else if (score ==-1) return "Advantage player2";
        else if (score>=2) return "Win for player1";
        else return "Win for player2";

    }

    private String foo(int score) {
        switch(score) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
            default: return "";
        }
    }

    public String getScore() {
        String announcement = "";
        if (scoreIsEven()) {
            announcement = setAnnouncement(player1score);
        } else if (playerHasOverThreePoints()) {
            int minusResult = player1score - player2score;
            announcement = findResult(minusResult);
        } else {
            int tempScore = 0;
            for (int i = 1; i<3; i++) {
                if (i==1) tempScore = player1score;
                else {
                    announcement+="-";
                    tempScore = player2score;
                }
                announcement += foo(tempScore);
            }
        }
        return announcement;
    }
}