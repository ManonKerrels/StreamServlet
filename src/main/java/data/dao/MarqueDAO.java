package data.dao;

import data.ConnectionFactory;
import models.Marque;

import java.sql.*;

public class MarqueDAO {


    public Marque insert(Marque toInsert){

        String query = "INSERT INTO marque(name, stockname) VALUES ( ?, ? )";
        String getId = "SELECT * FROM maque WHERE id = last_insert_id();"; //manière de récupérer tout ce qui est fait suite à un auto-increment

        try(
                Connection co = ConnectionFactory.getConnection();
                PreparedStatement statement = co.prepareStatement(query);
                Statement stmtGet = co.createStatement();

                ) {

            statement.setString(1, toInsert.getNom());
            statement.setString(2, toInsert.getStockName());
            int lignesAffected = statement.executeUpdate(); //permet de connaître le nombre de lignes affectées

            if (lignesAffected >= 1){
                try (ResultSet resultSet = stmtGet.executeQuery(getId)){ //si l'insertion s'est ien produite, on crée le resultset qui vient récupérer les données

                    if (resultSet.next()){
                        Marque m = new Marque();
                        m.setId(resultSet.getInt(1));
                        m.setNom(resultSet.getString(2));
                        m.setStockName(resultSet.getString(3));
                        return m;
                    }

                } //pas besoin de mettre un catch, car l'exception est gérée juste après avec l'autre catch
            }
        } catch (SQLException | ClassNotFoundException ignored) {}

        return null;
    }

}
