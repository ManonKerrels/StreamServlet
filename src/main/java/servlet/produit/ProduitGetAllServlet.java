package servlet.produit;

import models.Produit;
import service.ProduitService;
import service.ProduitServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProduitGetAllServlet", value = "/produit")
public class ProduitGetAllServlet extends HttpServlet {

    private final ProduitService service = ProduitServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Produit> list = service.getAll();
        PrintWriter out = resp.getWriter();
        out.println(
                """
                <!doctype html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Get all produit</title>
                </head>
                <body>
                                
                    <h1>Liste des produits</h1>
                                
                    <ul>
                """);

        list.forEach(produit -> {
            out.print("<li>");
            out.print(produit.getNom());
            out.print(' ');
            out.print(produit.getMarque());
            out.print(' ');
            out.print(produit.getPrix());
            out.println("$</li>");
        });

        out.print(
            
            "</ul>"+
            "<a href=\""+req.getContextPath()+"/produit/add\">vers ajout</a><br>" +
            "<a href=\""+req.getContextPath()+"/produit/update\">vers modif</a>" +
                            
            "</body>"+
            "</html>"
        );


    }
}
