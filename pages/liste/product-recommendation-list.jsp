<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bakery.model.ProductRecommendationCpl"%>
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
