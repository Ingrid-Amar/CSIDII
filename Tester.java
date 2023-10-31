public class War {
    private static int playerCards;
    private static int cpuCards;

    public static void main(String[] args) {
        double Player1 = 26;
        double Player2 = 26;
        double counter = 0;
        while ((Player1 > 0) && (Player2 > 0)) {
            double r1 = Math.random() * 12 + 1;
            double r2 = Math.random() * 12 + 1;
            if ((r1 == r2) && ((Player1 > 3) && (Player2 > 3))) {
                double r3 = Math.random() * 12 + 1;
                double r4 = Math.random() * 12 + 1;
                double r5 = Math.random() * 12 + 1;
                double total1 = r3 + r4 + r5;
                double r6 = Math.random() * 12 + 1;
                double r7 = Math.random() * 12 + 1;
                double r8 = Math.random() * 12 + 1;
                double total2 = r6 + r7 + r8;
                if (total1 > total2) {
                    Player1 += 3;
                    Player2 -= 3;
                } else {
                    Player2 += 3;
                    Player1 -= 3;
                }
            } else if (r1 > r2) {
                Player1 += 1;
                Player2 -= 1;
            } else if (r2 > r1) {
                Player1 -= 1;
                Player2 += 1;
            } else if ((r1 == r2) && ((Player1 < 3) || (Player2 < 3))) {
                break;
            }
            counter += 1;

        }
        if (Player1 > Player2) {
            System.out.println("You Won!!!!");
            System.out.println("Games Played: " + counter);
        } else if (Player1 < Player2) {
            System.out.println("You Lost");
            System.out.println("Games Played: " + counter);
        }

    }
}