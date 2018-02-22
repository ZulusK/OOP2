package zulus.lab2.proxy;

/**
 * Created by zulus on 22.02.18
 */

/**
 * defines Client for financial operations
 */
public class Client {
    String _name;
    double _money;

    /**
     * Create new client with specified name and start cash
     *
     * @param name name if client
     * @param cash value cash of client
     */
    public Client(String name, double cash) {
        setName(name);
        setMoney(cash);
    }

    /**
     * get name of client
     *
     * @return name of client
     */
    public String getName() {
        return _name;
    }

    /**
     * set name of client
     *
     * @param name value of name of client
     */
    public void setName(String name) {
        this._name = name;
    }

    /**
     * get current cash of client
     *
     * @return current cash of client
     */
    public double getMoney() {
        return _money;
    }

    /**
     * set value of cash of client
     *
     * @param money new value of cash
     */
    private void setMoney(double money) {
        if (money < 0) throw new IllegalArgumentException("Cash must be positive real number");
        this._money = money;
    }

    /**
     * Ask client to pay for product
     *
     * @param cost cost of product
     * @return true, if client had payed for product
     */
    public boolean pay(double cost) {
        if (canPay(cost)) {
            _money -= cost;
            return true;
        } else {
            return false;
        }
    }

    /**
     * check, can Client pay for product
     *
     * @param cost cost of product
     * @return true, if client can pay for product
     */
    public boolean canPay(double cost) {
        if (cost < 0) throw new IllegalArgumentException("Cost must be positive real number");
        return cost < _money;
    }

    @Override
    public String toString() {
        return String.format("Client [%s, %.2f]", _name, _money);
    }
}
