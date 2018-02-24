package zulus.lab3.fabricMethod;

/**
 * Created by zulus on 23.02.18
 */

/**
 * defines type of hearts card
 */
public class HeartsCard extends ICard {
    public HeartsCard() {
    }

    @Override
    public String getSuit() {
        return "hearts";
    }

    @Override
    public HeartsCard clone() {
        HeartsCard card = new HeartsCard();
        return card;
    }
}
