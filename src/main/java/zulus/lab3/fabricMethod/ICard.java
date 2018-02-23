package zulus.lab3.fabricMethod;

/**
 * Created by zulus on 23.02.18
 */

/**
 * defines abstract class of card
 */
public abstract class ICard {
    /**
     * get suit of this card
     *
     * @return suit of card
     */
    public abstract String getSuit();

    protected Dignity _dignity;

    /**
     * create card with specific Dignity
     *
     * @param _dignity
     */
    public ICard(Dignity _dignity) {
        setDignity(_dignity);
    }

    /**
     * get dignity if this card
     *
     * @return dignity оf card
     */
    public Dignity getDignity() {
        return _dignity;
    }

    /**
     * get dignity if this card
     *
     * @param dignity value of dignity if card
     */
    public void setDignity(Dignity dignity) {
        if (dignity == null) throw new IllegalArgumentException("Argument dignity must be not-null value");
        this._dignity = dignity;
    }

    @Override
    public String toString() {
        return String.format("%s %s card", this.getSuit(), this._dignity);
    }
}
