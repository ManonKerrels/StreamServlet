package servlet.magasin;

import service.MagasinService;
import service.MagasinServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpClient;

@WebServlet("/magasin")
public class MagasinGetAllServlet extends HttpServlet {

    private final MagasinService service = MagasinServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", service.getAll());
        req.getRequestDispatcher("/jsp/magasin/magasins.jsp").forward(req,resp);
    }
}
