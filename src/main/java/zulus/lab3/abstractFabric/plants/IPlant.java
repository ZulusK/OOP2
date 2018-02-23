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


}
