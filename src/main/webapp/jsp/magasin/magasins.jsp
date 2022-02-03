<%@ page import="java.util.List" %>
<%@ page import="models.Magasin" %>
<%@ include file="/WEB-INF/jsp/head.jsp" %>
<% List<Magasin> list = (List<Magasin>) request.getAttribute("list"); %>


    <h1>La liste des magasins</h1>
    
    <ul>
        <% for(Magasin m : list) { %>
        <li><a href="<%= request.getContextPath() %>/magasin/detail?id=<%=m.getId()%>"><%=m.getNom()%></a></li>
        <% } %>
    </ul>

<%@ include file="/WEB-INF/jsp/foot.jsp" %>
