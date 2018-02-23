package zulus.lab3.abstractFabric.plants;

/**
 * Created by zulus on 23.02.18
 */

import zulus.lab3.abstractFabric.Participant;
import zulus.lab3.abstractFabric.Quality;
import zulus.lab3.abstractFabric.awards.IAward;
import zulus.lab3.abstractFabric.certificates.ICertificate;
import zulus.lab3.abstractFabric.diplomas.IDiploma;

/**
 * defines interface of plant which can print different certificates
 */
public abstract class IPlant {

    public abstract IDiploma printDiploma(Participant target);

    public abstract ICertificate printCertificate(Participant target);

    public abstract IAward printAward(Participant target);

    public abstract int getCostOfAward();

    public abstract int getCostOfDiploma();

    public abstract int getCostOfCertificate();

    public abstract Quality getQualityOfColors();

    public abstract Quality getQualityOfPaper();

    public int compareToByQuality(IPlant plant) {
        return this.getQualityOfPaper().ordinal() + this.getQualityOfColors().ordinal() - plant.getQualityOfColors().ordinal() - plant.getQualityOfPaper().ordinal();
    }

    public int compareToByAward(IPlant plant) {
        if (plant == null) return 1;
        if (plant == this) return 0;
        if (plant.getCostOfAward() == this.getCostOfAward()) {
            return compareToByQuality(plant);
        } else {
            return plant.getCostOfAward() - this.getCostOfAward();
        }
    }

    public int compareToByCertificate(IPlant plant) {
        if (plant == null) return 1;
        if (plant == this) return 0;
        if (plant.getCostOfCertificate() == this.getCostOfCertificate()) {
            return compareToByQuality(plant);
        } else {
            return plant.getCostOfCertificate() - this.getCostOfCertificate();
        }
    }

    public int compareToByDiploma(IPlant plant) {
        if (plant == null) return 1;
        if (plant == this) return 0;
        if (plant.getCostOfDiploma() == this.getCostOfDiploma()) {
            return compareToByQuality(plant);
        } else {
            return plant.getCostOfDiploma() - this.getCostOfDiploma();
        }
    }
}
