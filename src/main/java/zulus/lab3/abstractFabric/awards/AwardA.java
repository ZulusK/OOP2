package zulus.lab3.abstractFabric.awards;

import zulus.lab3.abstractFabric.Participant;

/**
 * Created by zulus on 23.02.18
 */
public class AwardA extends IAward {

    @Override
    public String getInfo() {
        return "Award, type A";
    }

    public AwardA(Participant target) {
        super(target);
    }

    @Override
    public String toString() {
        return String.format("%s, for %s", getInfo(), _target);
    }
}
