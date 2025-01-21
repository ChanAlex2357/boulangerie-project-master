<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bakery.model.Customer"%>
<%@page import="bakery.model.Product"%>

<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h3 mb-0">Insertion Vente</div>
    </div>
</div>
<div class="card-body">
    <div class="row">
        <form method="POST" action="/boulangerie/sales" class="offset-2 col-8">
            <div class="form-group">
                <label for="saleDate">Date de la vente</label>
                <input type="date" id="saleDate" name="date" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="saleCustomerId">Customer</label>
                <select id="saleCustomerId" name="CustomerId" class="form-control" required>
                    <option value="">Sélectionner le Customer</option>
                    <!-- Populate options dynamically -->
                    <% 
                        Customer[] Customers = (Customer[]) request.getAttribute("customers");
                        for (Customer Customer : Customers) {
                    %>
                        <option value="<%=Customer.getId()%>"><%=Customer.getName()%></option>
                    <% 
                        }
                    %>
                </select>
            </div>
            <div class="form-group">
                <label>Détails des produits</label>
                <table class="table" id="productTable">
                    <thead>
                        <tr>
                            <th>Produit</th>
                            <th>Quantité</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <select name="productId[]" class="form-control" required>
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
                            </td>
                            <td>
                                <input type="number" name="quantity[]" class="form-control" placeholder="Quantité" required min="1">
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger" onclick="removeRow(this)">Supprimer</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <button type="button" class="btn btn-primary" onclick="addRow()">Ajouter un produit</button>
            </div>
            <div class="form-group">
                <input type="hidden" name="action" value="insert">
                <input type="submit" class="btn btn-soft-success offset-4 mt-4 col-4" value="VALIDER">
            </div>
        </form>
    </div>
</div>

<script>
function addRow() {
    var table = document.getElementById("productTable").getElementsByTagName('tbody')[0];
    var newRow = table.rows[0].cloneNode(true);
    newRow.querySelectorAll('input, select').forEach(function(input) {
        input.value = '';
    });
    table.appendChild(newRow);
}

function removeRow(button) {
    var row = button.closest('tr');
    var table = document.getElementById("productTable").getElementsByTagName('tbody')[0];
    if (table.rows.length > 1) {
        row.remove();
    } else {
        alert("Vous devez avoir au moins un produit.");
    }
}
</script>
