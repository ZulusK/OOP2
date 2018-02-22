package zulus.lab2;

/**
 * Created by zulus on 22.02.18
 */
public class CountingHouse implements ICountingHouse {
    String _name;

    public CountingHouse(String name) {
        setName(name);
    }

    @Override
    public String processOperation(double cost, Client client) {
        client.pay(cost);
        return String.format("Financial operation[%.2f$] computed for %s", cost, client);
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    @Override
    public String toString() {
        return String.format("Counting house: %s", _name);
    }
}
