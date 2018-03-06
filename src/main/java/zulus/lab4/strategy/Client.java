package zulus.lab4.strategy;

/**
 * Created by zulus on 06.03.18
 */
public class Client {
    Discount _discount;
    String _name;

    public Client(String name) {
        setName(name);
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public Discount getDiscount() {
        return _discount;
    }

    public void setDiscount(Discount discount) {
        this._discount = discount;
    }

    public String pay() {
        return String.format("%s payed for services with discount %s", _name, _discount != null ? _discount : "0%");
    }
}
