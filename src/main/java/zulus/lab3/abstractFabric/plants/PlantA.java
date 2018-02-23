package zulus.lab3.abstractFabric.plants;

import zulus.lab3.abstractFabric.Participant;
import zulus.lab3.abstractFabric.Quality;
import zulus.lab3.abstractFabric.awards.AwardA;
import zulus.lab3.abstractFabric.awards.IAward;
import zulus.lab3.abstractFabric.certificates.CertificateA;
import zulus.lab3.abstractFabric.certificates.ICertificate;
import zulus.lab3.abstractFabric.diplomas.DiplomaA;
import zulus.lab3.abstractFabric.diplomas.IDiploma;

/**
 * Created by zulus on 23.02.18
 */
public class PlantA extends IPlant {

    @Override
    public IDiploma printDiploma(Participant target) {
        return new DiplomaA(target);
    }

    @Override
    public ICertificate printCertificate(Participant target) {
        return new CertificateA(target);
    }

    @Override
    public IAward printAward(Participant target) {
        return new AwardA(target);
    }

    public int getCostOfAward() {
        return 100;
    }

    public int getCostOfDiploma() {
        return 500;
    }

    public int getCostOfCertificate() {
        return 500;
    }

    @Override
    public Quality getQualityOfColors() {
        return Quality.BEST;
    }

    @Override
    public Quality getQualityOfPaper() {
        return Quality.GOOD;
    }
}
