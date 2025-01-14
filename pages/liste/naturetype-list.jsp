<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bakery.model.NatureType"%>
<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h6 mb-0">/Liste/NatureType</div>
    </div>

    <div class="card mb-4">
        <div class="card-body">
            <h4 class="card-title">Liste de la nature des ingredients</h4>

            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Value</th>
                        <th scope="col">Description</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Populate table rows dynamically -->
                    <% 
                        NatureType[] natureTypes = (NatureType[]) request.getAttribute("natureTypes");
                        for (NatureType natureType : natureTypes) {
                    %>
                        <tr>
                            <td><%= natureType.getId() %></td>
                            <td><%= natureType.getValue() %></td>
                            <td><%= natureType.getDescription() %></td>
                        </tr>
                    <% 
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>
