<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Model.Prix"%>
<%@page import="Model.Produit"%>
<%@page import="Model.Vente"%>
<%@page import="Model.Categorie"%>
<%@page import="Model.Criterevente"%>


<%
    List<Prix> prix = (List<Prix>) request.getAttribute("listeprix");
    List<Vente> vente = (List<Vente>) request.getAttribute("listevente");
    List<Categorie> categorie = (List<Categorie>) request.getAttribute("listecategorie");
    List<Produit> produit = (List<Produit>) request.getAttribute("liste_produit");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Title -->
        <title> Liste Vente</title>
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
                        <div class="h6 mb-0">/Liste/Vente</div>
                    </div>
                    <form action="/boulangerie/PrepaVente"  method="POST">
                        <div class="mb-md-4 d-flex justify-content-between mt-4">
                            <div class="h4 mb-0 mt-2">Recherche</div>
                            <input type="hidden" name="action" value ="critere">
                        </div>
                        
                        <div class="row">
                            <div class="col-3">
                                <p class="h5"> Par produit  </P>
                                <select name="idproduit" class="form-control mt-5">
                                    <option value="0" class="active"> Aucun</option>
                                    <%
                                        for (int i = 0; i < produit.size(); i++) {
                                    %>
                                        <option value="<%=produit.get(i).getIdproduit()%>"> <%=produit.get(i).getNom()%> </option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                                
                            <div class="col-3" >
                                <p class="h5"> Entre deux date  </P>
                                    <div>
                                        <input type="date" class="form-control" placeholder="Minimum" name="datefin">
                                    </div>
                                    <div class="mt-1">
                                        <input type="date" class="form-control" placeholder="Maximum" name="datedepart">
                                    </div>
                            </div>
                                
                            <div class="col-3">
                                <p class="h5"> Par quantité </P>
                                    <div>
                                        <input type="number" class="form-control" placeholder="Minimum" name="qttmin">
                                    </div>
                                    <div class="mt-1">
                                        <input type="number" class="form-control" placeholder="Maximum" name="qttmax">
                                    </div>
                            </div>
                                
                            <div class="col-2 mt-9">
                                <input type="submit" class=" form-control btn btn-outline-darker" value="valider">
                            </div>
                        </div>
                            
                    </form>

                    <div class="card mb-4 mt-3">
                        <div class="card-body">
                            <form action="/boulangerie/PrepaVente" method="GET" >
                                <input type="hidden" value="insertion" name=action>
                                <h4 class="card-title">Liste des Ventes <input type="submit" class="btn btn-danger offset-9" value="AJOUTER"> </h4>
                            </form>

                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th scope="col">Id Vente</th>
                                            <th scope="col">Produit</th>
                                            <th scope="col">Catégorie</th>
                                            <th scope="col">Quantite</th>
                                            <th scope="col">Date</th>
                                            <th scope="col"></th>
                                            <th scope="col"></th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%  
                                            if(request.getAttribute("liste_critere") == null){
                                                for (int i = 0; i < vente.size(); i++) {
                                                    Produit prd = new Produit();
                                                    prd.getById(vente.get(i).getIdproduit());
                                                    Categorie categ = new Categorie();
                                                    categ.getById(prd.getIdcategorie());
                                        %>
                                        <tr>
                                            <th scope="row"> <%=vente.get(i).getIdvente()%> </th>
                                            <th scope="row"> <%=prd.getNom()%> </th>
                                            <th scope="row"> <%=categ.getNom()%> </th>
                                            <th scope="row"> <%=vente.get(i).getQuantite()%> </th>
                                            <th scope="row"> <%=vente.get(i).getDatevente()%> </th>

                                            <form action="/boulangerie/CrudVente" method="POST" >
                                                <input type="hidden" value="delete" name="action" >
                                                <input type="hidden" value="<%=vente.get(i).getIdvente()%>" name="idvente">
                                                <td> <input type="submit" class="btn btn-outline-danger" value="SUPPRIMER"></td>
                                            <form>
                                            <form action="/boulangerie/PrepaVente" method="POST" >
                                                <input type="hidden" value="<%=vente.get(i).getIdvente()%>">
                                                <td> <input type="submit" class="btn btn-outline-primary-lighter" value="MODIFIER"> </td>
                                            <form>

                                        </tr>
                                        <%
                                                }
                                            }
                                            else{
                                                List<Vente> critere = (List<Vente>)request.getAttribute("liste_critere");
                                                if(critere != null){
                                                for (int i = 0; i < critere.size(); i++) {
                                                    Produit prd = new Produit();
                                                    prd.getById(critere.get(i).getIdproduit());
                                                    Categorie categ = new Categorie();
                                                    categ.getById(prd.getIdcategorie());
                                        %>
                                        <tr>
                                            <th scope="row"> <%=critere.get(i).getIdvente()%> </th>
                                            <th scope="row"> <%=prd.getNom()%> </th>
                                            <th scope="row"> <%=categ.getNom()%> </th>
                                            <th scope="row"> <%=critere.get(i).getQuantite()%> </th>
                                            <th scope="row"> <%=critere.get(i).getDatevente()%> </th>

                                            <form action="/CrudVacance/CrudVente" method="POST" >
                                                <input type="hidden" value="delete" name="action" >
                                                <input type="hidden" value="<%=critere.get(i).getIdvente()%>" name="idvente">
                                                <td> <input type="submit" class="btn btn-outline-danger" value="SUPPRIMER"></td>
                                            <form>
                                            <form action="/PrepaProduit" method="POST" >
                                                <input type="hidden" value="<%=critere.get(i).getIdvente()%>">
                                                <td> <input type="submit" class="btn btn-outline-primary-lighter" value="MODIFIER"> </td>
                                            <form>

                                        </tr>
                                        <%
                                                }
                                            }
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

