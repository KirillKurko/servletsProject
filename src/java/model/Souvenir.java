package java.model;

import java.util.Calendar;

public class Souvenir {

    private int id;
    private String name;
    private String manufacturerEmail;
    private Calendar manufacturingDate;
    private double price;

    public Souvenir(int id, String name, String manufacturerEmail, Calendar manufacturingDate, double price) {
        this.id = id;
        this.name = name;
        this.manufacturerEmail = manufacturerEmail;
        this.manufacturingDate = manufacturingDate;
        this.price = price;
    }

    public Souvenir(String name, String manufacturerEmail, Calendar manufacturingDate, double price) {
        this.name = name;
        this.manufacturerEmail = manufacturerEmail;
        this.manufacturingDate = manufacturingDate;
        this.price = price;
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

    public Calendar getManufacturingDate() {
        return manufacturingDate;
    }

    public double getPrice() {
        return price;
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

    public void setManufacturingDate(Calendar manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
