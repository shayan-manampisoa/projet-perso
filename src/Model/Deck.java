package src.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<PlayingCard> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                System.out.println("Creating card [" + rank + "] [" + suit + "]");
                this.cards.add(new PlayingCard(rank, suit));
            }
        }

        shuffle();
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < cards.size(); i++){
            Collections.swap(cards, i, random.nextInt(cards.size()));
        }
    }

    public PlayingCard removeTopCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Cannot remove card from empty deck");
        }
        return cards.remove(0);
    }

    public void returnCardToDeck(PlayingCard pc) {
        cards.add(pc);
    }

    public List<PlayingCard> getCards() {
        return cards;
    }
}
