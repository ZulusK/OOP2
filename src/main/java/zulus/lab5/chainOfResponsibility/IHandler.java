package zulus.lab5.chainOfResponsibility;

/**
 * Created by zulus on 06.03.18
 */
public abstract class IHandler {
    IHandler _successor;

    public IHandler getSuccessor() {
        return _successor;
    }

    public void setSuccessor(IHandler successor) {
        this._successor = successor;
    }

    abstract boolean askForMoney(double cost);
}
