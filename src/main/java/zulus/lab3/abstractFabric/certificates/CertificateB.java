package zulus.lab3.abstractFabric.certificates;

import zulus.lab3.abstractFabric.Participant;

/**
 * Created by zulus on 23.02.18
 */
public class CertificateB extends ICertificate {

    @Override
    public String getInfo() {
        return "Certificate, type B";
    }

    public CertificateB(Participant target) {
        super(target);
    }

    @Override
    public String toString() {
        return String.format("%s, for %s", getInfo(), _target);
    }
}
