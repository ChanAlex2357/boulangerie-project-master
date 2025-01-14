<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bakery.model.Product"%>

<%
    Product[] products = (Product[]) request.getAttribute("products");
%>
<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h6 mb-0">/Liste/Product</div>
    </div>

    <div class="card mb-4">
        <div class="card-body">
            <form action="/boulangerie/productform" method="GET">
                <h4 class="card-title">Liste des produits <input type="submit" class="btn btn-danger offset-8" value="AJOUTER"> </h4>
            </form>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Id Product</th>
                        <th scope="col">Nom</th>
                        <th scope="col">Description</th>
                        <th scope="col">Prix de vente</th>
                        <th scope="col">Unité</th>
                        <th scope="col">Type de produit</th>
                        <th scope="colgroup" colspan="2">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%                                            
                        for (int i = 0; i < products.length; i++) {
                    %>
                    <tr>
                        <th scope="row"> <%=products[i].getId()%> </th>
                        <td><%=products[i].getName()%></td>
                        <td><%=products[i].getDescription()%></td>
                        <td><%=products[i].getSalePrice()%></td>
                        <td><%=products[i].getUnitId()%></td>
                        <td><%=products[i].getProductTypeId()%></td>
                        <td>
                            <form action="/boulangerie/products" method="GET">
                                <input type="hidden" value="delete" name="action">
                                <input type="hidden" value="<%=products[i].getId()%>" name="idproducts">
                                <input type="submit" class="btn btn-outline-danger" value="SUPPRIMER">
                            </form>
                        </td>
                        <td>
                            <form action="/boulangerie/products" method="POST" class='col-10'>
                                <input type="hidden" name="action" value="modif">
                                <input type="hidden" name="id" value="<%=products[i].getId()%>">
                                <input type="submit" class="btn btn-outline-primary-lighter" value="MODIFIER"> 
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>
