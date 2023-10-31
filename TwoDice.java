public class TwoDice {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = 0;
        int p = 0;
        int t = 0;
        // i = i+1;
        // i += 1
        // i++
        if (n > 0) {
            while (!(k == n || p == n)) {
                double r = Math.random();

                int s = 6;
                int diceRoll;
                diceRoll = (int) (r * s) + 1;
                double h = Math.random();
                int cpuDiceRoll = (int) (h * s) + 1;

                if (diceRoll > cpuDiceRoll) {
                    k += 1;
                } else if (diceRoll == cpuDiceRoll) {
                    t += 1;
                } else if (diceRoll < cpuDiceRoll) {
                    p += 1;
                }
            }
            if (k > p) {
                System.out.println("You Win!!! =-)");
                System.out
                        .println("You got " + k + " points. " + "Your opponite got " + p + " points. " + "You tied " + t
                                + " times.");
            } else {
                System.out.println("You lost. =-(");
                System.out
                        .println("You got " + k + " points. " + "Your opponite got " + p + " points. " + "You tied " + t
                                + " times.");
            }
        } else {
            System.out.println("Not a valid number entered");
        }
    }
}