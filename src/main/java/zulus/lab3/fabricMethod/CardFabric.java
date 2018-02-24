package zulus.lab3.fabricMethod;

/**
 * Created by zulus on 23.02.18
 */

/**
 * defines fabric of cards
 */
public class CardFabric {
    private static CardFabric _instance;

    private HeartsCard _hearts;
    private TilesCard _tiiles;
    private PikesСard _pikes;
    private CloversCard _clovers;

    private CardFabric() {
        _hearts = new HeartsCard();
        _tiiles = new TilesCard();
        _pikes = new PikesСard();
        _clovers = new CloversCard();
    }

    public static CardFabric getInstance() {
        if (_instance == null) {
            _instance = new CardFabric();
        }
        return _instance;
    }

    /**
     * create new card with specific dignity and suit
     *
     * @return created card
     */
    public ICard createCard(Dignity dignity, String suit) {
        ICard card;
        switch (suit.toLowerCase()) {
            case "hearts":
                card = _hearts.clone();
                break;
            case "tiles":
                card = _tiiles.clone();
                break;
            case "pikes":
                card = _pikes.clone();
                break;
            case "clovers":
                card = _clovers.clone();
                break;
            default:
                throw new IllegalArgumentException("Unrecognized suit of card");
        }
        card.setDignity(dignity);
        return card;
    }
}
