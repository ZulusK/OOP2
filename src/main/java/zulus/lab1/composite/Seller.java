package zulus.lab1.composite;


/**
 * Created by zulus on 21.02.18
 */

/**
 * Defines seller of trading company
 */
public class Seller implements ITradeUnit {
    double _extraCharge;
    String _name;

    /**
     * create new FlatSeller
     *
     * @param name        name of seller
     * @param extraCharge default extraCharge of seller
     */
    public Seller(String name, double extraCharge) {
        setExtraCharge(extraCharge);
        setName(name);
    }

    @Override
    public double getExtraCharge() {
        return _extraCharge;
    }

    @Override
    public void setExtraCharge(double value) {
        if (value < 0) throw new IllegalArgumentException("Extra charge must be positive real number");
        this._extraCharge = value;
    }

    @Override
    public void setName(String name) {
        this._name = name;
    }

    @Override
    public String getName() {
        return this._name;
    }

    @Override
    public boolean add(ITradeUnit employee) {
        throw new UnsupportedOperationException("FlatSeller couldn't have employee");
    }

    @Override
    public boolean remove(ITradeUnit employee) {
        throw new UnsupportedOperationException("FlatSeller couldn't have employee");
    }

    @Override
    public boolean sell(Product product) {
        if (product == null)
            throw new IllegalArgumentException("Argument product must be not-null value");
        return this.sell(product, product.getMinCost(), 1);
    }

    @Override
    public boolean sell(Product product, double costOfProduct, int deep) {
        if (product == null)
            throw new IllegalArgumentException("Argument product must be not-null value");
        if (costOfProduct < product.getMinCost())
            throw new IllegalArgumentException("CurrentCost must be >= product.minCost");

        double costOfTrade = getCurrentCost(product, costOfProduct);
        System.out.printf("%" + deep + "s FlatSeller %s sold the `%s` for %.2f$ (+%.2f%%)\n", " ", _name, product, costOfTrade, getCurrentExtraCharge(costOfProduct, costOfTrade));
        return true;
    }

    private double getCurrentExtraCharge(double costOfProduct, double costOfTrade) {
        double gain = costOfTrade - costOfProduct;
        return gain / 100;
    }

    private double getCurrentCost(Product P, double currentCost) {
        return Math.min(P.getMaxCost(), currentCost * (1 + _extraCharge));
    }
}
