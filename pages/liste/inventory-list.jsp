<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bakery.model.Inventory"%>

<%
    Inventory[] inventories = (Inventory[]) request.getAttribute("inventories");
%>
<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h6 mb-0">/Liste/Inventory</div>
    </div>

    <div class="card mb-4">
        <div class="card-body">
            <h4 class="card-title">Liste des inventaires</h4>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Id Inventory</th>
                        <th scope="col">Date d'inventaire</th>
                        <th scope="col">Quantité théorique</th>
                        <th scope="col">Quantité réelle</th>
                        <th scope="col">Id Produit</th>
                    </tr>
                </thead>
                <tbody>
                    <%                                            
                        for (int i = 0; i < inventories.length; i++) {
                    %>
                    <tr>
                        <th scope="row"> <%=inventories[i].getId()%> </th>
                        <td><%=inventories[i].getInventoryDate()%></td>
                        <td><%=inventories[i].getTheoreticalQuantity()%></td>
                        <td><%=inventories[i].getActualQuantity()%></td>
                        <td><%=inventories[i].getProductId()%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>
