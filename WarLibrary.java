/*
 * Author: Ingrid Bailey
 * Co-Author: Kyle Krstulich
 * 
 * 10/30/23
 * WarLibrary.java
 * 
 * Bunch of funcitons to play the card game war from the command-line.
 */

public class WarLibrary {
    private static String[] suits = { "hearts", "diamonds", "spades", "clubs" };
    private static String[] cardValues = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king",
            "ace" };
    public static String[][] cardDeck = new String[52][2];
    final private static String NULL_VALUE = "*";
    final private static String[] EMPTY_CARD = { NULL_VALUE, NULL_VALUE };

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
            deck[k] = EMPTY_CARD;
        }

        return deck;
    }

    public static String[][] CreateDeck() {
        String[][] deck = new String[52][2];
        int deckIndex;
        for (int i = 0; i < suits.length; i++) {
            String suit = suits[i];
            for (int j = 0; j < cardValues.length; j++) {
                String cardValue = cardValues[j];
                String[] card = { cardValue, suit };
                deckIndex = ((j * suits.length) + i);
                deck[deckIndex] = card;
            }
        }

        return deck;
    }

    // null value of a array is empty string, gets how many NON null values in deck
    public static int GetLength(String[][] deck) {
        int size = 0;
        for (int i = 0; i < 52; i++) {
            if (deck[i][0] != NULL_VALUE)
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
        String[] card = Deck[index];
        Deck[index] = EMPTY_CARD;
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

    // Decodes the string cards into integers, compares them, if playercard wins
    // throw true else throw false
    public static boolean CompareCard(String[] playercard, String[] cpucard) {
        boolean result = true;
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

    // From the master static deck, deal cards to both decks.
    public static void DealDeck(String[][] playerDeck, String[][] cpuDeck) {
        for (int k = 0; k < 52; k++) {
            if (k < 26) {
                playerDeck[k] = cardDeck[k];
            } else {
                cpuDeck[k - 26] = cardDeck[k];
            }
        }
    }

    // Throws false for empty deck
    public static boolean Lose(String[][] playerDeck) {
        boolean result = false;
        if (GetLength(playerDeck) == 0) {
            result = true;
        }
        return result;
    }

}