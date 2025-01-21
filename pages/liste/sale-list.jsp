<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bakery.model.Sale"%>
<%
    Sale[] sales = (Sale[]) request.getAttribute("sales");
%>
<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h6 mb-0">/Liste/Ventes</div>
    </div>

    <div class="card mb-4">
        <div class="card-body">
            <form action="/boulangerie/saleform" method="GET">
                <h4 class="card-title">Liste des ventes<input type="submit" class="btn btn-danger offset-8" value="AJOUTER"> </h4>
            </form>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Date vente</th>
                        <th scope="col">Montant</th>
                        <th scope="col">Client</th>
                        <th scope="col">Details</th>
                    </tr>
                </thead>
                <tbody>
                    <%                                            
                        for (int i = 0; i < sales.length; i++) {
                    %>
                    <tr>
                        <th scope="row"> <%=sales[i].getId()%> </th>
                        <td><%=sales[i].getSaleDate()%></td>
                        <td><%=sales[i].getAmount()%></td>
                        <td><%=sales[i].getCustomerId()%></td>
                        <td><a href="/boulangerie/saledetails?saleId=<%=sales[i].getId()%>">Voir les details</a></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>