package zulus.lab3.abstractFabric;

/**
 * Created by zulus on 23.02.18
 */
public abstract class IPrize {

    protected Participant _target;

    public abstract String getInfo();

    public Participant getTarget() {
        return _target;
    }

    private void setTarget(Participant target) {
        if (target == null) throw new IllegalArgumentException("Argument target must be not-null value");
        this._target = target;
    }

    public IPrize(Participant target) {
        setTarget(target);
    }

}
