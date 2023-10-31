import java.util.Scanner;

public class WarUpdated {
    public static void main(String[] args) {
        // makes 2 strings that will combine
        String[] suits = { "Hearts", "Spades", "Diamonds", "Clubs" };
        String[] cardValues = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" };

        // gives the length of the deck
        int cardDeckSize = suits.length * cardValues.length;

        // makes the card decks string to put stuff in
        String[] cardDeck = new String[cardDeckSize];
        String[] playerdeck = new String[(cardDeckSize)];
        String[] cpudeck = new String[(cardDeckSize)];

        // puts counters that will be needed
        int playerwins = 0;
        int cpuwins = 0;
        int games = 1;
        int turns = 0;
        int cpucount = 0;
        int playercount = 0;
        double times = 1;
        int runnnn = 1;
        int numspl = 26;
        int numsc = 26;

        // makes the deck with card value
        for (int i = 0; i < suits.length; i++) {
            String suit = suits[i];
            for (int j = 0; j < cardValues.length; j++) {
                String cardValue = cardValues[j];
                String card = cardValue + " of " + suit;
                cardDeck[cardValues.length * i + j] = card;
            }
        }

        // shuffles the deck
        for (int h = 0; h < cardDeckSize; h++) {
            int r = h + (int) (Math.random() * (cardDeckSize - h));
            String temp = cardDeck[h];
            cardDeck[h] = cardDeck[r];
            cardDeck[r] = temp;
        } // for end

        // makes player and cpu deck deck
        for (int y = 0; y < 26; y++) {
            playerdeck[y] = cardDeck[y];
        }
        for (int l = 26; l < 52; l++) {
            cpudeck[l - 26] = cardDeck[l];
        }

        // runs the game
        // while in the loop plays the game to make sure it runs till player stops it
        while (times > 0) {
            // puts a times to go down to 0 unless added to
            times -= 1;

            // prints out deck
            while ((runnnn == 1) && (turns < 500)) {
                Scanner cpuScan = new Scanner(cpudeck[0]);
                Scanner playerScan = new Scanner(playerdeck[0]);
                cpuScan.useDelimiter("\\D+");
                playerScan.useDelimiter("\\D+");
                if (cpuScan.hasNextInt() && playerScan.hasNextInt()) { // get int
                    int num1 = cpuScan.nextInt();
                    int num2 = playerScan.nextInt();
                    // System.out.println(num1);
                    // System.out.println(num2);
                    if (num1 > num2) {
                        if (numsc == (cardDeckSize - 1)) {
                            numsc = 0;
                        }
                        cpudeck[(numsc)] = Integer.toString(num1);
                        numsc += 1;

                        if (numsc == (cardDeckSize - 1)) {
                            numsc = 0;
                        }
                        cpudeck[(numsc)] = Integer.toString(num2);
                        numsc += 1;

                        cpuwins += 1;
                        turns += 1;

                    } else if (num2 > num1) {
                        if (numspl == (cardDeckSize - 1)) {
                            numspl = 0;
                        }
                        playerdeck[(numspl)] = Integer.toString(num1);
                        numspl += 1;
                        if (numspl == (cardDeckSize - 1)) {
                            numspl = 0;
                        }
                        playerdeck[(numspl)] = Integer.toString(num2);
                        numspl += 1;
                        playerwins += 1;
                        turns += 1;
                    } else if (num1 == num2) {
                        if (numsc == (cardDeckSize - 1)) {
                            numsc = 0;
                        }
                        cpudeck[(numsc)] = Integer.toString(num1);
                        numsc += 1;

                        if (numsc == (cardDeckSize - 1)) {
                            numsc = 0;
                        }
                        cpudeck[(numsc)] = Integer.toString(num2);
                        numsc += 1;

                        cpuwins += 1;
                        turns += 1;

                    } else {
                        System.out.println("error");
                    }
                } else {
                    runnnn -= 1;
                }
            }
            /*
             * for (int i = 0; i < 26; i++) {
             * System.out.println(playerdeck[i] + "player");
             * System.out.println(cpudeck[i] + "cpu");
             * } // the for end /*
             */

            // The yes or no statement to play again
            if (playerwins > cpuwins) {
                System.out.println("Game " + games + " took " + turns + " turns.");
                System.out.println("The Player won that game.");
                System.out.println("");
                System.out.println(cpuwins + " " + playerwins);
                playercount += 1;
                turns = 0;
                playerwins = 0;
                cpuwins = 0;
            } else if (cpuwins > playerwins) {
                System.out.println("Game " + games + " took " + turns + " turns.");
                System.out.println("The CPU won that game.");
                System.out.println("");
                System.out.println(cpuwins + " " + playerwins);
                cpucount += 1;
                turns = 0;
                playerwins = 0;
                cpuwins = 0;
            }
            Scanner myScan = new Scanner(System.in);
            System.out.println("Play again? (y/n) ");
            String newnim = myScan.next();
            if (newnim.equals("y") || newnim.equals("yes") || newnim.equals("Y") || newnim.equals("Yes")) {
                times += 1;
                games += 1;
                for (int e = 0; e < cardDeckSize; e++) {
                    int w = e + (int) (Math.random() * (cardDeckSize - e));
                    String temp1 = cardDeck[e];
                    cardDeck[e] = cardDeck[w];
                    cardDeck[w] = temp1;
                } // for end

                // makes player and cpu deck deck
                for (int p = 0; p < 26; p++) {
                    playerdeck[p] = cardDeck[p];
                }
                for (int q = 26; q < 52; q++) {
                    cpudeck[q - 26] = cardDeck[q];
                }
                for (int o = 26; o < 52; o++) {
                    playerdeck[o] = "0";
                }
                for (int t = 0; t < 26; t++) {
                    cpudeck[t] = "0";
                }
            } else if (newnim.equals("n") || newnim.equals("no") || newnim.equals("N") || newnim.equals("No")) {
                times = 0;
            }

        } // the while end

        // Prints out the final results so the player can see there games ending
        if (times == 0) {
            System.out.println("");
            System.out.println("Thanks for playing!");
            System.out.println("Final Results: ");
            System.out.println("Player wins: " + playercount);
            System.out.println("CPU wins: " + cpucount);
        } // if
          // end

    } // main end
}
// class end