package zulus.lab3.abstractFabric.plants;

import zulus.lab3.abstractFabric.Participant;
import zulus.lab3.abstractFabric.Quality;
import zulus.lab3.abstractFabric.awards.AwardB;
import zulus.lab3.abstractFabric.awards.IAward;
import zulus.lab3.abstractFabric.certificates.CertificateB;
import zulus.lab3.abstractFabric.certificates.ICertificate;
import zulus.lab3.abstractFabric.diplomas.DiplomaB;
import zulus.lab3.abstractFabric.diplomas.IDiploma;

/**
 * Created by zulus on 23.02.18
 */
public class PlantB extends IPlant {

    @Override
    public IDiploma printDiploma(Participant target) {
        return new DiplomaB(target);
    }

    @Override
    public ICertificate printCertificate(Participant target) {
        return new CertificateB(target);
    }

    @Override
    public IAward printAward(Participant target) {
        return new AwardB(target);
    }

    public int getCostOfAward() {
        return 700;
    }

    public int getCostOfDiploma() {
        return 100;
    }

    public int getCostOfCertificate() {
        return 500;
    }


    @Override
    public Quality getQualityOfColors() {
        return Quality.GOOD;
    }

    @Override
    public Quality getQualityOfPaper() {
        return Quality.GOOD;
    }
}
