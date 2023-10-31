public class WarMidterm {

    private static String[] suits = { "hearts", "diamonds", "spades", "clubs" };
    private static String[] cardValues = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king",
            "ace" };
    private static int cardDeckSize = suits.length * cardValues.length;

    private static int playerCards;
    private static int cpuCards;

    public static void applyRoundResult(int[] winnerDeck, int[] loserDeck, boolean isPlayerWinner, int winnerIndex,
            int loserIndex) {
        int winnerCards = isPlayerWinner ? playerCards : cpuCards;
        int loserCards = isPlayerWinner ? cpuCards : playerCards;

        // [0, 1, 2] - player deck, playerCards = 4
        // [1, 2, 0, 2]
        // [3, 4, 0] - cpu deck, cpuCards = 2
        for (int i = 1; i < winnerCards; i++) {
            winnerDeck[i - 1] = winnerDeck[i];
        }
        winnerDeck[winnerCards - 1] = winnerIndex;
        winnerDeck[winnerCards++] = loserIndex;

        for (int i = 1; i < loserCards; i++) {
            loserDeck[i - 1] = loserDeck[i];
        }
        loserDeck[--loserCards] = 0;

        playerCards = isPlayerWinner ? winnerCards : loserCards;
        cpuCards = isPlayerWinner ? loserCards : winnerCards;
    }

    public static void play(int[] playerDeck, int[] cpuDeck, int[] cardDeckValues, String[] cardDeck,
            int pauseDuration) {
        playerCards = cardDeckSize / 2;
        cpuCards = playerCards;

        boolean playing = true;
        int cardIndex = 0;
        double cardWidth = .35;
        double cardHeight = .5;
        StdDraw.enableDoubleBuffering();

        while (playing) {
            int playerIndex = playerDeck[cardIndex];
            int cpuIndex = cpuDeck[cardIndex];
            int playerValue = cardDeckValues[playerIndex];
            int cpuValue = cardDeckValues[cpuIndex];
            String playerCard = cardDeck[playerIndex];
            String cpuCard = cardDeck[cpuIndex];

            String text;
            if (playerValue > cpuValue) {
                text = "Player Wins!";
                applyRoundResult(playerDeck, cpuDeck, true, playerIndex, cpuIndex);
            } else if (cpuValue > playerValue) {
                text = "Cpu Wins!";
                applyRoundResult(cpuDeck, playerDeck, false, cpuIndex, playerIndex);
            } else {
                text = "Tie!";
                applyRoundResult(cpuDeck, playerDeck, false, cpuIndex, playerIndex);
            }

            StdDraw.clear();
            StdDraw.picture(.25, .7, "./assets/" + playerCard + ".png", cardWidth, cardHeight);
            StdDraw.picture(.75, .7, "./assets/" + cpuCard + ".png", cardWidth, cardHeight);

            StdDraw.text(.25, .25, "Player Cards: " + playerCards);
            StdDraw.text(.75, .25, "Cpu Cards: " + cpuCards);

            StdDraw.text(.5, .30, text);
            StdDraw.show();
            StdDraw.pause(pauseDuration * 1000);
            playing = playerCards > 0 && cpuCards > 0;
        }
    }

    public static void deal(int[] playerDeck, int[] cpuDeck) {
        int numberOfDeals = 0;
        boolean playerGoesFirst = (int) (Math.random() * 2) == 1;

        for (int i = 0; i < cardDeckSize; i += 2) {
            int playerIncrement = playerGoesFirst ? 0 : 1;
            int cpuIncrement = playerGoesFirst ? 1 : 0;
            playerDeck[numberOfDeals] = i + playerIncrement;
            cpuDeck[numberOfDeals] = i + cpuIncrement;
            numberOfDeals += 1;
        }
    }

    public static void createDeck(String[] suits, String[] cardValues, int[] cardDeckValues, String[] cardDeck) {

        for (int i = 0; i < suits.length; i++) {
            String suit = suits[i];
            for (int j = 0; j < cardValues.length; j++) {
                String cardValue = cardValues[j];
                cardDeck[i * cardValues.length + j] = cardValue + "_of_" + suit;
                cardDeckValues[i * cardValues.length + j] = j;
            }
        }
    }

    public static void shuffleDeck(int[] cardDeckValues, String[] cardDeck) {
        for (int i = 0; i < cardDeckValues.length; i++) {
            int randomIndex = (int) (Math.random() * cardDeckValues.length);
            int tempValue = cardDeckValues[randomIndex];
            cardDeckValues[randomIndex] = cardDeckValues[i];
            cardDeckValues[i] = tempValue;

            String tempCard = cardDeck[randomIndex];
            cardDeck[randomIndex] = cardDeck[i];
            cardDeck[i] = tempCard;
        }
    }

    public static void main(String[] args) {
        // Get pause duration in seconds from command line.
        int pauseDuration = Integer.parseInt(args[0]);

        // Initialize card deck.
        int[] cardDeckValues = new int[cardDeckSize];
        String[] cardDeck = new String[cardDeckSize];

        // Create card deck.
        createDeck(suits, cardValues, cardDeckValues, cardDeck);

        // Shuffle the deck.
        shuffleDeck(cardDeckValues, cardDeck);

        // Initialize the player and cpu decks.
        int[] playerDeck = new int[cardDeckSize];
        int[] cpuDeck = new int[cardDeckSize];

        // Deal cards to player and cpu decks.
        deal(playerDeck, cpuDeck);

        // Play war.
        play(playerDeck, cpuDeck, cardDeckValues, cardDeck, pauseDuration);
    }
}