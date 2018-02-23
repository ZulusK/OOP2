package zulus.lab3.fabricMethod;

/**
 * Created by zulus on 23.02.18
 */

/**
 * defines fabric of cards
 */
public class CardFabric {
    /**
     * create new card with specific dignity and suit
     *
     * @return created card
     */
    public ICard createCard(Dignity dignity, String suit) {
        switch (suit.toLowerCase()) {
            case "hearts":
                return new HeartsCard(dignity);
            case "tiles":
                return new TilesCard(dignity);
            case "pikes":
                return new PikesСard(dignity);
            case "clovers":
                return new CloversCard(dignity);
            default:
                throw new IllegalArgumentException("Unrecognized suit of card");
        }
    }
}
