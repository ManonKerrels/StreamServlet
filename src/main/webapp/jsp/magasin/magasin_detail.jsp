<%@ page import="models.Magasin" %>
<%@ page import="models.Produit" %>

<% Magasin magasin = (Magasin) request.getAttribute("magasin"); %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>

    <dl>
        <dt>id</dt>
        <dd><%=magasin.getId()%></dd>
        <dt>nom</dt>
        <dd><%=magasin.getNom()%></dd>
        <dt>adresse</dt>
        <dd><%=magasin.getNumero()%> <%=magasin.getRue()%> <%=magasin.getCodePostal()%> <%=magasin.getVille()%></dd>
        <dt>superficie</dt>
        <dd><%=magasin.getSuperficie()%></dd>
        <dt>produits disponibles</dt>
        <dd>
            <ul>
                <% for(Produit p : magasin.getProduits()){ %>
                <li>
                    <a href=""><%=p.getNom()%></a>
                    <a href=""><button>retirer</button></a>
                </li>
                <% } %>
            </ul>
        </dd>
    </dl>

</body>
</html>
