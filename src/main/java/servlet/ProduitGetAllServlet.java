package servlet;

import streams.exo.Produit;
import streams.exo.ProduitService;
import streams.exo.ProduitServiceImpl;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProduitGetAllServlet", value = "/produit")
public class ProduitGetAllServlet extends HttpServlet {

    ProduitService service = new ProduitServiceImpl();

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
            """
            </ul>
                            
            </body>
            </html>
            """
        );


    }
}
