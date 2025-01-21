<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bakery.model.Product"%>

<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h3 mb-0">Insertion Recommandation de Produit</div>
    </div>
</div> 
<div class="card-body">
    <div class="row">
        <form method="POST" action="/boulangerie/productrecommendations" class="offset-2 col-8">
            <div class="form-group">
                <label for="productId">Produit</label>
                <select id="productId" name="productId" class="form-control" required>
                    <option value="">Sélectionner le produit</option>
                    <!-- Populate options dynamically -->
                    <% 
                        Product[] products = (Product[]) request.getAttribute("products");
                        for (Product product : products) {
                    %>
                        <option value="<%=product.getId()%>"><%=product.getName()%></option>
                    <% 
                        }
                    %>
                </select>
            </div>
            <div class="form-group">
                <label for="dateMin">Date Min</label>
                <input type="date" id="dateMin" name="dateMin" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="dateMax">Date Max</label>
                <input type="date" id="dateMax" name="dateMax" class="form-control" required>
            </div>
            <div class="form-group">
                <input type="hidden" name="action" value="insert">
                <input type="submit" class="btn btn-soft-success offset-4 mt-4 col-4" value="VALIDER">
            </div>
        </form>
    </div>
</div>
