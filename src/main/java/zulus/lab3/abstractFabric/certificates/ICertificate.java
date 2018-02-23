package zulus.lab3.abstractFabric.certificates;

import zulus.lab3.abstractFabric.IPrize;
import zulus.lab3.abstractFabric.Participant;

/**
 * Created by zulus on 23.02.18
 */
public abstract class ICertificate extends IPrize {

    public ICertificate(Participant target) {
        super(target);
    }

}
