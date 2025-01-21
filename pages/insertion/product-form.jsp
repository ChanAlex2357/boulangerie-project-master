<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bakery.model.ProductType"%>
<%@page import="bakery.model.Unit"%>

<%
    Unit[] units = (Unit[]) request.getAttribute("units");
    ProductType[] productTypes = (ProductType[]) request.getAttribute("productTypes");
%>
<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h3 mb-0">Insertion Produit</div>
    </div>
</div> 
<div class="card-body">
    <div class="row">
        <form method="POST" action="/boulangerie/products" class="offset-2 col-8">
            <div class="form-group">
                <label for="productName">Nom</label>
                <input type="text" id="productName" name="name" placeholder="Entrer le nom du produit" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="productDescription">Description</label>
                <input type="text" id="productDescription" name="description" placeholder="Entrer la description du produit" class="form-control">
            </div>
            <div class="form-group">
                <label for="productSalePrice">Prix de vente</label>
                <input type="text" id="productSalePrice" name="salePrice" placeholder="Entrer le prix de vente" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="productTypeId">Type de produit</label>
                <select id="productTypeId" name="productTypeId" class="form-control" required>
                    <option value="">Sélectionner un type de produit</option>
                    <% for (ProductType productType : productTypes) { %>
                        <option value="<%= productType.getId() %>"><%= productType.getValue() %></option>
                    <% } %>
                </select>
            </div>
            <div class="form-group"></div>
                <label for="productUnitId">Unité</label>
                <select id="productUnitId" name="unitId" class="form-control" required>
                    <option value="">Sélectionner une unité</option>
                    <% for (Unit unit : units) { %>
                        <option value="<%= unit.getId() %>"><%= unit.getValue() %></option>
                    <% } %>
                </select>
            </div>
            
            <div class="form-group">
                <input type="hidden" name="action" value="insert">
                <input type="submit" class="btn btn-soft-success offset-4 mt-4 col-4" value="VALIDER">
            </div>
        </form>
    </div>
</div>
