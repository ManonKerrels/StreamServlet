package service;

import models.Magasin;

import java.util.List;

public interface MagasinService {

    List<Magasin> getAll();
    Magasin getOne(int id);

    boolean insert(Magasin toInsert);

    void addProduct( int magId, int prodId );
    void removeProduct( int magId, int prodId );

}
