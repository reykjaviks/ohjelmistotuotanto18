package ohtu;

public class TennisGame {
    private int player1points;
    private int player2points;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        int startinPoints = 0;
        this.player1points = startinPoints;
        this.player2points = startinPoints;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1points += 1;
        else
            player2points += 1;
    }

    private boolean scoreIsEven() {
        return player1points == player2points;
    }

    private boolean playerHasMoreThanThreePoints() {
        return player1points > 3 || player2points > 3;
    }

    private int countDifferenceBetweenPlayers() {
        return this.player1points - this.player2points;
    }

    public String getScore() {
        String announcement = "";
        if (scoreIsEven()) {
            announcement = AnnouncementBuilder.build("evenScore", player1points);
        } else if (playerHasMoreThanThreePoints()) {
            announcement = AnnouncementBuilder.build("threeOrMorePoints", countDifferenceBetweenPlayers());
        } else {
            int tempScore = 0;
            for (int i = 1; i<3; i++) {
                if (i==1) tempScore = player1points;
                else {
                    announcement+="-";
                    tempScore = player2points;
                }
                announcement += AnnouncementBuilder.build("lessThanThreePoints", tempScore);
            }
        }
        return announcement;
    }
}