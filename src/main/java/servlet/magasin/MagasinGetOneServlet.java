package servlet.magasin;

import exceptions.MagasinNotFoundException;
import models.Magasin;
import service.MagasinService;
import service.MagasinServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/magasin/detail")
public class MagasinGetOneServlet extends HttpServlet {

    private final MagasinService service = MagasinServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt( req.getParameter("id") );
            req.setAttribute("magasin", service.getOne(id));
            req.getRequestDispatcher("/").forward(req,resp);
        }
        catch (NumberFormatException ex){

        }
        catch (MagasinNotFoundException ex){

        }
    }
}
