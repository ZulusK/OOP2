package zulus.lab1.beutyStaff;

import java.util.HashSet;

/**
 * Created by zulus on 21.02.18
 */

/**
 * Defines manager of trading company
 */
public class Manager implements ITradeUnit {
    double _extraCharge;
    String _name;
    HashSet<ITradeUnit> _employees;

    /**
     * create new Manager
     *
     * @param name        name of manager
     * @param extraCharge default extraCharge of manager
     */
    public Manager(String name, double extraCharge) {
        setExtraCharge(extraCharge);
        setName(name);
        this._employees = new HashSet<>();
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
        if (employee == null) throw new IllegalArgumentException("Argument employee must be not-null value");
        if (employee == this) throw new IllegalArgumentException("Employee must be not self-pointer");
        return this._employees.add(employee);
    }

    @Override
    public boolean remove(ITradeUnit employee) {
        if (employee == null) throw new IllegalArgumentException("Argument employee must be not-null value");
        return this._employees.remove(employee);
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
            throw new IllegalArgumentException("costOfProduct must be >= product.minCost");
        if (_employees.isEmpty()) {
            System.out.printf("%" + deep + "s Manager %s cannot sold the `%s` \n", " ", _name, product);
            return false;
        } else {
            double costOfTrade = getCurrentCost(product, costOfProduct);
            System.out.printf("%" + deep + "s Manager %s sold the `%s` for %.2f$ (+%.2f%%)\n", " ", _name, product, costOfTrade, getCurrentExtraCharge(costOfProduct, costOfTrade));
            for (ITradeUnit unit : _employees) {
                unit.sell(product, costOfTrade, deep + 1);
            }
            return true;
        }
    }

    private double getCurrentExtraCharge(double costOfProduct, double costOfTrade) {
        double gain = costOfTrade - costOfProduct;
        return gain / 100;
    }

    private double getCurrentCost(Product P, double currentCost) {
        return Math.min(P.getMaxCost(), currentCost * (1 + _extraCharge));
    }
}
