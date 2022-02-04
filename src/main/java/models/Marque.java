package models;

public class Marque {

    private int id;
    private String nom;
    private String stockName;


    public Marque(int id, String nom, String stockName) {
        this.id = id;
        this.nom = nom;
        this.stockName = stockName;
    }

    public Marque() {

    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public String getStockName() {return stockName;}
    public void setStockName(String stockName) {this.stockName = stockName;}
}
