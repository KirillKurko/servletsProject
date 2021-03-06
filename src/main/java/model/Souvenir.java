package model;

public class Souvenir {

    private int id;
    private String name;
    private String manufacturerEmail;
    private double price;
    private int manufacturerID;

    public Souvenir(int id, String name, String manufacturerEmail, double price, int manufacturerID) {
        this.id = id;
        this.name = name;
        this.manufacturerEmail = manufacturerEmail;
        this.price = price;
        this.manufacturerID = manufacturerID;
    }

    public Souvenir(String name, String manufacturerEmail, double price, int manufacturerID) {
        this.name = name;
        this.manufacturerEmail = manufacturerEmail;
        this.price = price;
        this.manufacturerID = manufacturerID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManufacturerEmail() {
        return manufacturerEmail;
    }

    public double getPrice() {
        return price;
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturerEmail(String manufacturerEmail) {
        this.manufacturerEmail = manufacturerEmail;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
    }
}
