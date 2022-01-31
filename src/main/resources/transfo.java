// du texte html:

class JspServlet {

    void service(req,resp){
        PrintWriter out = ...;
        out.print("... le html ...");
    }

}

// la directive d'expression
// <%= 1+1 %>

class JspServlet {

    void service(req,resp){
        PrintWriter out = ...;
        out.print( 1+1 );
    }

}

// directive de scriptlet
//<p> okok </p>
//<%
//        for(int i = 0; i<5 ; i++)
//        {
//        out.println("salut")
//        }
//%>
class JspServlet {

    void service(req,resp){
        PrintWriter out = ...;
        out.println("<p> okok </p>");
        for(int i = 0; i<5 ; i++)
        {
            out.println("salut");
        }
    }

}

<% for(int i = 0; i<5 ; i++)%> ok <% { %>
<p> <%= i %> </p>
<%}%>

class JspServlet {

    void service(req, resp) {
        PrintWriter out = ...;
        for (int i = 0; i < 5; i++)
            out.println("ok");
        {
            out.print("<p>");
            out.print(i);
            out.print("</p>");
        }
    }
}
//    <%! int a = 5; %>

class JspServlet {

    int a = 5;

    void service(req, resp) {
        PrintWriter out = ...;

    }
}