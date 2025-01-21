<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bakery.model.IngredientType"%>
<%@page import="bakery.model.NatureType"%>
<%@page import="bakery.model.Unit"%>

<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h3 mb-0">Insertion Ingrédient</div>
    </div>
</div> 
<div class="card-body">
    <div class="row">
        <form method="POST" action="/boulangerie/ingredients" class="offset-2 col-8">
            <div class="form-group">
                <label for="ingredientName">Nom</label>
                <input type="text" id="ingredientName" name="name" placeholder="Entrer le nom de l'ingrédient" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="ingredientDescription">Description</label>
                <input type="text" id="ingredientDescription" name="description" placeholder="Entrer la description de l'ingrédient" class="form-control">
            </div>
            <div class="form-group">
                <label for="ingredientPurchasePrice">Prix d'achat</label>
                <input type="text" id="ingredientPurchasePrice" name="purchasePrice" placeholder="Entrer le prix d'achat" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="ingredientUnitId">Unité</label>
                <select id="ingredientUnitId" name="unitId" class="form-control" required>
                    <option value="">Sélectionner l'unité</option>
                    <!-- Populate options dynamically -->
                    <% 
                        Unit[] units = (Unit[]) request.getAttribute("units");
                        for (Unit unit : units) {
                    %>
                        <option value="<%=unit.getId()%>"><%=unit.getValue()%></option>
                    <% 
                        }
                    %>
                </select>
            </div>
            <div class="form-group">
                <label for="ingredientTypeId">Type d'ingrédient</label>
                <select id="ingredientTypeId" name="ingredientTypeId" class="form-control" required>
                    <option value="">Sélectionner le type d'ingrédient</option>
                    <!-- Populate options dynamically -->
                    <% 
                        IngredientType[] ingredientTypes = (IngredientType[]) request.getAttribute("ingredientTypes");
                        for (IngredientType ingredientType : ingredientTypes) {
                    %>
                        <option value="<%=ingredientType.getId()%>"><%=ingredientType.getValue()%></option>
                    <% 
                        }
                    %>
                </select>
            </div>
            <div class="form-group">
                <label for="ingredientTypeNatureTypeId">Nature Type</label>
                <select id="ingredientTypeNatureTypeId" name="natureTypeId" class="form-control" required>
                    <option value="">Sélectionner le type de nature</option>
                    <!-- Populate options dynamically -->
                    <% 
                        NatureType[] natureTypes = (NatureType[]) request.getAttribute("natureTypes");
                        for (NatureType natureType : natureTypes) {
                    %>
                        <option value="<%=natureType.getId()%>"><%=natureType.getValue()%></option>
                    <% 
                        }
                    %>
                </select>
            </div>
            <div class="form-group">
                <input type="hidden" name="action" value="insert">
                <input type="submit" class="btn btn-soft-success offset-4 mt-4 col-4" value="VALIDER">
            </div>
        </form>
    </div>
</div>
