package models;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Magasin {

    private int id;
    private String nom;
    private String rue;
    private String ville;
    private int codePostal;
    private int numero;
    private int superficie;
    private List<Produit> produits = new ArrayList<>();

}
