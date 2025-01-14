<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Model.Categorie"%>

<%
    List<Categorie> categorie = (List<Categorie>) request.getAttribute("listecategorie");

%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Title -->
        <title> Liste Catégorie</title>
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
                        <div class="h6 mb-0">/Liste/Catégorie</div>
                    </div>

                    <div class="card mb-4">
                        <div class="card-body">
                            <form action="/boulangerie/insertion/categorie.jsp" method="POST" >
                                <h4 class="card-title">Liste des catégories <input type="submit" class="btn btn-danger offset-8" value="AJOUTER"> </h4>
                            </form>

                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th scope="col">Id Catégorie</th>
                                        <th scope="col">Nom</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%                                            
                                        for (int i = 0; i < categorie.size(); i++) {
                                    %>
                                    <tr>
                                        <th scope="row"> <%=categorie.get(i).getIdcategorie()%> </th>
                                        <td><%=categorie.get(i).getNom()%></td>
                                        <td >
                                            <form action="/boulangerie/CrudCategorie" method="POST" >
                                                <input type="hidden" value="delete" name="action" >
                                                <input type="hidden" value="<%=categorie.get(i).getIdcategorie()%>" name="idcategorie">
                                                <input type="submit" class="btn btn-outline-danger " value="SUPRRIMER">
                                            </form>
                                        </td>
                                        <td >
                                            <form action="/boulangerie/PrepaCategorie" method="POST" class='col-10'>
                                                <input type="hidden" name="action" value="modif">
                                                <input type="hidden" name="id" value="<%=categorie.get(i).getIdcategorie()%>">
                                                <input type="submit" class="btn btn-outline-primary-lighter " value="MODIFIER"> 
                                            </form>
                                        </td>
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

