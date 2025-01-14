<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bakery.model.ProductType"%>

<%
    ProductType[] productTypes = (ProductType[]) request.getAttribute("productTypes");
%>
<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h6 mb-0">/Liste/ProductType</div>
    </div>

    <div class="card mb-4">
        <div class="card-body">
            <form action="/boulangerie/producttypeform" method="GET">
                <h4 class="card-title">Liste des types de produits <input type="submit" class="btn btn-danger offset-8" value="AJOUTER"> </h4>
            </form>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Id ProductType</th>
                        <th scope="col">Value</th>
                        <th scope="col">Description</th>
                        <th scope="colgroup" colspan="2">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%                                            
                        for (int i = 0; i < productTypes.length; i++) {
                    %>
                    <tr>
                        <th scope="row"> <%=productTypes[i].getId()%> </th>
                        <td><%=productTypes[i].getValue()%></td>
                        <td><%=productTypes[i].getDescription()%></td>
                        <td>
                            <form action="/boulangerie/producttypes" method="GET">
                                <input type="hidden" value="delete" name="action">
                                <input type="hidden" value="<%=productTypes[i].getId()%>" name="idproducttypes">
                                <input type="submit" class="btn btn-outline-danger" value="SUPPRIMER">
                            </form>
                        </td>
                        <td>
                            <form action="/boulangerie/producttypes" method="POST" class='col-10'>
                                <input type="hidden" name="action" value="modif">
                                <input type="hidden" name="id" value="<%=productTypes[i].getId()%>">
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
