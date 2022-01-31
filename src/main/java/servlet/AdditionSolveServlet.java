package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addition/solve")
public class AdditionSolveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int m1 = Integer.parseInt( req.getParameter("m1") );
        int m2 = Integer.parseInt( req.getParameter("m2") );
        String saveIn = req.getParameter("save-in");

        HttpSession session = req.getSession();

        switch( saveIn ){
            case "session" :
                session.setAttribute("rslt", m1+m2);
                break;
            case "request" :
                req.setAttribute("rslt", m1+m2);
                break;
            default:
                resp.sendError(400);
        }

        req.getRequestDispatcher("/jsp/attribute/rslt.jsp").forward(req, resp);
        //resp.sendRedirect(req.getContextPath()+"/jsp/attribute/rslt.jsp");

    }
}
