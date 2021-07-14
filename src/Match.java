import java.util.Random;

public class Match {
    public static void main(String[] args) {
        /* This is an option for implementing the core algorithm for run something that
         * generates random number til it find the goal (it could be 1) */
        final Thread match = Thread.currentThread();
        // 45 minutes match
        //final int timeToRun = 60000; // 1 minute;
        // 90 minutes match
        final int timeToRun = 120000; // 2 minutes;
        Random home_fact = new Random();
        Random away_fact = new Random();
        int ht_score = 0;
        int at_score = 0;
        // increasing numbers increase the difficult
        double ht_goal_possibilities = 0.9999999995;
        double at_goal_possibilities = 0.99999999978;
        // increasing numbers increase the probability
        double[] yellow_card = {0.1, 0.1000000004};
        double[] red_card = {0.11, 0.11000000004};

        double[] throw_in = {0.2, 0.20000000068};
        double[] offside = {0.21, 0.2100000003};
        double[] foul = {0.22, 0.22000000042};
        double[] pass = {0.23, 0.23000000095};
        double[] shoot = {0.25, 0.25000000035};
        //TODO corner kick, free kick, penalty and goal kick

        int ht_number_of_red_cards = 0;
        int at_number_of_red_cards = 0;
        double after_red_cards = 0.00000000015;

        new Thread(() -> {
            try {
                Thread.sleep(timeToRun);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            match.interrupt();
        }).start();

        while (!Thread.interrupted()) {
            // fact.nextDouble() number has at least 15 digits, it may have up to 18 digits.
            double home_team = home_fact.nextDouble();
            double away_team = away_fact.nextDouble();

            if (home_team > ht_goal_possibilities) {
                ht_score++;
                System.out.println("Goaaaal Bayern!!");
            }
            if (away_team > at_goal_possibilities) {
                at_score++;
                System.out.println("Goaaaal Dortmund!!");
            }
            // Home Team
            if (home_team > yellow_card[0] && home_team < yellow_card[1]) {
                System.out.println("Bayern yellow card");
            }
            if (home_team > red_card[0] && home_team < red_card[1]) {
                System.out.println("Bayern red card");
                ht_number_of_red_cards++;
                at_goal_possibilities -= after_red_cards * ht_number_of_red_cards;
            }
            if (home_team > throw_in[0] && home_team < throw_in[1]) {
                System.out.println("Thrown in for Bayern");
            }
            if (home_team > offside[0] && home_team < offside[1]) {
                System.out.println("Bayern offside");
            }
            if (home_team > foul[0] && home_team < foul[1]) {
                System.out.println("Bayern's foul");
            }
            if (home_team > pass[0] && home_team < pass[1]) {
                System.out.println("Bayern pass");
            }
            if (home_team > shoot[0] && home_team < shoot[1]) {
                System.out.println("Bayern shoot");
            }
            // Away Team
            if (away_team > yellow_card[0] && away_team < yellow_card[1]) {
                System.out.println("Dortmund yellow card");
            }
            if (away_team > red_card[0] && away_team < red_card[1]) {
                System.out.println("Dortmund red card");
                at_number_of_red_cards++;
                ht_goal_possibilities -= after_red_cards * at_number_of_red_cards;
            }
            if (away_team > throw_in[0] && away_team < throw_in[1]) {
                System.out.println("Thrown in for Dortmund");
            }
            if (away_team > offside[0] && away_team < offside[1]) {
                System.out.println("Dortmund offside");
            }
            if (away_team > foul[0] && away_team < foul[1]) {
                System.out.println("Dortmund's foul");
            }
            if (away_team > pass[0] && away_team < pass[1]) {
                System.out.println("Dortmund pass");
            }
            if (away_team > shoot[0] && away_team < shoot[1]) {
                System.out.println("Dortmund shoot");
            }
        }
        System.out.println("The result is: Bayern " + ht_score + " - " + at_score + " Dortmund");
    }
}
