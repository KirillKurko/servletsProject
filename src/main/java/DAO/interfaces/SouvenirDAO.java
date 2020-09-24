package DAO.interfaces;

import model.Souvenir;

import java.util.List;

public interface SouvenirDAO {

    void insertSouvenir(Souvenir souvenir);

    boolean updateSouvenir(Souvenir souvenir);

    Souvenir selectSouvenir(int id);

    List<Souvenir> selectAllSouvenirs();

    List<Souvenir> selectSouvenirsByCountry();

    List<Souvenir> selectSouvenirsByManufacturerName(String manufacturerName);

    List<Souvenir> selectSouvenirsByPrice(double price);

    boolean deleteSouvenir(int id);
}