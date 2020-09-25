package DAO.interfaces;

import model.Manufacturer;

import java.util.Calendar;
import java.util.List;

public interface ManufacturerDAO {

    void insertManufacturer(Manufacturer manufacturer);

    boolean updateManufacturer(Manufacturer manufacturer);

    Manufacturer selectManufacturer(int id);

    List<Manufacturer> selectAllManufacturers();

    boolean deleteManufacturer(int id);

    void deleteManufacturerSouvenirs(int id);
}
