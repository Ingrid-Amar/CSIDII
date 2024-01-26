public class WarLibrary {
    private static String[] suits = { "hearts", "diamonds", "spades", "clubs" };
    private static String[] cardValues = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king",
            "ace" };
    public static String[][] cardDeck = new String[52][2];

    // makes the unshuffled deck
    /*
     * Data structured as:
     * deck = [
     * [cardValue, cardSuit],
     * [cardValue, cardSuit],
     * ...
     * ]
     */

    static {
        cardDeck = CreateDeck();
        ShuffleDeck(cardDeck);
    }

    public static String[][] CreateEmptyDeck() {
        String[][] deck = new String[52][];

        for (int k = 0; k < 52; k++) {
            String[] card = { " ", " " };
            deck[k] = card;
        }

        return deck;
    }

    public static String[][] CreateDeck() {
        String[][] deck = new String[52][2];
        for (int i = 0; i < suits.length; i++) {
            String suit = suits[i];
            for (int j = 0; j < cardValues.length; j++) {
                String cardValue = cardValues[j];
                String[] card = { cardValue, suit };
                deck[(i + 1) * (j + 1) - 1] = card;
            }
        }

        return deck;
    }

    // null value of a array is empty string, gets how many NON null values in deck
    public static int GetLength(String[][] deck) {
        int size = 0;
        for (int i = 0; i < 52; i++) {
            if (deck[i][0] != " ")
                size++;

        }
        return size;
    }

    // shuffle the deck exluding null val
    public static void ShuffleDeck(String[][] Deck) {

        String[] temp, card;
        int size = GetLength(Deck);
        for (int i = 0; i < size; i++) {
            int randomIndex = (int) (Math.random() * i);
            temp = Deck[randomIndex];
            card = Deck[i];
            Deck[randomIndex] = card;
            Deck[i] = temp;

        }
    }

    // takes out the last NON null value from top of array
    public static String[] PullCard(String[][] Deck) {
        int index = GetLength(Deck) - 1;
        String[] emptyCard = { " ", " " };
        String[] card = Deck[index];
        Deck[index] = emptyCard;
        System.out.println("Pull_Card: " + card[0] + ", " + card[1]);
        return card;
    }

    // replaces the first null value of array, shuffles deck
    public static void AddCard(String[][] Deck, String[] card) {
        int index = GetLength(Deck);
        Deck[index] = card;
        ShuffleDeck(Deck);
    }

    // converts string values of card to int
    public static int[] Decode(String[] card) {
        int[] cardDecoder = new int[2];
        switch (card[0]) {
            case "ace":
                cardDecoder[0] = 14;
                break;
            case "king":
                cardDecoder[0] = 13;
                break;
            case "queen":
                cardDecoder[0] = 12;
                break;
            case "jack":
                cardDecoder[0] = 11;
                break;
            default:
                cardDecoder[0] = Integer.valueOf(card[0]);
        }
        switch (card[1]) {
            case "diamonds":
                cardDecoder[1] = 4;
                break;
            case "hearts":
                cardDecoder[1] = 3;
                break;
            case "clubs":
                cardDecoder[1] = 2;
                break;
            case "spades":
                cardDecoder[1] = 1;
                break;
            default:
                cardDecoder[1] = 0;
        }
        return cardDecoder;
    }

    public static boolean CompareCard(String[] playercard, String[] cpucard) {
        boolean result = true;
        System.out.println("Player card " + playercard[0] + ", " + playercard[1]);
        System.out.println("cpu card " + cpucard[0] + ", " + cpucard[1]);
        int[] playerconvert = Decode(playercard);
        int[] cpuconvert = Decode(cpucard);

        int playercardvalue = playerconvert[0];
        int playersuitvalue = playerconvert[1];
        int cpucardvalue = cpuconvert[0];
        int cpusuitvalue = cpuconvert[1];
        if (playercardvalue < cpucardvalue)
            result = false;
        else if (playercardvalue == cpucardvalue) {
            if (playersuitvalue < cpusuitvalue)
                result = false;
        }
        return result;
    }

    public static void DealDeck(String[][] playerDeck, String[][] cpuDeck) {
        for (int k = 0; k < 52; k++) {
            if (k < 26) {
                playerDeck[k] = cardDeck[k];
            } else {
                cpuDeck[k - 25] = cardDeck[k];
            }
        }
    }

    public static boolean Lose(String[][] playerDeck) {
        boolean result = false;
        if (GetLength(playerDeck) == 0) {
            result = true;
        }
        return result;
    }

    public static void TestFuction() {
        String[][] playerDeck = CreateEmptyDeck();
        String[][] cpuDeck = CreateEmptyDeck();

        boolean playersturn = true;
        int playerwins = 0;
        int cpuwins = 0;
        DealDeck(playerDeck, cpuDeck);
        String[] playercard = PullCard(playerDeck);
        String[] cpucard = PullCard(cpuDeck);
        System.out.println(playerDeck[0][0]);
        while (true) {
            if (Lose(playerDeck) || Lose(cpuDeck))
                break;
            if (playersturn) {
                playercard = PullCard(playerDeck);
                cpucard = PullCard(cpuDeck);
            } else {
                cpucard = PullCard(cpuDeck);
                playercard = PullCard(playerDeck);
            }
            if (CompareCard(playercard, cpucard)) {
                AddCard(playerDeck, cpucard);
                AddCard(playerDeck, playercard);
                playersturn = true;
                playerwins += 1;
            } else {
                AddCard(cpuDeck, cpucard);
                AddCard(cpuDeck, playercard);
                playersturn = false;
                cpuwins += 1;
            }
            System.out.println("cpu length: " + GetLength(cpuDeck));
            System.out.println("Player length: " + GetLength(playerDeck));
            System.out.println("Player wins: " + playerwins);
            System.out.println("cpuwins: " + cpuwins);
        }
        System.out.println("Player wins: " + playerwins);
        System.out.println("cpuwins: " + cpuwins);
        System.out.println("cpudeck size: " + GetLength(cpuDeck));
        System.out.println("playerdeck size: " + GetLength(playerDeck));

    }

    public static void main(String[] args) {
        TestFuction();

    }
}