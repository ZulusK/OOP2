package zulus.lab3.fabricMethod;

/**
 * Created by zulus on 23.02.18
 */

/**
 * defines type of clovers card
 */
public class CloversCard extends ICard {
    public CloversCard() {
    }

    @Override
    public String getSuit() {
        return "clovers";
    }

    @Override
    public CloversCard clone() {
        CloversCard card = new CloversCard();
        return card;
    }
}
