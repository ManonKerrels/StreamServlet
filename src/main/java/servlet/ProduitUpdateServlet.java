package servlet;

import streams.exo.ProduitService;
import streams.exo.ProduitServiceImpl;
import streams.exo.exceptions.ProduitNotFoundException;
import streams.exo.models.ProduitForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProduitUpdateServlet", value = "/produit/update")
public class ProduitUpdateServlet extends HttpServlet {

    ProduitService service = ProduitServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.print("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Update form</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "    <form action=\""+ req.getContextPath() +"/produit/update\" method=\"post\">\n" +
                "        <input type=\"number\" name=\"id\" placeholder=\"id\"><br>\n" +
                "        <input type=\"text\" name=\"nom\" placeholder=\"nom\"><br>\n" +
                "        <input type=\"text\" name=\"prix\" placeholder=\"prix\"><br>\n" +
                "        <button type=\"submit\">envoyer</button>\n" +
                "    </form>\n" +
                "\n" +
                "</body>\n" +
                "</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String nom = req.getParameter("nom");
            double prix = Double.parseDouble(req.getParameter("prix"));

            service.update(id, new ProduitForm(nom, prix));

            resp.sendRedirect(req.getContextPath() + "/produit");
        }
        catch (NumberFormatException ex){
            resp.setStatus(400);
            out.print("id ou prix invalide");
        }
        catch(ProduitNotFoundException ex){
            resp.setStatus(404);
            out.print("produit introuvable");
        }
    }
}
