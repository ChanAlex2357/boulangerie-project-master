<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Model.Prix"%>
<%@page import="Model.Produit"%>


<%
    List<Prix> prix = (List<Prix>) request.getAttribute("listeprix");
    List<Produit> produit = (List<Produit>) request.getAttribute("liste_produit");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Title -->
        <title> Liste Prix</title>
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
                        <div class="h6 mb-0">/Liste/Prix</div>
                    </div>

                    <div class="card mb-4">
                        <div class="card-body">
                            <form action="/boulangerie/PrepaPrix" method="GET" >
                                <input type="hidden" value="insertion" name=action>
                                <h4 class="card-title">Listes Des Prix <input type="submit" class="btn btn-danger offset-9" value="AJOUTER"> </h4>
                            </form>

                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th scope="col">Id Prix</th>
                                            <th scope="col">Produit</th>
                                            <th scope="col">Montant</th>
                                            <th scope="col">Date</th>
                                            <th scope="col"></th>
                                            <th scope="col"></th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%                                        
                                            for (int i = 0; i < prix.size(); i++) {
                                            Produit pd = new Produit();
                                            pd.getById(prix.get(i).getIdproduit());
                                        %>
                                        <tr>
                                            <th scope="row"> <%=prix.get(i).getIdprix()%> </th>
                                            <td><%=pd.getNom()%></td>
                                            <td><%=prix.get(i).getMontant()%></td>
                                            <th> <%=prix.get(i).getDateprix()%> </th>

                                            <form action="/boulangerie/CrudPrix" method="POST" >
                                                <input type="hidden" value="delete" name="action" >
                                                <input type="hidden" name="idprix" value="<%=prix.get(i).getIdprix()%>">
                                                <td> <input type="submit" class="btn btn-outline-danger" value="SUPPRIMER"></td>
                                            <form>
                                            <form action="/boulangerie/PrepaPrix" method="POST" >
                                                <input type="hidden" value="modif" name="action" >
                                                <input type="hidden" name="id" value="<%=prix.get(i).getIdprix()%>">
                                                <td> <input type="submit" class="btn btn-outline-primary-lighter" value="MODIFIER"> </td>
                                            <form>

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

