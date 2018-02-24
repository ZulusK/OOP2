package zulus.lab3.fabricMethod;

/**
 * Created by zulus on 23.02.18
 */

/**
 * defines type of tiles card
 */
public class TilesCard extends ICard {
    public TilesCard() {

    }


    @Override
    public TilesCard clone() {
        TilesCard card = new TilesCard();
        return card;
    }

    @Override
    public String getSuit() {
        return "tiles";
    }
}
