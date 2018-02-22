package zulus.lab2.proxy;

/**
 * Created by zulus on 22.02.18
 */
public class OperationCannotBePerformedException extends IllegalArgumentException {
    private Client _client;
    private ICountingHouse _house;
    private String _description;

    public OperationCannotBePerformedException(Client client, ICountingHouse house, String description) {
        setClient(client);
        setHouse(house);
        setDescription(description);
    }

    public String getDescription() {
        return _description;
    }

    private void setDescription(String description) {
        this._description = description;
    }

    private void setClient(Client client) {
        this._client = client;
    }

    private void setHouse(ICountingHouse house) {
        this._house = house;
    }

    public Client getClient() {
        return _client;
    }

    public ICountingHouse getHouse() {
        return _house;
    }

    @Override
    public String toString() {
        return String.format("OperationCannotBePerformedException: client: %s; counting house: %s; description: %s", getClient(), getHouse(), getDescription());
    }
}
