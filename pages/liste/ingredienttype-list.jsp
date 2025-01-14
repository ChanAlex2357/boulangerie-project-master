<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bakery.model.IngredientType"%>

<%
    IngredientType[] ingredientTypes = (IngredientType[]) request.getAttribute("ingredientTypes");
%>
<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h6 mb-0">/Liste/IngredientType</div>
    </div>

    <div class="card mb-4">
        <div class="card-body">
            <h4 class="card-title">Liste des types d'ingrédients</h4>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Id IngredientType</th>
                        <th scope="col">Value</th>
                        <th scope="col">Description</th>
                    </tr>
                </thead>
                <tbody>
                    <%                                            
                        for (int i = 0; i < ingredientTypes.length; i++) {
                    %>
                    <tr>
                        <th scope="row"> <%=ingredientTypes[i].getId()%> </th>
                        <td><%=ingredientTypes[i].getValue()%></td>
                        <td><%=ingredientTypes[i].getDescription()%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>
