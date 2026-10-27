package src.Model;

public enum Suit {
    NONE(0),
    DIAMONDS(1), 
    HEARTS(2),
    SPADES(3), 
    CLUBS(4);
    
    int suit;
    
    private Suit(int suit) {
        this.suit = suit;
    }

    public int value() {
        return this.suit;
    }
}
