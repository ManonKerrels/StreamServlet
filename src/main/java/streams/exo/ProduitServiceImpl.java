package streams.exo;

import streams.exo.exceptions.NoProduitException;
import streams.exo.exceptions.ProduitNotFoundException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProduitServiceImpl implements ProduitService{

    private final List<Produit> liste = new ArrayList<>();

    public ProduitServiceImpl() {
        liste.add(new Produit(1, "patate", "les bons légumes", 2.5));
        liste.add(new Produit(2, "tomate", "les bons légumes", .99));
    }

    @Override
    public List<Produit> getAll() {
        return List.copyOf(liste);
    }

    @Override
    public Produit getOne(int id) {
        Optional<Produit> prod = liste.stream()
                .filter(produit -> produit.getId() == id)
                .findFirst();

        return prod.orElseThrow( ProduitNotFoundException::new );
    }

    @Override
    public boolean insert(Produit toAdd) {
        boolean rslt = false;
        if( toAdd != null && liste.stream().noneMatch(produit -> produit.getId() == toAdd.getId()))
        {
            liste.add(toAdd);
            rslt = true;
        }
        return rslt;
    }

    @Override
    public Produit delete(int id) {
        Produit toDelete = getOne(id);
        liste.remove(toDelete);
        return toDelete;
    }

    @Override
    public List<Produit> getAllSorted(Comparator<Produit> comparator) {
        return liste.stream()
                .sorted( comparator )
                .toList();
    }

    @Override
    public Produit getCheapest() {
        return liste.stream()
                .min( Comparator.comparingDouble( Produit::getPrix ) )
                .orElseThrow( NoProduitException::new );
    }

    @Override
    public Produit getMostExpensive() {
        return liste.stream()
                .max( Comparator.comparingDouble(Produit::getPrix) )
                .orElseThrow( NoProduitException::new );
    }

    @Override
    public List<Produit> getAllByBrand(String brand) {
        return liste.stream()
                .filter( produit -> produit.getMarque().equals(brand) )
                .collect(Collectors.toList());
    }
}
