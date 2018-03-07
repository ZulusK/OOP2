package zulus.lab5.mediator;

/**
 * Created by zulus on 06.03.18
 */
public class FlatBuyer {
    private String name;
    private int rooms;
    private double maxCost;

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        if (rooms <= 0) throw new IllegalArgumentException("Argument rooms must be positive integer ");
        this.rooms = rooms;
    }

    public double getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(double maxCost) {
        if (maxCost <= 0) throw new IllegalArgumentException("Argument cost must be positive real number");
        this.maxCost = maxCost;
    }

    public FlatBuyer(String name, int rooms, double maxCost) {
        this.setName(name);
        this.setMaxCost(maxCost);
        this.setRooms(rooms);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean correspondsTo(Flat flat) {
        return flat.getCost() <= getMaxCost() && flat.getRooms() == getRooms();
    }

}
