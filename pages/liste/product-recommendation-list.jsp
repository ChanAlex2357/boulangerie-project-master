<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bakery.model.ProductRecommendationCpl"%>
<%@page import="bakery.model.Product"%>
<%@page import="bakery.model.ProductType"%>

<%
    ProductType[] productTypes = (ProductType[]) request.getAttribute("types");
%>
<h1>Liste des Recommandations de Produit</h1>
<div class="container">

    <form action="/boulangerie/productrecommendations" method="get">
        <div class="form-inline">
            <div class="form-group mx-3 gap-2">
                <label for="">Date Min</label>
                <input type="date" name="dmin" class="form-control" id="">
            </div>
            <div class="form-group mx-3 gap-2">
                <label for="">Date Max</label>
                <input type="date" name="dmax" class="form-control" id="">
            </div>
        </div>
    
        <!-- <div class="form-group">
            <label for="productTypeId">Type de produit</label>
            <select id="productTypeId" name="productTypeId" class="form-control" required>
                <option value="">Sélectionner un type de produit</option>
                <% for (ProductType productType : productTypes) { %>
                    <option value="<%= productType.getId() %>"><%= productType.getValue() %></option>
                    <% } %>
            </select>
        </div> -->
        <div class="mt-3">
            <input type="submit" class="btn btn-primary" value="Filter">
        </div>
    </form>
</div>
<table class="table">
    <thead>
        <tr>
            <th>ID</th>
            <th>Produit</th>
            <th>Date Min</th>
            <th>Date Max</th>
        </tr>
    </thead>
    <tbody>
        <!-- Populate table rows dynamically -->
        <% 
        ProductRecommendationCpl[] recommendations = (ProductRecommendationCpl[]) request.getAttribute("recommendations");
            for (ProductRecommendationCpl recommendation : recommendations) { %>
                <tr>
                    <td><%=recommendation.getRecommendationId()%></td>
                    <td><%=recommendation.getProductName()%></td>
                    <td><%=recommendation.getRecommendationDateMin()%></td>
                    <td><%=recommendation.getRecommendationDateMax()%></td>
                </tr>
        <% } %>
    </tbody>
</table>
