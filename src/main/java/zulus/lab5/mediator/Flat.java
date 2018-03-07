package zulus.lab5.mediator;

/**
 * Created by zulus on 06.03.18
 */
public class Flat {
    private int _rooms;
    private double _cost;
    private FlatSeller _seller;

    public FlatSeller getSeller() {
        return _seller;
    }

    public void setSeller(FlatSeller seller) {
        if (seller == null) throw new IllegalArgumentException("Argument seller must be not-null value");
        this._seller = seller;
    }

    public int getRooms() {
        return _rooms;
    }

    public void setRooms(int rooms) {
        if (rooms <= 0) throw new IllegalArgumentException("Argument rooms must positive integer");
        this._rooms = rooms;
    }

    public double getCost() {
        return _cost;
    }

    public void setCost(double cost) {
        if (cost <= 0) throw new IllegalArgumentException("Argument cost must positive real number");
        this._cost = cost;
    }

    public Flat(int rooms, double cost, FlatSeller seller) {
        setCost(cost);
        setSeller(seller);
        setRooms(rooms);
    }

    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Flat) {
            Flat that = (Flat) other;
            result = that._seller.equals(this._seller) && Math.abs(that._cost - this._cost) < 1e-6;
        }
        return result;
    }

}
