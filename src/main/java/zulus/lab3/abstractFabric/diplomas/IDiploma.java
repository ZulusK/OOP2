package zulus.lab3.abstractFabric.diplomas;

import zulus.lab3.abstractFabric.IPrize;
import zulus.lab3.abstractFabric.Participant;

/**
 * Created by zulus on 23.02.18
 */
public abstract class IDiploma extends IPrize {

    public IDiploma(Participant target) {
        super(target);
    }

}
