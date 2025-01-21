<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bakery.model.Ingredient"%>

<%
    Ingredient[] ingredients = (Ingredient[]) request.getAttribute("ingredients");
%>
<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h6 mb-0">/Liste/Ingredient</div>
    </div>

    <div class="card mb-4">
        <div class="card-body">
            <h4 class="card-title">Liste des ingrédients</h4>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Id Ingredient</th>
                        <th scope="col">Nom</th>
                        <th scope="col">Description</th>
                        <th scope="col">Prix d'achat</th>
                        <th scope="col">Id Unité</th>
                        <th scope="col">Id Type d'ingrédient</th>
                        <th scope="col">Id Nature Type</th>
                    </tr>
                </thead>
                <tbody>
                    <%                                            
                        for (int i = 0; i < ingredients.length; i++) {
                    %>
                    <tr>
                        <th scope="row"> <%=ingredients[i].getId()%> </th>
                        <td><%=ingredients[i].getName()%></td>
                        <td><%=ingredients[i].getDescription()%></td>
                        <td><%=ingredients[i].getPurchasePrice()%></td>
                        <td><%=ingredients[i].getUnitId()%></td>
                        <td><%=ingredients[i].getIngredientTypeId()%></td>
                        <td><%=ingredients[i].getNatureTypeId()%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>
