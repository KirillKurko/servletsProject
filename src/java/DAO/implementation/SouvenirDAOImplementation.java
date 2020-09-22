package java.DAO.implementation;

import java.DAO.interfaces.SouvenirDAO;
import java.model.Souvenir;
import java.util.List;

public class SouvenirDAOImplementation implements SouvenirDAO {

    //TODO implement all the methods

    @Override
    public void insertSouvenir(Souvenir souvenir) {

    }

    @Override
    public boolean updateSouvenir(Souvenir souvenir) {
        return false;
    }

    @Override
    public Souvenir selectSouvenir(int id) {
        return null;
    }

    @Override
    public List<Souvenir> selectAllSouvenirs() {
        return null;
    }

    @Override
    public List<Souvenir> selectSouvenirsByCountry() {
        return null;
    }

    @Override
    public List<Souvenir> selectSouvenirsByManufacturerName(String manufacturerName) {
        return null;
    }

    @Override
    public List<Souvenir> selectSouvenirsByPrice(double price) {
        return null;
    }

    @Override
    public boolean deleteSouvenir(int id) {
        return false;
    }
}
