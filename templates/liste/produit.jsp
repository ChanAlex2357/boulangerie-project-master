<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Model.Produit"%>
<%@page import="Model.Categorie"%>

<%
    List<Produit> produit = (List<Produit>) request.getAttribute("liste_produit");
    List<Categorie> categorie = (List<Categorie>) request.getAttribute("liste_categorie");

%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Title -->
        <title> Liste Produit</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <jsp:include page="../layout/linkheader.jsp" />
    </head>

    <jsp:include page="../layout/navheader.jsp" />
    <body class="has-sidebar has-fixed-sidebar-and-header">

        <main class="main">
            <jsp:include page="../layout/navMenu.jsp" />

            <div class="content">
                <div class="py-4 px-3 px-md-4">

                    <div class="mb-3 mb-md-4 d-flex justify-content-between">
                        <div class="h6 mb-0">/Liste/Produit</div>
                    </div>

                    <div class="card mb-4">
                        <div class="card-body">
                            <form action="/boulangerie/PrepaProduit" method="GET" >
                                <input type="hidden" value="insertion" name=action>
                                <h4 class="card-title">Liste des produits <input type="submit" class="btn btn-danger offset-9" value="AJOUTER"> </h4>
                            </form>

                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th scope="col">Id Produit</th>
                                        <th scope="col">Nom</th>
                                        <th scope="col">Categorie</th>
                                        <th scope="col"></th>
                                        <th scope="col"></th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <%                                        
                                        for (int i = 0; i < produit.size(); i++) {
                                        Categorie cat = new Categorie();
                                        cat.getById(produit.get(i).getIdcategorie());
                                    %>
                                    <tr>
                                        <th scope="row"> <%=produit.get(i).getIdproduit()%> </th>
                                        <td><%=produit.get(i).getNom()%></td>
                                        <td><%=cat.getNom()%></td>

                                <form action="/boulangerie/CrudProduit" method="POST" >
                                    <input type="hidden" value="delete" name="action" >
                                    <input type="hidden" value="<%=produit.get(i).getIdproduit()%>" name="idproduit">
                                    <td> <input type="submit" class="btn btn-outline-danger" value="SUPPRIMER"></td>
                                </form>

                                <form action="/boulangerie/PrepaProduit" method="POST" >
                                    <input type="hidden" value="modif" name="action" >
                                    <input type="hidden" value="<%=produit.get(i).getIdproduit()%>" name="idproduit">
                                    <td> <input type="submit" class="btn btn-outline-primary-lighter" value="MODIFIER"> </td>
                                </form>

                                </tr>
                                <%
                                    }
                                %>
                                </tbody>
                            </table>

                        </div>
                    </div>

                </div>
                <jsp:include page="../layout/footer.jsp" />
            </div>
        </main>
        <jsp:include page="../layout/linkfooter.jsp" />
    </body>
</html>

