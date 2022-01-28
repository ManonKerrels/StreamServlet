package servlet;

import streams.exo.Produit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddProduitServlet", value = "/produit/add")
public class AddProduitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.print("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Ajout de produit</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "    <form action=\""+ req.getContextPath() +"/produit/add\" method=\"post\">\n" +
                "        <input type=\"number\" name=\"id\" placeholder=\"id\"><br>\n" +
                "        <input type=\"text\" name=\"nom\" placeholder=\"nom\"><br>\n" +
                "        <input type=\"text\" name=\"marque\" placeholder=\"marque\"><br>\n" +
                "        <input type=\"number\" name=\"prix\" placeholder=\"prix\"><br>\n" +
                "        <button type=\"submit\">envoyer</button>\n" +
                "    </form>\n" +
                "\n" +
                "</body>" +
                "</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("J'ai récupéré des infos");
    }
}