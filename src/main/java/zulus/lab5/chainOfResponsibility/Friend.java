package zulus.lab5.chainOfResponsibility;

/**
 * Created by zulus on 06.03.18
 */
public class Friend extends IHandler {
    String _name;
    double _money;

    public double getMoney() {
        return _money;
    }

    public void setMoney(double money) {
        this._money = money;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public Friend(String name, double money) {
        setName(name);
        setMoney(money);
    }

    public boolean askForMoney(double cost) {
        if (cost <= _money) {
            _money -= cost;
            return true;
        } else {
            if (_successor != null && _successor.askForMoney(cost)) {
                return true;
            } else {
                return false;
            }
        }
    }
}

