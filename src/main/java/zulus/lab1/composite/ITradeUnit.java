package zulus.lab1.composite;

/**
 * Created by zulus on 21.02.18
 */

/**
 * Defines interface of distribution network's elements
 */
public interface ITradeUnit {


    /**
     * get extra charge of this employee
     *
     * @return value of extra charge of current employee
     */
    double getExtraCharge();

    /**
     * get name of this employee
     *
     * @return name of employee
     */
    String getName();

    /**
     * set name of employee
     *
     * @param name new name of employee
     */
    void setName(String name);

    /**
     * set extra charge of this employee
     *
     * @param value new value of extra charge of this unit
     */
    void setExtraCharge(double value);


    /**
     * add new employee
     *
     * @param employee new employee
     * @return true, if employee has been added
     */
    boolean add(ITradeUnit employee);

    /**
     * remove employee
     *
     * @param employee new employee
     * @return true, if employee has been removed
     */
    boolean remove(ITradeUnit employee);

    /**
     * sell product to all clients, cost of product start from currentCost
     *
     * @param product       product to sell by this network
     * @param costOfProduct current cost of product
     * @param deep          level of current employee
     * @return true, if product has been sold
     */
    boolean sell(Product product, double costOfProduct, int deep);

    /**
     * sell product to all clients, cost of product start from product.minCost
     *
     * @param product product to sell by this network
     * @return true, if product has been sold
     */
    boolean sell(Product product);
}
