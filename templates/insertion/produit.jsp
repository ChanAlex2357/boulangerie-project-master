<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Model.Categorie"%>

<%
    List<Categorie> categorie = (List<Categorie>) request.getAttribute("liste_categorie");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Title -->
        <title> Insertion Produit</title>
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
                        <div class="h3 mb-0">Insertion produit</div>
                    </div>
                </div> 
                <div class="card-body">
                    <div class="row">
                        <form method="POST" action="/boulangerie/CrudProduit" class="offset-2 col-8">
                            <div class="form-group">
                                <label for="simpleinput">Nom du produit</label>
                                <input type="text" id="simpleinput" name="nom" placeholder="entrer le nom du produit" class="form-control">
                            </div>
                            <div class="form-group mt-5" >
                                <label for="example-email">Catégorie</label>
                                <select id="example-email" name="idcategorie" class='form-control'>
                                    <%
                                        for(int i = 0 ; i < categorie.size(); i ++){
                                    %>
                                        <option value=" <%=categorie.get(i).getIdcategorie()%> " > <%=categorie.get(i).getNom()%> </option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="hidden" name="action" value="insert">
                                <input type="submit" class=" btn btn-soft-success offset-4 mt-4 col-4" value="VALIDER">
                            </div>
                        </form>
                    </div>
                </div>
            <jsp:include page="../layout/footer.jsp" />
        </div>
    </main>
    <jsp:include page="../layout/linkfooter.jsp" />
</body>
</html>

