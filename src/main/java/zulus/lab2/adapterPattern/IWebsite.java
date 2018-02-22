package zulus.lab2.adapterPattern;

/**
 * Created by zulus on 22.02.18
 */

/**
 * Defines interface of site, that allows visitors enter to service
 */
public interface IWebsite {
    /**
     * EnterAllows the user to the site
     *
     * @param visitor visitor of service
     * @return greeting message
     */
    String enterToService(Visitor visitor);
}
