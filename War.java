/*
 * Author: Ingrid Bailey
 * Co-Author: Kyle Krstulich
 * 
 * 10/30/23
 * War.java
 * 
 * Bunch of funcitons to play the card game war from the command-line.
 */
public class War {
    static String[][] playerDeck = WarLibrary.CreateEmptyDeck();
    static String[][] cpuDeck = WarLibrary.CreateEmptyDeck();
    static int time;

    public static void draw_cards(String[] playercard, String[] cpucard) {
        StdDraw.clear();
        double cardWidth = .35;
        double cardHeight = .5;
        StdDraw.picture(.25, .7, "./assets/" + playercard[0] + "_of_" + playercard[1] + ".png", cardWidth, cardHeight);
        StdDraw.picture(.75, .7, "./assets/" + cpucard[0] + "_of_" + cpucard[1] + ".png", cardWidth, cardHeight);

        StdDraw.text(.25, .25, "Player Cards: " + WarLibrary.GetLength(playerDeck));
        StdDraw.text(.75, .25, "Cpu Cards: " + WarLibrary.GetLength(cpuDeck));

        animate();

    }

    public static void animate() {

        StdDraw.show();
        StdDraw.pause(time);
    }

    public static void GamePlayer() {
        StdDraw.enableDoubleBuffering();

        boolean playersturn = true;
        int playerwins = 0;
        int cpuwins = 0;
        WarLibrary.DealDeck(playerDeck, cpuDeck);
        String[] playercard = WarLibrary.PullCard(playerDeck);
        String[] cpucard = WarLibrary.PullCard(cpuDeck);
        String respon;
        while (true) {
            if (WarLibrary.CompareCard(playercard, cpucard)) {
                respon = "Player Wins!";
                WarLibrary.AddCard(playerDeck, cpucard);
                WarLibrary.AddCard(playerDeck, playercard);
                playersturn = true;
                playerwins += 1;
            } else {
                respon = "CPU Wins!";
                WarLibrary.AddCard(cpuDeck, cpucard);
                WarLibrary.AddCard(cpuDeck, playercard);
                playersturn = false;
                cpuwins += 1;
            }
            if (WarLibrary.Lose(playerDeck) || WarLibrary.Lose(cpuDeck))
                break;
            if (playersturn) {
                playercard = WarLibrary.PullCard(playerDeck);
                cpucard = WarLibrary.PullCard(cpuDeck);
            } else {
                cpucard = WarLibrary.PullCard(cpuDeck);
                playercard = WarLibrary.PullCard(playerDeck);
            }

            draw_cards(playercard, cpucard);

        }
        System.out.println("Player wins: " + playerwins);
        System.out.println("cpuwins: " + cpuwins);
        System.out.println("cpudeck size: " + WarLibrary.GetLength(cpuDeck));
        System.out.println("playerdeck size: " + WarLibrary.GetLength(playerDeck));
        draw_cards(playercard, cpucard);

        if (cpuwins > playerwins) {
            StdDraw.text(.5, .10, "Cpu Wins! ");
        } else {
            StdDraw.text(.5, .10, "Player Wins! ");
        }
        animate();

    }

    public static void main(String[] args) {
        time = Integer.parseInt(args[0]);

        GamePlayer();
    }
}