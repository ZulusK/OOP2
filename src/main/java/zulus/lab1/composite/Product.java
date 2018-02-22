package zulus.lab1.composite;

/**
 * Created by zulus on 21.02.18
 */

/**
 * Defines goods to be sold by the distributor
 */
public class Product {
    private double _minCost;
    private double _maxCost;
    private String _name;

    /**
     * creates new Product with specific name and cost
     *
     * @param minCost min cost of product
     * @param maxCost max cost of product
     * @param name    name of product
     */
    public Product(double minCost, double maxCost, String name) {

        setMaxCost(maxCost);
        setMinCost(minCost);
        setName(name);
    }

    /**
     * get max cost of this product
     *
     * @return max cost of product
     */
    public double getMaxCost() {
        return _maxCost;
    }

    /**
     * get min cost of this product
     *
     * @return min cost of product
     */
    public double getMinCost() {
        return _minCost;
    }

    /**
     * set min cost of product
     *
     * @param cost value of min cost
     */
    public void setMinCost(double cost) {
        if (cost <= 0) throw new IllegalArgumentException("Cost of product must be positive real number");
        if (cost > _maxCost) throw new IllegalArgumentException("Max cost must be > min cost");
        this._minCost = cost;
    }

    /**
     * set max cost of product
     *
     * @param cost value of max cost
     */
    public void setMaxCost(double cost) {
        if (cost <= 0) throw new IllegalArgumentException("Cost of product must be positive real number");
        if (cost < _minCost) throw new IllegalArgumentException("Max cost must be > min cost");
        this._maxCost = cost;
    }

    /**
     * get name of product
     *
     * @return name of product
     */
    public String getName() {
        return _name;
    }

    /**
     * set name of product
     *
     * @param name new name of product
     */
    public void setName(String name) {
        this._name = name;
    }

    @Override
    public String toString() {
        return String.format("Product %s, cost range [%.2f, %.2f]", _name, _minCost, _maxCost);
    }
}
