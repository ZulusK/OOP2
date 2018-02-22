package zulus.lab2.proxy;

/**
 * Created by zulus on 22.02.18
 */
public class CountingHouseGuard implements ICountingHouse {
    ICountingHouse _countingHouse;

    public CountingHouseGuard(ICountingHouse countingHouse) {
        setCountingHouse(countingHouse);
    }

    public ICountingHouse getCountinghouse() {
        return _countingHouse;
    }

    public void setCountingHouse(ICountingHouse countingHouse) {
        if (countingHouse == null) throw new IllegalArgumentException("Argument proxy must be not-null value");
        this._countingHouse = countingHouse;
    }

    @Override
    public String processOperation(double cost, Client client) {
        if (client == null) throw new IllegalArgumentException("Argument client must be not-null value");
        if (!client.canPay(cost))
            throw new OperationCannotBePerformedException(client, _countingHouse, "Client haven't enough money for this operation");
        return _countingHouse.processOperation(cost, client);
    }

}
