package service;

import exceptions.MagasinNotFoundException;
import models.Magasin;
import models.Produit;

import java.util.ArrayList;
import java.util.List;

public class MagasinServiceImpl implements MagasinService {

    // region singleton
    private static MagasinServiceImpl _instance;
    public static MagasinServiceImpl getInstance() {
        return _instance == null ? _instance = new MagasinServiceImpl() : _instance;
    }
    private MagasinServiceImpl() {}
    // endregion

    private final List<Magasin> list = new ArrayList<>();
    private final ProduitServiceImpl produitService = ProduitServiceImpl.getInstance();

    @Override
    public List<Magasin> getAll() {
        return List.copyOf(list);
    }

    @Override
    public Magasin getOne(int id) {
        return list.stream()
                .filter(magasin -> magasin.getId() == id)
                .findFirst()
                .orElseThrow(() -> new MagasinNotFoundException(id));
    }

    @Override
    public boolean insert(Magasin toInsert) {
        boolean exists = list.stream()
                .noneMatch(magasin -> magasin.getId() == toInsert.getId());

        if( !exists )
            return list.add(toInsert);

        return false;
    }

    @Override
    public void addProduct(int magId, int prodId) {
        Produit toAdd = produitService.getOne(prodId);
        Magasin addIn = getOne(magId);

        if( addIn.getProduits().contains(toAdd) )
            addIn.getProduits().add(toAdd);
    }

    @Override
    public void removeProduct(int magId, int prodId) {
        Produit toRemove = produitService.getOne(prodId);
        Magasin removeFrom = getOne(magId);
        removeFrom.getProduits().remove(toRemove);
    }
}
