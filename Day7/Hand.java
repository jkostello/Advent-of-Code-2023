package Day7;
import java.util.HashMap;

public class Hand implements Comparable<Hand> {
    public char[] cards;
    public int strength;
    public int bet;

    private HashMap<Character, Integer> cardMap = new HashMap<>();
    private char[] cardStrength = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};

    public Hand(String input) {
        cards = input.split(" ")[0].toCharArray();
        bet = Integer.parseInt(input.split(" ")[1]);
        
        // Add cards to map
        // Map represents how many of each card there are
        for (char card : cards) {
            if (cardMap.containsKey(card)) {
                cardMap.put(card, cardMap.get(card) + 1); // Increment count by 1
            } else {
                cardMap.put(card, 1); // Add to map
            }
        }
        
        // Determine hand strength
        switch (cardMap.size()) {
        case 1:
            this.strength = 7; // Five of a kind
            break;
        case 2:
            if (cardMap.containsValue(4)) {
                this.strength = 6; // Four of a kind
            } else {
                this.strength = 5; // Full house
            }
            break;
        case 3:
            if (cardMap.containsValue(3)) {
                this.strength = 4; // Three of a kind
            } else {
                this.strength = 3; // Two pair
            }
            break;
        case 4:
            this.strength = 2; // One pair
            break;
        default:
            this.strength = 1; // High card
        }
    }

    // For sorting array
    @Override
    public int compareTo(Hand other) {
        if (this.strength == other.strength) {

            for(int i = 0; i < this.cards.length; i++) {
                char thisCard = this.cards[i];
                char otherCard = other.cards[i];
                if (thisCard != otherCard) {
                    int thisStrength = new String(cardStrength).indexOf(thisCard);
                    int otherStrength = new String(cardStrength).indexOf(otherCard);
                    return Integer.compare(thisStrength, otherStrength);
                }
            }

            return 0;
        }

        return Integer.compare(this.strength, other.strength);
    }
}