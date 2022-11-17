package carshop.interf;

public interface Customer {
    public void getCarsPrice();

    void getCarsColors();

    public double getCarPrice(int id);
    public String getCarColor(int id);
    public void purchaseCar(int id);

}