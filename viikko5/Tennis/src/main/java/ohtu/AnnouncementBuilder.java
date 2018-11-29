package ohtu;

public class AnnouncementBuilder {

    public static String build(String command, int score) {
        switch(command) {
            case "evenScore": return linesEvenScore(score);
            case "threeOrMorePoints": return linesThreeOrMorePoints(score);
            case "lessThanThreePoints": return linesLessThanThreePoints(score);
            default: return "";
        }
    }

    public static String linesEvenScore(int score) {
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

    public static String linesThreeOrMorePoints(int score) {
        if (score==1) return "Advantage player1";
        else if (score ==-1) return "Advantage player2";
        else if (score>=2) return "Win for player1";
        else return "Win for player2";

    }

    public static String linesLessThanThreePoints(int score) {
        switch(score) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
            default: return "";
        }
    }
}
