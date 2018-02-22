package zulus.lab2.proxy;

/**
 * Created by zulus on 22.02.18
 */

/**
 * defines interface of counting house
 */
public interface ICountingHouse {
    /**
     * process client's request to counting house
     *
     * @param cost   cost of operation
     * @param client client of operation
     * @return document, that describes operation
     */
    String processOperation(double cost, Client client);
}
