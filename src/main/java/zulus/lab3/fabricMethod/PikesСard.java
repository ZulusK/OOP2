package zulus.lab3.fabricMethod;

/**
 * Created by zulus on 23.02.18
 */

/**
 * defines type of pikes card
 */
public class PikesСard extends ICard {
    @Override
    public String getSuit() {
        return "pikes";
    }

    public PikesСard(Dignity value) {
        super(value);
    }

}
