<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bakery.model.ProductRecommendation"%>
<%@page import="bakery.model.Product"%>
<h1>Liste des Recommandations de Produit</h1>
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
            ProductRecommendation[] recommendations = (ProductRecommendation[]) request.getAttribute("recommendations");
            for (ProductRecommendation recommendation : recommendations) {
        %>
            
        <% } %>
    </tbody>
</table>
