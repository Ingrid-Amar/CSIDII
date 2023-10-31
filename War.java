public class War {
    private static int playerCards;
    private static int cpuCards;

    public static void main(String[] args) {
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
}