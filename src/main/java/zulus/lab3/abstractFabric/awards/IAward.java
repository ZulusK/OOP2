package zulus.lab3.abstractFabric.awards;

import zulus.lab3.abstractFabric.IPrize;
import zulus.lab3.abstractFabric.Participant;

/**
 * Created by zulus on 23.02.18
 */
public abstract class IAward extends IPrize {
    public IAward(Participant target) {
        super(target);
    }
}
