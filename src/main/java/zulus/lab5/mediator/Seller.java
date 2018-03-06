package zulus.lab5.mediator;

/**
 * Created by zulus on 06.03.18
 */
public class Seller {
    private String name;

    public Seller(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Seller %s", getName());
    }
}
