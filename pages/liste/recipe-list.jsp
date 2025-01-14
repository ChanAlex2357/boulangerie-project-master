<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bakery.model.Recipe"%>
<%@page import="bakery.model.NatureType"%>
<%@page import="bakery.model.Product"%>

<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h6 mb-0">/Liste/Recipe</div>
    </div>
    
    <div class="card mb-4">
        <div class="card-body">
            <form action="/boulangerie/recipeform" method="GET">
                <h4 class="card-title">Liste des recettes<input type="submit" class="btn btn-danger offset-8" value="AJOUTER"> </h4>
            </form>
            <h1>Liste des Recettes</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Coût de la recette</th>
                        <th>Type de recette</th>
                        <th>Produit</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Populate table rows dynamically -->
                    <% 
                        Recipe[] recipes = (Recipe[]) request.getAttribute("recipes");
                        for (Recipe recipe : recipes) {
                    %>
                        <tr>
                            <td><%= recipe.getId() %></td>
                            <td><%= recipe.getName() %></td>
                            <td><%= recipe.getRecipeCost() %></td>
                            <td><%= recipe.getRecipeTypeId() %></td>
                            <td><%= recipe.getProductId() %></td>
                        </tr>
                    <% 
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>
